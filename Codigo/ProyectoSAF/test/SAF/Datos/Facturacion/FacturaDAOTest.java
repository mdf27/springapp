/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.Datos.Facturacion;

import java.text.DecimalFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
        String RUT = "";
        String razonSocial = "";
        Date fecha = new Date();
        DecimalFormat descuento =  null;
        DecimalFormat montoNetoTotal = null;
        DecimalFormat montoNetoGravIva = null;
        DecimalFormat montoNetoGravIvaMin = null;
        DecimalFormat montoTotal = null;
        DecimalFormat montoTotalAPagar = null;
        DecimalFormat idTransaccion = null;
        FacturaDAO instance = new FacturaDAO();
        instance.insertarFactura(idTipoFactura, idCliente, RUT, razonSocial, fecha, descuento, montoNetoTotal, montoNetoGravIva, montoNetoGravIvaMin, montoTotal, montoTotalAPagar, idTransaccion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
