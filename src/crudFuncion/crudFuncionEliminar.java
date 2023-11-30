package crudFuncion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Datas.DataFuncion;
import Datas.DataSala;
import Datas.DataTicket;
import Entidades.Pelicula;
import Entidades.Sala;
import Entidades.Ticket;
import Entidades.funcion;
import rojerusan.RSTableMetro;
import java.awt.Toolkit;

public class crudFuncionEliminar {

	public JFrame frmCrudFuncionEliminar;
	
	private JScrollPane scrollPane;


	public ArrayList<funcion> listaTickets = new ArrayList<funcion>();
	public DefaultTableModel model= new DefaultTableModel();
	funcion x;
	ArrayList<funcion> lista;
	int fila = 0;
	int idTi = 0;
	private JButton btnEliminar;
	private JTable tblFunciones;

	 public void actualizarTabla() {
		 DataFuncion da = new DataFuncion();
		 
		  while (model.getRowCount()>0) { 
		   model.removeRow(0);
		   }
		   lista = da.SelectFuncion();
		   for (funcion u : lista) {
		    Object o[]=new Object[5];
		    
		    o[0] = u.getIdsala();
			o[1] = u.getIdPeli();
			o[2] = u.getFecha();
			o[3] = u.getHora();
		    model.addRow(o);
		   }
		   tblFunciones.setModel(model);
		 }
	
	/**
	 * Create the application.
	 */
	public crudFuncionEliminar() {
		initialize();
		actualizarTabla();
	}
	
		 


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudFuncionEliminar = new JFrame();
		frmCrudFuncionEliminar.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\8.png"));
		frmCrudFuncionEliminar.setTitle("EliminarFuncion");
		frmCrudFuncionEliminar.setBounds(100, 100, 842, 284);
		frmCrudFuncionEliminar.setLocationRelativeTo(null);
		frmCrudFuncionEliminar.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 531, 203);
		frmCrudFuncionEliminar.getContentPane().add(scrollPane);
		
		tblFunciones = new RSTableMetro();
		tblFunciones.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				fila = tblFunciones.getSelectedRow();
				x = lista.get(fila);
			}
		});
	
		 ((RSTableMetro) tblFunciones).setColorBackgoundHead(new Color(231,0,32));
	        ((RSTableMetro) tblFunciones).setAltoHead(20);
	        ((RSTableMetro) tblFunciones).setColorFilasForeground1(Color.BLACK);
	        ((RSTableMetro) tblFunciones).setColorFilasForeground2(Color.BLACK);
	        ((RSTableMetro) tblFunciones).setColorFilasBackgound2(Color.LIGHT_GRAY);
	        ((RSTableMetro) tblFunciones).setColorSelBackgound(new Color(0, 0, 0));
	        tblFunciones.setForeground(Color.WHITE);
	        scrollPane.setViewportView(tblFunciones);
	        model = new DefaultTableModel();
	       
	        model.addColumn("SALA");
			  model.addColumn("PELICULA");
			  model.addColumn("FECHA");
			  model.addColumn("HORA");
			  
	        scrollPane.setViewportView(tblFunciones);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setOpaque(false);
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(Color.ORANGE);
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\yig-removebg-preview.png"));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(null, "estas seguro de eliminar?", "Eliminar",
						JOptionPane.YES_NO_OPTION);
				System.out.print(op);
				if (op == 0) {

					if (x.EliminarFuncion()) {
						JOptionPane.showMessageDialog(null, "se elimino correctamente");
						actualizarTabla();
					} else {
						JOptionPane.showMessageDialog(null, "Error");
					}
				}
			}
		});
		btnEliminar.setBounds(551, 10, 267, 203);
		frmCrudFuncionEliminar.getContentPane().add(btnEliminar);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\jjoyu.jpg"));
		lblNewLabel.setBounds(0, 0, 826, 245);
		frmCrudFuncionEliminar.getContentPane().add(lblNewLabel);
	}
	public void limpiarFormulario() {
		
	}
}
