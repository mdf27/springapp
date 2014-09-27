/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Stock;

import SAF.VO.Stock.DatosCompletosMedProdVO;
import SAF.VO.Stock.DatosCompletosMedicamentoVO;
import SAF.VO.Stock.DatosCompletosProductoVO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author majo
 */
public class LuceneDAOTest {
    private LuceneDAO luceneDao;
    private ApplicationContext context;
    
    public LuceneDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ClassNotFoundException, SQLException, IOException, ParseException {
        context = new FileSystemXmlApplicationContext("file:web/WEB-INF/dispatcher-servlet.xml");
        luceneDao = (LuceneDAO)context.getBean(LuceneDAO.class);
       
        Map<Integer, DatosCompletosProductoVO> productos = new HashMap<Integer,DatosCompletosProductoVO>();
        DatosCompletosProductoVO p = new DatosCompletosProductoVO();
        p.setIdProducto(2);
        p.setDescripcion("VOLTAREN  75  5 AMP");
        p.setPrecioCompra(240.0);
        p.setPrecioVenta(220.8);
        p.setHabilitado(true);
        p.setCantidadStock(5);        
        p.setVencimientoStock(new Date("30/08/2015"));
        p.setCodigoBarras("1568");
        p.setTipoIVA("basico");
        p.setProveedor("Daniela Fagúndez");
        p.setDescuentos(40.0);
        p.setDescuentos(15.0);
        p.setDescripcionDescuento("Receta");
        p.setDescripcionDescuento("Producto");
        productos.put(2, p);
        DatosCompletosProductoVO p1 = new DatosCompletosProductoVO();
        p1.setIdProducto(3);
        p1.setDescripcion("VOLTAREN RETARD 100 MG");
        p1.setPrecioCompra(207.0);
        p1.setPrecioVenta(190.44);
        p1.setHabilitado(true);
        p1.setCantidadStock(15);        
        p1.setVencimientoStock(new Date("11/01/2020"));
        p1.setVencimientoStock(new Date("05/10/2023"));
        p1.setVencimientoStock(new Date("15/09/2016"));
        p1.setCodigoBarras("1570");
        p1.setTipoIVA("basico");
        p1.setProveedor("Ma José Rabaza");
        p1.setDescuentos(40.0);
        p1.setDescuentos(15.0);
        p1.setDescripcionDescuento("Receta");
        p1.setDescripcionDescuento("Descuento");
        productos.put(3, p1);
        
        Map <Integer, DatosCompletosMedicamentoVO> medicamentos = new HashMap<Integer,DatosCompletosMedicamentoVO>(); 
        DatosCompletosMedicamentoVO m = new DatosCompletosMedicamentoVO();
        m.setIdProducto(2);
        m.setRequiereReceta(true);
        m.setNombreLaboratorio("GRA");
        m.setNombreDroga("drogaVoltaren");
        m.setAccionTerapeutica("atVoltaren");
        m.setPresentacion("drogaVoltaren");
        medicamentos.put(2, m);
        DatosCompletosMedicamentoVO m1 = new DatosCompletosMedicamentoVO();
        m1.setIdProducto(3);
        m1.setRequiereReceta(true);
        m1.setNombreLaboratorio("GRA");
        m1.setNombreDroga("drogaVoltaren");
        m1.setAccionTerapeutica("atVoltaren");
        m1.setPresentacion("drogaVoltaren");
        medicamentos.put(3, m1);  
        
        luceneDao.cargarProductos(productos, medicamentos);

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
    }

    /**
     * Test of getInstance method, of class LuceneDAO.
     */
    @Test
    public void testGetInstance() throws Exception {
        System.out.println("getInstance");
        LuceneDAO expResult = null;
        LuceneDAO result = LuceneDAO.getInstance();
        assertNotNull(result);        
        assertEquals(result, LuceneDAO.getInstance());
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
        
        Directory indice = new RAMDirectory();  
        instance.setIndiceProductosLucene(indice);
        expResult=true;
        result = instance.indiceCargado();
        assertEquals(expResult, result);
    }

