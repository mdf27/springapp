/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prototipo.ConsultaStock;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uy.com.dusa.ws.*;

/**
 *
 * @author Usuario
 */
public class VerInfoProducto extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Informacion Producto 77</title>");            
            out.println("</head>");
            out.println("<body>");  
            //out.println("<h1>Informacion del Producto 77</h1>");

           // URL rutaService= new URL ("http://dev.dusa.com.uy/ws_consulta_stock?wsdl");
            WSConsultaStockService servicio = new WSConsultaStockService();
            WSConsultaStock consultaStock = servicio.getWSConsultaStockPort();
            
            try {
                for (int i = 1; i < 100; i++) {
                    out.println("<h1>Informacion del Producto " + i + "</h1>");
                    ResultGetStock prod = consultaStock.getStock("PIS2014","uvM4-N39C-Jt01-mc9E-e95b", i);
                    DataInfoProducto producto = prod.getProducto(); 
                    out.println("<ul>");  
                           out.println("<li>Clave 1: " + producto.getClave1() + "</li><br/>");
                           out.println("<li>Clave 2: " + producto.getClave2() + "</li><br/>");
                           out.println("<li>Clave 3: " + producto.getClave3() + "</li><br/>");
                           out.println("<li>Codigo de Barras: " + producto.getCodigoBarra() + "</li><br/>");
                           out.println("<li>Descripcion: " + producto.getDescripcion() + "</li><br/>");
                           out.println("<li>IdLaboratorio: " + producto.getIdLaboratorio() + "</li><br/>");
                           out.println("<li>IdLineaLaboratorio: " + producto.getIdLineaLaboratorio()+ "</li><br/>");
                           out.println("<li>CodigoLaboratorio: " + producto.getCodigoLaboratorio() + "</li><br/>");
                           out.println("<li>Tipo IVA: " + producto.getTipoIVA() + "</li><br/>");
                           out.println("<li>Fecha Ultimo Precio: " + producto.getFechaUltimaActualizacion() + "</li><br/>");
                           out.println("<li>Fecha Ultima Actualizacion: " + producto.getFechaUltimaActualizacion() + "</li><br/>");
                           out.println("<li>Habilitado: " + producto.getHabilitado() + "</li><br/>");
                           out.println("<li>IdPresentacionNoritel: " + producto.getIdPresentacionNoritel() + "</li><br/>");
                           out.println("<li>IdProductoNoritel: " + producto.getIdProductoNoritel() + "</li><br/>");                 
                           out.println("<li>Numero Articulo: " + producto.getNumeroArticulo() + "</li><br/>");
                           out.println("<li>Porcentaje Descuento Oferta: " + producto.getPorcentajeDescuentoOferta() + "</li><br/>");
                           out.println("<li>Precio Oferta: " + producto.getPrecioOferta() + "</li><br/>");
                           out.println("<li>Precio Publico: " + producto.getPrecioPublico() + "</li><br/>");
                           out.println("<li>Precio Venta: " + producto.getPrecioVenta() + "</li><br/>");
                           out.println("<li>Precio Receta: " +producto.getPrecioReceta() + "</li><br/>");
                    out.println("</ul>");
                    out.println("<br/>");

                    List <DataOferta> ofertas =  producto.getOfertas();

                    Iterator it = ofertas.iterator();
                    DataOferta oferta; 

                    out.println("<h3>Ofertas!</h3><br/>");

                    out.println("<table border=\"2\">\n" +
                     "    <thead>\n" +
                     "        <tr>\n" +
                     "            <th>Descripcion</th>\n" +
                     "            <th>Cantidad Bonificado</th>\n" +
                     "            <th>Cantidad Venta</th>\n" +
                     "            <th>Fecha Fin</th>\n" +
                     "            <th>Numero Articulo</th>\n" +
                     "            <th>Porcentaje Bonificado</th>\n" +       
                     "        </tr>\n" +
                     "    </thead>\n" +
                     "    <tbody>\n");  

                    while(it.hasNext()){
                        oferta = (DataOferta) it.next();

                        out.println("<tr>\n" +
                        "<td>"+ oferta.getDescripcion() + "</td>\n" +                      
                        "<td>"+ oferta.getCantidadBonificado() +"</td>\n" +
                        "<td>"+ oferta.getCantidadVenta() +"</td>\n" +
                        "<td>"+ oferta.getFechaFin() +"</td>\n" +
                        "<td>"+ oferta.getNumeroArticulo() +"</td>\n" +
                        "<td>"+ oferta.getPorcentajeBonificado() +"</td>\n" +
                        "</tr>\n");             
                    }

                    out.println("</tbody>\n" +
                    "</table>");
                    out.println("<br/>");
                }    
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
