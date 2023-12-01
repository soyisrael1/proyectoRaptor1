package proyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.border.LineBorder;

import crudCombos.crudCombo;
import crudCombos.crudComboEliminar;
import crudCombos.crudComboVer;
import crudFuncion.VerFunciones;
import crudFuncion.crudFuncion;
import crudFuncion.crudFuncionEliminar;
import crudPelicula.crudPelicula;
import crudPelicula.crudPeliculaEliminar;
import crudPelicula.crudPeliculaVer;
import crudUsuarios.crudUsuario;
import crudVenta.crudVenta;
import crudVenta.crudVentaEliminar;
import crudVenta.crudVentaVer;
import cruds.crudSala;
import cruds.crudSalaEliminar;
import cruds.crudSalaVer4;
import data.DataUsuario;
import data.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class cine<crudFuncionElimianr> {

	JFrame frmLobby;
	private JMenuItem mntmNewMenuItem_2;
	private JLabel lblNewLabel_3;
	private JLabel lblUEFEW;
	DataUsuario da=new DataUsuario();
	private JMenuItem mntmNewMenuItem_15;
	private JLabel lblUsuairo;
	int usuario;
	Usuario o=new Usuario();
	 ArrayList<Usuario> listaUsuario=new ArrayList<Usuario>();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 * @param usuario 
	 */
	public cine(int usuario) {
		initialize();
		this.usuario=usuario;
		lblUsuairo.setText("USUARIO:"+usuario);
		
	}
	public String getNombre(int idUser) {
		  String nombre = null;
		  for (Usuario u: listaUsuario) {
		   if(u.getIdUser()== usuario){
		    nombre = u.getNombre();
		    
		   }
		  }
		  return nombre;
		 }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLobby = new JFrame();
		frmLobby.setUndecorated(true);
		frmLobby.getContentPane().setBackground(new Color(0, 0, 0));
		frmLobby.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmLobby.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\travi\\Downloads\\PROYECTVIC\\8.png"));
		frmLobby.setTitle("Cine");
		frmLobby.setBounds(100, 100, 1500, 800);
		frmLobby.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLobby.setLocationRelativeTo(null);
		frmLobby.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 153), 3));
		panel_1.setBackground(new Color(0, 0, 0,80));
		panel_1.setBounds(56, 0, 1444, 101);
		frmLobby.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setForeground(new Color(255, 255, 255));
		menuBar_1.setBackground(new Color(255, 51, 0));
		menuBar_1.setBounds(20, 40, 1404, 44);
		panel_1.add(menuBar_1);
		
		JMenu mnNewMenu_1 = new JMenu("PELICULAS");
		mnNewMenu_1.setForeground(new Color(255, 255, 255));
		menuBar_1.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("VER");
		mntmNewMenuItem_4.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\ver1.png"));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudPeliculaVer pelicula = new crudPeliculaVer();
				pelicula.frmCrudPeliculaVer.setVisible(true);
			}
		});
		mntmNewMenuItem_4.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_4.setBackground(new Color(255, 51, 0));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("AÑADIR");
		mntmNewMenuItem_6.setIcon(new ImageIcon("C:\\Users\\Amgel\\Downloads\\imagenes java\\agg.gif"));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudPelicula pelicula = new crudPelicula();
				pelicula.frmCrudPelicula.setVisible(true);
			}
		});
		mntmNewMenuItem_6.setBackground(Color.RED);
		mntmNewMenuItem_6.setForeground(Color.WHITE);
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("ELIMINAR");
		mntmNewMenuItem_7.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\ba.jpeg"));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudPeliculaEliminar pelicula = new crudPeliculaEliminar();
				pelicula.frmCrudPeliculaEliminar.setVisible(true);
			}
		});
		mntmNewMenuItem_7.setBackground(Color.RED);
		mntmNewMenuItem_7.setForeground(Color.WHITE);
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu = new JMenu("VENTA");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		menuBar_1.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("VER");
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\ver1.png"));
		mntmNewMenuItem.setForeground(Color.WHITE);
		mntmNewMenuItem.setBackground(Color.RED);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudVentaVer venta = new crudVentaVer();
				venta.frmCrudVentasVer.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("AÑADIR");
		mntmNewMenuItem_1.setForeground(Color.WHITE);
		mntmNewMenuItem_1.setBackground(Color.RED);
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\Amgel\\Downloads\\imagenes java\\agg.gif"));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudVenta venta = new crudVenta(usuario);
				venta.frmCrudVenta.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("ELIMINAR");
		mntmNewMenuItem_2.setForeground(Color.WHITE);
		mntmNewMenuItem_2.setBackground(Color.RED);
		mntmNewMenuItem_2.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\ba.jpeg"));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			crudVentaEliminar venta = new crudVentaEliminar();
			venta.frmCrudVentaEliminar.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("SALA");
		mnNewMenu_3.setBackground(new Color(255, 255, 255));
		mnNewMenu_3.setForeground(new Color(255, 255, 255));
		menuBar_1.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("AÑADIR/ACTUALIZAR SALA ");
		mntmNewMenuItem_5.setIcon(new ImageIcon("C:\\Users\\Amgel\\Downloads\\imagenes java\\agg.gif"));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudSala sala = new crudSala();
				sala.frmCrudSala.setVisible(true);
			}
		});
		mntmNewMenuItem_5.setBackground(Color.RED);
		mntmNewMenuItem_5.setForeground(Color.WHITE);
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("ELIMINAR SALA");
		mntmNewMenuItem_8.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\ba.jpeg"));
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudSalaEliminar sala = new crudSalaEliminar();
				sala.frmCrudSalaEliminar.setVisible(true);
			}
		});
		mntmNewMenuItem_8.setBackground(Color.RED);
		mntmNewMenuItem_8.setForeground(Color.WHITE);
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("VER SALA");
		mntmNewMenuItem_9.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\ver1.png"));
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudSalaVer4 sala = new crudSalaVer4();
				sala.frmCrudSalaVer.setVisible(true);
			}
		});
		mntmNewMenuItem_9.setBackground(Color.RED);
		mntmNewMenuItem_9.setForeground(Color.WHITE);
		mnNewMenu_3.add(mntmNewMenuItem_9);
		
		JMenu mnNewMenu_2 = new JMenu("COMBOS");
		mnNewMenu_2.setForeground(new Color(255, 255, 255));
		menuBar_1.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("AGREGAR COMBO");
		mntmNewMenuItem_3.setForeground(Color.WHITE);
		mntmNewMenuItem_3.setBackground(Color.RED);
		mntmNewMenuItem_3.setIcon(new ImageIcon("C:\\Users\\Amgel\\Downloads\\imagenes java\\agg.gif"));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudCombo sala = new crudCombo();
				sala.frmCrudCombo.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("VER COMBO");
		mntmNewMenuItem_10.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\ver1.png"));
		mntmNewMenuItem_10.setForeground(Color.WHITE);
		mntmNewMenuItem_10.setBackground(Color.RED);
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudComboVer sala = new crudComboVer();
				sala.frmCrudComboVer.setVisible(true);
			}
			
		});
		mnNewMenu_2.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("ELIMINAR COMBO");
		mntmNewMenuItem_11.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\ba.jpeg"));
		mntmNewMenuItem_11.setForeground(Color.WHITE);
		mntmNewMenuItem_11.setBackground(Color.RED);
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudComboEliminar sala = new crudComboEliminar();
				sala.frmCrudComboEliminar.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_11);
		
		JMenu mnNewMenu_4 = new JMenu("FUNCION");
		mnNewMenu_4.setForeground(new Color(255, 255, 255));
		menuBar_1.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("AÑADIR/ACTUALIZAR");
		mntmNewMenuItem_12.setForeground(Color.WHITE);
		mntmNewMenuItem_12.setBackground(Color.RED);
		mntmNewMenuItem_12.setIcon(new ImageIcon("C:\\Users\\Amgel\\Downloads\\imagenes java\\agg.gif"));
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudFuncion sala = new crudFuncion();
				sala.frmCrudFuncion.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("ELIMINAR FUNCION");
		mntmNewMenuItem_13.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\ba.jpeg"));
		mntmNewMenuItem_13.setForeground(Color.WHITE);
		mntmNewMenuItem_13.setBackground(Color.RED);
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudFuncionEliminar sala1 = new crudFuncionEliminar();
				sala1.frmCrudFuncionEliminar.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_13);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("VER FUNCION");
		mntmNewMenuItem_14.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\ver1.png"));
		mntmNewMenuItem_14.setForeground(Color.WHITE);
		mntmNewMenuItem_14.setBackground(Color.RED);
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerFunciones sala =new VerFunciones();
				sala.frmCrudSalaVer.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_14);
		
		JMenu mnNewMenu_5 = new JMenu("USUARIOS");
		mnNewMenu_5.setForeground(Color.WHITE);
		menuBar_1.add(mnNewMenu_5);
		
		mntmNewMenuItem_15 = new JMenuItem("USUARIOS");
		mntmNewMenuItem_15.setForeground(Color.WHITE);
		mntmNewMenuItem_15.setBackground(Color.RED);
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudUsuario sala =new crudUsuario();
				sala.frmCrudUsuario.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_15);
		
		JLabel lblNewLabel_5_1 = new JLabel(" TICKET RAPTOR");
		lblNewLabel_5_1.setBounds(10, 0, 264, 30);
		panel_1.add(lblNewLabel_5_1);
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		lblUEFEW = new JLabel(" No solo vendemos boleto vendemos una experiencia inolvidable");
		lblUEFEW.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblUEFEW.setHorizontalAlignment(SwingConstants.CENTER);
		lblUEFEW.setBounds(-57, 0, 1481, 44);
		panel_1.add(lblUEFEW);
		lblUEFEW.setForeground(Color.WHITE);
		
		lblUsuairo = new JLabel("USUARIO:");
		lblUsuairo.setBounds(1212, 8, 212, 33);
		panel_1.add(lblUsuairo);
		lblUsuairo.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblUsuairo.setForeground(new Color(255, 255, 255));
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Amgel\\Downloads\\salir (2).png"));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmLobby.dispose();
				proyecto login=new proyecto();
				login.frame.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Amgel\\Downloads\\8.png"));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 153), 3));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(0, 0, 1500, 101);
		frmLobby.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CERRAR SESION");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(522, 642, 161, 43);
		frmLobby.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("FINALIZAR PROGRAMA");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_2_1.setBounds(830, 642, 232, 43);
		frmLobby.getContentPane().add(lblNewLabel_2_1);
		
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(538, 506, 113, 126);
		frmLobby.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmLobby.dispose();
			}
		});
		lblNewLabel_3_1.setIcon(new ImageIcon("C:\\Users\\Amgel\\Downloads\\cerrar pestaña.png"));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(874, 520, 123, 112);
		frmLobby.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Amgel\\Downloads\\rojo4 (1).png"));
		lblNewLabel_6.setBounds(0, 0, 1511, 800);
		frmLobby.getContentPane().add(lblNewLabel_6);
	}
}
