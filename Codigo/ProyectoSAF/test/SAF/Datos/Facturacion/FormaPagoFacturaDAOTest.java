/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.Datos.Facturacion;

import SAF.VO.Facturacion.FormaPagoFacturaVO;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Fernanda
 */
public class FormaPagoFacturaDAOTest {
    
      
    /**
     *
     */
    
        
    private FormaPagoFacturaDAO formaPago;    
    private ApplicationContext context;
    
    
    /**
     * Test of validarUsuario method, of class LoginDAO.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext("file:web/WEB-INF/dispatcher-servlet.xml");
        formaPago = (FormaPagoFacturaDAO) context.getBean(FormaPagoFacturaDAO.class);
    
    }
    @Test
    public void testInsertarFormaPagoFactura() {
        FormaPagoFacturaVO pago = new FormaPagoFacturaVO();
        //pago.setIdCuenta(null);
        int idFactura = 15;
        short idTipoFactura = (short)102;
        pago.setIdFactura(idFactura);
        pago.setIdTipoFactura(idTipoFactura);
        pago.setIdTipoFormaPago((short)1);
        pago.setNroTarjeta(1051455);
        formaPago.insertarFormaPagoFactura(pago);
        
        FormaPagoFacturaVO pagoObtenido = formaPago.getFormaPagoFactura(idFactura, idTipoFactura);
        
        assertEquals(pagoObtenido.getIdFactura(), pago.getIdFactura());
        assertEquals(pagoObtenido.getIdCuenta(), pago.getIdCuenta());
        assertEquals(pagoObtenido.getIdTipoFactura(),pago.getIdTipoFactura());
        assertEquals(pagoObtenido.getIdTipoFormaPago(),pago.getIdTipoFormaPago());
        assertEquals(pagoObtenido.getIdTransaccion(),pago.getIdTransaccion());
        assertEquals(pagoObtenido.getNroTarjeta(),pago.getNroTarjeta());
        
    }
    
}
