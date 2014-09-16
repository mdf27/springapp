package SAF.UI.Stock;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uy.com.dusa.ws.DataLaboratorio;
import uy.com.dusa.ws.ResultGetLaboratorio;
import uy.com.dusa.ws.ResultGetLaboratorios;
import uy.com.dusa.ws.WSConsultaStock;
import uy.com.dusa.ws.WSConsultaStockService;

@Controller
public class verInfoLaboratorioController {
    @RequestMapping(value = "verLaboratorio")
    public ModelAndView redireccion(@RequestParam(value = "id") String idLaboratorio ){
        try {
                WSConsultaStockService servicio = new WSConsultaStockService();
                WSConsultaStock consultaStock = servicio.getWSConsultaStockPort();
                ResultGetLaboratorio obtenerLaboratorio = consultaStock.getLaboratorio("PIS2014","uvM4-N39C-Jt01-mc9E-e95b", idLaboratorio);
                DataLaboratorio laboratorio = obtenerLaboratorio.getLaboratorio();
                return (new ModelAndView("verLaboratorio","laboratorio",laboratorio));
        } catch (Exception e){
            
        }       
        return new ModelAndView("index");
    } 
}
