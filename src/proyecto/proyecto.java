package proyecto;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

import data.Usuario;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.SwingConstants;

public class proyecto {

    JFrame frame;
    private JTextField txtCorreo;
    private JTextField txtPassword;
    public Usuario x = new Usuario();
    public int usuario;
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    proyecto window = new proyecto();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public proyecto() {
        initialize();
    }

    private void initialize() {
    	frame = new JFrame();
    	frame.setUndecorated(true);

		frame.setBounds(100, 100, 753, 446);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		

		JPanel panel = new JPanel();

		panel.setBackground(Color.WHITE);

		panel.setBounds(0, 37, 383, 409);

		frame.getContentPane().add(panel);

		panel.setLayout(null);

		

		JLabel lblNewLabel_1 = new JLabel("   Correo");

		lblNewLabel_1.setForeground(Color.RED);

		lblNewLabel_1.setFont(new Font("SimSun", Font.BOLD, 19));

		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 51, 153), 2, true));

		lblNewLabel_1.setBounds(103, 183, 126, 28);

		panel.add(lblNewLabel_1);

		

		txtCorreo = new JTextField();

		txtCorreo.setForeground(Color.BLACK);

		txtCorreo.setColumns(10);

		txtCorreo.setBorder(null);

		txtCorreo.setBackground(Color.WHITE);

		txtCorreo.setBounds(103, 214, 153, 20);

		panel.add(txtCorreo);

		

		JLabel lblNewLabel_1_1 = new JLabel(" Contraseña");

		lblNewLabel_1_1.setForeground(Color.RED);

		lblNewLabel_1_1.setFont(new Font("SimSun", Font.BOLD, 18));

		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 51, 153), 2, true));

		lblNewLabel_1_1.setBounds(103, 257, 126, 28);

		panel.add(lblNewLabel_1_1);

		

		JButton btnNewButton = new JButton("iniciar sesion");

		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW));

		btnNewButton.setBounds(103, 339, 153, 38);
		btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try {
    			    
    			    x.setCorreo(txtCorreo.getText());
    			    x.setPassword(encriptarPassword(txtPassword.getText()));
    			    
    			  
    			    if (x.login()) {
    			    	usuario=x.getIdUser();
    			        JOptionPane.showMessageDialog(null, "BIENVENIDO "+txtCorreo.getText());
    			        barraprogreso b = new barraprogreso(usuario);
    			        frame.setVisible(false);
    			        b.frmBarraDeProgreso.setVisible(true);
    			    } else {
    			        JOptionPane.showMessageDialog(null, "Correo/o Password");
    			    }
    			} catch (Exception e2) {
    			    e2.printStackTrace();
    			    JOptionPane.showMessageDialog(null, "ERROR");
    			}
    		}
    	});

		panel.add(btnNewButton);

		

		JLabel lblNewLabel_2 = new JLabel("_________________________");

		lblNewLabel_2.setBounds(103, 214, 221, 32);

		panel.add(lblNewLabel_2);

		

		txtPassword = new JTextField();

		txtPassword.setForeground(Color.BLACK);

		txtPassword.setColumns(10);

		txtPassword.setBorder(null);

		txtPassword.setBackground(Color.WHITE);

		txtPassword.setBounds(103, 296, 153, 20);

		panel.add(txtPassword);

		

		JLabel lblNewLabel_2_1 = new JLabel("_________________________");

		lblNewLabel_2_1.setBounds(103, 296, 221, 32);

		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Tickets Raptor");
		lblNewLabel_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Venus Rising", Font.PLAIN, 27));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 0, 353, 38);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\el buenop.gif"));
		lblNewLabel_4.setBounds(-15, 21, 326, 181);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\ozi.gif"));
		lblNewLabel.setBounds(381, 37, 372, 409);
		frame.getContentPane().add(lblNewLabel);

		

		JPanel panel_1 = new JPanel();

		panel_1.setBackground(Color.RED);

		panel_1.setBounds(0, 0, 997, 38);

		frame.getContentPane().add(panel_1);

	

}
    	
    	
                
         
    public String encriptarPassword(String password) {
        MessageDigest md;
        byte[] encoded = null;
        try {
            md = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            md.update(password.getBytes());
            byte[] digest = md.digest();

            for (byte b : digest) {
                // System.out.println(Integer.toHexString(0xFF & b));
            }
            System.out.println();

            encoded = Base64.encodeBase64(digest);
            // System.out.println(new String(encoded));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new String(encoded);
    }
    public void obtenerUsuario() {
    	
    }
    
}
