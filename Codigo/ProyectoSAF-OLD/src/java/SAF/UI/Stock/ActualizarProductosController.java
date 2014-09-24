/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.UI.Stock;

import SAF.Facade.Stock.FacadeStock;
import SAF.VO.Stock.DataInfoProductoVO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Manu
 */

@Controller
public class ActualizarProductosController {
    @Autowired
    private FacadeStock bpm;
    
    @RequestMapping(value = "actualizarProductosDUSA")
    public ModelAndView redireccion(){
       // WSConsultaStockService servicio = new WSConsultaStockService();
       // WSConsultaStock consultaStock = servicio.getWSConsultaStockPort();
       // ResultGetStockUpdates obtenerStockUpdates= consultaStock.getStockUpdates("PIS2014","uvM4-N39C-Jt01-mc9E-e95b");
       // List <DataInfoProducto> productos = obtenerStockUpdates.getProductos();
       
//        List<DataInfoProductoVO> productos = new ArrayList<>();
//        DataInfoProductoVO prod = new DataInfoProductoVO();
//        DataInfoProductoVO prod1 = new DataInfoProductoVO();
//        DataInfoProductoVO prod2 = new DataInfoProductoVO();
//        DataInfoProductoVO prod3 = new DataInfoProductoVO();
//        DataInfoProductoVO prod4 = new DataInfoProductoVO();
//        
//        prod.setNumeroArticulo(11);
//        prod.setDescripcion("Ahora soy yo");
//        prod.setTipoIVA("basico");
//        BigDecimal num = new BigDecimal(255);
//        prod.setPrecioVenta(num);
//        num = new BigDecimal(355);
//        prod.setPrecioPublico(num);
//        prod.setHabilitado(1);
//        productos.add(prod);
//        
//        prod1.setNumeroArticulo(13);
//        prod1.setDescripcion("Ahora soy yo");
//        prod1.setTipoIVA("basico");
//        num = new BigDecimal(255);
//        prod1.setPrecioVenta(num);
//        num = new BigDecimal(355);
//        prod1.setPrecioPublico(num);
//        prod1.setHabilitado(1);
//        productos.add(prod1);
//        
//        prod2.setNumeroArticulo(14);
//        prod2.setDescripcion("Ahora soy yo 2");
//        prod2.setTipoIVA("basico");
//        num = new BigDecimal(755);
//        prod2.setPrecioVenta(num);
//        num = new BigDecimal(855);
//        prod2.setPrecioPublico(num);
//        prod2.setHabilitado(1);
//        productos.add(prod2);
//        
//        prod3.setNumeroArticulo(18);
//        prod3.setDescripcion("Ahora soy yo 3");
//        prod3.setTipoIVA("basico");
//        num = new BigDecimal(655);
//        prod3.setPrecioVenta(num);
//        num = new BigDecimal(755);
//        prod3.setPrecioPublico(num);
//        prod3.setHabilitado(1);
//        productos.add(prod3);
//        
//        prod4.setNumeroArticulo(12);
//        prod4.setDescripcion("Ahora soy yo des");
//        prod4.setTipoIVA("basico");
//        num = new BigDecimal(755);
//        prod4.setPrecioVenta(num);
//        num = new BigDecimal(955);
//        prod4.setPrecioPublico(num);
//        prod4.setHabilitado(0);
//        productos.add(prod4);
//        
//        bpm.actualizarProductosDUSA(productos);   
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("actualizarProductosDUSA");
        return (mv);
    }
}
