/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Stock;

import SAF.VO.Stock.DatosCompletosMedProdVO;
import SAF.VO.Stock.DatosCompletosMedicamentoVO;
import SAF.VO.Stock.DatosCompletosProductoVO;
import java.util.List;
import java.util.Map;
import org.apache.lucene.store.Directory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author majo
 */
public class LuceneDAOTest {
    
    public LuceneDAOTest() {
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
     * Test of getIndiceProductosLucene method, of class LuceneDAO.
     */
    @Test
    public void testGetIndiceProductosLucene() {
        System.out.println("getIndiceProductosLucene");
        LuceneDAO instance = new LuceneDAO();
        Directory expResult = null;
        Directory result = instance.getIndiceProductosLucene();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInstance method, of class LuceneDAO.
     */
    @Test
    public void testGetInstance() throws Exception {
        System.out.println("getInstance");
        LuceneDAO expResult = null;
        LuceneDAO result = LuceneDAO.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of indiceCargado method, of class LuceneDAO.
     */
    @Test
    public void testIndiceCargado() {
        System.out.println("indiceCargado");
        
        LuceneDAO instance = new LuceneDAO();
        boolean expResult = false;
        boolean result = instance.indiceCargado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarProductos method, of class LuceneDAO.
     */
    @Test
    public void testCargarProductos() throws Exception {
        System.out.println("cargarProductos");
        Map<Integer, DatosCompletosProductoVO> productos = null;
        Map<Integer, DatosCompletosMedicamentoVO> medicamentos = null;
        LuceneDAO instance = new LuceneDAO();
        instance.cargarProductos(productos, medicamentos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarIndiceProductosLucene method, of class LuceneDAO.
     */
    @Test
    public void testActualizarIndiceProductosLucene() throws Exception {
        System.out.println("actualizarIndiceProductosLucene");
        Map<Integer, DatosCompletosProductoVO> productos = null;
        Map<Integer, DatosCompletosMedicamentoVO> medicamentos = null;
        LuceneDAO instance = new LuceneDAO();
        instance.actualizarIndiceProductosLucene(productos, medicamentos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarProducto method, of class LuceneDAO.
     */
    @Test
    public void testBuscarProducto() throws Exception {
        System.out.println("buscarProducto");
        String texto_buscar = "";
        String filtro = "";
        LuceneDAO instance = new LuceneDAO();
        List<DatosCompletosMedProdVO> expResult = null;
        List<DatosCompletosMedProdVO> result = instance.buscarProducto(texto_buscar, filtro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
