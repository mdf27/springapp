package SAF.Logica.Stock;

import SAF.Datos.Stock.ActualizacionService;
import SAF.Datos.Stock.ActualizarProductoDAO;
import SAF.Logica.Abstract.AbstractManejador;
import SAF.VO.Stock.ProductoVO;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
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
        GregorianCalendar gcal = new GregorianCalendar();
        gcal.setTime(new Date(114,8,20));
        XMLGregorianCalendar xgcal;
        try {
            xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        } catch (DatatypeConfigurationException ex) {
           xgcal = null;
        }
        return productoDAO.actualizarProductosDUSA(servicio.obtenerActualizacionDUSA(xgcal),servicio.obtenerLaboratoriosDUSA());
//        productoDAO.actualizarProductosDUSA (productos);
    }
}
