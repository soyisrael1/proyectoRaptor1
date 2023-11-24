package cruds;

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

import javax.swing.JButton;
import javax.swing.JFrame;
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

import Datas.DataSala;
import Entidades.Sala;
import rojerusan.RSTableMetro;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;

public class crudSalaVer4 {

	public JFrame frmCrudSalaVer;
	private JTable tblSalas;
	private JScrollPane scrollPane;
	public ArrayList<Sala> listaSalas = new ArrayList<Sala>();
	public DefaultTableModel model= new DefaultTableModel();
	Sala x;
	ArrayList<Sala> lista;
	int fila = 0;
	int idSala = 0;
	private JButton btnPDF;
	
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
	public crudSalaVer4() {
		initialize();
		actualizarTabla();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudSalaVer = new JFrame();
		frmCrudSalaVer.setTitle("                                                   Ver Salas");
		frmCrudSalaVer.setBounds(100, 100, 589, 640);
		frmCrudSalaVer.setLocationRelativeTo(null);
		frmCrudSalaVer.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 555, 462);
		frmCrudSalaVer.getContentPane().add(scrollPane);
		
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
	        model.addColumn("NUM ASIENTOS");
			  model.addColumn("PANTALLA");
			  model.addColumn("SONIDO");
			  model.addColumn("NOMBRE");
			  
	        scrollPane.setViewportView(tblSalas);
        
        
		btnPDF = new JButton("");
		btnPDF.setBorder(null);
		btnPDF.setOpaque(false);
		btnPDF.setBackground(Color.RED);
		btnPDF.setIcon(new ImageIcon("C:\\Users\\travi\\Downloads\\pdhgg-removebg-preview.png"));
		btnPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarPDF();
			}
		});
		btnPDF.setBounds(172, 482, 186, 100);
		frmCrudSalaVer.getContentPane().add(btnPDF);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\travi\\Downloads\\PROYECTVIC\\ipxf.png"));
		lblNewLabel.setBounds(0, 0, 573, 601);
		frmCrudSalaVer.getContentPane().add(lblNewLabel);
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
               p.add("CONTROL DE CELULARES");
               p.add(Chunk.NEWLINE);
               p.add(Chunk.NEWLINE);
               p.setAlignment(Element.ALIGN_CENTER);
               doc.add(p);
               //Tabla de datos
               PdfPTable tabla = new PdfPTable(5);
               tabla.setWidthPercentage(100);
               PdfPCell c1 = new PdfPCell(new Phrase("ID SALA", negrita));
               PdfPCell c2 = new PdfPCell(new Phrase("NUM ASIENTOS", negrita));
               PdfPCell c3 = new PdfPCell(new Phrase("PANTALLA", negrita));
               PdfPCell c4 = new PdfPCell(new Phrase("SONIDO", negrita));
               PdfPCell c5 = new PdfPCell(new Phrase("NOMBRE", negrita));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               c2.setHorizontalAlignment(Element.ALIGN_RIGHT);
               c3.setHorizontalAlignment(Element.ALIGN_CENTER);
               c4.setHorizontalAlignment(Element.ALIGN_CENTER);
               c5.setHorizontalAlignment(Element.ALIGN_CENTER);
               c1.setBackgroundColor(BaseColor.RED);
               c2.setBackgroundColor(BaseColor.RED);
               c3.setBackgroundColor(BaseColor.RED);
               c4.setBackgroundColor(BaseColor.RED);
               c5.setBackgroundColor(BaseColor.RED);
               tabla.addCell(c1);
               tabla.addCell(c2);
               tabla.addCell(c3);
               tabla.addCell(c4);
               tabla.addCell(c5);
               //Agregar los registros
               DataSala dc=new DataSala();
               listaSalas=dc.SelectSala();
               for (Sala c : listaSalas) {
                   tabla.addCell("" +c.getIdSala());
                   tabla.addCell("" + c.getNumAsientos());
                   tabla.addCell("" + c.getPantalla());
                   tabla.addCell("" + c.getSonido());
                   tabla.addCell("" + c.getNombre());
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
               JOptionPane.showMessageDialog(frmCrudSalaVer, "" + ex.getMessage());
               //Logger.getLogger(todosPDF.class.getName()).log(Level.SEVERE, null, ex);
           }
   }
}
