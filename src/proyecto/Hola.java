package proyecto;
import javax.swing.*;
import javax.swing.border.LineBorder;



import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hola {

    JFrame frmHola;
    String nombre = "";
    
    public Hola() {
        initialize();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void initialize() {

        frmHola = new JFrame();
        frmHola.setTitle("HOLA");
        frmHola.setExtendedState (JFrame.MAXIMIZED_BOTH);
        frmHola.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Amgel\\Downloads\\goku.jpg"));
        frmHola.setBounds(100, 100, 1550, 297);
        frmHola.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmHola.setLocationRelativeTo(null);
        frmHola.getContentPane().setLayout(null);
        
        JMenuBar menuBar = new JMenuBar();
        frmHola.setJMenuBar(menuBar);
        
        JMenu mnNewMenu = new JMenu("New menu");
        menuBar.add(mnNewMenu);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Dulceria");
        mntmNewMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        mnNewMenu.add(mntmNewMenuItem);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Compras");
        mnNewMenu.add(mntmNewMenuItem_1);
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("");
        mnNewMenu.add(mntmNewMenuItem_2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Hola frame = new Hola();
                frame.frmHola.setSize(450, 300);
                
                frame.frmHola.setVisible(true);
            }
        });
    }
}

