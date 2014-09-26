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
public class loginController {
    
    @Autowired
    FacadeSeguridad facadeSeguridad;
    
    
    public static boolean controlDeSeguridad(HttpSession session,int codigo){
        int codigoUsuario;
        Object cUsuario =  session.getAttribute("codigoUsuario");
        if (cUsuario != null){
            codigoUsuario = (int) cUsuario;
            return true;
        }
        else
            return false;  
    }
    

    @RequestMapping(value = "controlLogin", method = RequestMethod.POST)
    public ModelAndView validarUsuario(@RequestParam(value = "usuario") int codigoU){       
        ModelAndView mv = new ModelAndView();
        
        boolean loginCorrecto = facadeSeguridad.login(codigoU);        
        if (facadeSeguridad.login(codigoU))         
             mv.setViewName("inicio");
        else
             mv.setViewName("index");
        mv.addObject("resultadoLogin", loginCorrecto);                
        return (mv);
    }
        
}