/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Stock;

import SAF.VO.Stock.DatosCompletosMedicamentoVO;
import SAF.VO.Stock.DatosCompletosProductoVO;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author majo
 */
@Repository
public class BuscarProductoDAOTest {
    
    private BuscarProductoDAO buscarDao;
    private ApplicationContext context;
    
    public BuscarProductoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        context = new FileSystemXmlApplicationContext("file:web/WEB-INF/dispatcher-servlet.xml");
        buscarDao = (BuscarProductoDAO)context.getBean(BuscarProductoDAO.class);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of obtenerDatosCompletosMedicamento method, of class BuscarProductoDAO.
     */
    @Test
    public void testObtenerDatosCompletosMedicamento() {
        System.out.println("obtenerDatosCompletosMedicamento");
        String sql = "select distinct p.idProducto, m.requiereReceta, l.nombre as 'laboratorio' , d.nombre as 'droga', act.descripcion as 'accionter', pr.descripcion as 'presentacion'\n" +
                 "from producto p, medicamento m, laboratorio l, droga d, accionterapeutica act, presentacion pr\n" +
                 "where (exists (select * from medicamento m, producto p where m.idProducto=p.idProducto))\n" +
                 " and (m.idProducto = p.idProducto and m.idLaboratorio = l.idLaboratorio)\n" +
                 " and (exists (select * from drogamedicamento dm where dm.idProducto=m.idProducto and dm.idDroga=d.idDroga))\n" +
                 " and (exists (select * from accionterapeuticamedicamento atm where m.idProducto=atm.idProducto and atm.idAccionTerapeutica=act.idAccionTerapeutica))\n"+
                 "and (pr.idPresentacion=m.idPresentacion)";

        Map <Integer, DatosCompletosMedicamentoVO> medicamentos = new HashMap<Integer,DatosCompletosMedicamentoVO>();
                
	List<Map<String, Object>> rows = buscarDao.getJdbcTemplate().queryForList(sql);        
	for (Map row : rows) {
            int idProducto=(int)row.get("idProducto");
            if (medicamentos.get(idProducto)==null){
                DatosCompletosMedicamentoVO medCompleto = new DatosCompletosMedicamentoVO();
                medCompleto.setIdProducto((int)row.get("idProducto"));
                medCompleto.setAccionTerapeutica((String)row.get("accionter"));
                medCompleto.setNombreDroga((String)row.get("droga"));
                medCompleto.setNombreLaboratorio((String)row.get("laboratorio"));
                medCompleto.setRequiereReceta((boolean)row.get("requiereReceta"));
                medCompleto.setPresentacion((String)row.get("presentacion"));
                medicamentos.put((int)row.get("idProducto"),medCompleto);
            }else{
                DatosCompletosMedicamentoVO m=medicamentos.get(idProducto);
                m.setNombreDroga((String)row.get("droga"));
                m.setAccionTerapeutica((String)row.get("accionter"));
                medicamentos.put(idProducto, m);
            }           
        }
        
        Map<Integer, DatosCompletosMedicamentoVO> expResult = medicamentos;
        Map<Integer, DatosCompletosMedicamentoVO> result = buscarDao.obtenerDatosCompletosMedicamento();
        
        Iterator iter = (Iterator) expResult.keySet().iterator();
        Iterator iter1 = (Iterator) result.keySet().iterator();
        while (iter.hasNext() && iter1.hasNext()){
            DatosCompletosMedicamentoVO med = (DatosCompletosMedicamentoVO)expResult.get(iter.next());
            DatosCompletosMedicamentoVO med1 = (DatosCompletosMedicamentoVO)result.get(iter1.next());
            assertEquals(med.getAccionTerapeutica(), med1.getAccionTerapeutica());
            assertEquals(med.getIdProducto(), med1.getIdProducto());
            assertEquals(med.getNombreDroga(), med1.getNombreDroga());
            assertEquals(med.getNombreLaboratorio(), med1.getNombreLaboratorio());
            assertEquals(med.getPresentacion(), med1.getPresentacion());
        }
        
    }

