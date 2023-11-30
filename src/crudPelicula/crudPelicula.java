package crudPelicula;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Datas.DataPelicula;
import Entidades.Pelicula;
import rojerusan.RSTableMetro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    ImageIcon imgOri = null;
    String imagenActual="";
    

    public void actualizarTabla() {
        DataPelicula da = new DataPelicula();
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override //Redefinimos el mÃ©todo getColumnClass
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Object.class;
                    case 1:
                        return Object.class;
                    case 2:
                        return Object.class;
                    case 3:
                        return Object.class;
                    case 4:
                        return ImageIcon.class;
                    default:
                        return Object.class;
                }
            }
        };

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
            if(!sala.getRutaImagen().equals("")) {
            	o[2] = base64ToImage(sala.getRutaImagen());
            }else {
            	o[2]=null;
            }

            model.addRow(o);
        }
        tblPeliculas.setModel(model);
    }
   
        
        
       
   
    public ImageIcon base64ToImage(String base64) {
        ImageIcon image = null;
        try {
            byte[] imageByte;
            imageByte = Base64.getDecoder().decode(base64);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            BufferedImage bufferedImage = ImageIO.read(bis);
            image = new ImageIcon(bufferedImage);
            bis.close();
        } catch (IOException ex) {
            Logger.getLogger(crudPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }

    public String convetirImagen(URL url) {
        String base64 = "";
        try {
            BufferedImage bImage = ImageIO.read(new File(url.getPath()));
            BufferedImage img = resize(bImage, 100, 100);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", bos);
            byte[] data = bos.toByteArray();
            base64 = Base64.getEncoder().encodeToString(data);
        } catch (MalformedURLException ex) {
            Logger.getLogger(crudPelicula.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(crudPelicula.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return base64;
    }

    public BufferedImage resize(BufferedImage bufferedImage, int newW, int newH) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        BufferedImage bufim = new BufferedImage(newW, newH, bufferedImage.getType());
        Graphics2D g = bufim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return bufim;
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
        frmCrudPelicula.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\8.png"));
        frmCrudPelicula.setBounds(100, 100, 928, 743);
        frmCrudPelicula.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(363, 10, 526, 541);
        frmCrudPelicula.getContentPane().add(scrollPane);

        tblPeliculas  = new RSTableMetro();
        ((RSTableMetro) tblPeliculas).setColorBackgoundHead(new Color(231,0,32));
        ((RSTableMetro) tblPeliculas).setAltoHead(20);
        ((RSTableMetro) tblPeliculas).setColorFilasForeground1(Color.BLACK);
        ((RSTableMetro) tblPeliculas).setColorFilasForeground2(Color.BLACK);
        ((RSTableMetro) tblPeliculas).setColorFilasBackgound2(Color.LIGHT_GRAY);
        ((RSTableMetro) tblPeliculas).setColorSelBackgound(new Color(231, 0, 32));
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
        btnAgregar.setBackground(Color.RED);
        btnAgregar.setOpaque(false);
        btnAgregar.setBorder(null);
        btnAgregar.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\tiinsdt-removebg-preview.png"));
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Pelicula peli = new Pelicula();
                peli.setNombre(txtNombre.getText());
                peli.setCategoria(txtCategoria.getText());
                peli.setRangoEdad(txtRangoEdad.getText());
                peli.setRutaImagen(imagenActual);

             
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
        btnActualizar.setBackground(Color.RED);
        btnActualizar.setBorder(null);
        btnActualizar.setOpaque(false);
        btnActualizar.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\upassaew-removebg-preview.png"));
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
        btnActualizar.setBounds(101, 411, 186, 140);
        frmCrudPelicula.getContentPane().add(btnActualizar);

        JLabel lblNewLabel = new JLabel("ID:");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(68, 10, 84, 43);
        frmCrudPelicula.getContentPane().add(lblNewLabel);

        lblId = new JLabel("0");
        lblId.setForeground(new Color(255, 255, 255));
        lblId.setHorizontalAlignment(SwingConstants.CENTER);
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblId.setBounds(190, 11, 92, 45);
        frmCrudPelicula.getContentPane().add(lblId);

        JLabel lblNewLabel_2 = new JLabel("Nombre");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
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
        lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setBounds(10, 123, 167, 43);
        frmCrudPelicula.getContentPane().add(lblNewLabel_2_1);

        txtRangoEdad = new JTextField();
        txtRangoEdad.setColumns(10);
        txtRangoEdad.setBounds(190, 188, 163, 19);
        frmCrudPelicula.getContentPane().add(txtRangoEdad);

        JLabel lblNewLabel_2_2 = new JLabel("RangoEdad");
        lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2_2.setBounds(10, 176, 167, 43);
        frmCrudPelicula.getContentPane().add(lblNewLabel_2_2);

        btnImagen = new JButton("Seleccionar imagen");
        btnImagen.setBackground(Color.RED);
        btnImagen.setOpaque(false);
        btnImagen.setBorder(null);
        btnImagen.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\asxx.png"));
        btnImagen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SeleccionarImagen();
            }
        });
        btnImagen.setBounds(115, 561, 167, 140);
        frmCrudPelicula.getContentPane().add(btnImagen);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Amgel\\Downloads\\qw.png"));
        lblNewLabel_1.setBounds(0, 0, 904, 706);
        frmCrudPelicula.getContentPane().add(lblNewLabel_1);
    }

    public void limpiarFormulario() {
        txtNombre.setText("");
        txtCategoria.setText("");
        txtRangoEdad.setText("");
        lblId.setText("0");
    }

    public void SeleccionarImagen() {
    	JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        selector.setFileFilter(filtroImagen);
        int r = selector.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            try {
                File f = selector.getSelectedFile();
                ImageIcon img = new ImageIcon(selector.getSelectedFile().toURL());
                imgOri = img;
                Image image = img.getImage(); // transform it
                Image newimg = image.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
                URL urlImage = selector.getSelectedFile().toURL();
                imagenActual = convetirImagen(urlImage);
                System.out.println(imagenActual);
                lblImagen.setIcon(new ImageIcon(newimg));
            } catch (MalformedURLException ex) {
                Logger.getLogger(crudPelicula.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        
        }
}
    
        