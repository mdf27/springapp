

package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class realizarFacturaController implements Controller{

    public realizarFacturaController() {
        
    }
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
       return new ModelAndView("/WEB-INF/jsp/realizarFacturacion.jsp");
    }
    
}
