package crudPelicula;

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

import Datas.DataPelicula;
import Datas.DataSala;
import Entidades.Pelicula;
import Entidades.Sala;

public class crudPeliculaVer {
	public JFrame frmCrudPeliculaVer;
	private JTable tblSalas;
	private JScrollPane scrollPane;
	public ArrayList<Pelicula> listaSalas = new ArrayList<Pelicula>();
	public DefaultTableModel model= new DefaultTableModel();
	Pelicula x;
	ArrayList<Pelicula> lista;
	int fila = 0;
	int idPeli = 0;
	private JButton btnPDF;
	
	public void actualizarTabla() {
		DataPelicula da = new DataPelicula();

		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}

		lista = da.SelectPelicula();
		for (Pelicula sala : lista) {
			Object o[] = new Object[5];
			o[0] = sala.getIdPeli();
			o[1] = sala.getNombre();
			o[2] = sala.getCategoria();
			o[3] = sala.getRangoEdad();
			
		
			
			model.addRow(o);

		}
		tblSalas.setModel(model);
	}
	/**
	 * Create the application.
	 */
	public crudPeliculaVer() {
		initialize();
		actualizarTabla();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudPeliculaVer = new JFrame();
		frmCrudPeliculaVer.setTitle("                                                   Ver Peliculas");
		frmCrudPeliculaVer.setBounds(100, 100, 589, 640);
		frmCrudPeliculaVer.setLocationRelativeTo(null);
		frmCrudPeliculaVer.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 555, 462);
		frmCrudPeliculaVer.getContentPane().add(scrollPane);
		
		tblSalas = new JTable();
		tblSalas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblSalas.getSelectedRow();
				x = lista.get(fila);
				
			}
		});
		model.addColumn("ID PELI");
		  model.addColumn("NOMBRE");
		  model.addColumn("CATEGORIA");
		  model.addColumn("RANGO EDAD");
		  
		scrollPane.setViewportView(tblSalas);
		
		btnPDF = new JButton("PDF");
		btnPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarPDF();
			}
		});
		btnPDF.setBounds(10, 482, 555, 100);
		frmCrudPeliculaVer.getContentPane().add(btnPDF);
	}
	public void limpiarFormulario() {
		
	}
	public void generarPDF() {
        try {
               FileOutputStream archivo;
              
               File file = new File("C:\\Users\\Amgel\\eclipse-workspace\\jajjajajja\\project2\\src\\PDF\\PDF PELICULAS.pdf");
              
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
               p.add("CONTROL DE PELICULAS");
               p.add(Chunk.NEWLINE);
               p.add(Chunk.NEWLINE);
               p.setAlignment(Element.ALIGN_CENTER);
               doc.add(p);
               //Tabla de datos
               PdfPTable tabla = new PdfPTable(4);
               tabla.setWidthPercentage(100);
               PdfPCell c1 = new PdfPCell(new Phrase("ID PELI", negrita));
               PdfPCell c2 = new PdfPCell(new Phrase("NOMBRE", negrita));
               PdfPCell c3 = new PdfPCell(new Phrase("CATEGORIA", negrita));
               PdfPCell c4 = new PdfPCell(new Phrase("RANGOEDAD", negrita));
               
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               c2.setHorizontalAlignment(Element.ALIGN_RIGHT);
               c3.setHorizontalAlignment(Element.ALIGN_CENTER);
               c4.setHorizontalAlignment(Element.ALIGN_CENTER);
               
               c1.setBackgroundColor(BaseColor.PINK);
               c2.setBackgroundColor(BaseColor.BLUE);
               c3.setBackgroundColor(BaseColor.ORANGE);
               c4.setBackgroundColor(BaseColor.GREEN);
               
               tabla.addCell(c1);
               tabla.addCell(c2);
               tabla.addCell(c3);
               tabla.addCell(c4);
               
               //Agregar los registros
               DataPelicula dc=new DataPelicula();
               listaSalas=dc.SelectPelicula();
               for (Pelicula c : listaSalas) {
                   tabla.addCell("" +c.getIdPeli());
                   tabla.addCell("" + c.getNombre());
                   tabla.addCell("" + c.getCategoria());
                   tabla.addCell("" + c.getRangoEdad());
                   
               }
               doc.add(tabla);
               Paragraph p1 = new Paragraph(10);
               p1.add(Chunk.NEWLINE);
               p1.add("NÚMERO DE PELICULAS: " + listaSalas.size());
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
               JOptionPane.showMessageDialog(frmCrudPeliculaVer, "" + ex.getMessage());
               //Logger.getLogger(todosPDF.class.getName()).log(Level.SEVERE, null, ex);
           }
   }
}