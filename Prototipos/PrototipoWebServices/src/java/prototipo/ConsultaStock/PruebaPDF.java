/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prototipo.ConsultaStock;

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
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uy.com.dusa.ws.DataLaboratorio;
import uy.com.dusa.ws.DataLineaLaboratorio;
import uy.com.dusa.ws.ResultGetLaboratorio;
import uy.com.dusa.ws.WSConsultaStock;
import uy.com.dusa.ws.WSConsultaStockService;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "PruebaPDF", urlPatterns = {"/PruebaPDF"})
public class PruebaPDF extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");

            String idLaboratorio = request.getParameter("id");

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

               ResultGetLaboratorio lab = consultaStock.getLaboratorio("PIS2014","uvM4-N39C-Jt01-mc9E-e95b", "ROE");
               
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
       // } // cierra if de parametro nulo
    }
    
     //public void createPdfTextTable(PdfPTable tabla, PdfPTable tablaTels, DataLaboratorio laboratorio, String titulo, File Destino, String idLaboratorio, HttpServletResponse response) throws MalformedURLException {
     public void createPdfTextTable(PdfPTable tabla, PdfPTable tablaTels, DataLaboratorio laboratorio, String titulo,String idLaboratorio, HttpServletResponse response) {
        /*Declaramos documento como un objeto Document
         Asignamos el tamaño de hoja y los margenes */
        //Document documento = new Document(PageSize.A4, 80, 80, 75, 75);
        Document documento = new Document();
        //writer es declarado como el método utilizado para escribir en el archivo
        //PdfWriter writer = null;

        /*try {
            //Obtenemos la instancia del archivo a utilizar
           writer = PdfWriter.getInstance(documento, new FileOutputStream(Destino + ".pdf"));
          // writer = PdfWriter.getInstance(documento, response.getOutputStream());
        } catch (Exception ex) {
            ex.getMessage();
        }*/
        
        //Document document = new Document();
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

        //Abrimos el documento para edición
       // documento.open();

        //Declaramos un texto como Paragraph
        //Le podemos dar formado como alineación, tamaño y color a la fuente.
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
            parrafo.add("RUC ");
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

       // documento.close(); //Cerramos el documento
        //writer.close(); //Cerramos writer

       /* try {
            File path;
            path = new File(Destino + ".pdf");
            Desktop.getDesktop().open(path);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}