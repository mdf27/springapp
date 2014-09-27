package SAF.UI.Seguridad;

import SAF.Facade.Seguridad.FacadeSeguridad;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class LoginController {
@Autowired
    FacadeSeguridad facadeSeguridad;
    ControlDeAcceso cAcceso = ControlDeAcceso.getInstancia();
    
    
    //Principal
    @RequestMapping(value = "inicio")
    public ModelAndView redireccion(HttpSession session){
        ModelAndView mv = new ModelAndView(); 
        if (cAcceso.controlDeLogin(session))
          mv.setViewName("inicio");
        else
            mv.setViewName("index");
        return (mv);
    }

    @RequestMapping(value = "controlLogin", method = RequestMethod.POST)
    public ModelAndView validarUsuario(@RequestParam(value = "usuario") int codigoU,HttpSession session){       
        ModelAndView mv = new ModelAndView();
            boolean loginCorrecto = facadeSeguridad.login(codigoU);        
            if (loginCorrecto){        
                 mv.setViewName("index");
                 session.setAttribute("codigoUsuario", codigoU);
                 mv.addObject("resultadoLogin", "Exito");
            }
            else{
                 mv.setViewName("index");
                 mv.addObject("resultadoLogin", "Error");
            }                            
        return (mv);
        
    }        
}