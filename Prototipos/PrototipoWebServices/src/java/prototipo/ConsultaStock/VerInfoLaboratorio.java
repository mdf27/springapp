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
public class VerInfoLaboratorio extends HttpServlet {

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
            
            if(request.getParameter("idLaboratorio") == null) {
                out.println("<h1>ERROR: Parametro idLaboratorio Nulo</h1>");
            } else {
                String idLaboratorio = request.getParameter("idLaboratorio");
                out.println("<h1>Informacion del Laboratorio "+ idLaboratorio +"</h1><br/>");
                WSConsultaStockService servicio = new WSConsultaStockService();
                WSConsultaStock consultaStock = servicio.getWSConsultaStockPort();
                try{ 
                    DataLaboratorio laboratorio = consultaStock.getLaboratorio("PIS2014","uvM4-N39C-Jt01-mc9E-e95b", idLaboratorio);

                    List<DataLineaLaboratorio> lineasLab = laboratorio.getLineas();
                    List <String> telefonos = laboratorio.getTelefonos();

                    out.println("<ul>");
                        out.println("<li>Codigo Postal: " + laboratorio.getCodigoPostal() + "</li><br/>");
                        out.println("<li>Departamento: " + laboratorio.getDepartamento() + "</li><br/>");
                        out.println("<li>Direccion: " + laboratorio.getDireccion() + "</li><br/>");
                        out.println("<li>IdLaboratorio: " + laboratorio.getIdLaboratorio() + "</li><br/>");
                        out.println("<li>Localidad: " + laboratorio.getLocalidad() + "</li><br/>");
                        out.println("<li>Nombre: " + laboratorio.getNombre() + "</li><br/>");
                        out.println("<li>Razon Social: " + laboratorio.getRazonSocial() + "</li><br/>");
                        out.println("<li>RUC: " + laboratorio.getRuc() + "</li><br/>");
                    out.println("</ul>");

                    out.println("<br/>");
                    DataLineaLaboratorio linea;
                    Iterator it = lineasLab.iterator();

                   out.println("<h3>Lineas del Laboratorio</h3><br/>");
                   
                   out.println("<table border=\"2\">\n" +
                    "    <thead>\n" +
                    "        <tr>\n" +
                    "            <th>IdLaboratorio</th>\n" +
                    "            <th>IdLinea</th>\n" +
                    "            <th>Nombre</th>\n" +
                    "        </tr>\n" +
                    "    </thead>\n" +
                    "    <tbody>\n");  

                    while(it.hasNext()) {
                        linea = (DataLineaLaboratorio) it.next();       
                        out.println("<tr>\n" +
                            "<td>"+ linea.getIdLaboratorio() +"</td>\n" +
                            "<td>"+ linea.getIdLinea() +"</td>\n" +
                            "<td>"+ linea.getNombre() +"</td>\n" +
                            "</tr>\n");        
                    }
                    out.println("</tbody>\n" +
                    "</table>");

                    out.println("<br/>");

                    it = telefonos.iterator();
                    String telefono;
                    out.println("<table border=\"2\">\n" +
                    "    <thead>\n" +
                    "        <tr>\n" +
                    "            <th>Telefonos</th>\n" +
                    "        </tr>\n" +
                    "    </thead>\n" +
                    "    <tbody>\n");  

                    while(it.hasNext()) {
                        telefono = (String) it.next();       
                        out.println("<tr>\n" +
                            "<td>"+ telefono +"</td>\n" +
                            "</tr>\n");        
                    }
                    out.println("</tbody>\n" +
                    "</table>");

                    out.println("<br/>");
                } catch (Exception e) {
                    out.println("<h1>ERROR: " + e.getMessage() + "</h1>");
                }
            }         
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
