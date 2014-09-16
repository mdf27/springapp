/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.UI.Stock;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uy.com.dusa.ws.DataLaboratorio;
import uy.com.dusa.ws.DataLineaLaboratorio;
import uy.com.dusa.ws.ResultGetLaboratorio;
import uy.com.dusa.ws.WSConsultaStock;
import uy.com.dusa.ws.WSConsultaStockService;

@Controller
public class hacerPDFController {
    @RequestMapping(value = "verPDF")
    private void downloadPDF(@RequestParam(value = "id") String idLaboratorio,
            HttpServletResponse response, HttpServletRequest request) throws IOException {
        
        try{ 
                WSConsultaStockService servicio = new WSConsultaStockService();
                WSConsultaStock consultaStock = servicio.getWSConsultaStockPort();
               
                PdfPTable tabla = new PdfPTable(3);

                PdfPCell celda;
                Paragraph parrafo;

                parrafo = new Paragraph();
                parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo.setFont(FontFactory.getFont("Sans", 12, Font.BOLD, BaseColor.BLACK));
                parrafo.add("IdLaboratorio");
                celda = new PdfPCell();
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda.setVerticalAlignment(Element.ALIGN_CENTER);
                celda.addElement(parrafo);
                tabla.addCell(celda);

                parrafo = new Paragraph();
                parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo.setFont(FontFactory.getFont("Sans", 12, Font.BOLD, BaseColor.BLACK));
                parrafo.add("IdLínea");
                celda = new PdfPCell();
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda.setVerticalAlignment(Element.ALIGN_CENTER);
                celda.addElement(parrafo);
                tabla.addCell(celda);

                parrafo = new Paragraph();
                parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo.setFont(FontFactory.getFont("Sans", 12, Font.BOLD, BaseColor.BLACK));
                parrafo.add("Nombre");
                celda = new PdfPCell();
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda.setVerticalAlignment(Element.ALIGN_CENTER);
                celda.addElement(parrafo);
                tabla.addCell(celda);

               ResultGetLaboratorio lab = consultaStock.getLaboratorio("PIS2014","uvM4-N39C-Jt01-mc9E-e95b", idLaboratorio);
               
                DataLaboratorio laboratorio = lab.getLaboratorio();
                List<DataLineaLaboratorio> lineasLab = laboratorio.getLineas();
                DataLineaLaboratorio linea;
                Iterator it = lineasLab.iterator();

                while(it.hasNext()) {
                    linea = (DataLineaLaboratorio) it.next();
                    parrafo = new Paragraph();
                    parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo.add(linea.getIdLaboratorio());
                    celda = new PdfPCell();
                    celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda.setVerticalAlignment(Element.ALIGN_CENTER);
                    celda.addElement(parrafo);
                    tabla.addCell(celda);

                    parrafo = new Paragraph();
                    parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo.add(""+linea.getIdLinea());
                    celda = new PdfPCell();
                    celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda.setVerticalAlignment(Element.ALIGN_CENTER);
                    celda.addElement(parrafo);
                    tabla.addCell(celda);

                    parrafo = new Paragraph();
                    parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo.add(""+linea.getNombre());
                    celda = new PdfPCell();
                    celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda.setVerticalAlignment(Element.ALIGN_CENTER);
                    celda.addElement(parrafo);
                    tabla.addCell(celda);
                }

                PdfPTable tablaTels = new PdfPTable(1);

                parrafo = new Paragraph();
                parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo.setFont(FontFactory.getFont("Sans", 12, Font.BOLD, BaseColor.BLACK));
                parrafo.add("Teléfonos");
                celda = new PdfPCell();
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
                celda.addElement(parrafo);
                tablaTels.addCell(celda);

                List <String> telefonos = laboratorio.getTelefonos();
                it = telefonos.iterator();
                String telefono;
                
                while(it.hasNext()) {
                    telefono = (String) it.next();

                    parrafo = new Paragraph();
                    parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo.add(""+telefono);
                    celda = new PdfPCell();
                    celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda.addElement(parrafo);
                    tablaTels.addCell(celda);
                }

                float[] columnWidths = {1.5f, 1.3f, 3.5f};
                tabla.setWidths(columnWidths);

                float[] columnWidths2 = {0.5f};
                tablaTels.setWidths(columnWidths2);

                createPdfTextTable(tabla, tablaTels, laboratorio, "Información del laboratorio ROE" ,"ROE",response);    
            } catch (Exception e) {
            }  
        }
    
