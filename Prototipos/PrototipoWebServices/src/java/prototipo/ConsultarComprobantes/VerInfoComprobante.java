/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prototipo.ConsultarComprobantes;

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
public class VerInfoComprobante extends HttpServlet {

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

           // URL rutaService= new URL ("http://dev.dusa.com.uy/ws_consulta_stock?wsdl"); 
            if((request.getParameter("tipoCFE") == null) || (request.getParameter("serieCFE") == null) || (request.getParameter("numeroCFE") == null)) {
                out.println("<h1>ERROR: Algun parametro es Nulo</h1>");
            } else {
                int tipoCFE = Integer.parseInt(request.getParameter("tipoCFE"));
                String serieCFE = (String) request.getParameter("serieCFE");
                int numeroCFE = Integer.parseInt(request.getParameter("numeroCFE"));
                out.println("<h1>Informacion del Comprobante de tipo "+ tipoCFE +", serie "+ serieCFE +" y numero "+ numeroCFE +"</h1><br/>");
                WSConsultaComprobantesService servicio = new WSConsultaComprobantesService();
                WSConsultaComprobantes consultaComprobantes = servicio.getWSConsultaComprobantesPort();
 
                try{ 
                    DataComprobante comprobante = consultaComprobantes.getComprobante("PIS2014","uvM4-N39C-Jt01-mc9E-e95b", tipoCFE,serieCFE,numeroCFE);
                    
                    out.println("<ul>");
                        out.println("<li>Cantidad Lineas: " + comprobante.getCantidadLineas() + "</li><br/>");
                        out.println("<li>Serie: " + serieCFE + "</li><br/>");
                        out.println("<li>Fecha Comprobante: " + comprobante.getFechaComprobante() + "</li><br/>");
                        out.println("<li>Fecha Emision: " + comprobante.getFechaEmision() + "</li><br/>");
                        out.println("<li>Forma de Pago: " + comprobante.getFormaDePago() + "</li><br/>");
                        out.println("<li>Monto Neto Gravado Iva Basico: " + comprobante.getMontoNetoGravadoIvaBasico() + "</li><br/>");
                        out.println("<li>Monto Neto Gravado Iva Minimo: " + comprobante.getMontoNetoGravadoIvaMinimo() + "</li><br/>");
                        out.println("<li>Monto No Facturable: " + comprobante.getMontoNoFacturable() + "</li><br/>");
                        out.println("<li>Monto No Gravado: " + comprobante.getMontoNoGravado() + "</li><br/>");
                        out.println("<li>Monto Retenido IRAE: " + comprobante.getMontoRetenidoIRAE() + "</li><br/>");
                        out.println("<li>Monto Detenido IVA: " + comprobante.getMontoRetenidoIVA() + "</li><br/>");
                        out.println("<li>Monto Total: " + comprobante.getMontoTotal() + "</li><br/>");
                        out.println("<li>Monto Total a Pagar: " + comprobante.getMontoTotalAPagar() + "</li><br/>");
                        out.println("<li>Monto Tributo IVA Basico: " + comprobante.getMontoTributoIvaBasico() + "</li><br/>");
                        out.println("<li>Monto Tributo IVA Minimo: " + comprobante.getMontoTributoIvaMinimo() + "</li><br/>");
                        out.println("<li>Numero: " + numeroCFE + "</li><br/>");
                        out.println("<li>Orden de Compra: " + comprobante.getOrdenDeCompra() + "</li><br/>");
                        out.println("<li>Tipo: " + tipoCFE + "</li><br/>");
                        out.println("<li>Total IVA Basico: " + comprobante.getTotalIvaBasico() + "</li><br/>");
                        out.println("<li>Total IVA Minimo: " + comprobante.getTotalIvaMinimo() + "</li><br/>");  
                    out.println("</ul>");            
    
                    out.println("<br/>");
                    List <DataLineaComprobante> detalles = comprobante.getDetalle();
                    DataLineaComprobante linea;
                    Iterator it = detalles.iterator();

                   out.println("<h3>Detalles del Comprobante</h3><br/>");
                   
                   out.println("<table border=\"2\">\n" +
                    "    <thead>\n" +
                    "        <tr>\n" +
                    "            <th>DescripcionOferta</th>\n" +
                    "            <th>Serie</th>\n" +
                    "            <th>Cantidad</th>\n" +
                    "            <th>Descuento</th>\n" +
                    "            <th>IndicadorFacturacion</th>\n" +
                    "            <th>Numero</th>\n" +
                    "            <th>NumeroArticulo</th>\n" +
                    "            <th>NumeroLinea</th>\n" +
                    "            <th>PrecioUnitario</th>\n" +
                    "            <th>Tipo</th>\n" +
                    "        </tr>\n" +
                    "    </thead>\n" +
                    "    <tbody>\n");  

                    while(it.hasNext()) {
                        linea = (DataLineaComprobante) it.next();       
                        out.println("<tr>\n" + 
                            "<td>"+ linea.getDescripcionOferta() +"</td>\n" +
                            "<td>"+ linea.getSerie() +"</td>\n" +
                            "<td>"+ linea.getCantidad() +"</td>\n" +
                            "<td>"+ linea.getDescuento() +"</td>\n" +
                            "<td>"+ linea.getIndicadorDeFacturacion() +"</td>\n" +
                            "<td>"+ linea.getNumero() +"</td>\n" +    
                            "<td>"+ linea.getNumeroArticulo() +"</td>\n" +
                            "<td>"+ linea.getNumeroLinea() +"</td>\n" +
                            "<td>"+ linea.getPrecioUnitario() +"</td>\n" +
                            "<td>"+ linea.getTipo() +"</td>\n" +
                            "</tr>\n");        
                    }
                    out.println("</tbody>\n" +
                    "</table>");

                    out.println("<br/>");
                    List <DataVencimiento> vencimientos = comprobante.getVencimientos();
                    it = vencimientos.iterator();
                    DataVencimiento vencimiento;
                    
                    out.println("<h3>Vencimientos del Comprobante</h3><br/>");
                    
                    out.println("<table border=\"2\">\n" +
                    "    <thead>\n" +
                    "        <tr>\n" +
                    "            <th>Codigo</th>\n" +
                    "            <th>Fecha</th>\n" +
                    "            <th>Importe</th>\n" +
                    "        </tr>\n" +
                    "    </thead>\n" +
                    "    <tbody>\n");  

                    while(it.hasNext()) {
                        vencimiento = (DataVencimiento) it.next();       
                        out.println("<tr>\n" +
                            "<td>"+ vencimiento.getCodigo() +"</td>\n" +
                            "<td>"+ vencimiento.getFecha() +"</td>\n" +
                            "<td>"+ vencimiento.getImporte() +"</td>\n" +
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
