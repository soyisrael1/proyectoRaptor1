package crudVenta;

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
import Datas.DataTicket;
import Entidades.Sala;
import Entidades.Ticket;
import rojerusan.RSTableMetro;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class crudVentaVer {

	public JFrame frmCrudVentasVer;
	private JTable tblSalas;
	private JScrollPane scrollPane;
	public ArrayList<Ticket> listaTicket = new ArrayList<Ticket>();
	public DefaultTableModel model= new DefaultTableModel();
	Ticket x;
	ArrayList<Ticket> lista;
	int fila = 0;
	int idSala = 0;
	private JButton btnPDF;
	private JLabel lblNewLabel;
	
	 public void actualizarTabla() {
		 DataTicket dc=new DataTicket();
		  while (model.getRowCount()>0) { 
		   model.removeRow(0);
		   }
		   lista = dc.SelectTicket();
		   for (Ticket u : lista) {
		    Object o[]=new Object[10];
		    o[0]=u.getIdDV();
		    o[1]=u.getCantboletosn();
		    o[2]=u.getCantboletosv();
		    o[3]=u.getCostoboletosn();
		    o[4]=u.getCostoboletosv();
		    o[5]=u.getIdcombo();
		    o[6]=u.getIduser();
		    o[7]=u.getCosto();
		    o[8]=u.getIdfun();
		    o[9]=u.getCostot();
		    
		    model.addRow(o);
		   }
		   tblSalas.setModel(model);
		 }
	/**
	 * Create the application.
	 */
	public crudVentaVer() {
		initialize();
		actualizarTabla();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudVentasVer = new JFrame();
		frmCrudVentasVer.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\8.png"));
		frmCrudVentasVer.setTitle("                                                   Ver Ventas");
		frmCrudVentasVer.setBounds(100, 100, 589, 640);
		frmCrudVentasVer.setLocationRelativeTo(null);
		frmCrudVentasVer.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 555, 462);
		frmCrudVentasVer.getContentPane().add(scrollPane);
		
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
		model.addColumn("ID TI");
		  model.addColumn("ID SALA");
		  model.addColumn("ID PELICULA");
		  model.addColumn("FEHCA");
		  model.addColumn("COSTO");
		  model.addColumn("TIPO");
		  model.addColumn("CANTIDAD ASIENTOS");
		scrollPane.setViewportView(tblSalas);
		
		btnPDF = new JButton("");
		btnPDF.setOpaque(false);
		btnPDF.setBorder(null);
		btnPDF.setBackground(Color.RED);
		btnPDF.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\pdhgg-removebg-preview.png"));
		btnPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarPDF();
			}
		});
		btnPDF.setBounds(10, 482, 555, 100);
		frmCrudVentasVer.getContentPane().add(btnPDF);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project3\\src\\IMG\\ipxf.png"));
		lblNewLabel.setBounds(0, 0, 575, 603);
		frmCrudVentasVer.getContentPane().add(lblNewLabel);
	}
	public void limpiarFormulario() {
		
	}
	public void generarPDF() {
        try {
               FileOutputStream archivo;
              
               File file = new File("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project2\\src\\PDF\\PDF Ventas.pdf");
              
               archivo = new FileOutputStream(file);
               Document doc = new Document();
               PdfWriter.getInstance(doc, archivo);
               doc.open();
              Image img = Image.getInstance("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project2\\src\\Imagenes\\pdf}.jpeg");
//               Image img = Image.getInstance(getClass().getResource("/imagenes/logooxxo.png"));
               img.setAlignment(Element.ALIGN_CENTER);
               img.scaleToFit(30, 30);
               doc.add(img);
               Paragraph p = new Paragraph(10);
               Font negrita = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.BLACK);
               p.add(Chunk.NEWLINE);
               p.add("CONTROL DE VENTAS");
               p.add(Chunk.NEWLINE);
               p.add(Chunk.NEWLINE);
               p.setAlignment(Element.ALIGN_CENTER);
               doc.add(p);
               //Tabla de datos
               PdfPTable tabla = new PdfPTable(10);
               
               tabla.setWidthPercentage(100);
               PdfPCell c1 = new PdfPCell(new Phrase("ID DV", negrita));
               PdfPCell c2 = new PdfPCell(new Phrase("CANT BOLETOS N", negrita));
               PdfPCell c3 = new PdfPCell(new Phrase("CANT BOLETOS V", negrita));
               PdfPCell c4 = new PdfPCell(new Phrase("COSTO BOLETOS N", negrita));
               PdfPCell c5 = new PdfPCell(new Phrase("COSTO BOLETOS V", negrita));
               PdfPCell c6 = new PdfPCell(new Phrase("COMBO", negrita));
               PdfPCell c7 = new PdfPCell(new Phrase("VENDIDO POR", negrita));
               PdfPCell c8 = new PdfPCell(new Phrase("COSTO COMBO", negrita));
               PdfPCell c9 = new PdfPCell(new Phrase("FUNCION", negrita));
               PdfPCell c10 = new PdfPCell(new Phrase("TOTAL", negrita));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               c2.setHorizontalAlignment(Element.ALIGN_CENTER);
               c3.setHorizontalAlignment(Element.ALIGN_CENTER);
               c4.setHorizontalAlignment(Element.ALIGN_CENTER);
               c5.setHorizontalAlignment(Element.ALIGN_CENTER);
               c6.setHorizontalAlignment(Element.ALIGN_CENTER);
               c7.setHorizontalAlignment(Element.ALIGN_CENTER);
               c8.setHorizontalAlignment(Element.ALIGN_CENTER);
               c9.setHorizontalAlignment(Element.ALIGN_CENTER);
               c10.setHorizontalAlignment(Element.ALIGN_CENTER);
               c1.setBackgroundColor(BaseColor.BLUE);
               c2.setBackgroundColor(BaseColor.BLUE);
               c3.setBackgroundColor(BaseColor.BLUE);
               c4.setBackgroundColor(BaseColor.BLUE);
               c5.setBackgroundColor(BaseColor.BLUE);
               c6.setBackgroundColor(BaseColor.BLUE);
               c7.setBackgroundColor(BaseColor.BLUE);
               c8.setBackgroundColor(BaseColor.BLUE);
               c9.setBackgroundColor(BaseColor.BLUE);
               c10.setBackgroundColor(BaseColor.BLUE);
               tabla.addCell(c1);
               tabla.addCell(c2);
               tabla.addCell(c3);
               tabla.addCell(c4);
               tabla.addCell(c5);
               tabla.addCell(c6);
               tabla.addCell(c7);
               tabla.addCell(c8);
               tabla.addCell(c9);
               tabla.addCell(c10);
               //Agregar los registros
               DataTicket dc=new DataTicket();
               listaTicket=dc.SelectTicket();
               for (Ticket c : listaTicket) {
                   tabla.addCell("" +c.getIdDV());
                   tabla.addCell("" + c.getCantboletosn());
                   tabla.addCell("" + c.getCantboletosv());
                   tabla.addCell("" + c.getCostoboletosn());
                   tabla.addCell("" + c.getCostoboletosv());
                   tabla.addCell("" + c.getIdcombo());
                   tabla.addCell("" + c.getIduser());
                   tabla.addCell("" + c.getCosto());
                   tabla.addCell("" + c.getIdfun());
                   tabla.addCell("" + c.getCostot());
                                  
               }
               doc.add(tabla);
               Paragraph p1 = new Paragraph(10);
               p1.add(Chunk.NEWLINE);
               p1.add("NÚMERO DE VENTAS: " + listaTicket.size());
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
               JOptionPane.showMessageDialog(frmCrudVentasVer, "" + ex.getMessage());
               //Logger.getLogger(todosPDF.class.getName()).log(Level.SEVERE, null, ex);
           }
   }
}
