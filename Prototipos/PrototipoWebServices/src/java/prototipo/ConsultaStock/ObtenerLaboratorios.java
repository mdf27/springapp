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
public class ObtenerLaboratorios extends HttpServlet {

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

           // URL rutaService= new URL ("http://dev.dusa.com.uy/ws_consulta_stock?wsdl");
            WSConsultaStockService servicio = new WSConsultaStockService();
            WSConsultaStock consultaStock = servicio.getWSConsultaStockPort();
            try {
                ResultGetLaboratorios obtenerLaboratorios = consultaStock.getLaboratorios("PIS2014","uvM4-N39C-Jt01-mc9E-e95b");
                List <DataLaboratorio> laboratorios = obtenerLaboratorios.getLaboratorios();
                DataLaboratorio laboratorio;
                Iterator it = laboratorios.iterator();
                String nombreLab;
                String idLab;
                String codigoPostal;
                String departamento;
                String direccion;
                String localidad;
                String razonSocial;
                String ruc;
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>ObtenerLaboratorios</title>");  

                out.println("<script type=\"text/javascript\">\n" +
    "            function verInfoLab(idLab){\n" +
    "                var xmlhttp=new XMLHttpRequest();\n" +
    "                xmlhttp.open(\"POST\",\"VerInfoLaboratorio\",true);// va una ruta ahi pa q atiendan la request\n" +
    "                xmlhttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n" +

    "                var parametro='idLaboratorio='+idLab; " +                    

    "                xmlhttp.send(parametro);\n" +
    "                \n" +
    "               xmlhttp.onreadystatechange=function()\n" +
    "                {\n" +
    "                if (xmlhttp.readyState===4 && xmlhttp.status===200){\n" +
    "                    document.getElementById(\"infoLaboratorio\").innerHTML=xmlhttp.responseText;\n" +
    "                }//if\n" +
    "                };            \n" +
    "            }  // del onlick\n" +
    "        </script> ");

                out.println("</head>");
                out.println("<body>");

                // Aca se llena con la info de un laboratorio en particular 
                out.println("<div id=\"infoLaboratorio\"> \n \n </div>"); 

                out.println("<h1>Lista de Laboratorios </h1>");

                out.println("<table border=\"2\">\n" +
                "    <thead>\n" +
                "        <tr>\n" +
                "            <th>Id</th>\n" +
                "            <th>Nombre</th>\n" +
                "            <th>CodPostal</th>\n" +
                "            <th>Dpto</th>\n" +
                "            <th>Direccion</th>\n" +
                "            <th>Localidad</th>\n" +
                "            <th>Razon Social</th>\n" +
                "            <th>RUC</th>\n" +
                "        </tr>\n" +
                "    </thead>\n" +
                "    <tbody>\n");  

                while(it.hasNext()) {
                    laboratorio = (DataLaboratorio) it.next();
                    idLab = laboratorio.getIdLaboratorio();
                    nombreLab = laboratorio.getNombre();
                    codigoPostal = laboratorio.getCodigoPostal();
                    departamento = laboratorio.getDepartamento();
                    direccion = laboratorio.getDireccion();
                    localidad = laboratorio.getLocalidad();
                    razonSocial = laboratorio.getRazonSocial();
                    ruc = laboratorio.getRuc();

                    out.println("<tr>\n" +
                    "<td><dd><a href=\"javascript:{}\" class=\"navbar-link\" onclick=\"verInfoLab('" + idLab + "');\">" + idLab + "</a></dd></td>\n" +                      
                    "<td>"+ nombreLab +"</td>\n" +
                    "<td>"+ codigoPostal +"</td>\n" +
                    "<td>"+ departamento +"</td>\n" +
                    "<td>"+ direccion +"</td>\n" +
                    "<td>"+ localidad +"</td>\n" +
                    "<td>"+ razonSocial +"</td>\n" +
                    "<td>"+ ruc +"</td>\n" +
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
