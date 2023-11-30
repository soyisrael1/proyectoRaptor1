package crudPelicula;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Datas.DataPelicula;
import Datas.DataSala;
import Entidades.Pelicula;
import Entidades.Sala;
import rojerusan.RSTableMetro;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class crudPeliculaEliminar {

	public JFrame frmCrudPeliculaEliminar;
	private JTable tblSalas;
	private JScrollPane scrollPane;
	public ArrayList<Pelicula> listaSalas = new ArrayList<Pelicula>();
	public DefaultTableModel model= new DefaultTableModel();
	Pelicula x;
	ArrayList<Pelicula> lista;
	int fila = 0;
	int idPeli = 0;
	private JButton btnEliminar;
	private JLabel lblNewLabel;
	
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
			
		
			
			model.addRow(o);

		}
		tblSalas.setModel(model);
	}
	/**
	 * Create the application.
	 */
	public crudPeliculaEliminar() {
		initialize();
		actualizarTabla();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudPeliculaEliminar = new JFrame();
		frmCrudPeliculaEliminar.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\8.png"));
		frmCrudPeliculaEliminar.setTitle("EliminarPelicula");
		frmCrudPeliculaEliminar.setBounds(100, 100, 842, 284);
		frmCrudPeliculaEliminar.setLocationRelativeTo(null);
		frmCrudPeliculaEliminar.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 531, 203);
		frmCrudPeliculaEliminar.getContentPane().add(scrollPane);
		
		tblSalas = new RSTableMetro();
		tblSalas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblSalas.getSelectedRow();
				x = lista.get(fila);
				
			}
		});
		((RSTableMetro) tblSalas).setColorBackgoundHead(new Color(231,0,32));
        ((RSTableMetro) tblSalas).setAltoHead(20);
        ((RSTableMetro) tblSalas).setColorFilasForeground1(Color.BLACK);
        ((RSTableMetro) tblSalas).setColorFilasForeground2(Color.BLACK);
        ((RSTableMetro) tblSalas).setColorFilasBackgound2(Color.LIGHT_GRAY);
        ((RSTableMetro) tblSalas).setColorSelBackgound(new Color(0, 0, 0));

		model.addColumn("ID PELI");
		  model.addColumn("NOMBRE");
		  model.addColumn("CATEGORIA");
		  model.addColumn("RANGO EDAD");
		  
		scrollPane.setViewportView(tblSalas);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.RED);
		btnEliminar.setBorder(null);
		btnEliminar.setOpaque(false);
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\yig-removebg-preview.png"));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int op = JOptionPane.showConfirmDialog(null, "estas seguro de eliminar?", "Eliminar",
						JOptionPane.YES_NO_OPTION);
				System.out.print(op);
				if (op == 0) {

					if (x.EliminarPelicula()) {
						JOptionPane.showMessageDialog(null, "se elimino correctamente");
						actualizarTabla();
					} else {
						JOptionPane.showMessageDialog(null, "Error");
					}
				}
			}
		});
		btnEliminar.setBounds(551, 10, 267, 203);
		frmCrudPeliculaEliminar.getContentPane().add(btnEliminar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\jjoyu.jpg"));
		lblNewLabel.setBounds(0, 0, 828, 247);
		frmCrudPeliculaEliminar.getContentPane().add(lblNewLabel);
	}
	public void limpiarFormulario() {
		
	}
}