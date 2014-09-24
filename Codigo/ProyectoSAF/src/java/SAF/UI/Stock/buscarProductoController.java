/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.UI.Stock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
