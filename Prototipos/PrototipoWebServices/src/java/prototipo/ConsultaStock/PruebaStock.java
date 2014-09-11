/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prototipo.ConsultaStock;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import uy.com.dusa.ws.*;

/**
 *
 * @author Usuario
 */
public class PruebaStock extends HttpServlet {

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
            throws ServletException, IOException, DatatypeConfigurationException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                       
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Stock</title>");            
            out.println("</head>");
            out.println("<body>");  
            out.println("<h1>Stock</h1>");

           // URL rutaService= new URL ("http://dev.dusa.com.uy/ws_consulta_stock?wsdl");
            WSConsultaStockService servicio = new WSConsultaStockService();
            WSConsultaStock consultaStock = servicio.getWSConsultaStockPort();
            GregorianCalendar gcal = new GregorianCalendar();
            XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
            try {
                ResultGetStockUpdates stock = consultaStock.getStockUpdates("PIS2014","uvM4-N39C-Jt01-mc9E-e95b", xgcal);
                List <DataInfoProducto> productos =  stock.getProductos();
                if (productos.isEmpty()) {
                    out.println("<h1>Lista de productos vacía</h1>");
                } else { 
                
                    Iterator it = productos.iterator();
                    DataInfoProducto producto;  

                    out.println("<table border=\"2\">\n" +
                     "    <thead>\n" +
                     "        <tr>\n" +
                     "            <th>Clave1</th>\n" +
                     "            <th>Clave2</th>\n" +
                     "            <th>Clave3</th>\n" +
                     "            <th>Tiene Cod.Barra?</th>\n" +      
                     "            <th>Cod.Barra</th>\n" +
                     "            <th>Desc</th>\n" +
                     "            <th>IdLab</th>\n" +
                     "            <th>IdLineaLab</th>\n" +
                     "            <th>IdCodigoLab</th>\n" +
                     "            <th>TipoIVA</th>\n" +
                     "            <th>Fecha Ultimo Precio</th>\n" +       
                     "            <th>Fecha Ultima Actualizacion</th>\n" +
                     "            <th>habilitado</th>\n" +
                     "            <th>IdPresentNoritel</th>\n" +
                     "            <th>IdProdNoritel</th>\n" +
                     "            <th>NumArticulo</th>\n" +    
                     "            <th>PorcDescOferta</th>\n" +
                     "            <th>PrecOferta</th>\n" +
                     "            <th>PrecPublico</th>\n" +
                     "            <th>PrecVenta</th>\n" +     
                     "        </tr>\n" +
                     "    </thead>\n" +
                     "    <tbody>\n");  

                    while(it.hasNext()){
                        producto = (DataInfoProducto) it.next();

                        out.println("<tr>\n" +
                        "<td>"+ producto.getClave1() + "</td>\n" +                      
                        "<td>"+ producto.getClave2() +"</td>\n" +
                        "<td>"+ producto.getClave3() +"</td>\n" +
                        "<td>"+ producto.isHasCodigoBarra() +"</td>\n" +
                        "<td>"+ producto.getCodigoBarra() +"</td>\n" +
                        "<td>"+ producto.getDescripcion() +"</td>\n" +
                        "<td>"+ producto.getIdLaboratorio() +"</td>\n" +
                        "<td>"+ producto.getIdLineaLaboratorio() +"</td>\n" +
                        "<td>"+ producto.getCodigoLaboratorio() +"</td>\n" +
                        "<td>"+ producto.getTipoIVA() + "</td>\n" +    
                        "<td>"+ producto.getFechaUlitmoPrecio()+"</td>\n" +
                        "<td>"+ producto.getFechaUltimaActualizacion() +"</td>\n" +
                        "<td>"+ producto.getHabilitado() +"</td>\n" +
                        "<td>"+ producto.getIdPresentacionNoritel() +"</td>\n" +
                        "<td>"+ producto.getIdProductoNoritel() +"</td>\n" +
                        "<td>"+ producto.getNumeroArticulo() +"</td>\n" +          
                        "<td>"+ producto.getPorcentajeDescuentoOferta() +"</td>\n" +
                        "<td>"+ producto.getPrecioOferta() +"</td>\n" +          
                        "<td>"+ producto.getPrecioPublico() +"</td>\n" +
                        "<td>"+ producto.getPrecioVenta() +"</td>\n" +
                        "</tr>\n");             
                    } 
                    //"<td>"+ producto.getPreciosRecetas() +"</td>\n" +
                   // "<td>"+ producto.getOfertas() +"</td>\n" +


                    out.println("</tbody>\n" +
                    "</table>");
                    out.println("<br/>");
                } // cierra if lista vacia
            } catch (Exception e) {
                out.println("<h1>ERROR: " + e.getMessage() + "</h1>");
            }
            out.println("</body>");
            out.println("</html>");
        }
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
        try {
            processRequest(request, response);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(PruebaStock.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(PruebaStock.class.getName()).log(Level.SEVERE, null, ex);
        }
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
