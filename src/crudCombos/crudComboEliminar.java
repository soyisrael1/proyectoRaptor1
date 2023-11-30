package crudCombos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Datas.DataCombo;
import Datas.DataSala;
import Entidades.Combo;
import Entidades.Sala;
import rojerusan.RSTableMetro;
import java.awt.Toolkit;

public class crudComboEliminar {

	public JFrame frmCrudComboEliminar;
	private JTable tblSalas;
	private JScrollPane scrollPane;
	public ArrayList<Combo> listaSalas = new ArrayList<Combo>();
	public DefaultTableModel model= new DefaultTableModel();
	Combo x;
	ArrayList<Combo> lista;
	int fila = 0;
	int idSala = 0;
	private JButton btnEliminar;
	private JLabel lblNewLabel;
	
	public void actualizarTabla() {
		DataCombo da = new DataCombo();

		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}

		lista = da.SelectCombo();
		for (Combo sala : lista) {
			Object o[] = new Object[5];
			
			o[0] = sala.getTamaño();
			o[1] = sala.getNombre();
			o[2] = sala.getCantPalomitas();
			o[3] = sala.getCantRefresco();
			o[4] = sala.getCosto();
			
		
			
			model.addRow(o);

		}
		tblSalas.setModel(model);
	}
	/**
	 * Create the application.
	 */
	public crudComboEliminar() {
		initialize();
		actualizarTabla();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudComboEliminar = new JFrame();
		frmCrudComboEliminar.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\8.png"));
		frmCrudComboEliminar.setTitle("EliminarCombo");
		frmCrudComboEliminar.setBounds(100, 100, 842, 284);
		frmCrudComboEliminar.setLocationRelativeTo(null);
		frmCrudComboEliminar.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 531, 203);
		frmCrudComboEliminar.getContentPane().add(scrollPane);
		
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
	        tblSalas.setForeground(Color.WHITE);
	        scrollPane.setViewportView(tblSalas);
	        model = new DefaultTableModel();
	        model.addColumn("TAMAÑO");
			  model.addColumn("NOMBRE");
			  model.addColumn("CANTIDAD DE PALOMITAS");
			  model.addColumn("COSTO");
			  model.addColumn("CANTIDAD DE REFRESCO");
			  
	        scrollPane.setViewportView(tblSalas);
		
		btnEliminar = new JButton("");
		btnEliminar.setBackground(Color.RED);
		btnEliminar.setOpaque(false);
		btnEliminar.setBorder(null);
		btnEliminar.setIcon(new ImageIcon(crudComboEliminar.class.getResource("/IMG/yig-removebg-preview.png")));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int op = JOptionPane.showConfirmDialog(null, "estas seguro de eliminar?", "Eliminar",
						JOptionPane.YES_NO_OPTION);
				System.out.print(op);
				if (op == 0) {

					if (x.EliminarCombo()) {
						JOptionPane.showMessageDialog(null, "se elimino correctamente");
						actualizarTabla();
					} else {
						JOptionPane.showMessageDialog(null, "Error");
					}
				}
			}
		});
		btnEliminar.setBounds(551, 10, 267, 203);
		frmCrudComboEliminar.getContentPane().add(btnEliminar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(crudComboEliminar.class.getResource("/IMG/jjoyu.jpg")));
		lblNewLabel.setBounds(0, 0, 826, 245);
		frmCrudComboEliminar.getContentPane().add(lblNewLabel);
	}
	public void limpiarFormulario() {
		
	}
}