package crudVenta;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

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
import rojerusan.RSTableMetro;

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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class crudVenta {

	public JFrame frmCrudVenta;
	ArrayList<Ticket> listaTickets=null;
	 
	 static ArrayList<Combo>listaCombo;
	 static ArrayList<funcion>listaFuncion;
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
	 private JScrollPane scrollPane;
	 private JLabel lblID;
	 String tipo="";
	 private JLabel lblNewLabel_2;
	 private JSpinner spnAsientosV;
	 private JLabel lblCombo;
	 private JComboBox cmbCombo;
	 int usuario;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 * @param usuario 
	 */
	  
	public crudVenta(int usuario) {
		initialize();
		this.usuario=usuario;
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
		 
		 JLabel lblNewLabel_4 = new JLabel("");
		 lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Amgel\\Downloads\\imagenes java\\121212121.jpg"));
		 lblNewLabel_4.setBounds(0, 0, 832, 608);
		 frmCrudVenta.getContentPane().add(lblNewLabel_4);
		 
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
	 
	 public static String getFuncion(int idFun) {
		  String fun = "";
		  for (funcion u: listaFuncion) {
		   if(u.getIdfun()== idFun){
		    System.out.println("id user:"+u.getIdfun());
		    fun = u.getFecha()+" "+u.getHora();
		   }
		  }
		  return fun;
		  
		 }	
	 public static String getCombo(int idCom) {
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
		    o[6]=getComboC(u.getIdcombo());
		    o[7]=getFuncion(u.getIdfun());
		    o[8]=u.getCostot();
		    
		    model.addRow(o);
		   }
		   tblVentas.setModel(model);
		 }
	 public static void generateTicket(String tickets, Ticket p) {
	        Document document = new Document();
	        

	        try {
	            PdfWriter.getInstance(document, new FileOutputStream(tickets));
	            document.open();

	            // 
	            document.add(new Paragraph("Funcion: " + getFuncion(p.getIdfun())));
	            document.add(new Paragraph("Combo: " + getCombo(p.getIdcombo())));
	            document.add(new Paragraph("Cantidad de Boletos Normales: " + p.getCantboletosn()+" = "+p.getCostoboletosn()));
	            document.add(new Paragraph("Cantidad de Boletos VIP: " + p.getCantboletosv()+" = "+p.getCostoboletosv()));
	            document.add(new Paragraph("Costo Total: $" + p.getCostot()));
	            

	        } catch (DocumentException | FileNotFoundException e) {
	            e.printStackTrace(System.out);
	        } finally {
	            document.close();
	        }

	    }
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudVenta = new JFrame();
		frmCrudVenta.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\8.png"));
		frmCrudVenta.setBounds(100, 100, 846, 645);
		
		frmCrudVenta.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Funcion");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 55, 108, 36);
		frmCrudVenta.getContentPane().add(lblNewLabel);
		
		cmbFuncion = new JComboBox();
		cmbFuncion.setBounds(109, 55, 190, 36);
		frmCrudVenta.getContentPane().add(cmbFuncion);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 108, 35);
		frmCrudVenta.getContentPane().add(lblNewLabel_1);
		
		lblID = new JLabel("0");
		lblID.setForeground(new Color(255, 255, 255));
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setBounds(128, 10, 108, 35);
		frmCrudVenta.getContentPane().add(lblID);
		
		
		 scrollPane = new JScrollPane();
		 scrollPane.setBounds(309, 10, 513, 588);
		 frmCrudVenta.getContentPane().add(scrollPane);
		 
		 tblVentas = new RSTableMetro();
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
		        
		        
		        
		 	}
		 });
		 ((RSTableMetro) tblVentas).setColorBackgoundHead(new Color(231,0,32));
	        ((RSTableMetro) tblVentas).setAltoHead(20);
	        ((RSTableMetro) tblVentas).setColorFilasForeground1(Color.BLACK);
	        ((RSTableMetro) tblVentas).setColorFilasForeground2(Color.BLACK);
	        ((RSTableMetro) tblVentas).setColorFilasBackgound2(Color.LIGHT_GRAY);
	        ((RSTableMetro) tblVentas).setColorSelBackgound(new Color(231, 0, 32));
	        tblVentas.setForeground(Color.WHITE);

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
		 lblNewLabel_3.setForeground(new Color(255, 255, 255));
		 lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 lblNewLabel_3.setBounds(10, 151, 152, 37);
		 frmCrudVenta.getContentPane().add(lblNewLabel_3);
		 
		 JButton btnAgregar = new JButton("Agregar");
		 btnAgregar.setBackground(Color.DARK_GRAY);
		 btnAgregar.setBorder(null);
		 btnAgregar.setOpaque(false);
		 btnAgregar.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\tiinsdt-removebg-preview.png"));
		 btnAgregar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		 try {
		 			
		 			
				     Ticket p= new Ticket();
				     int costoCombo=costoCombo = getComboC(listaCombo.get(cmbCombo.getSelectedIndex()).getIdcombo());
				     int costoTota = costoBN + costoBV + costoCombo;

		
				     p.setCantboletosn(numAsientosN);
				     p.setCantboletosv(numAsientosV);
				     p.setCostoboletosn(costoBN);
				     p.setCostoboletosv(costoBV);
				     p.setIdcombo(listaCombo.get(cmbCombo.getSelectedIndex()).getIdcombo());
				     p.setIduser(usuario);
				     p.setCosto(costoCombo);
				     p.setIdfun(listaFuncion.get(cmbFuncion.getSelectedIndex()).getIdfun());
				     p.setCostot(costoTota);
				     
				     if (p.insertarTicket()) {
				    	    JOptionPane.showConfirmDialog(null, "se insertó correctamente");
				    	    actualizarTabla();
				    	    generateTicket("tickets.pdf", p);
				    	} else {
				    	    JOptionPane.showConfirmDialog(null, "ERROR");
				    	}

				    } catch (Exception e2) {
				     JOptionPane.showConfirmDialog(null, "ERROR");
				    }
		 	}
		 });
		 btnAgregar.setBounds(114, 291, 122, 114);
		 frmCrudVenta.getContentPane().add(btnAgregar);
		 
		 JButton btnActualizar = new JButton("Actualizar");
		 btnActualizar.setBorder(null);
		 btnActualizar.setBackground(new Color(0, 0, 255));
		 btnActualizar.setOpaque(false);
		 btnActualizar.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\upassaew-removebg-preview.png"));
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
				     p.setCosto(getComboC(listaCombo.get(cmbCombo.getSelectedIndex()).getIdcombo()));
				    

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
		 btnActualizar.setBounds(66, 473, 196, 44);
		 frmCrudVenta.getContentPane().add(btnActualizar);
		 
		 lblNewLabel_2 = new JLabel("Asietnos Vip");
		 lblNewLabel_2.setForeground(new Color(255, 255, 255));
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
		 lblCombo.setForeground(new Color(255, 255, 255));
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
