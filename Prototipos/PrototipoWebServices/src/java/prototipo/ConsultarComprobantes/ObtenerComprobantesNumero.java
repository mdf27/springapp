/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prototipo.ConsultarComprobantes;

import java.io.IOException;
import java.io.PrintWriter;
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
import uy.com.dusa.ws.DataComprobante;
import uy.com.dusa.ws.ResultGetComprobantes;
import uy.com.dusa.ws.WSConsultaComprobantes;
import uy.com.dusa.ws.WSConsultaComprobantesService;

/**
 *
 * @author Usuario
 */
public class ObtenerComprobantesNumero extends HttpServlet {

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
            out.println("<title>Comprobantes</title>");  
            out.println("<script type=\"text/javascript\">\n" +
    "            function infoComprobante(tipo,serie,numero){\n" +
    "                var xmlhttp=new XMLHttpRequest();\n" +
    "                xmlhttp.open(\"POST\",\"VerInfoComprobante\",true);// va una ruta ahi pa q atiendan la request\n" +
    "                xmlhttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n" +

    "                var parametro='tipoCFE='+tipo+'&serieCFE='+serie+'&numeroCFE='+numero;  " +                    

    "                xmlhttp.send(parametro);\n" +
    "                \n" +
    "               xmlhttp.onreadystatechange=function()\n" +
    "                {\n" +
    "                if (xmlhttp.readyState===4 && xmlhttp.status===200){\n" +
    "                    document.getElementById(\"infoComprobante\").innerHTML=xmlhttp.responseText;\n" +
    "                }//if\n" +
    "                };            \n" +
    "            }  // del onlick\n" +
    "        </script> ");
            out.println("</head>");
            out.println("<body>");  
            out.println("<div id=\"infoComprobante\"> \n \n </div>");
            out.println("<h1>Lista de Comprobantes</h1>");
            
            WSConsultaComprobantesService servicio = new WSConsultaComprobantesService();
            WSConsultaComprobantes consultaComprobantes = servicio.getWSConsultaComprobantesPort();
            try {
                // FALTA PONER UN VALOR REAL!
                ResultGetComprobantes obtenerComprobantes = consultaComprobantes.getComprobantesDesdeNumero("PIS2014","uvM4-N39C-Jt01-mc9E-e95b", 0, null, 0);
                List<DataComprobante> comprobantes = obtenerComprobantes.getComprobantes();
                Iterator it = comprobantes.iterator();
                DataComprobante comprobante;

                out.println("<table border=\"2\">\n" +
                 "    <thead>\n" +
                 "        <tr>\n" +
                 "            <th>CanLineas</th>\n" +
                 "            <th>Serie</th>\n" +
                 "            <th>FechaComprobante</th>\n" +
                 "            <th>FechaEmision</th>\n" +
                 "            <th>FormaPago</th>\n" +
                 "            <th>MontoNetoGravadoIvaBasico</th>\n" +
                 "            <th>MontoNetoGravadoIvaMinimo</th>\n" +
                 "            <th>MontoNoFacturable</th>\n" +
                 "            <th>MontoNoGravado</th>\n" +
                 "            <th>MontoRetenidoIRAE</th>\n" +
                 "            <th>MontoRetenidoIVA</th>\n" +
                 "            <th>MontoTotal</th>\n" +    
                 "            <th>MontoTotalAPagar</th>\n" +
                 "            <th>MontoTributoIvaBasico</th>\n" +
                 "            <th>MontoTributoIvaMinimo</th>\n" +
                 "            <th>Numero</th>\n" + 
                 "            <th>OrdenCompra</th>\n" +
                 "            <th>Tipo</th>\n" +
                 "            <th>TotalIvaBasico</th>\n" +
                 "            <th>TotalIvaMinimo</th>\n" +        
                 "        </tr>\n" +
                 "    </thead>\n" +
                 "    <tbody>\n");  

                int tipo;
                String serie;
                
                while(it.hasNext()){
                    comprobante = (DataComprobante) it.next();
                    tipo = comprobante.getTipo();
                    serie = comprobante.getSerie(); 
                    int numero = comprobante.getNumero();
                    out.println("<tr> onclick=\"infoComprobante('" + tipo + "','" + serie + "','" + numero + "')\"\n" +
                    "<td>"+ comprobante.getCantidadLineas() + "</td>\n" +                      
                    "<td>"+ serie +"</td>\n" +
                    //"<td>"+ comprobante.getDetalle() +"</td>\n" +
                    "<td>"+ comprobante.getFechaComprobante() +"</td>\n" +
                    "<td>"+ comprobante.getFechaEmision() +"</td>\n" +
                    "<td>"+ comprobante.getFormaDePago() +"</td>\n" + // no se si funcionara
                    "<td>"+ comprobante.getMontoNetoGravadoIvaBasico() + "</td>\n" +                      
                    "<td>"+ comprobante.getMontoNetoGravadoIvaMinimo() +"</td>\n" +
                    "<td>"+ comprobante.getMontoNoFacturable() +"</td>\n" +
                    "<td>"+ comprobante.getMontoNoGravado() +"</td>\n" +
                    "<td>"+ comprobante.getMontoRetenidoIRAE() +"</td>\n" +
                    "<td>"+ comprobante.getMontoRetenidoIVA() +"</td>\n" +          
                    "<td>"+ comprobante.getMontoTotal() +"</td>\n" +
                    "<td>"+ comprobante.getMontoTotalAPagar() +"</td>\n" +          
                    "<td>"+ comprobante.getMontoTributoIvaBasico() +"</td>\n" +
                    "<td>"+ comprobante.getMontoTributoIvaMinimo() +"</td>\n" +       
                    "<td>"+ numero +"</td>\n" +          
                    "<td>"+ comprobante.getOrdenDeCompra() +"</td>\n" +
                    "<td>"+ tipo +"</td>\n" +          
                    "<td>"+ comprobante.getTotalIvaBasico() +"</td>\n" +
                    "<td>"+ comprobante.getTotalIvaMinimo() +"</td>\n" +  
                    //"<td>"+ comprobante.getVencimientos() +"</td>\n" +  
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
