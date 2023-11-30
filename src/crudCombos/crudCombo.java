package crudCombos;

import java.awt.Color;
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

import Datas.DataCombo;
import Datas.DataSala;
import Entidades.Combo;
import Entidades.Sala;
import rojerusan.RSTableMetro;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Toolkit;

public class crudCombo {
	public JFrame frmCrudCombo;
	private JTextField txtTamaño;
	private JTextField txtNombre;
	private JTable tblSalas;
	private JScrollPane scrollPane;
	public ArrayList<Combo> listaCombos = new ArrayList<Combo>();
	public DefaultTableModel model= new DefaultTableModel();
	Combo x;
	ArrayList<Combo> lista;
	int fila = 0;
	int idSala = 0;
	int CantidadDePalomitas;
	int CantidadDeRefresco;
	int Costo;
	private JLabel lblID;
	private JButton btnActualizar;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblSonido_1;
	private JSpinner spnCosto;
	private JSpinner spnCantidadPalomitas;
	private JSpinner spnCantidadRefrescos;
	
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
	public crudCombo() {
		initialize();
		actualizarTabla();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudCombo = new JFrame();
		frmCrudCombo.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\8.png"));
		frmCrudCombo.setBackground(Color.RED);
		frmCrudCombo.setBounds(100, 100, 678, 500);
		frmCrudCombo.setLocationRelativeTo(null);
		frmCrudCombo.getContentPane().setLayout(null);
		
		spnCantidadPalomitas = new JSpinner();
		spnCantidadPalomitas.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				CantidadDePalomitas=(int) spnCantidadPalomitas.getValue();
			}
		});
		spnCantidadPalomitas.setBackground(Color.WHITE);
		spnCantidadPalomitas.setForeground(Color.BLACK);
		spnCantidadPalomitas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnCantidadPalomitas.setBounds(202, 99, 43, 31);
		frmCrudCombo.getContentPane().add(spnCantidadPalomitas);
		
		spnCantidadRefrescos = new JSpinner();
		spnCantidadRefrescos.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				CantidadDeRefresco=(int) spnCantidadRefrescos.getValue();
			}
		});
		spnCantidadRefrescos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnCantidadRefrescos.setBounds(202, 143, 43, 31);
		frmCrudCombo.getContentPane().add(spnCantidadRefrescos);
		
		JLabel lblNewLabel = new JLabel("Tamaño");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial Black", Font.ITALIC, 12));
		lblNewLabel.setBounds(10, 39, 91, 31);
		frmCrudCombo.getContentPane().add(lblNewLabel);
		
		lblNewLabel_3 = new JLabel("_____________");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(101, 39, 159, 32);
		frmCrudCombo.getContentPane().add(lblNewLabel_3);
		
		spnCosto = new JSpinner();
		spnCosto.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Costo=(int) spnCosto.getValue();
			}
		});
		spnCosto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spnCosto.setBounds(82, 176, 43, 31);
		frmCrudCombo.getContentPane().add(spnCosto);
		
		txtTamaño = new JTextField();
		txtTamaño.setForeground(Color.WHITE);
		txtTamaño.setOpaque(false);
		txtTamaño.setBorder(null);
		txtTamaño.setBounds(108, 39, 96, 19);
		frmCrudCombo.getContentPane().add(txtTamaño);
		txtTamaño.setColumns(10);
		
		lblNewLabel_4 = new JLabel("____________");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(82, 68, 122, 32);
		frmCrudCombo.getContentPane().add(lblNewLabel_4);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(Color.WHITE);
		txtNombre.setOpaque(false);
		txtNombre.setBorder(null);
		txtNombre.setColumns(10);
		txtNombre.setBounds(82, 68, 96, 19);
		frmCrudCombo.getContentPane().add(txtNombre);
		
		lblSonido_1 = new JLabel("CantidadDeRefrescos");
		lblSonido_1.setForeground(Color.RED);
		lblSonido_1.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblSonido_1.setBounds(10, 135, 182, 31);
		frmCrudCombo.getContentPane().add(lblSonido_1);
		
		JLabel lblPantalla = new JLabel("Nombre");
		lblPantalla.setForeground(Color.RED);
		lblPantalla.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblPantalla.setBounds(10, 69, 81, 31);
		frmCrudCombo.getContentPane().add(lblPantalla);
		
		JLabel lblSonido = new JLabel("CantidadDePalomitas");
		lblSonido.setForeground(Color.RED);
		lblSonido.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblSonido.setBounds(10, 99, 182, 31);
		frmCrudCombo.getContentPane().add(lblSonido);
		
		JLabel lblNombre = new JLabel("Costo");
		lblNombre.setForeground(Color.RED);
		lblNombre.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblNombre.setBounds(10, 176, 81, 31);
		frmCrudCombo.getContentPane().add(lblNombre);
		
		scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.WHITE);
		scrollPane.setOpaque(false);
		scrollPane.setBackground(new Color(0,0,0));
		scrollPane.setBounds(319, 16, 339, 436);
		frmCrudCombo.getContentPane().add(scrollPane);
		
		tblSalas = new RSTableMetro();
		tblSalas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblSalas.getSelectedRow();
				x = lista.get(fila);
				lblID.setText("" + x.getIdcombo());
				txtTamaño.setText(x.getTamaño());
				txtNombre.setText(x.getNombre());
				spnCosto.setValue(x.getCosto());
				spnCantidadPalomitas.setValue(x.getCantPalomitas());
				spnCantidadRefrescos.setValue(x.getCantRefresco());
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
        model.addColumn("TAMAÑO");
		  model.addColumn("NOMBRE");
		  model.addColumn("CANTIDAD DE PALOMITAS");
		  model.addColumn("COSTO");
		  model.addColumn("CANTIDAD DE REFRESCO");
		  
        scrollPane.setViewportView(tblSalas);
		  
      scrollPane.setViewportView(tblSalas);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(10, 10, 43, 25);
		frmCrudCombo.getContentPane().add(lblNewLabel_1);
		
		lblID = new JLabel("0");
		lblID.setForeground(Color.RED);
		lblID.setFont(new Font("Arial MT Black", Font.BOLD, 15));
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setBounds(38, 10, 34, 25);
		frmCrudCombo.getContentPane().add(lblID);
		
		JButton btnAgregar = new JButton("");
		btnAgregar.setBorder(null);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.RED);
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Combo sala = new Combo();
				sala.setTamaño(txtTamaño.getText());
				sala.setNombre(txtNombre.getText());
				sala.setCantPalomitas(CantidadDePalomitas);
				sala.setCosto(Costo);
				sala.setCantRefresco(CantidadDeRefresco);
				listaCombos.add(sala);
				actualizarTabla();
				limpiarFormulario();
				if (sala.insertarCombo()) {
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
		btnAgregar.setIcon(new ImageIcon(crudCombo.class.getResource("/IMG/tiinsdt-removebg-preview.png")));
		btnAgregar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnAgregar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnAgregar.setHorizontalAlignment(SwingConstants.CENTER);
		btnAgregar.setBounds(89, 291, 115, 98);
		frmCrudCombo.getContentPane().add(btnAgregar);
		
		btnActualizar = new JButton("");
		btnActualizar.setBorder(null);
		btnActualizar.setOpaque(false);
		btnActualizar.setBackground(Color.WHITE);
		btnActualizar.setIcon(new ImageIcon(crudCombo.class.getResource("/IMG/upassaew-removebg-preview.png")));
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					x.setTamaño(txtTamaño.getText());
					x.setNombre(txtNombre.getText());
					x.setCantPalomitas(CantidadDePalomitas);
					x.setCosto(Costo);
					x.setCantRefresco(CantidadDeRefresco);
					if(x.actualizarCombo()) {
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
		btnActualizar.setBounds(38, 399, 218, 53);
		frmCrudCombo.getContentPane().add(btnActualizar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(crudCombo.class.getResource("/IMG/digidrty.jpg")));
		lblNewLabel_2.setBounds(0, 0, 688, 495);
		frmCrudCombo.getContentPane().add(lblNewLabel_2);
	}
	public void limpiarFormulario() {
		
	}
}