    /**
     * Test of cargarProductos method, of class LuceneDAO.
     */
    @Test
    public void testCargarProductos() throws Exception {
        System.out.println("cargarProductos");
       
        Map<Integer, DatosCompletosProductoVO> productos = new HashMap<Integer,DatosCompletosProductoVO>();
        DatosCompletosProductoVO p = new DatosCompletosProductoVO();
        p.setIdProducto(2);
        p.setDescripcion("VOLTAREN  75  5 AMP");
        p.setPrecioCompra(240.0);
        p.setPrecioVenta(220.8);
        p.setHabilitado(true);
        p.setCantidadStock(5);        
        p.setVencimientoStock(new Date("30/08/2015"));
        p.setCodigoBarras("1568");
        p.setTipoIVA("basico");
        p.setProveedor("Daniela Fagúndez");
        p.setDescuentos(40.0);
        p.setDescuentos(15.0);
        p.setDescripcionDescuento("Receta");
        p.setDescripcionDescuento("Producto");
        productos.put(2, p);
        DatosCompletosProductoVO p1 = new DatosCompletosProductoVO();
        p1.setIdProducto(3);
        p1.setDescripcion("VOLTAREN RETARD 100 MG");
        p1.setPrecioCompra(207.0);
        p1.setPrecioVenta(190.44);
        p1.setHabilitado(true);
        p1.setCantidadStock(15);        
        p1.setVencimientoStock(new Date("11/01/2020"));
        p1.setVencimientoStock(new Date("05/10/2023"));
        p1.setVencimientoStock(new Date("15/09/2016"));
        p1.setCodigoBarras("1570");
        p1.setTipoIVA("basico");
        p1.setProveedor("Ma José Rabaza");
        p1.setDescuentos(40.0);
        p1.setDescuentos(15.0);
        p1.setDescripcionDescuento("Receta");
        p1.setDescripcionDescuento("Descuento");
        productos.put(3, p1);
        
        Map <Integer, DatosCompletosMedicamentoVO> medicamentos = new HashMap<Integer,DatosCompletosMedicamentoVO>(); 
        DatosCompletosMedicamentoVO m = new DatosCompletosMedicamentoVO();
        m.setIdProducto(2);
        m.setRequiereReceta(true);
        m.setNombreLaboratorio("GRA");
        m.setNombreDroga("drogaVoltaren");
        m.setAccionTerapeutica("atVoltaren");
        m.setPresentacion("drogaVoltaren");
        medicamentos.put(2, m);
        DatosCompletosMedicamentoVO m1 = new DatosCompletosMedicamentoVO();
        m1.setIdProducto(3);
        m1.setRequiereReceta(true);
        m1.setNombreLaboratorio("GRA");
        m1.setNombreDroga("drogaVoltaren");
        m1.setAccionTerapeutica("atVoltaren");
        m1.setPresentacion("drogaVoltaren");
        medicamentos.put(3, m1);  
        
        LuceneDAO instance = new LuceneDAO();
        instance.cargarProductos(productos, medicamentos);
        
        LuceneDAO instance1 = LuceneDAO.getInstance();
        instance1.setIndiceProductosLucene(new RAMDirectory());
        instance1.crearIndiceProductosLuecene(productos, medicamentos);
        int expResult = instance1.getIndiceProductosLucene().listAll().length;
        int result = instance.getIndiceProductosLucene().listAll().length;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of actualizarIndiceProductosLucene method, of class LuceneDAO.
     */
    @Test
    public void testActualizarIndiceProductosLucene() throws Exception {
        System.out.println("actualizarIndiceProductosLucene");
        Map<Integer, DatosCompletosProductoVO> productos = new HashMap<Integer,DatosCompletosProductoVO>();
        DatosCompletosProductoVO p = new DatosCompletosProductoVO();
        p.setIdProducto(2);
        p.setDescripcion("VOLTAREN  75  5 AMP");
        p.setPrecioCompra(240.0);
        p.setPrecioVenta(220.8);
        p.setHabilitado(true);
        p.setCantidadStock(5);        
        p.setVencimientoStock(new Date("30/08/2015"));
        p.setCodigoBarras("1568");
        p.setTipoIVA("basico");
        p.setProveedor("Daniela Fagúndez");
        p.setDescuentos(40.0);
        p.setDescuentos(15.0);
        p.setDescripcionDescuento("Receta");
        p.setDescripcionDescuento("Producto");
        productos.put(2, p);
        DatosCompletosProductoVO p1 = new DatosCompletosProductoVO();
        p1.setIdProducto(3);
        p1.setDescripcion("VOLTAREN RETARD 100 MG");
        p1.setPrecioCompra(207.0);
        p1.setPrecioVenta(190.44);
        p1.setHabilitado(true);
        p1.setCantidadStock(15);        
        p1.setVencimientoStock(new Date("11/01/2020"));
        p1.setVencimientoStock(new Date("05/10/2023"));
        p1.setVencimientoStock(new Date("15/09/2016"));
        p1.setCodigoBarras("1570");
        p1.setTipoIVA("basico");
        p1.setProveedor("Ma José Rabaza");
        p1.setDescuentos(40.0);
        p1.setDescuentos(15.0);
        p1.setDescripcionDescuento("Receta");
        p1.setDescripcionDescuento("Descuento");
        productos.put(3, p1);
        
        Map <Integer, DatosCompletosMedicamentoVO> medicamentos = new HashMap<Integer,DatosCompletosMedicamentoVO>(); 
        DatosCompletosMedicamentoVO m = new DatosCompletosMedicamentoVO();
        m.setIdProducto(2);
        m.setRequiereReceta(true);
        m.setNombreLaboratorio("GRA");
        m.setNombreDroga("drogaVoltaren");
        m.setAccionTerapeutica("atVoltaren");
        m.setPresentacion("drogaVoltaren");
        medicamentos.put(2, m);
        DatosCompletosMedicamentoVO m1 = new DatosCompletosMedicamentoVO();
        m1.setIdProducto(3);
        m1.setRequiereReceta(true);
        m1.setNombreLaboratorio("GRA");
        m1.setNombreDroga("drogaVoltaren");
        m1.setAccionTerapeutica("atVoltaren");
        m1.setPresentacion("drogaVoltaren");
        medicamentos.put(3, m1);  
        
        LuceneDAO instance = new LuceneDAO();
        instance.setIndiceProductosLucene(new RAMDirectory());
        instance.actualizarIndiceProductosLucene(productos, medicamentos);
        
        LuceneDAO instance1 = LuceneDAO.getInstance();
        instance1.setIndiceProductosLucene(new RAMDirectory());
        instance1.crearIndiceProductosLuecene(productos, medicamentos);
        int expResult = instance1.getIndiceProductosLucene().listAll().length;
        int result = instance.getIndiceProductosLucene().listAll().length;
        assertEquals(expResult, result);
    }

    /**
     * Test of buscarProducto method, of class LuceneDAO.
     */
    @Test
    public void testBuscarProducto() throws Exception {
        System.out.println("buscarProducto");
        String texto_buscar = "vol";
        String filtro = "descripcion";
        
        List<DatosCompletosMedProdVO> expResult = new LinkedList<>();
        
        DatosCompletosMedProdVO m = new DatosCompletosMedProdVO();
        m.setIdProducto(2);
        m.setDescripcion("VOLTAREN  75  5 AMP");
        m.setPrecioCompra(240.0);
        m.setPrecioVenta(220.8);
        m.setPrecioLista(220.8);
        m.setHabilitado("Disponible");
        m.setCantidad(5);        
        m.setVencimientos("08/06/2017");
        m.setCodigos("1568");
        m.setTipoIVA("basico");
        m.setProveedor("Daniela Fagúndez");
        m.setReceta("Si");
        m.setLaboratorio("GRA");
        m.setDrogas("drogaVoltaren");
        m.setAccion("atVoltaren");
        m.setPresentacion("drogaVoltaren");
        m.setDescuentoReceta(40.0);
        m.setDescuentoProducto(0.0);
        m.setFarmaDescuento(132.48);
        m.setCostoReal(0.0);
        m.setDescDescuento(null);
        DatosCompletosMedProdVO m1 = new DatosCompletosMedProdVO();
        m1.setIdProducto(3);
        m1.setDescripcion("VOLTAREN RETARD 100 MG");
        m1.setPrecioCompra(207.0);
        m1.setPrecioVenta(190.44);
        m1.setPrecioLista(190.44);
        m1.setHabilitado("Disponible");
        m1.setCantidad(15);        
        m1.setVencimientos("11/01/2020,05/10/2023,15/09/2016");
        m1.setCodigos("1570");
        m1.setTipoIVA("basico");
        m1.setProveedor("Ma José Rabaza");
        m1.setReceta("Si");
        m1.setLaboratorio("GRA");
        m1.setDrogas("drogaVoltaren");
        m1.setAccion("atVoltaren");
        m1.setPresentacion("drogaVoltaren");
        m1.setDescuentoReceta(15.0);
        m1.setDescuentoProducto(0.0);
        m1.setFarmaDescuento(161.87);
        m1.setCostoReal(0.0);
        m1.setDescDescuento(null);
        expResult.add(m);
        expResult.add(m1);
        
        List<DatosCompletosMedProdVO> result = luceneDao.buscarProducto(texto_buscar, filtro);
        
        ListIterator it = result.listIterator();
        ListIterator it1 = expResult.listIterator();
        while (it.hasNext()&&(it1.hasNext())){
            DatosCompletosMedProdVO medExpResult = (DatosCompletosMedProdVO)it1.next();
            DatosCompletosMedProdVO medResult = (DatosCompletosMedProdVO)it.next();            
            assertEquals(medExpResult.getIdProducto(), medResult.getIdProducto());            
            assertEquals(medExpResult.getDescripcion(), medResult.getDescripcion());  
            assertEquals(medExpResult.getPrecioCompra(), medResult.getPrecioCompra(),2);            
            assertEquals(medExpResult.getPrecioCompra(), medResult.getPrecioCompra(),2);          
            assertEquals(medExpResult.getPrecioLista(), medResult.getPrecioLista(),2);
            assertEquals(medExpResult.getHabilitado(), medResult.getHabilitado());        
            assertEquals(medExpResult.getCantidad(), medResult.getCantidad(),2);
            //assertEquals(medExpResult.getVencimientos(), medResult.getVencimientos());          
            assertEquals(medExpResult.getCodigos(), medResult.getCodigos());
            assertEquals(medExpResult.getTipoIVA(), medResult.getTipoIVA());
            assertEquals(medExpResult.getProveedor(), medResult.getProveedor());
            assertEquals(medExpResult.getReceta(), medResult.getReceta());
            assertEquals(medExpResult.getLaboratorio(), medResult.getLaboratorio());
            assertEquals(medExpResult.getDrogas(), medResult.getDrogas());
            assertEquals(medExpResult.getAccion(), medResult.getAccion());
            assertEquals(medExpResult.getPresentacion(), medResult.getPresentacion());
        }
    }
    
}
