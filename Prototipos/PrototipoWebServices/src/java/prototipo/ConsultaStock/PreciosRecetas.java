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
public class PreciosRecetas extends HttpServlet {

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
            out.println("<title>PreciosRecetas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Precios de las Recetas</h1>");
            
            WSConsultaStockService servicio = new WSConsultaStockService();
            WSConsultaStock consultaStock = servicio.getWSConsultaStockPort();
            try {
                ResultGetPreciosRecetas ObtenerPreciosRecetas = consultaStock.getPreciosRecetas("PIS2014","uvM4-N39C-Jt01-mc9E-e95b");
                List <DataPreciosReceta> listaPreciosReceta = ObtenerPreciosRecetas.getPreciosRecetas();
                Iterator it = listaPreciosReceta.iterator();
                DataPreciosReceta preciosReceta;

                out.println("<table border=\"2\">\n" +
                "    <thead>\n" +
                "        <tr>\n" +
                "            <th>Institucion</th>\n" +
                "            <th>Descuento Receta</th>\n" +
                "            <th>Numero Articulo</th>\n" +
                "            <th>Precio Receta</th>\n" +
                "        </tr>\n" +
                "    </thead>\n" +
                "    <tbody>\n");  

                while(it.hasNext()){
                    preciosReceta = (DataPreciosReceta) it.next();

                    out.println("<tr>\n" +
                        "<td>"+ preciosReceta.getInstitucion() +"</td>\n" +
                        "<td>"+ preciosReceta.getDescuentoReceta() +"</td>\n" +
                        "<td>"+ preciosReceta.getNumeroArticulo() +"</td>\n" +
                        "<td>"+ preciosReceta.getPrecioReceta() +"</td>\n" + 
                        "</tr>\n");
                    }

                    out.println("</tbody>\n" +
                    "</table>");
                } catch (Exception e) {
                    out.println("<h1>ERROR: " + e.getMessage() + "</h1>");
                }    
                out.println("</body>");
                out.println("</html>");
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
