package SAF.UI.Stock;

import SAF.Facade.Stock.FacadeStock;
import SAF.VO.Stock.ProductoVO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Manu
 */

@Controller
public class ActualizarProductosController {
    
    @RequestMapping(value = "actualizarProductosDUSA")
    public ModelAndView redireccion(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("actualizarProductosDUSA");
        return (mv);
    }
    
    @Autowired
    private FacadeStock fs;
    
    @RequestMapping(value = "actualizar.json",method = RequestMethod.GET)    
    public @ResponseBody  Map <String, List<ProductoVO>> buscarProducto (@RequestParam(value="fecha") Date fecha) throws ClassNotFoundException, SQLException, IOException, ParseException, java.text.ParseException{
        Map <String, List<ProductoVO>>  productosActualizados = fs.actualizarProductosDUSA(fecha); 
       return productosActualizados;
   }
}
