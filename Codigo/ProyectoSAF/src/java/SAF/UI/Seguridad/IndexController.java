

package SAF.UI.Seguridad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class IndexController {
    @RequestMapping(value = "index")
    public ModelAndView redireccion(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return (mv);
    }
    
    
}
