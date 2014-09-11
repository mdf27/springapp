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
public class ObtenerOfertas extends HttpServlet {

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
            out.println("<title>ObtenerOfertas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de Ofertas!</h1>");
            
            WSConsultaStockService servicio = new WSConsultaStockService();
            WSConsultaStock consultaStock = servicio.getWSConsultaStockPort();
            try {
                ResultGetOfertas obtenerOfertas = consultaStock.getOfertas("PIS2014","uvM4-N39C-Jt01-mc9E-e95b");
                List<DataOferta> ofertas = obtenerOfertas.getOfertas();
                Iterator it = ofertas.iterator();
                DataOferta oferta;

                out.println("<table border=\"2\">\n" +
                "    <thead>\n" +
                "        <tr>\n" +
                "            <th>Cant. Bonificado</th>\n" +
                "            <th>Cant. Venta</th>\n" +
                "            <th>Descripcion</th>\n" +
                "            <th>Fecha Fin</th>\n" +
                "            <th>Num. Articulo</th>\n" +
                "            <th>Porcentaje Bonificado</th>\n" +
                "        </tr>\n" +
                "    </thead>\n" +
                "    <tbody>\n");  

                while(it.hasNext()){
                    oferta = (DataOferta) it.next();

                    out.println("<tr>\n" +
                    "<td>"+ oferta.getCantidadBonificado() +"</td>\n" +
                    "<td>"+ oferta.getCantidadVenta() +"</td>\n" +
                    "<td>"+ oferta.getDescripcion() +"</td>\n" +
                    "<td>"+ oferta.getFechaFin() +"</td>\n" +
                    "<td>"+ oferta.getNumeroArticulo() +"</td>\n" +
                    "<td>"+ oferta.getPorcentajeBonificado() +"</td>\n" +
                    "</tr>\n");
                }

                out.println("</tbody>\n" +
                "</table>");

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
