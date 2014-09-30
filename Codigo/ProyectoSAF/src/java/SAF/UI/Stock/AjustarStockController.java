/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.UI.Stock;

import SAF.Facade.Stock.FacadeStock;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author majo
 */

@Controller
public class AjustarStockController {
    @RequestMapping(value = "ajustarStock")
    public ModelAndView redireccion(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("ajustarStock");
        return (mv);
    }    

    @Autowired
    private FacadeStock bpm;

    @RequestMapping(value ="ajustarCantidadStock.htm",method = RequestMethod.POST)      
    public @ResponseBody void ajustarCantidadStock (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, ClassNotFoundException, SQLException, org.apache.lucene.queryparser.classic.ParseException {
        int cantidad = Integer.valueOf(request.getParameter("cant"));
        int id = Integer.valueOf(request.getParameter("id"));
        bpm.ajustarCantidadStock(id, cantidad);        
    }

}
