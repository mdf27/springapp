package SAF.UI.Facturacion;

import SAF.Facade.Facturacion.FacadeFacturacion;
import SAF.VO.Facturacion.FacturaVO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "ingresarFactura.htm", method = RequestMethod.POST)
    public void ingresarFactura(@RequestParam(value = "buscar") String texto_buscar, @RequestParam(value = "filtro") String filtro,HttpServletRequest request) {

        FacturaVO factura = new FacturaVO();
        facadeFacturacion.registrarFactura(factura);
    }
    
}
