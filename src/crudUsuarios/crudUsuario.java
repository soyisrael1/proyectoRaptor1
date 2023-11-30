package crudUsuarios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

import data.DataUsuario;
import data.Usuario;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class crudUsuario {

	public JFrame frmCrudUsuario;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtPassword;
	private JTextField txtNombre;
	private JButton btnAgregaar;
	private JTable tblUsuarios;
	DefaultTableModel model = new DefaultTableModel();
	ArrayList<Usuario> listaUsuario;
	DataUsuario du = new DataUsuario();
	Usuario u = null;
	int fila = 0;
	int id = 0;
	private JLabel txtidUser;

	public crudUsuario() {
		initialize();
		actualizarTabla();

	}

	public void actualizarTabla() {
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
		listaUsuario = du.selectUsuarios();
		for (Usuario u : listaUsuario) {
			Object o[] = new Object[4];
			o[0] = u.getIdUser();
			o[1] = u.getCorreo();
			
			o[2] = u.getPassword();
			o[3] = u.getNombre();
			model.addRow(o);

		}
		tblUsuarios.setModel(model);
	}

	private void initialize() {
		frmCrudUsuario = new JFrame();
		frmCrudUsuario.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\8.png"));
		frmCrudUsuario.setTitle("CRUD USUARIO");
		frmCrudUsuario.setBounds(100, 100, 783, 569);
		
		frmCrudUsuario.setLocationRelativeTo(null);
		frmCrudUsuario.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("IdUser");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(23, 10, 90, 29);
		frmCrudUsuario.getContentPane().add(lblNewLabel);

		txtidUser = new JLabel("");
		txtidUser.setForeground(Color.WHITE);
		txtidUser.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtidUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtidUser.setBounds(141, 10, 90, 29);
		frmCrudUsuario.getContentPane().add(txtidUser);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCorreo.setBounds(23, 59, 84, 29);
		frmCrudUsuario.getContentPane().add(lblCorreo);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTelefono.setBounds(23, 100, 90, 29);
		frmCrudUsuario.getContentPane().add(lblTelefono);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(23, 139, 103, 29);
		frmCrudUsuario.getContentPane().add(lblPassword);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombre.setBounds(23, 178, 84, 29);
		frmCrudUsuario.getContentPane().add(lblNombre);

		txtCorreo = new JTextField();
		txtCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCorreo.getText().length() >= 100) {
					e.consume();
				}
			}
		});
		txtCorreo.setBounds(123, 68, 190, 19);
		frmCrudUsuario.getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtTelefono.getText().length() >= 10) {
					e.consume();
				}
			}
		});
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(123, 109, 190, 19);
		frmCrudUsuario.getContentPane().add(txtTelefono);

		txtPassword = new JTextField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtPassword.getText().length() >= 100) {
					e.consume();
				}
			}
		});
		txtPassword.setColumns(10);
		txtPassword.setBounds(123, 148, 190, 19);
		frmCrudUsuario.getContentPane().add(txtPassword);

		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNombre.getText().length() >= 10) {
					e.consume();
				}
			}
		});
		txtNombre.setColumns(10);
		txtNombre.setBounds(123, 187, 190, 19);
		frmCrudUsuario.getContentPane().add(txtNombre);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\dd.jpeg"));
		
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAgregar.setForeground(new Color(0, 0, 0));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuario x = new Usuario();
					x.setCorreo(txtCorreo.getText());
					
					x.setPassword(encriptarPassword(txtPassword.getText()));
					x.setNombre(txtNombre.getText());
					if (x.insertarUsuario()) {
						JOptionPane.showMessageDialog(null, "SE INSERTÓ CORRECTAMENTE");
						actualizarTabla();
						limpiarFormulario();
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}
				} catch (Exception e2) {

					JOptionPane.showMessageDialog(null, "ERROR");
				}

			}
		});
		btnAgregar.setBounds(377, 56, 147, 38);
		frmCrudUsuario.getContentPane().add(btnAgregar);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\ac.jpeg"));
		
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					u.setCorreo(txtCorreo.getText());
					
					u.setPassword(encriptarPassword(txtPassword.getText()));
					u.setNombre(txtNombre.getText());
					if (u.actualizarUsuario()) {
						JOptionPane.showMessageDialog(null, "SE ACTUALIZO CORRECTAMENTE");
						actualizarTabla();
						limpiarFormulario();
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}
				} catch (Exception e2) {

					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnActualizar.setBounds(565, 56, 147, 38);
		frmCrudUsuario.getContentPane().add(btnActualizar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\si3.png"));
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int op = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar registro?", "Eliminar",
							JOptionPane.YES_NO_OPTION);
					if (op == 0) {
						if (u.eliminarUsuario()) {
							JOptionPane.showMessageDialog(null, "Se elimino correctamente");
							actualizarTabla();
							limpiarFormulario();
							u = null;
						}
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminar.setBounds(565, 136, 147, 38);
		frmCrudUsuario.getContentPane().add(btnEliminar);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\ba.jpeg"));
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txtidUser.setText(" ");
			txtCorreo.setText(" ");
			txtTelefono.setText(" ");
			txtPassword.setText(" ");
			txtNombre.setText(" ");
		
			}
			});
		btnBorrar.setFont(new Font("Verdana", Font.BOLD, 14));
		btnBorrar.setBounds(377, 136, 147, 38);
		frmCrudUsuario.getContentPane().add(btnBorrar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(94, 226, 572, 268);
		frmCrudUsuario.getContentPane().add(scrollPane);

		tblUsuarios = new JTable();
		tblUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblUsuarios.getSelectedRow();
				u = listaUsuario.get(fila);
				txtidUser.setText("" + u.getIdUser());
				txtCorreo.setText(u.getCorreo());
			
				txtPassword.setText(u.getPassword());
				txtNombre.setText(u.getNombre());
			}
		});
		model.addColumn("ID USER");
		model.addColumn("CORREO");
		
		model.addColumn("PASSWORD");
		model.addColumn("NOMBRE");
		tblUsuarios.setModel(model);

		scrollPane.setViewportView(tblUsuarios);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\rojo4 (1).png"));
		lblNewLabel_1.setBounds(0, 0, 769, 532);
		frmCrudUsuario.getContentPane().add(lblNewLabel_1);
	}

	public void limpiarFormulario() {
		txtidUser.setText("");
		txtCorreo.setText("");
		txtTelefono.setText("");
		txtPassword.setText("");
		txtNombre.setText("");
	}

	public String encriptarPassword(String password) {
		MessageDigest md;
		byte[] encoded = null;
		try {
			md = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
			md.update(password.getBytes());
			byte[] digest = md.digest();

			for (byte b : digest) {
				System.out.println(Integer.toHexString(0xFF & b));
			}
			System.out.println();

			encoded = Base64.encodeBase64(digest);
			System.out.println(new String(encoded));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return new String(encoded);

	}
}
