package crudVenta;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Datas.DataCombo;
import Datas.DataFuncion;
import Datas.DataSala;
import Datas.DataTicket;
import Entidades.Combo;
import Entidades.Pelicula;
import Entidades.Sala;
import Entidades.Ticket;
import Entidades.funcion;

public class crudVentaEliminar {

	 public JFrame frmCrudVentaEliminar;
	 private JTable tblVenta;
	 private JScrollPane scrollPane;
	 public ArrayList<Ticket> lista = new ArrayList<Ticket>();
	 public ArrayList<Ticket> listaTickets = new ArrayList<Ticket>();
	 DefaultTableModel model=new DefaultTableModel();
	 DefaultComboBoxModel modelCombo=null;
	 DataTicket dc=new DataTicket();
	 Ticket x=null;
	 int fila=0;
	 private JComboBox cmbFuncion;
	 private JTable tblVentas;
	 private JSpinner spnAsientosN;
	 int costo=0;
	 int numAsientosN;
	 int numAsientosV;
	 int costoBN;
	 int costoBV;
	 private JButton btnEliminar;

	 public void actualizarTabla() {
		  while (model.getRowCount()>0) { 
		   model.removeRow(0);
		   }
		   listaTickets = dc.SelectTicket();
		   for (Ticket u : listaTickets) {
		    Object o[]=new Object[10];
		    o[0]=u.getIdDV();
		    o[1]=u.getCantboletosn();
		    o[2]=u.getCantboletosv();
		    o[3]=u.getCostoboletosn();
		    o[4]=u.getCostoboletosv();
		    o[5]=u.getIdcombo();
		    o[6]=u.getIduser();
		    o[7]=u.getCosto();
		    o[8]=u.getIdfun();
		    o[9]=u.getCostot();
		    
		    model.addRow(o);
		   }
		   tblVenta.setModel(model);
		 }
	
	/**
	 * Create the application.
	 */
	public crudVentaEliminar() {
		initialize();
		 
		 actualizarTabla();

	}
	
	
	
	 	private void initialize() {
		frmCrudVentaEliminar = new JFrame();
		frmCrudVentaEliminar.setTitle("EliminarVenta");
		frmCrudVentaEliminar.setBounds(100, 100, 842, 284);
		frmCrudVentaEliminar.setLocationRelativeTo(null);
		frmCrudVentaEliminar.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 531, 203);
		frmCrudVentaEliminar.getContentPane().add(scrollPane);
		
		tblVenta = new JTable();
		tblVenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblVenta.getSelectedRow();
				x = listaTickets.get(fila);
				
			}
		});
		model.addColumn("ID DETALLEVENTA");
		model.addColumn("CANTIDAD DE BOLETOS NORMAL");
		model.addColumn("CANTIDAD DE BOLETOS VIP");
		model.addColumn("COSTO DE BOLETOS NORMAL");
		model.addColumn("COSTO DE BOLETOS VIP");
		model.addColumn("COMBO");
		model.addColumn("USUARIO");
		model.addColumn("PRECIO COMBO");
		model.addColumn("FUNCION");
		model.addColumn("TOTAL");
		scrollPane.setViewportView(tblVenta);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int op = JOptionPane.showConfirmDialog(null, "estas seguro de eliminar?", "Eliminar",
						JOptionPane.YES_NO_OPTION);
				System.out.print(op);
				if (op == 0) {

					if (x.EliminarTicket()) {
						JOptionPane.showMessageDialog(null, "se elimino correctamente");
						actualizarTabla();
					} else {
						JOptionPane.showMessageDialog(null, "Error");
					}
				}
			}
		});
		btnEliminar.setBounds(551, 10, 267, 203);
		frmCrudVentaEliminar.getContentPane().add(btnEliminar);
	}
	public void limpiarFormulario() {
		
	}
}
