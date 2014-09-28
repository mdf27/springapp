/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.Datos.Stock;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uy.com.dusa.ws.DataInfoProducto;
import uy.com.dusa.ws.DataLaboratorio;

/**
 *
 * @author esti
 */
public class ActualizacionServiceTest {
    
    public ActualizacionServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of obtenerActualizacionDUSA method, of class ActualizacionService.
     */
    @Test
    public void testObtenerActualizacionDUSA() {
        String iva = "I.V.A. 22con Imesi";
        String subIva = iva.substring(0,10);
        assertEquals("I.V.A. 22c",subIva);
    }

    
}
