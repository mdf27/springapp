/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Facturacion;

import SAF.VO.Facturacion.FacturaVO;
import java.sql.Timestamp;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Fernanda
 */
public class FacturaDAOTest {


    private FacturaDAO instance;
    private ApplicationContext context;

   
    @Before
    public void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext("file:web/WEB-INF/dispatcher-servlet.xml");
        instance = (FacturaDAO) context.getBean(FacturaDAO.class);

    }

    @Test
    public void testInsertarFactura() {
        System.out.println("insertarFactura");
        short idTipoFactura = 102;
        int idCliente = 2;
        String RUT = "RUT";
        String razonSocial = "RAZON SOCIAL";
        
        
        Timestamp fecha = new java.sql.Timestamp(new java.util.Date().getTime());
        
        double descuento = 20.01;
        double montoNetoTotal = 20.01;
        double montoNetoGravIva = 20.01;
        double montoNetoGravIvaMin = 20.01;
        double montoTotal = 20.01;
        double montoTotalAPagar = 20.01;
        double idTransaccion = 20.01;
        instance.insertarFactura(idTipoFactura, idCliente, RUT, razonSocial, fecha, descuento, montoNetoTotal, montoNetoGravIva, montoNetoGravIvaMin, montoTotal, montoTotalAPagar, idTransaccion);
        // TODO review the generated test code and remove the default call to fail.
        

        FacturaVO fvo = null;

        fvo = instance.getFactura(3, idTipoFactura);

        
        assertEquals(fvo.getRUT(),"RUT");
        
        
    }

}
