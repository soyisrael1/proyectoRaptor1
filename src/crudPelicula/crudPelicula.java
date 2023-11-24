package crudPelicula;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Datas.DataPelicula;
import Entidades.Pelicula;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class crudPelicula {

    public JFrame frmCrudPelicula;
    private JTable tblPeliculas;

    public ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
    public DefaultTableModel model = new DefaultTableModel();
    Pelicula x;
    ArrayList<Pelicula> lista;
    int fila = 0;
    static String rutaImagen;
    int idPeli = 0;
    private JLabel lblID;
    private JButton btnActualizar;
    private JTextField txtNombre;
    private JTextField txtCategoria;
    private JTextField txtRangoEdad;
    private JLabel lblId;
    private JButton btnImagen;
    private JLabel lblImagen;

    public void actualizarTabla() {
        DataPelicula da = new DataPelicula();

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        lista = da.SelectPelicula();
        for (Pelicula sala : lista) {
            Object o[] = new Object[5];
            o[0] = sala.getIdPeli();
            o[1] = sala.getNombre();
            o[2] = sala.getCategoria();
            o[3] = sala.getRangoEdad();
            o[4] = new ImageIcon(sala.getRutaImagen());

            model.addRow(o);
        }
        tblPeliculas.setModel(model);
    }

    /**
     * Create the application.
     */
    public crudPelicula() {
        initialize();
        actualizarTabla();
    }

    private void initialize() {
        frmCrudPelicula = new JFrame();
        frmCrudPelicula.setBounds(100, 100, 928, 743);
        frmCrudPelicula.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(363, 10, 526, 541);
        frmCrudPelicula.getContentPane().add(scrollPane);

        tblPeliculas = new JTable();
        tblPeliculas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fila = tblPeliculas.getSelectedRow();
                x = lista.get(fila);
                lblId.setText("" + x.getIdPeli());
                txtNombre.setText(x.getNombre());
                txtCategoria.setText(x.getCategoria());
                txtRangoEdad.setText(x.getRangoEdad());
                
            }
        });
        tblPeliculas.setDefaultRenderer(Object.class, new TableCellRenderer() {
            private final DefaultTableCellRenderer defaultRenderer = new DefaultTableCellRenderer();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component renderer = defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (column == 5 && value instanceof ImageIcon) {
                    JLabel label = new JLabel((ImageIcon) value);
                    label.setOpaque(true);
                    label.setBackground(table.getBackground());
                    return label;
                }

                return renderer;
            }
        });


        model.addColumn("ID PELI");
        model.addColumn("NOMBRE");
        model.addColumn("CATEGORIA");
        model.addColumn("RENGO EDAD");
        model.addColumn("IMAGEN"); 

        scrollPane.setViewportView(tblPeliculas);
        
        lblImagen = new JLabel();
        lblImagen.setBounds(363, 574, 129, 127);  
        frmCrudPelicula.getContentPane().add(lblImagen);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Pelicula peli = new Pelicula();
                peli.setNombre(txtNombre.getText());
                peli.setCategoria(txtCategoria.getText());
                peli.setRangoEdad(txtRangoEdad.getText());
                peli.setRutaImagen(rutaImagen);

             
                listaPeliculas.add(peli);
                actualizarTabla();
                limpiarFormulario();
                if (peli.insertarPelicula()) {
                    JOptionPane.showMessageDialog(null, "Se insertó correctamente ");
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR ");
                }

                actualizarTabla();
            }
        });
        btnAgregar.setBounds(115, 261, 167, 140);
        frmCrudPelicula.getContentPane().add(btnAgregar);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    x.setNombre(txtNombre.getText());
                    x.setCategoria(txtCategoria.getText());
                    x.setRangoEdad(txtRangoEdad.getText());

                    if (x.actualizarPelicula()) {
                        JOptionPane.showMessageDialog(null, "Correcto");
                        actualizarTabla();
                        limpiarFormulario();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
        btnActualizar.setBounds(115, 411, 167, 140);
        frmCrudPelicula.getContentPane().add(btnActualizar);

        JLabel lblNewLabel = new JLabel("ID:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(10, 12, 65, 43);
        frmCrudPelicula.getContentPane().add(lblNewLabel);

        lblId = new JLabel("0");
        lblId.setHorizontalAlignment(SwingConstants.CENTER);
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblId.setBounds(190, 11, 92, 45);
        frmCrudPelicula.getContentPane().add(lblId);

        JLabel lblNewLabel_2 = new JLabel("Nombre");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(10, 70, 167, 43);
        frmCrudPelicula.getContentPane().add(lblNewLabel_2);

        txtNombre = new JTextField();
        txtNombre.setBounds(190, 82, 163, 19);
        frmCrudPelicula.getContentPane().add(txtNombre);
        txtNombre.setColumns(10);

        txtCategoria = new JTextField();
        txtCategoria.setColumns(10);
        txtCategoria.setBounds(190, 135, 163, 19);
        frmCrudPelicula.getContentPane().add(txtCategoria);

        JLabel lblNewLabel_2_1 = new JLabel("Categoria");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setBounds(10, 123, 167, 43);
        frmCrudPelicula.getContentPane().add(lblNewLabel_2_1);

        txtRangoEdad = new JTextField();
        txtRangoEdad.setColumns(10);
        txtRangoEdad.setBounds(190, 188, 163, 19);
        frmCrudPelicula.getContentPane().add(txtRangoEdad);

        JLabel lblNewLabel_2_2 = new JLabel("RangoEdad");
        lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2_2.setBounds(10, 176, 167, 43);
        frmCrudPelicula.getContentPane().add(lblNewLabel_2_2);

        btnImagen = new JButton("Seleccionar imagen");
        btnImagen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SeleccionarImagen();
            }
        });
        btnImagen.setBounds(115, 561, 167, 140);
        frmCrudPelicula.getContentPane().add(btnImagen);
    }

    public void limpiarFormulario() {
        txtNombre.setText("");
        txtCategoria.setText("");
        txtRangoEdad.setText("");
        lblId.setText("0");
    }

    public void SeleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar Imagen");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Imagen", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(frmCrudPelicula);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            rutaImagen = selectedFile.getAbsolutePath();
            System.out.println("Imagen seleccionada: " + rutaImagen);
            Image mImagen=new ImageIcon(rutaImagen).getImage();
            ImageIcon mIcon =new ImageIcon(mImagen.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
            lblImagen.setIcon(mIcon);
            	

        }
        }
    public class ImageToBytesAndText {

        public static void main(String[] args) {
            try {
                // Ruta de la imagen
                String imagePath = rutaImagen;

                // Convertir imagen a bytes
                byte[] imageBytes = convertImageToBytes(imagePath);

                // Convertir bytes a texto
                String textRepresentation = convertBytesToText(imageBytes);

                // Imprimir el resultado
                System.out.println("Texto generado a partir de la imagen:\n" + textRepresentation);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Método para convertir una imagen a bytes
        private static byte[] convertImageToBytes(String imagePath) throws IOException {
            BufferedImage image = ImageIO.read(new File(imagePath));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", baos);
            return baos.toByteArray();
        }

        // Método para convertir bytes a texto
        private static String convertBytesToText(byte[] bytes) {
            return new String(bytes);
        }
    }
    
    }
            