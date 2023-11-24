package crudVenta;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Datas.DataCombo;
import Datas.DataFuncion;
import Datas.DataPelicula;
import Datas.DataSala;
import Datas.DataTicket;
import Entidades.Combo;
import Entidades.Pelicula;
import Entidades.Sala;
import Entidades.Ticket;
import Entidades.funcion;
import data.Usuario;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class crudVenta {

	public JFrame frmCrudVenta;
	ArrayList<Ticket> listaTickets=null;
	 
	 ArrayList<Combo>listaCombo;
	 ArrayList<funcion>listaFuncion;
	 DefaultTableModel model=new DefaultTableModel();
	 DefaultComboBoxModel modelCombo=null;
	 DefaultComboBoxModel modelCombo2=null;
	 DataTicket dc=new DataTicket();
	 Ticket p=null;
	 int fila=0;
	 private JComboBox cmbFuncion;
	 private JTable tblVentas;
	 private JSpinner spnAsientosN;
	 int costo=0;
	 int numAsientosN;
	 int numAsientosV;
	 int costoBN;
	 int costoBV;
	 private JLabel lblCosto;
	 private JScrollPane scrollPane;
	 private JLabel lblID;
	 String tipo="";
	 private JLabel lblNewLabel_2;
	 private JSpinner spnAsientosV;
	 private JLabel lblCombo;
	 private JComboBox cmbCombo;
	 

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	  
	public crudVenta() {
		initialize();
		DataFuncion du=new DataFuncion();
		  listaFuncion=du.SelectFuncion();
		  Object nombresFunciones[]=new Object[listaFuncion.size()];
		  for (int i = 0; i <listaFuncion.size(); i++) {
		   nombresFunciones[i]=listaFuncion.get(i).getFecha()+listaFuncion.get(i).getHora();
		  }
		  modelCombo=new DefaultComboBoxModel(nombresFunciones);
		  cmbFuncion.setModel(modelCombo);
		  
		  DataCombo dp = new DataCombo();
		  listaCombo = dp.SelectCombo();
		  Object nombresCom[] = new Object[listaCombo.size()];
		 for (int i = 0; i< listaCombo.size();i++) {
			 nombresCom[i]=listaCombo.get(i).getNombre();
		 }
		 modelCombo = new DefaultComboBoxModel(nombresCom);
		 cmbCombo.setModel(modelCombo);
		 
		 actualizarTabla();

	}
	 public int seleccionarCombo(Ticket p) {
		   int pos =0;
		   for (Combo u : listaCombo) {
		   if (u.getIdcombo() == p.getIdcombo()) {
		    pos++;
		   }
		  }
		  return pos;
		   
		  }
	 public int seleccionarFuncion(Ticket p) {
		   int pos =0;
		   for (funcion u : listaFuncion) {
		   if (u.getIdfun() == p.getIdfun()) {
		    pos++;
		   }
		  }
		  return pos;
		   
		  }
	 
	 public String getFuncion(int idFun) {
		  String fun = "";
		  for (funcion u: listaFuncion) {
		   if(u.getIdfun()== idFun){
		    System.out.println("id user:"+u.getIdfun());
		    fun = u.getFecha()+" "+u.getHora();
		   }
		  }
		  return fun;
		  
		 }	
	 public String getCombo(int idCom) {
		  String com = "";
		  for (Combo u: listaCombo) {
		   if(u.getIdcombo()== idCom){
		    System.out.println("combo:"+u.getIdcombo());
		    com = u.getNombre();
		   }
		  }
		  return com;
		  
		 }	
	 public int getComboC(int idCom) {
		  int cos = 0;
		  for (Combo u: listaCombo) {
		   if(u.getIdcombo()== idCom){
		    System.out.println("combo:"+u.getIdcombo());
		    cos = u.getCosto();
		   }
		  }
		  return cos;
		 
		  
		 }
	 
	 public void actualizarTabla() {
		  while (model.getRowCount()>0) { 
		   model.removeRow(0);
		   }
		   listaTickets = dc.SelectTicket();
		   for (Ticket u : listaTickets) {
		    Object o[]=new Object[9];
		    
		    o[0]=u.getCantboletosn();
		    o[1]=u.getCantboletosv();
		    o[2]=u.getCostoboletosn();
		    o[3]=u.getCostoboletosv();
		    o[4]=getCombo(u.getIdcombo());
		    o[5]=u.getIduser();
		    o[6]=u.getCosto();
		    o[7]=getFuncion(u.getIdfun());
		    o[8]=u.getCostot();
		    
		    model.addRow(o);
		   }
		   tblVentas.setModel(model);
		 }
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudVenta = new JFrame();
		frmCrudVenta.setBounds(100, 100, 846, 645);
		
		frmCrudVenta.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Funcion");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 55, 108, 36);
		frmCrudVenta.getContentPane().add(lblNewLabel);
		
		cmbFuncion = new JComboBox();
		cmbFuncion.setBounds(109, 55, 190, 36);
		frmCrudVenta.getContentPane().add(cmbFuncion);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 108, 35);
		frmCrudVenta.getContentPane().add(lblNewLabel_1);
		
		lblID = new JLabel("0");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setBounds(128, 10, 108, 35);
		frmCrudVenta.getContentPane().add(lblID);
		
		
		 scrollPane = new JScrollPane();
		 scrollPane.setBounds(309, 10, 513, 588);
		 frmCrudVenta.getContentPane().add(scrollPane);
		 
		 tblVentas = new JTable();
		 tblVentas.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		fila = tblVentas.getSelectedRow();
		        p = listaTickets.get(fila);
		        lblID.setText("" + p.getIdfun());
		        cmbFuncion.setSelectedIndex(seleccionarFuncion(p));
		        cmbCombo.setSelectedIndex(seleccionarCombo(p));
		        spnAsientosN.setValue(p.getCantboletosn());
		        spnAsientosV.setValue(p.getCantboletosv());
		        lblCosto.setText(""+p.getCostot()+"$");
		        
		        
		 	}
		 });

		  model.addColumn("CANTIDAD DE BOLETOS NORMAL");
		  model.addColumn("CANTIDAD DE BOLETOS VIP");
		  model.addColumn("COSTO DE BOLETOS NORMAL");
		  model.addColumn("COSTO DE BOLETOS VIP");
		  model.addColumn("COMBO");
		  model.addColumn("USUARIO");
		  model.addColumn("PRECIO COMBO");
		  model.addColumn("FUNCION");
		  model.addColumn("TOTAL");
		  tblVentas.setModel(model);
		 scrollPane.setViewportView(tblVentas);
		 
		 spnAsientosN = new JSpinner();
		 spnAsientosN.addChangeListener(new ChangeListener() {
		 	public void stateChanged(ChangeEvent e) {
		 		numAsientosN=(int) spnAsientosN.getValue();
		 		costoBN=numAsientosN*75;
		 	}
		 });
		 spnAsientosN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		 spnAsientosN.setBounds(172, 150, 127, 36);
		 frmCrudVenta.getContentPane().add(spnAsientosN);
		 
		 JLabel lblNewLabel_3 = new JLabel("Asientos Normales");
		 lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 lblNewLabel_3.setBounds(10, 151, 152, 37);
		 frmCrudVenta.getContentPane().add(lblNewLabel_3);
		 
		 JButton btnAgregar = new JButton("Agregar");
		 btnAgregar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		 try {
		 			
		 			
				     Ticket p= new Ticket();
				     int costoCombo=getComboC(p.getIdcombo());
				     int costoTota=costoBN+costoBV+costoCombo;
				     p.setCantboletosn(numAsientosN);
				     p.setCantboletosv(numAsientosV);
				     p.setCostoboletosn(costoBN);
				     p.setCostoboletosv(costoBV);
				     p.setIdcombo(listaCombo.get(cmbCombo.getSelectedIndex()).getIdcombo());
				     p.setIduser(p.getIduser());
				     p.setCosto(costoCombo);
				     p.setIdfun(listaFuncion.get(cmbFuncion.getSelectedIndex()).getIdfun());
				     p.setCostot(costoTota);
				     
				     if(p.insertarTicket()) {
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
		 btnAgregar.setBounds(98, 303, 122, 114);
		 frmCrudVenta.getContentPane().add(btnAgregar);
		 
		 JButton btnActualizar = new JButton("Actualizar");
		 btnActualizar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try {
		 			Ticket p= new Ticket();
				     int costoCombo=getComboC(p.getIdcombo());
				     int costoTota=((costoBN+costoBV)+getComboC(p.getIdcombo()));
				     p.setCantboletosn(numAsientosN);
				     p.setCantboletosv(numAsientosV);
				     p.setCostoboletosn(costoBN);
				     p.setCostoboletosv(costoBV);
				     p.setIdcombo(listaCombo.get(cmbCombo.getSelectedIndex()).getIdcombo());
				     p.setIduser(1);
				     p.setCosto(costoCombo);
				     p.setIdfun(listaFuncion.get(cmbFuncion.getSelectedIndex()).getIdfun());
				     p.setCostot(costoTota);
				     if(p.actualizarTicket()) {
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
		 btnActualizar.setBounds(98, 427, 122, 114);
		 frmCrudVenta.getContentPane().add(btnActualizar);
		 
		 lblCosto = new JLabel("0$");
		 lblCosto.setHorizontalAlignment(SwingConstants.CENTER);
		 lblCosto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		 lblCosto.setBounds(88, 253, 148, 40);
		 frmCrudVenta.getContentPane().add(lblCosto);
		 
		 lblNewLabel_2 = new JLabel("Asietnos Vip");
		 lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 lblNewLabel_2.setBounds(10, 101, 152, 37);
		 frmCrudVenta.getContentPane().add(lblNewLabel_2);
		 
		 spnAsientosV = new JSpinner();
		 spnAsientosV.addChangeListener(new ChangeListener() {
		 	public void stateChanged(ChangeEvent e) {
		 		numAsientosV=(int) spnAsientosV.getValue();
		 		costoBV=numAsientosV*100;
		 	}
		 });
		 spnAsientosV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		 spnAsientosV.setBounds(172, 101, 127, 36);
		 frmCrudVenta.getContentPane().add(spnAsientosV);
		 
		 lblCombo = new JLabel("Combo");
		 lblCombo.setHorizontalAlignment(SwingConstants.CENTER);
		 lblCombo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 lblCombo.setBounds(10, 196, 108, 36);
		 frmCrudVenta.getContentPane().add(lblCombo);
		 
		 cmbCombo = new JComboBox();
		 cmbCombo.setBounds(109, 196, 190, 36);
		 frmCrudVenta.getContentPane().add(cmbCombo);
		
	}
	
	public void total() {
		
	}
	public void limpiar() {
		
	}
}
