package SAF.Logica.Stock;

import SAF.Datos.Stock.ActualizacionService;
import SAF.Logica.Abstract.AbstractManejador;
import SAF.VO.Stock.ProductoVO;
import java.util.List;
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
    
    @Transactional(rollbackFor = Exception.class)
    public List<ProductoVO> actualizarProductosDUSA () {
        return servicio.actualizarProductosDUSA();
//        productoDAO.actualizarProductosDUSA (productos);
    }
}
