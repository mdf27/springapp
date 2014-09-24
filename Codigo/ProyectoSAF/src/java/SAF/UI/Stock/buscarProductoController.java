/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.UI.Stock;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author majo
 */
@Controller
public class buscarProductoController {
    @RequestMapping(value = "buscarVerProducto")
    public ModelAndView redireccion(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("buscarVerProducto");
        return (mv);
    }
    
    @RequestMapping(value ="buscarPOST", method = RequestMethod.POST)
    public void buscarPost(HttpServletRequest request) throws ServletException {
        String buscar= (String) request.getParameter("bucar");
        request.setAttribute("search", buscar);        
    }
}
