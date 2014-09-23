/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class ProductoDAOTest {    
    
    private ProductoDAO productoDao;    
    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext("file:web/WEB-INF/dispatcher-servlet.xml");
        productoDao = (ProductoDAO) context.getBean(ProductoDAO.class);
    
    }
    
    @Test
    public void testActualizarProductosDUSA() {
        List<DataInfoProductoVO> productos = new ArrayList<>();
        DataInfoProductoVO prod = new DataInfoProductoVO();
        DataInfoProductoVO prod1 = new DataInfoProductoVO();
        DataInfoProductoVO prod2 = new DataInfoProductoVO();
        DataInfoProductoVO prod3 = new DataInfoProductoVO();
        DataInfoProductoVO prod4 = new DataInfoProductoVO();
        
        prod.setNumeroArticulo(11);
        prod.setDescripcion("Ahora soy yo");
        prod.setTipoIVA("basico");
        BigDecimal num = new BigDecimal(255);
        prod.setPrecioVenta(num);
        num = new BigDecimal(355);
        prod.setPrecioPublico(num);
        prod.setHabilitado(1);
        productos.add(prod);
        
        prod1.setNumeroArticulo(13);
        prod1.setDescripcion("Ahora soy yo");
        prod1.setTipoIVA("basico");
        num = new BigDecimal(255);
        prod1.setPrecioVenta(num);
        num = new BigDecimal(355);
        prod1.setPrecioPublico(num);
        prod1.setHabilitado(1);
        productos.add(prod1);
        
        prod2.setNumeroArticulo(14);
        prod2.setDescripcion("Ahora soy yo 2");
        prod2.setTipoIVA("basico");
        num = new BigDecimal(755);
        prod2.setPrecioVenta(num);
        num = new BigDecimal(855);
        prod2.setPrecioPublico(num);
        prod2.setHabilitado(1);
        productos.add(prod2);
        
        prod3.setNumeroArticulo(18);
        prod3.setDescripcion("Ahora soy yo 3");
        prod3.setTipoIVA("basico");
        num = new BigDecimal(655);
        prod3.setPrecioVenta(num);
        num = new BigDecimal(755);
        prod3.setPrecioPublico(num);
        prod3.setHabilitado(1);
        productos.add(prod3);
        
        prod4.setNumeroArticulo(12);
        prod4.setDescripcion("Ahora soy yo des");
        prod4.setTipoIVA("basico");
        num = new BigDecimal(755);
        prod4.setPrecioVenta(num);
        num = new BigDecimal(955);
        prod4.setPrecioPublico(num);
        prod4.setHabilitado(0);
        productos.add(prod4);
        
        //ProductoDAO productoDao = new ProductoDAO();
        productoDao.actualizarProductosDUSA(productos);
        
        ProductoVO producto = productoDao.getProducto(13);
        
        double expected = new Double(255.0);
        double actual = producto.getPrecioCompra();
        assertEquals(expected,actual,0);
        expected = new Double(355.0);
        actual = producto.getPrecioVenta();
        assertEquals(expected,actual,0);
        
        producto = productoDao.getProducto(18);
        expected = new Double(655.0);
        actual = producto.getPrecioCompra();
        assertEquals(expected,actual,0);
        expected = new Double(755.0);
        actual = producto.getPrecioVenta();
        assertEquals(expected,actual,0);

    }
}
