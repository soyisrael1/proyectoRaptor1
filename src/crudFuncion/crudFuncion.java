package crudFuncion;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Datas.DataFuncion;
import Datas.DataPelicula;
import Datas.DataSala;
import Datas.DataTicket;
import Entidades.Pelicula;
import Entidades.Sala;
import Entidades.Ticket;
import Entidades.funcion;

import rojerusan.RSTableMetro;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class crudFuncion {

	public JFrame frmCrudFuncion;
	ArrayList<Ticket> listaTickets=null;
	 ArrayList<Sala>listaSalas=null;
	 ArrayList<Pelicula>listaPeliculas=null;
	 public ArrayList<funcion> listaFuncion = new ArrayList<funcion>();
		
		funcion x;
		ArrayList<funcion> lista;
				int idSala = 0;
	 DefaultTableModel model=new DefaultTableModel();
	 DefaultComboBoxModel modelCombo=null;
	 DefaultComboBoxModel modelCombo2=null;
	 DataTicket dc=new DataTicket();
	 Ticket p=null;
	 int fila=0;
	 private JComboBox cmbSala;
	 private JComboBox cmbPeli;
	 
	 String tipo="";
	 private JComboBox cmbSala_1;
	 private JComboBox cmbPeli_1;
	 private JLabel lblHora;
	 private JLabel lblFecha;
	 private JTextField txtHora;
	 private JTextField txtFecha;
	 private JTable tblFunciones;
	 private JLabel lblNewLabel_1;
	 


	

	/**
	 * Create the application.
	 */
	public crudFuncion() {
		initialize();
		DataSala du=new DataSala();
		  listaSalas=du.SelectSala();
		  Object nombresSalas[]=new Object[listaSalas.size()];
		  for (int i = 0; i <listaSalas.size(); i++) {
		   nombresSalas[i]=listaSalas.get(i).getNombre();
		  }
		  modelCombo=new DefaultComboBoxModel(nombresSalas);
		  cmbSala_1.setModel(modelCombo);
		  
		  DataPelicula dp = new DataPelicula();
		  listaPeliculas = dp.SelectPelicula();
		  Object nombresPeli[] = new Object[listaPeliculas.size()];
		 for (int i = 0; i< listaPeliculas.size();i++) {
			 nombresPeli[i]=listaPeliculas.get(i).getNombre();
		 }
		 modelCombo = new DefaultComboBoxModel(nombresPeli);
		 cmbPeli_1.setModel(modelCombo);
		 
		 lblHora = new JLabel("Hora");
		 lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		 lblHora.setFont(new Font("Arial", Font.PLAIN, 15));
		 lblHora.setBounds(10, 112, 85, 41);
		 frmCrudFuncion.getContentPane().add(lblHora);
		 
		 lblFecha = new JLabel("Fecha");
		 lblFecha.setBackground(new Color(255, 255, 255));
		 lblFecha.setForeground(new Color(255, 255, 255));
		 lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		 lblFecha.setFont(new Font("Arial", Font.PLAIN, 15));
		 lblFecha.setBounds(10, 163, 85, 41);
		 frmCrudFuncion.getContentPane().add(lblFecha);
		 
		 txtHora = new JTextField();
		 txtHora.setBounds(105, 112, 96, 41);
		 frmCrudFuncion.getContentPane().add(txtHora);
		 txtHora.setColumns(10);
		 
		 txtFecha = new JTextField();
		 txtFecha.setColumns(10);
		 txtFecha.setBounds(105, 163, 96, 41);
		 frmCrudFuncion.getContentPane().add(txtFecha);
		 
		 JButton btnAñadir = new JButton("New button");
		 btnAñadir.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try {
					funcion sala = new funcion();
					 sala.setIdsala(listaSalas.get(cmbSala_1.getSelectedIndex()).getIdSala());
				     sala.setIdPeli(listaPeliculas.get(cmbPeli_1.getSelectedIndex()).getIdPeli());
					sala.setFecha(txtFecha.getText());
					sala.setHora(txtHora.getText());
					
					listaFuncion.add(sala);
					actualizarTabla();
					limpiarFormulario();
					if (sala.insertarFuncion()) {
						JOptionPane.showMessageDialog(null, "Se inseto correctamente ");

					} else {
						JOptionPane.showMessageDialog(null, "ERRROR ");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERRROR ");
				}
				actualizarTabla();
		 	}
		 });
		 btnAñadir.setBounds(40, 214, 160, 113);
		 frmCrudFuncion.getContentPane().add(btnAñadir);
		 
		 JButton btnActualizar = new JButton("New button");
		 btnActualizar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try {
		 		x.setIdsala(listaSalas.get(cmbSala_1.getSelectedIndex()).getIdSala());
			     x.setIdPeli(listaPeliculas.get(cmbPeli_1.getSelectedIndex()).getIdPeli());
			     x.setFecha(txtFecha.getText());
			     x.setHora(txtHora.getText());
			     
			     if(x.actualizarFuncion()) {
	 		      JOptionPane.showConfirmDialog(null, "se inserto correctamente");
	 		     actualizarTabla();
	 		  
	 		     }else {
	 		      JOptionPane.showConfirmDialog(null, "ERROR");
	 		     }
	 		    } catch (Exception e2) {
	 		     JOptionPane.showConfirmDialog(null, "ERROR");
	 		    }
	 		    
		 	
		 	}
		 });
		 btnActualizar.setBounds(40, 337, 165, 116);
		 frmCrudFuncion.getContentPane().add(btnActualizar);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(231, 10, 423, 443);
		 frmCrudFuncion.getContentPane().add(scrollPane);
		 
		 tblFunciones = new RSTableMetro();
			tblFunciones.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					fila = tblFunciones.getSelectedRow();
					x = lista.get(fila);
					
					cmbSala_1.setSelectedIndex(seleccionarSala(x));
			        cmbPeli_1.setSelectedIndex(seleccionarPelicula(x));
					txtFecha.setText(x.getFecha());
					txtHora.setText(x.getHora());
				}
			});
			((RSTableMetro) tblFunciones).setColorBackgoundHead(new Color(231,0,32));
	        ((RSTableMetro) tblFunciones).setAltoHead(20);
	        ((RSTableMetro) tblFunciones).setColorFilasForeground1(Color.BLACK);
	        ((RSTableMetro) tblFunciones).setColorFilasForeground2(Color.BLACK);
	        ((RSTableMetro) tblFunciones).setColorFilasBackgound2(Color.LIGHT_GRAY);
	        ((RSTableMetro) tblFunciones).setColorSelBackgound(new Color(231, 0, 32));
	        tblFunciones.setForeground(Color.WHITE);
	        scrollPane.setViewportView(tblFunciones);
	        model = new DefaultTableModel();
	        model.addColumn("SALA");
			  model.addColumn("PELICULA");
			  model.addColumn("FECHA");
			  model.addColumn("HORA");
			  
	        scrollPane.setViewportView(tblFunciones);
	        
	        lblNewLabel_1 = new JLabel("");
	        lblNewLabel_1.setBounds(0, 0, 688, 495);
	        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\travi\\Downloads\\PROYECTVIC\\digidrty.jpg"));
	        frmCrudFuncion.getContentPane().add(lblNewLabel_1);
		 
		 
		
		 
		 actualizarTabla();
		
		  
		 }
	 
	 public String getPelicula(int idPeli) {
		  String peli = "";
		  for (Pelicula u: listaPeliculas) {
		   if(u.getIdPeli()== idPeli){
		    System.out.println("id user:"+u.getIdPeli());
		    peli = u.getNombre();
		   }
		  }
		  return peli;
		  
		 }	
		 public String getSala(int idSala) {
		  String sala = null;
		  for (Sala u: listaSalas) {
		   if(u.getIdSala()== idSala){
		    sala = u.getNombre();
		    
		   }
		  }
		  return sala;
		 }
		 public int seleccionarPelicula(funcion p) {
				int pos = 0;
				for (Pelicula u : listaPeliculas) {
					if (u.getIdPeli() == p.getIdPeli()) {
						break;
					}
					pos++;
				}
				return pos;

			}
		 public int seleccionarSala(funcion p) {
				int pos = 0;
				for (Sala u : listaSalas) {
					if (u.getIdSala() == p.getIdsala()) {
						break;
					}
					pos++;
				}
				return pos;

			}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudFuncion = new JFrame();
		frmCrudFuncion.setBackground(Color.RED);
		frmCrudFuncion.setBounds(100, 100, 678, 500);
		frmCrudFuncion.setLocationRelativeTo(null);
		frmCrudFuncion.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sala");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 85, 41);
		frmCrudFuncion.getContentPane().add(lblNewLabel);
		
		cmbSala_1 = new JComboBox();
		cmbSala_1.setBounds(105, 10, 100, 41);
		frmCrudFuncion.getContentPane().add(cmbSala_1);
		
		JLabel lblPelicula = new JLabel("Pelicula");
		lblPelicula.setForeground(new Color(255, 255, 255));
		lblPelicula.setHorizontalAlignment(SwingConstants.CENTER);
		lblPelicula.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPelicula.setBounds(10, 61, 85, 41);
		frmCrudFuncion.getContentPane().add(lblPelicula);
		
		cmbPeli_1 = new JComboBox();
		cmbPeli_1.setBounds(105, 61, 100, 41);
		frmCrudFuncion.getContentPane().add(cmbPeli_1);
	}
	public void actualizarTabla() {
		DataFuncion da = new DataFuncion();

		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}

		lista = da.SelectFuncion();
		for (funcion sala : lista) {
			Object o[] = new Object[4];
			
			o[0] = getSala(sala.getIdsala());
			o[1] = getPelicula(sala.getIdPeli());
			o[2] = sala.getFecha();
			o[3] = sala.getHora();
		
			
			model.addRow(o);

		}
		tblFunciones.setModel(model);
	}
	public void limpiarFormulario() {
		txtFecha.setText("");
		txtHora.setText("");
	}
}
