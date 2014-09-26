package SAF.UI.Stock;

import SAF.Facade.Stock.FacadeStock;
import SAF.VO.Stock.ProductoVO;
import java.util.List;
import java.util.Map;
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
    private FacadeStock fs;
    
    @RequestMapping(value = "actualizarProductosDUSA")
    public ModelAndView redireccion(){ 
    // Ahora lo mapeo a producto 
//        ProductoVO productos = new ProductoVO();
//        for (DataInfoProductoVO prodActual : productosDUSA) {
//            
//        }
        Map <String, List<ProductoVO>>  productosActualizados = fs.actualizarProductosDUSA(); 
        return (new ModelAndView("actualizarProductosDUSA",
                "productosActualizados", productosActualizados));
    }
}
