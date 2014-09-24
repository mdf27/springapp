package SAF.Datos.Stock;

import SAF.VO.Stock.DataInfoProductoVO;
import SAF.VO.Stock.ProductoVO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Usuario
 */
public class ActualizarProductoDAOTest {    
    
    private ActualizarProductoDAO productoDao;    
    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext("file:web/WEB-INF/dispatcher-servlet.xml");
        productoDao = (ActualizarProductoDAO) context.getBean(ActualizarProductoDAO.class);
    
    }
    
    @Test
    public void testActualizarProductosDUSA() {
        List<DataInfoProductoVO> productosDUSA = new ArrayList<>();
        DataInfoProductoVO prod = new DataInfoProductoVO();
        DataInfoProductoVO prod1 = new DataInfoProductoVO();
        DataInfoProductoVO prod2 = new DataInfoProductoVO();
        DataInfoProductoVO prod3 = new DataInfoProductoVO();
        DataInfoProductoVO prod4 = new DataInfoProductoVO();
        
        prod.setNumeroArticulo(11);
        prod.setDescripcion("cambie, me deshabilite");
        prod.setTipoIVA("basico");
        BigDecimal num = new BigDecimal(355);
        prod.setPrecioVenta(num);
        num = new BigDecimal(455);
        prod.setPrecioPublico(num);
        prod.setHabilitado(0);
        productosDUSA.add(prod);
        
        prod1.setNumeroArticulo(13);
        prod1.setDescripcion("Ahora soy yo");
        prod1.setTipoIVA("basico");
        num = new BigDecimal(255);
        prod1.setPrecioVenta(num);
        num = new BigDecimal(355);
        prod1.setPrecioPublico(num);
        prod1.setHabilitado(1);
        productosDUSA.add(prod1);
        
        prod2.setNumeroArticulo(14);
        prod2.setDescripcion("Ahora soy yo 2");
        prod2.setTipoIVA("basico");
        num = new BigDecimal(755);
        prod2.setPrecioVenta(num);
        num = new BigDecimal(855);
        prod2.setPrecioPublico(num);
        prod2.setHabilitado(1);
        productosDUSA.add(prod2);
        
        prod3.setNumeroArticulo(22);
        prod3.setDescripcion("soy nuevo!");
        prod3.setTipoIVA("basico");
        num = new BigDecimal(455);
        prod3.setPrecioVenta(num);
        num = new BigDecimal(755);
        prod3.setPrecioPublico(num);
        prod3.setHabilitado(1);
        productosDUSA.add(prod3);
        
        prod4.setNumeroArticulo(12);
        prod4.setDescripcion("Ahora soy yo des");
        prod4.setTipoIVA("basico");
        num = new BigDecimal(755);
        prod4.setPrecioVenta(num);
        num = new BigDecimal(877);
        prod4.setPrecioPublico(num);
        prod4.setHabilitado(0);
        productosDUSA.add(prod4);
        
        //ProductoDAO productoDao = new ActualizarProductoDAO();
        List <ProductoVO> productosActualizados = productoDao.actualizarProductosDUSA(productosDUSA);
        
        ProductoVO producto = productosActualizados.get(0);
        assertEquals(11,producto.getIdProducto());
        double expected = new Double(355.0);
        double actual = producto.getPrecioCompra();
        assertEquals(expected,actual,0);
        expected = new Double(455.0);
        actual = producto.getPrecioVenta();
        assertEquals(expected,actual,0);
        assertFalse(producto.isHabilitado());
        
        producto = productosActualizados.get(3);
        assertEquals(22,producto.getIdProducto());
        expected = new Double(455.0);
        actual = producto.getPrecioCompra();
        assertEquals(expected,actual,0);
        expected = new Double(755.0);
        actual = producto.getPrecioVenta();
        assertEquals(expected,actual,0);
        assertTrue(producto.isHabilitado());
        
        producto = productosActualizados.get(4);
        assertEquals(12,producto.getIdProducto());
        expected = new Double(755.0);
        actual = producto.getPrecioCompra();
        assertEquals(expected,actual,0);
        expected = new Double(877.0);
        actual = producto.getPrecioVenta();
        assertEquals(expected,actual,0);
        assertFalse(producto.isHabilitado());

    }
}

