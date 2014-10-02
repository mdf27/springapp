/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.Datos.Facturacion;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Fernanda
 */
public class FacturaDAOTest {
    
      
    /**
     *
     */
    
        
    private FacturaDAO facturaDao;    
    private ApplicationContext context;
    
    
    /**
     * Test of validarUsuario method, of class LoginDAO.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext("file:web/WEB-INF/dispatcher-servlet.xml");
        facturaDao = (FacturaDAO) context.getBean(FacturaDAO.class);
    
    }
    @Test
    public void testobtenerSerieActual() {

        assertEquals(facturaDao.obtenerSerieActual("AAA"), "AAB");
        assertEquals(facturaDao.obtenerSerieActual("AAZ"), "ABA");
        assertEquals(facturaDao.obtenerSerieActual("AZY"), "AZZ");
        assertEquals(facturaDao.obtenerSerieActual("AZZ"), "BAA");
        assertEquals(facturaDao.obtenerSerieActual("CTZ"), "CUA");
        assertEquals(facturaDao.obtenerSerieActual("DXY"), "DXZ");
        assertEquals(facturaDao.obtenerSerieActual("AAN"), "AAO");
        
    }
    
}