    /**
     * Test of obtenerDatosCompletosProducto method, of class BuscarProductoDAO.
     */
    @Test
    public void testObtenerDatosCompletosProducto() throws Exception {
        System.out.println("obtenerDatosCompletosProducto");
        String sql ="select distinct p.idProducto, p.descripcion, p.precioCompra, p.precioVenta, p.habilitado,\n" +
                        "c.codigo, s.cantidad, v.fecha, pv.nombre as 'proveedor', t.descripcion as 'tipoiva', o.porcentBonif as 'porcentajeDescuento', o.descripcion as 'descDescuento'\n" +
                    "from producto p,proveedor pv, codigoproducto c, stock s, tipoiva t, vencimientostock v, ofertadescuento o\n" +
                    "where (exists (select * from productoproveedor pp where p.idProducto=pp.idProducto and pv.idProveedor=pp.idProveedor)) \n" +
                        "and (p.idProducto=s.idProducto)\n" +
                        "and (c.idProducto = p.idProducto)\n" +
                        "and (p.idTipoIVA=t.idTipoIVA)\n" +
                        "and (v.idProducto=p.idProducto)\n" +
                        "and (exists (select * from ofertadescuentoproducto odp where p.idProducto=odp.idProducto and o.idOfertaDescuento=odp.idOfertaDescuento))\n" +
                    "order by p.idProducto;";

        Map <Integer,DatosCompletosProductoVO> productos = new HashMap<Integer,DatosCompletosProductoVO>();
        
	List<Map<String, Object>> rows = buscarDao.getJdbcTemplate().queryForList(sql);        
	for (Map row : rows) {
            int idProducto=(int)row.get("idProducto");
            if (productos.get(idProducto)==null){
                DatosCompletosProductoVO prodCompleto = new DatosCompletosProductoVO();
                prodCompleto.setIdProducto((int)row.get("idProducto"));
                prodCompleto.setCantidadStock((int)row.get("cantidad"));
                prodCompleto.setCodigoBarras((String)row.get("codigo"));
                prodCompleto.setDescripcion((String)row.get("descripcion"));
                prodCompleto.setHabilitado((boolean)row.get("habilitado"));
                BigDecimal bd = (BigDecimal)row.get("precioCompra");
                prodCompleto.setPrecioCompra(bd.doubleValue());
                bd = (BigDecimal)row.get("precioVenta");
                prodCompleto.setPrecioVenta(bd.doubleValue());
                prodCompleto.setProveedor((String)row.get("proveedor"));
                prodCompleto.setTipoIVA((String)row.get("tipoiva"));
                prodCompleto.setVencimientoStock((Date)row.get("fecha"));
                String descripcionDescuento= (String)row.get("descDescuento");
                prodCompleto.setDescripcionDescuento(descripcionDescuento);
                bd= (BigDecimal)row.get("porcentajeDescuento");
                prodCompleto.setDescuentos(bd.doubleValue());                
                productos.put(idProducto,prodCompleto);
            }else{
                DatosCompletosProductoVO p1 = productos.get(idProducto);
                String codigo =(String)row.get("codigo");
                if (!p1.getCodigoBarras().contains(codigo))
                    p1.setCodigoBarras(codigo);
                Date d = (Date)row.get("fecha");
                if (!p1.getVencimientoStock().contains(d))
                    p1.setVencimientoStock(d);
                String descripcionDescuento= (String)row.get("descDescuento");
                if (!p1.getDescripcionDescuento().contains(descripcionDescuento))
                    p1.setDescripcionDescuento(descripcionDescuento);
                BigDecimal bd= (BigDecimal)row.get("porcentajeDescuento");
                if (!p1.getDescuentos().contains(bd.doubleValue()))
                    p1.setDescuentos(bd.doubleValue());        
                productos.put(idProducto, p1);                
            }
        }
        
        Map<Integer, DatosCompletosProductoVO> expResult = productos;
        Map<Integer, DatosCompletosProductoVO> result = buscarDao.obtenerDatosCompletosProducto();
        
        Iterator iter = (Iterator) expResult.keySet().iterator();
        Iterator iter1 = (Iterator) result.keySet().iterator();
        while (iter.hasNext() && iter1.hasNext()){
            DatosCompletosProductoVO prod = (DatosCompletosProductoVO)expResult.get(iter.next());
            DatosCompletosProductoVO prod1 = (DatosCompletosProductoVO)result.get(iter1.next());
            assertEquals(prod.getCantidadStock(),prod1.getCantidadStock());
            assertEquals(prod.getCodigoBarras(),prod1.getCodigoBarras());
            assertEquals(prod.getDescripcion(),prod1.getDescripcion());
            assertEquals(prod.getDescripcionDescuento(),prod1.getDescripcionDescuento());
            assertEquals(prod.getDescuentos(),prod1.getDescuentos());
            assertEquals(prod.getIdProducto(),prod1.getIdProducto());
            assertEquals(prod.getPrecioCompra(),prod1.getPrecioCompra(),2);
            assertEquals(prod.getPrecioVenta(),prod1.getPrecioVenta(),2);
            assertEquals(prod.getProveedor(),prod1.getProveedor());
            assertEquals(prod.getTipoIVA(),prod1.getTipoIVA());
            assertEquals(prod.getVencimientoStock(),prod1.getVencimientoStock());
        }
    }
    
}
