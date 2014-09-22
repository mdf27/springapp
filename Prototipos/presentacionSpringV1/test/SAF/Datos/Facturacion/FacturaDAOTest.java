/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.Datos.Facturacion;

import SAF.VO.Facturacion.FacturaVO;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fernanda
 */
public class FacturaDAOTest {
    
    @Test
    public void testInsertarFactura() {
        System.out.println("insertarFactura");
        short idTipoFactura = 101;
        int idCliente = 0;
        String RUT = "rut";
        String razonSocial = "raxon social";
        Date fecha = new Date();
        DecimalFormat descuento =  new DecimalFormat("000,00");
        DecimalFormat montoNetoTotal = new DecimalFormat("100,00");
        DecimalFormat montoNetoGravIva = new DecimalFormat("50,00");
        DecimalFormat montoNetoGravIvaMin = new DecimalFormat("25,00");
        DecimalFormat montoTotal = new DecimalFormat("10,00");
        DecimalFormat montoTotalAPagar = new DecimalFormat("000,00");
        DecimalFormat idTransaccion = new DecimalFormat("000,00");
        FacturaDAO instance = new FacturaDAO();
        FacturaVO factura = new FacturaVO();
        factura.setDescuento(descuento);
        factura.setFecha(fecha);
        factura.setIdCliente(idCliente);
        factura.setIdFactura(1);
        factura.setIdTipoFactura(idTipoFactura);
        instance.insertarFactura(idTipoFactura, idCliente, RUT, razonSocial, fecha, descuento, montoNetoTotal, montoNetoGravIva, montoNetoGravIvaMin, montoTotal, montoTotalAPagar, idTransaccion);
        
        ArrayList<FacturaVO> facturas =instance.getFacturas((short)101);
        assertEquals(1,facturas.size());
        
        for (FacturaVO fac : facturas){
            
            assertEquals(fac,factura);
        }
        
        
        
        fail("The test case is a prototype.");
    }
    
}
