/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.UI.Stock;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value ="ajustar.htm",method = RequestMethod.POST)      
    public @ResponseBody void ajustarStock (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String majo = "lalala";
        System.out.println(majo);
    }

}
