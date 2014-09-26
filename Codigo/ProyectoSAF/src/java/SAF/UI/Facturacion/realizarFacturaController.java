package SAF.UI.Facturacion;

import SAF.Facade.Facturacion.FacadeFacturacion;
import SAF.VO.Facturacion.FacturaVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class realizarFacturaController { //implements Controller{

    @Autowired
    FacadeFacturacion facadeFacturacion;

    @RequestMapping(value = "realizarFacturacion")
    public ModelAndView redireccion() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("realizarFacturacion");
        return (mv);
    }

    /**
     *
     * @param json
     * @param factura
     * @return 
     */
    @RequestMapping(value = "ingresarFactura.htm", method = RequestMethod.POST)
    public ModelAndView ingresarFactura(String json) throws IOException {

        FacturaVO factura = new ObjectMapper().readValue(json, FacturaVO.class);
        facadeFacturacion.registrarFactura(factura);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return (mv); 
    }
    
}
