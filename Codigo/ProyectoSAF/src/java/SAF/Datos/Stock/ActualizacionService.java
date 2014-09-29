package SAF.Datos.Stock;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Service;
import uy.com.dusa.ws.DataInfoProducto;
import uy.com.dusa.ws.DataLaboratorio;
import uy.com.dusa.ws.ResultGetLaboratorios;
import uy.com.dusa.ws.ResultGetStockUpdates;
import uy.com.dusa.ws.WSConsultaStock;
import uy.com.dusa.ws.WSConsultaStockService;

/**
 *
 * @author Manu
 */
@Service
public class ActualizacionService {
    
    public List <DataInfoProducto> obtenerActualizacionDUSA(XMLGregorianCalendar fecha){
        WSConsultaStockService servicio = new WSConsultaStockService();
        WSConsultaStock consultaStock = servicio.getWSConsultaStockPort();
        try { 
            ResultGetStockUpdates obtenerStockUpdates= consultaStock.getStockUpdates("PIS2014","uvM4-N39C-Jt01-mc9E-e95b",fecha);
            return obtenerStockUpdates.getProductos();
        } catch (Exception e) {    
            return null;
        }
        
    }
    
    public List <DataLaboratorio> obtenerLaboratoriosDUSA(){
        WSConsultaStockService servicio = new WSConsultaStockService();
        WSConsultaStock consultaStock = servicio.getWSConsultaStockPort();
        try {
            ResultGetLaboratorios obtenerLaboratorios= consultaStock.getLaboratorios("PIS2014","uvM4-N39C-Jt01-mc9E-e95b");
            return obtenerLaboratorios.getLaboratorios();
        } catch (Exception ex) {
            return null;
        }
    }
    
/// mientras no funciona el web service me creo yo una lista de DataInfoProductoVO
//    public List<DataInfoProductoVO> actualizarProductosDUSA(){
//    
//// supongamos que productosDUSA es la lista de DataInfoProducto que me llega de DUSA
//            
//        List<DataInfoProductoVO> productosDUSA = new ArrayList<>();
//        DataInfoProductoVO prod = new DataInfoProductoVO();
//        DataInfoProductoVO prod1 = new DataInfoProductoVO();
//        DataInfoProductoVO prod2 = new DataInfoProductoVO();
//        DataInfoProductoVO prod3 = new DataInfoProductoVO();
//        DataInfoProductoVO prod4 = new DataInfoProductoVO();
//
//        prod.setNumeroArticulo(55);
//        prod.setDescripcion("Ahora soy yo");
//        prod.setTipoIVA("basico");
//        BigDecimal num = new BigDecimal(255);
//        prod.setPrecioVenta(num);
//        num = new BigDecimal(355);
//        prod.setPrecioPublico(num);
//        prod.setHabilitado(1);
//        prod.setCodigoBarra("manu");
//        productosDUSA.add(prod);
//
//        prod1.setNumeroArticulo(555);
//        prod1.setDescripcion("Ahora soy yo");
//        prod1.setTipoIVA("basico");
//        num = new BigDecimal(255);
//        prod1.setPrecioVenta(num);
//        num = new BigDecimal(355);
//        prod1.setPrecioPublico(num);
//        prod1.setHabilitado(1);
//        prod1.setCodigoBarra("Estera");
//        productosDUSA.add(prod1);
//
//        prod2.setNumeroArticulo(5555);
//        prod2.setDescripcion("Ahora soy yo 2");
//        prod2.setTipoIVA("basico");
//        num = new BigDecimal(355);
//        prod2.setPrecioVenta(num);
//        num = new BigDecimal(555);
//        prod2.setPrecioPublico(num);
//        prod2.setHabilitado(1);
//        prod2.setCodigoBarra("manu");
//        productosDUSA.add(prod2);
//
//        prod3.setNumeroArticulo(55555);
//        prod3.setDescripcion("Ahora soy yo 3");
//        prod3.setTipoIVA("basico");
//        num = new BigDecimal(655);
//        prod3.setPrecioVenta(num);
//        num = new BigDecimal(755);
//        prod3.setPrecioPublico(num);
//        prod3.setHabilitado(1);
//        prod3.setCodigoBarra("manu");
//        productosDUSA.add(prod3);
//
//        prod4.setNumeroArticulo(555555);
//        prod4.setDescripcion("Ahora soy yo 20");
//        prod4.setTipoIVA("basico");
//        num = new BigDecimal(755);
//        prod4.setPrecioVenta(num);
//        num = new BigDecimal(955);
//        prod4.setPrecioPublico(num);
//        prod4.setHabilitado(0);
//        prod4.setCodigoBarra("manu");
//        productosDUSA.add(prod4);
//
//        return productosDUSA;
//    }
}