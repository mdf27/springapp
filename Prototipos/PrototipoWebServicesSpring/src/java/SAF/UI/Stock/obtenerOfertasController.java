/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.UI.Stock;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uy.com.dusa.ws.DataOferta;
import uy.com.dusa.ws.ResultGetOfertas;
import uy.com.dusa.ws.WSConsultaStock;
import uy.com.dusa.ws.WSConsultaStockService;

@Controller
public class obtenerOfertasController {
    @RequestMapping(value = "listarOfertas")
    public ModelAndView redireccion(){
        try {
                WSConsultaStockService servicio = new WSConsultaStockService();
                WSConsultaStock consultaStock = servicio.getWSConsultaStockPort();
                ResultGetOfertas obtenerOfertas = consultaStock.getOfertas("PIS2014","uvM4-N39C-Jt01-mc9E-e95b");
                List<DataOferta> ofertas = obtenerOfertas.getOfertas();
                return (new ModelAndView("listarOfertas","ofertas",ofertas));
        } catch (Exception e){
            
        }       
        return new ModelAndView("index");
    } 
}
