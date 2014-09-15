package SAF.UI.Laboratorios;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uy.com.dusa.ws.DataLaboratorio;
import uy.com.dusa.ws.ResultGetLaboratorios;
import uy.com.dusa.ws.WSConsultaStock;
import uy.com.dusa.ws.WSConsultaStockService;

@Controller
public class formListarLaboratoriosController {
    @RequestMapping(value = "listarLaboratorios")
    public ModelAndView redireccion(){
        try {
                WSConsultaStockService servicio = new WSConsultaStockService();
                WSConsultaStock consultaStock = servicio.getWSConsultaStockPort();
                ResultGetLaboratorios obtenerLaboratorios = consultaStock.getLaboratorios("PIS2014","uvM4-N39C-Jt01-mc9E-e95b");
                List <DataLaboratorio> laboratorios = obtenerLaboratorios.getLaboratorios();
                return (new ModelAndView("listarLaboratorios","laboratorios",laboratorios));
        } catch (Exception e){
            
        }       
        return new ModelAndView("index");
    } 
}
