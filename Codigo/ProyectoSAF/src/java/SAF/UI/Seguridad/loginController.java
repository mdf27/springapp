package SAF.UI.Seguridad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class loginController {
    @RequestMapping(value = "inicio")
    public ModelAndView redireccion(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("inicio");
        return (mv);
    }
    
    
}