        public void createPdfTextTable(PdfPTable tabla, PdfPTable tablaTels, DataLaboratorio laboratorio, String titulo,String idLaboratorio, HttpServletResponse response) {

        Document documento = new Document();
  
        try{
            PdfWriter.getInstance(documento, response.getOutputStream());
            documento.open();
        }catch(Exception e){
            e.printStackTrace();
        }

        //Agregamos un titulo al archivo
        documento.addTitle(titulo);

        //Agregamos el autor del archivo
        documento.addAuthor("PIS 2014");

        Paragraph parrafo = new Paragraph();
        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
        parrafo.setFont(FontFactory.getFont("Sans", 20, Font.BOLD, BaseColor.BLACK));
        parrafo.add(titulo);

        try {
            //Agregamos el texto al documento
            documento.add(parrafo);

            //Agregamos un salto de linea
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            
            parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo.setFont(FontFactory.getFont("Sans", 12, Font.BOLD, BaseColor.BLACK));
            parrafo.add("Codigo Postal: ");
            parrafo.setFont(FontFactory.getFont("Sans", 12, BaseColor.BLACK));
            parrafo.add(""+laboratorio.getCodigoPostal());
            documento.add(parrafo);
            
            parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo.setFont(FontFactory.getFont("Sans", 12, Font.BOLD, BaseColor.BLACK));
            parrafo.add("Departamento: ");
            parrafo.setFont(FontFactory.getFont("Sans", 12, BaseColor.BLACK));
            parrafo.add(""+laboratorio.getDepartamento());
            documento.add(parrafo);
            
            parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo.setFont(FontFactory.getFont("Sans", 12, Font.BOLD, BaseColor.BLACK));
            parrafo.add("Direccion: ");
            parrafo.setFont(FontFactory.getFont("Sans", 12, BaseColor.BLACK));
            parrafo.add(""+laboratorio.getDireccion());
            documento.add(parrafo);
            
            parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo.setFont(FontFactory.getFont("Sans", 12, Font.BOLD, BaseColor.BLACK));
            parrafo.add("IdLaboratorio: ");
            parrafo.setFont(FontFactory.getFont("Sans", 12, BaseColor.BLACK));
            parrafo.add(""+laboratorio.getIdLaboratorio());
            documento.add(parrafo);
            
            parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo.setFont(FontFactory.getFont("Sans", 12, Font.BOLD, BaseColor.BLACK));
            parrafo.add("Localidad: ");
            parrafo.setFont(FontFactory.getFont("Sans", 12, BaseColor.BLACK));
            parrafo.add(""+laboratorio.getLocalidad());
            documento.add(parrafo);
            
            parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo.setFont(FontFactory.getFont("Sans", 12, Font.BOLD, BaseColor.BLACK));
            parrafo.add("Nombre: ");
            parrafo.setFont(FontFactory.getFont("Sans", 12, BaseColor.BLACK));
            parrafo.add(""+laboratorio.getNombre());
            documento.add(parrafo);
            
            parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo.setFont(FontFactory.getFont("Sans", 12, Font.BOLD, BaseColor.BLACK));
            parrafo.add("Razón Social: ");
            parrafo.setFont(FontFactory.getFont("Sans", 12, BaseColor.BLACK));
            parrafo.add(""+laboratorio.getRazonSocial());
            documento.add(parrafo);
            
            parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo.setFont(FontFactory.getFont("Sans", 12, Font.BOLD, BaseColor.BLACK));
            parrafo.add("RUC: ");
            parrafo.setFont(FontFactory.getFont("Sans", 12, BaseColor.BLACK));
            parrafo.add(""+laboratorio.getRuc());
            documento.add(parrafo);     
            
            documento.add(new Paragraph(" "));
            
            parrafo = new Paragraph();
            parrafo.setFont(FontFactory.getFont("Sans", 14, Font.BOLD, BaseColor.BLACK));
            parrafo.add("Líneas del Laboratorio");
            documento.add(parrafo);     
            documento.add(new Paragraph(" "));
            documento.add(tabla);
            
            documento.add(new Paragraph(" "));
            
            parrafo = new Paragraph();
            parrafo.setFont(FontFactory.getFont("Sans", 14, Font.BOLD, BaseColor.BLACK));
            parrafo.add("Teléfonos");
            documento.add(parrafo);
            
            documento.add(new Paragraph(" "));

            documento.add(tablaTels);
            documento.close();
            
        } catch (DocumentException ex) {
            ex.getMessage();
        }
    } 
}
