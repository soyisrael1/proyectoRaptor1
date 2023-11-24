package cruds;

import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Datas.DataSala;
import Entidades.Sala;
import rojerusan.RSTableMetro;

import java.awt.Color;

public class crudSalaEliminar {

	public JFrame frmCrudSalaEliminar;
	private JTable tblSalas;
	private JScrollPane scrollPane;
	public ArrayList<Sala> listaSalas = new ArrayList<Sala>();
	public DefaultTableModel model= new DefaultTableModel();
	Sala x;
	ArrayList<Sala> lista;
	int fila = 0;
	int idSala = 0;
	private JButton btnEliminar;
	private JLabel lblNewLabel;
	
	public void actualizarTabla() {
		DataSala da = new DataSala();

		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}

		lista = da.SelectSala();
		for (Sala sala : lista) {
			Object o[] = new Object[5];
			o[0] = sala.getIdSala();
			o[1] = sala.getNumAsientos();
			o[2] = sala.getPantalla();
			o[3] = sala.getSonido();
			o[4] = sala.getNombre();
		
			
			model.addRow(o);

		}
		tblSalas.setModel(model);
	}
	/**
	 * Create the application.
	 */
	public crudSalaEliminar() {
		initialize();
		actualizarTabla();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudSalaEliminar = new JFrame();
		frmCrudSalaEliminar.setTitle("EliminarSala");
		frmCrudSalaEliminar.setBounds(100, 100, 842, 284);
		frmCrudSalaEliminar.setLocationRelativeTo(null);
		frmCrudSalaEliminar.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 531, 203);
		frmCrudSalaEliminar.getContentPane().add(scrollPane);
		
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
	        model.addColumn("NUM ASIENTOS");
			  model.addColumn("PANTALLA");
			  model.addColumn("SONIDO");
			  model.addColumn("NOMBRE");
			  
	        scrollPane.setViewportView(tblSalas);
		
		btnEliminar = new JButton("");
		btnEliminar.setBackground(Color.RED);
		btnEliminar.setOpaque(false);
		btnEliminar.setBorder(null);
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\travi\\Downloads\\yig-removebg-preview.png"));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int op = JOptionPane.showConfirmDialog(null, "estas seguro de eliminar?", "Eliminar",
						JOptionPane.YES_NO_OPTION);
				System.out.print(op);
				if (op == 0) {

					if (x.EliminarSala()) {
						JOptionPane.showMessageDialog(null, "se elimino correctamente");
						actualizarTabla();
					} else {
						JOptionPane.showMessageDialog(null, "Error");
					}
				}
			}
		});
		btnEliminar.setBounds(551, 10, 267, 203);
		frmCrudSalaEliminar.getContentPane().add(btnEliminar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\travi\\Downloads\\PROYECTVIC\\jjoyu.jpg"));
		lblNewLabel.setBounds(0, 0, 826, 245);
		frmCrudSalaEliminar.getContentPane().add(lblNewLabel);
	}
	public void limpiarFormulario() {
		
	}
}
