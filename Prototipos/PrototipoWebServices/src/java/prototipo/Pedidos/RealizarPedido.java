/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prototipo.Pedidos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uy.com.dusa.ws.*;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "RealizarPedido", urlPatterns = {"/RealizarPedido"})
public class RealizarPedido extends HttpServlet {

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
            out.println("<h1>Pedido Realizado</h1>");
            
            WSPedidosService servicio = new WSPedidosService();
            WSPedidos pedidos = servicio.getWSPedidosPort();
            try {
                DataPedidoSimple pedidoSimple = new DataPedidoSimple();
                pedidoSimple.setFormaDePago(PedidoFormaDePago.CONTADO);
                ResultRealizarPedido mensaje = pedidos.realizarPedidoSimple("PIS2014","uvM4-N39C-Jt01-mc9E-e95b", pedidoSimple);
                out.println("<h1>" + mensaje.getMensaje()+ "</h1>");
                
                pedidoSimple = new DataPedidoSimple();
                pedidoSimple.setFormaDePago(PedidoFormaDePago.CREDITO);
                mensaje = pedidos.realizarPedidoSimple("PIS2014","uvM4-N39C-Jt01-mc9E-e95b", pedidoSimple);
                out.println("<h1>" + mensaje + "</h1>");
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
