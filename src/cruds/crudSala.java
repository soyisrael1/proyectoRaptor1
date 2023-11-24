package cruds;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Datas.DataSala;
import Entidades.Sala;
import rojerusan.RSTableMetro;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class crudSala {

	public JFrame frmCrudSala;
	private JTextField txtNumAsientos;
	private JTextField txtPantalla;
	private JTextField txtSonido;
	private JTextField txtNombre;
	private JTable tblSalas;
	private JScrollPane scrollPane;
	public ArrayList<Sala> listaSalas = new ArrayList<Sala>();
	public DefaultTableModel model= new DefaultTableModel();
	Sala x;
	ArrayList<Sala> lista;
	int fila = 0;
	int idSala = 0;
	private JLabel lblID;
	private JButton btnActualizar;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	
	public void actualizarTabla() {
		DataSala da = new DataSala();

		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}

		lista = da.SelectSala();
		for (Sala sala : lista) {
			Object o[] = new Object[4];
			
			o[0] = sala.getNumAsientos();
			o[1] = sala.getPantalla();
			o[2] = sala.getSonido();
			o[3] = sala.getNombre();
		
			
			model.addRow(o);

		}
		tblSalas.setModel(model);
	}
	/**
	 * Create the application.
	 */
	public crudSala() {
		initialize();
		actualizarTabla();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudSala = new JFrame();
		frmCrudSala.setBackground(Color.RED);
		frmCrudSala.setBounds(100, 100, 678, 500);
		frmCrudSala.setLocationRelativeTo(null);
		frmCrudSala.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Num Asientos");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial Black", Font.ITALIC, 12));
		lblNewLabel.setBounds(10, 39, 91, 31);
		frmCrudSala.getContentPane().add(lblNewLabel);
		
		lblNewLabel_3 = new JLabel("_____________");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(101, 39, 159, 32);
		frmCrudSala.getContentPane().add(lblNewLabel_3);
		
		txtNumAsientos = new JTextField();
		txtNumAsientos.setForeground(Color.WHITE);
		txtNumAsientos.setOpaque(false);
		txtNumAsientos.setBorder(null);
		txtNumAsientos.setBounds(108, 39, 96, 19);
		frmCrudSala.getContentPane().add(txtNumAsientos);
		txtNumAsientos.setColumns(10);
		
		lblNewLabel_4 = new JLabel("____________");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(82, 68, 122, 32);
		frmCrudSala.getContentPane().add(lblNewLabel_4);
		
		txtPantalla = new JTextField();
		txtPantalla.setForeground(Color.WHITE);
		txtPantalla.setOpaque(false);
		txtPantalla.setBorder(null);
		txtPantalla.setColumns(10);
		txtPantalla.setBounds(82, 68, 96, 19);
		frmCrudSala.getContentPane().add(txtPantalla);
		
		JLabel lblPantalla = new JLabel("Pantalla");
		lblPantalla.setForeground(Color.RED);
		lblPantalla.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblPantalla.setBounds(10, 69, 81, 31);
		frmCrudSala.getContentPane().add(lblPantalla);
		
		lblNewLabel_5 = new JLabel("____________");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(69, 104, 159, 32);
		frmCrudSala.getContentPane().add(lblNewLabel_5);
		
		txtSonido = new JTextField();
		txtSonido.setForeground(Color.WHITE);
		txtSonido.setOpaque(false);
		txtSonido.setBorder(null);
		txtSonido.setColumns(10);
		txtSonido.setBounds(69, 107, 96, 19);
		frmCrudSala.getContentPane().add(txtSonido);
		
		JLabel lblSonido = new JLabel("Sonido");
		lblSonido.setForeground(Color.RED);
		lblSonido.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblSonido.setBounds(10, 99, 62, 31);
		frmCrudSala.getContentPane().add(lblSonido);
		
		lblNewLabel_6 = new JLabel("___________");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(80, 130, 159, 32);
		frmCrudSala.getContentPane().add(lblNewLabel_6);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(Color.WHITE);
		txtNombre.setOpaque(false);
		txtNombre.setBorder(null);
		txtNombre.setColumns(10);
		txtNombre.setBounds(82, 130, 96, 19);
		frmCrudSala.getContentPane().add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.RED);
		lblNombre.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblNombre.setBounds(10, 130, 81, 31);
		frmCrudSala.getContentPane().add(lblNombre);
		
		scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.WHITE);
		scrollPane.setOpaque(false);
		scrollPane.setBackground(new Color(0,0,0));
		scrollPane.setBounds(280, 16, 378, 436);
		frmCrudSala.getContentPane().add(scrollPane);
		
		tblSalas = new RSTableMetro();
		tblSalas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblSalas.getSelectedRow();
				x = lista.get(fila);
				lblID.setText("" + x.getIdSala());
				txtNumAsientos.setText(x.getNumAsientos());
				txtPantalla.setText(x.getPantalla());
				txtSonido.setText(x.getSonido());
				txtNombre.setText(x.getNombre());
			}
		});
		((RSTableMetro) tblSalas).setColorBackgoundHead(new Color(231,0,32));
        ((RSTableMetro) tblSalas).setAltoHead(20);
        ((RSTableMetro) tblSalas).setColorFilasForeground1(Color.BLACK);
        ((RSTableMetro) tblSalas).setColorFilasForeground2(Color.BLACK);
        ((RSTableMetro) tblSalas).setColorFilasBackgound2(Color.LIGHT_GRAY);
        ((RSTableMetro) tblSalas).setColorSelBackgound(new Color(231, 0, 32));
        tblSalas.setForeground(Color.WHITE);
        scrollPane.setViewportView(tblSalas);
        model = new DefaultTableModel();
        model.addColumn("NUM ASIENTOS");
		  model.addColumn("PANTALLA");
		  model.addColumn("SONIDO");
		  model.addColumn("NOMBRE");
		  
        scrollPane.setViewportView(tblSalas);
		  
      scrollPane.setViewportView(tblSalas);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(10, 10, 43, 25);
		frmCrudSala.getContentPane().add(lblNewLabel_1);
		
		lblID = new JLabel("0");
		lblID.setForeground(Color.RED);
		lblID.setFont(new Font("Arial MT Black", Font.BOLD, 15));
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setBounds(38, 10, 34, 25);
		frmCrudSala.getContentPane().add(lblID);
		
		JButton btnAgregar = new JButton("");
		btnAgregar.setBorder(null);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.RED);
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Sala sala = new Sala();
				sala.setNumAsientos(txtNumAsientos.getText());
				sala.setPantalla(txtPantalla.getText());
				sala.setSonido(txtSonido.getText());
				sala.setNombre(txtNombre.getText());
				
				listaSalas.add(sala);
				actualizarTabla();
				limpiarFormulario();
				if (sala.insertarSala()) {
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
		btnAgregar.setIcon(new ImageIcon("C:\\Users\\travi\\Downloads\\tiinsdtxxc-removebg-preview.png"));
		btnAgregar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnAgregar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnAgregar.setHorizontalAlignment(SwingConstants.CENTER);
		btnAgregar.setBounds(10, 206, 115, 98);
		frmCrudSala.getContentPane().add(btnAgregar);
		
		btnActualizar = new JButton("");
		btnActualizar.setBorder(null);
		btnActualizar.setOpaque(false);
		btnActualizar.setBackground(Color.WHITE);
		btnActualizar.setIcon(new ImageIcon("C:\\Users\\travi\\Downloads\\upassaew-removebg-preview.png"));
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					x.setNumAsientos(txtNumAsientos.getText());
					x.setPantalla(txtPantalla.getText());
					x.setSonido(txtSonido.getText());
					x.setNombre(txtNombre.getText());
					
					if(x.actualizarSala()) {
						JOptionPane.showMessageDialog(null, "correcto");
						actualizarTabla();
						limpiarFormulario();
					}else {
						JOptionPane.showMessageDialog(null, "error");
					}
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "error");
				}
			}
		});
		btnActualizar.setBounds(10, 326, 218, 53);
		frmCrudSala.getContentPane().add(btnActualizar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\travi\\Downloads\\PROYECTVIC\\digidrty.jpg"));
		lblNewLabel_2.setBounds(0, 0, 688, 495);
		frmCrudSala.getContentPane().add(lblNewLabel_2);
	}
	public void limpiarFormulario() {
		
	}
}
