package crudCombos;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Datas.DataCombo;
import Datas.DataSala;
import Entidades.Combo;
import Entidades.Sala;
import rojerusan.RSTableMetro;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class crudComboVer {

	public JFrame frmCrudComboVer;
	private JTable tblSalas;
	private JScrollPane scrollPane;
	public ArrayList<Combo> listaSalas = new ArrayList<Combo>();
	public DefaultTableModel model= new DefaultTableModel();
	Combo x;
	ArrayList<Combo> lista;
	int fila = 0;
	int idSala = 0;
	private JButton btnPDF;
	private JTextField txtBuscar;
	
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
	
	 
	
	 public void refrescarTabla2(String palabra) {
		 DataCombo da=new DataCombo();
		 
	        while (model.getRowCount() > 0) {
	            model.removeRow(0);
	        }
	        lista = da.buscar(palabra);
	        
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
	public crudComboVer() {
		initialize();
		actualizarTabla();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudComboVer = new JFrame();
		frmCrudComboVer.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\8.png"));
		frmCrudComboVer.setTitle("                                                   Ver Combo");
		frmCrudComboVer.setBounds(100, 100, 589, 640);
		frmCrudComboVer.setLocationRelativeTo(null);
		frmCrudComboVer.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 555, 462);
		frmCrudComboVer.getContentPane().add(scrollPane);
		
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
        
        
		btnPDF = new JButton("");
		btnPDF.setBorder(null);
		btnPDF.setOpaque(false);
		btnPDF.setBackground(Color.RED);
		btnPDF.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\pdhgg-removebg-preview.png"));
		btnPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarPDF();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Buscar");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(94, 13, 98, 22);
		frmCrudComboVer.getContentPane().add(lblNewLabel_1);
		
		txtBuscar = new JTextField();
		 txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
	            public void keyReleased(java.awt.event.KeyEvent evt) {
	                txtBuscarKeyReleased(evt);
	            }
	        });
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(205, 16, 186, 19);
		frmCrudComboVer.getContentPane().add(txtBuscar);
		btnPDF.setBounds(205, 501, 186, 100);
		frmCrudComboVer.getContentPane().add(btnPDF);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\ipxf.png"));
		lblNewLabel.setBounds(0, 0, 573, 601);
		frmCrudComboVer.getContentPane().add(lblNewLabel);
	}
	public void limpiarFormulario() {
		
	}
	public void generarPDF() {
        try {
               FileOutputStream archivo;
              
               File file = new File("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project2\\src\\PDF\\PDF Salas.pdf");
              
               archivo = new FileOutputStream(file);
               Document doc = new Document();
               PdfWriter.getInstance(doc, archivo);
               doc.open();
              Image img = Image.getInstance("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project2\\src\\Imagenes\\pdf}.jpeg");
//               Image img = Image.getInstance(getClass().getResource("/imagenes/logooxxo.png"));
               img.setAlignment(Element.ALIGN_CENTER);
               img.scaleToFit(50, 50);
               doc.add(img);
               Paragraph p = new Paragraph(10);
               Font negrita = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
               p.add(Chunk.NEWLINE);
               p.add("CONTROL DE COMBOS");
               p.add(Chunk.NEWLINE);
               p.add(Chunk.NEWLINE);
               p.setAlignment(Element.ALIGN_CENTER);
               doc.add(p);
               //Tabla de datos
               PdfPTable tabla = new PdfPTable(6);
               tabla.setWidthPercentage(100);
               PdfPCell c1 = new PdfPCell(new Phrase("ID COMBO", negrita));
               PdfPCell c2 = new PdfPCell(new Phrase("TAMAÑO", negrita));
               PdfPCell c3 = new PdfPCell(new Phrase("NOMBRE", negrita));
               PdfPCell c4 = new PdfPCell(new Phrase("CANTIDAD DE PALOMITAS", negrita));
               PdfPCell c5 = new PdfPCell(new Phrase("COSTO", negrita));
               PdfPCell c6 = new PdfPCell(new Phrase("CANTIDAD DE REFRESCOS", negrita));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               c2.setHorizontalAlignment(Element.ALIGN_RIGHT);
               c3.setHorizontalAlignment(Element.ALIGN_CENTER);
               c4.setHorizontalAlignment(Element.ALIGN_CENTER);
               c5.setHorizontalAlignment(Element.ALIGN_CENTER);
               c6.setHorizontalAlignment(Element.ALIGN_CENTER);
               c1.setBackgroundColor(BaseColor.RED);
               c2.setBackgroundColor(BaseColor.RED);
               c3.setBackgroundColor(BaseColor.RED);
               c4.setBackgroundColor(BaseColor.RED);
               c5.setBackgroundColor(BaseColor.RED);
               c6.setBackgroundColor(BaseColor.RED);
               tabla.addCell(c1);
               tabla.addCell(c2);
               tabla.addCell(c3);
               tabla.addCell(c4);
               tabla.addCell(c5);
               tabla.addCell(c6);
               //Agregar los registros
               DataCombo dc=new DataCombo();
               listaSalas=dc.SelectCombo();
               for (Combo c : listaSalas) {
                   tabla.addCell("" +c.getIdcombo());
                   tabla.addCell("" + c.getTamaño());
                   tabla.addCell("" + c.getNombre());
                   tabla.addCell("" + c.getCantPalomitas());
                   tabla.addCell("" + c.getCosto());
                   tabla.addCell("" + c.getCantRefresco());
               }
               doc.add(tabla);
               Paragraph p1 = new Paragraph(10);
               p1.add(Chunk.NEWLINE);
               p1.add("NÚMERO DE SALAS: " + listaSalas.size());
               p1.add(Chunk.NEWLINE);
               p1.add(Chunk.NEWLINE);
               p1.setAlignment(Element.ALIGN_RIGHT);
               doc.add(p1);
               doc.close();
               archivo.close();
               Desktop.getDesktop().open(file);
           } catch (FileNotFoundException ex) {
           } catch (DocumentException ex) {
           } catch (IOException ex) {
               JOptionPane.showMessageDialog(frmCrudComboVer, "" + ex.getMessage());
               //Logger.getLogger(todosPDF.class.getName()).log(Level.SEVERE, null, ex);
           }
        
   }
	 private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
	        refrescarTabla2(txtBuscar.getText().toString());
	    }//GEN-LAST:event_txtBuscarKeyReleased
}