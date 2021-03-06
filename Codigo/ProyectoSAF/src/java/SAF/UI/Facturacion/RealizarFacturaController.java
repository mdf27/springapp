package SAF.UI.Facturacion;

import SAF.Facade.Facturacion.FacadeFacturacion;
import SAF.VO.Facturacion.FacturaVO;
import SAF.VO.Facturacion.TipoFormaPagoVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RealizarFacturaController { //implements Controller{

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
    public String ingresarFactura(String json) throws IOException {

        String result = "";
        try {
            FacturaVO factura = new ObjectMapper().readValue(json, FacturaVO.class);
            facadeFacturacion.registrarFactura(factura);
        } catch (Exception ex) {
            Logger.getLogger(RealizarFacturaController.class.getName()).log(Level.SEVERE, null, ex);
            result = ex.getMessage();
        }
        return result;
        
    }
    
    @RequestMapping(value = "obtenerFormasPago.json",method = RequestMethod.GET)      
    public @ResponseBody List<TipoFormaPagoVO> obtenerFormasPago (){
        
        List<TipoFormaPagoVO> formasPago = facadeFacturacion.obtenerFormasDePago();
        return formasPago;
        
    }
    
}
