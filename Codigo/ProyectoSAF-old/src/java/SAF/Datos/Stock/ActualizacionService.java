package SAF.Datos.Stock;

import SAF.VO.Stock.DataInfoProductoVO;
import SAF.VO.Stock.ProductoVO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Manu
 */
@Service
public class ActualizacionService {
    
    @Autowired
    private ActualizarProductoDAO productoDAO;
    
//    public List <DataInfoProducto> obtenerActualizacionDUSA(){
//        WSConsultaStockService servicio = new WSConsultaStockService();
//        WSConsultaStock consultaStock = servicio.getWSConsultaStockPort();
//        ResultGetStockUpdates obtenerStockUpdates= consultaStock.getStockUpdates("PIS2014","uvM4-N39C-Jt01-mc9E-e95b");
//        return obtenerStockUpdates.getProductos();;
//    }
    
/// mientras no funciona el web service me creo yo una lista de DataInfoProductoVO
    public Map <String, List<ProductoVO>> actualizarProductosDUSA(){
    
// supongamos que productosDUSA es la lista de DataInfoProducto que me llega de DUSA
            
        List<DataInfoProductoVO> productosDUSA = new ArrayList<>();
        DataInfoProductoVO prod = new DataInfoProductoVO();
        DataInfoProductoVO prod1 = new DataInfoProductoVO();
        DataInfoProductoVO prod2 = new DataInfoProductoVO();
        DataInfoProductoVO prod3 = new DataInfoProductoVO();
        DataInfoProductoVO prod4 = new DataInfoProductoVO();

        prod.setNumeroArticulo(25);
        prod.setDescripcion("Ahora soy yo");
        prod.setTipoIVA("basico");
        BigDecimal num = new BigDecimal(255);
        prod.setPrecioVenta(num);
        num = new BigDecimal(355);
        prod.setPrecioPublico(num);
        prod.setHabilitado(1);
        productosDUSA.add(prod);

        prod1.setNumeroArticulo(27);
        prod1.setDescripcion("Ahora soy yo");
        prod1.setTipoIVA("basico");
        num = new BigDecimal(255);
        prod1.setPrecioVenta(num);
        num = new BigDecimal(355);
        prod1.setPrecioPublico(num);
        prod1.setHabilitado(1);
        productosDUSA.add(prod1);

        prod2.setNumeroArticulo(30);
        prod2.setDescripcion("Ahora soy yo 2");
        prod2.setTipoIVA("basico");
        num = new BigDecimal(355);
        prod2.setPrecioVenta(num);
        num = new BigDecimal(555);
        prod2.setPrecioPublico(num);
        prod2.setHabilitado(1);
        productosDUSA.add(prod2);

        prod3.setNumeroArticulo(12);
        prod3.setDescripcion("Ahora soy yo 3");
        prod3.setTipoIVA("basico");
        num = new BigDecimal(655);
        prod3.setPrecioVenta(num);
        num = new BigDecimal(755);
        prod3.setPrecioPublico(num);
        prod3.setHabilitado(1);
        productosDUSA.add(prod3);

        prod4.setNumeroArticulo(8);
        prod4.setDescripcion("Ahora soy yo 20");
        prod4.setTipoIVA("basico");
        num = new BigDecimal(755);
        prod4.setPrecioVenta(num);
        num = new BigDecimal(955);
        prod4.setPrecioPublico(num);
        prod4.setHabilitado(0);
        productosDUSA.add(prod4);

        return productoDAO.actualizarProductosDUSA(productosDUSA);
    }
}