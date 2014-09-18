package SAF.UI.Seguridad;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class realizarFacturaController { //implements Controller{

    @RequestMapping(value = "realizarFacturacion")
    public ModelAndView redireccion(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("realizarFacturacion");
        return (mv);
    }
    
}