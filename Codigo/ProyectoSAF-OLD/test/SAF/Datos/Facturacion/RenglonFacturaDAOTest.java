/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.Datos.Facturacion;

import java.math.BigInteger;
import java.text.DecimalFormat;
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
public class RenglonFacturaDAOTest {
    
    public RenglonFacturaDAOTest() {
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
     * Test of insertarRenglonFactura method, of class RenglonFacturaDAO.
     */
    @Test
    public void testInsertarRenglonFactura() {
        System.out.println("insertarRenglonFactura");
        short idTipoFactura = 0;
        int idFactura = 0;
        int idProducto = 0;
        DecimalFormat precioProducto = null;
        DecimalFormat precioVtaReal = null;
        String descDescripcion = "";
        int descCantBonif = 0;
        DecimalFormat descPorcentBonif = null;
        DecimalFormat descMontoBonif = null;
        BigInteger idTransaccion = null;
        RenglonFacturaDAO instance = new RenglonFacturaDAO();
        instance.insertarRenglonFactura(idTipoFactura, idFactura, idProducto, precioProducto, precioVtaReal, descDescripcion, descCantBonif, descPorcentBonif, descMontoBonif, idTransaccion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
