package SAF.Logica.Stock;

import SAF.Datos.Stock.ActualizacionService;
import SAF.Datos.Stock.ActualizarProductoDAO;
import SAF.Logica.Abstract.AbstractManejador;
import SAF.VO.Stock.ProductoVO;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Manu
 */
@Service
public class ModificarProductoManager extends AbstractManejador {
//    @Autowired
//    private ProductoDAO productoDAO;
    
    @Autowired
    private ActualizacionService servicio;
    
    @Autowired
    private ActualizarProductoDAO productoDAO;
    
    @Transactional(rollbackFor = Exception.class)
    public Map <String, List<ProductoVO>> actualizarProductosDUSA () {
        return productoDAO.actualizarProductosDUSA(servicio.obtenerActualizacionDUSA(),servicio.obtenerLaboratoriosDUSA());
//        productoDAO.actualizarProductosDUSA (productos);
    }
}
