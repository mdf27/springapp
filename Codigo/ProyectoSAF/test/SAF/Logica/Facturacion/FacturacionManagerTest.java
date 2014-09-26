/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Logica.Facturacion;

import SAF.VO.Facturacion.FacturaVO;
import SAF.VO.Facturacion.RenglonFacturaVO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Fernanda
 */
public class FacturacionManagerTest {


    private static FacturacionManager instance;
    private static ApplicationContext context;

    public FacturacionManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        context = new FileSystemXmlApplicationContext("file:web/WEB-INF/dispatcher-servlet.xml");
        instance = (FacturacionManager) context.getBean(FacturacionManager.class);
    }

    /**
     * Test of ingresarFactura method, of class FacturacionManager.
     */
    @Test
    public void testIngresarFactura() {
        System.out.println("ingresarFactura");
        FacturaVO factura = null;
        //renglon 1

        RenglonFacturaVO renglon1 = new RenglonFacturaVO();
        renglon1.setCantidad(2);
        renglon1.setConReceta(false);
        renglon1.setDescCantBonif(12);
        renglon1.setDescDescripcion("10");
        renglon1.setDescPorcentBonif(1);
        renglon1.setIdProducto(1);
        renglon1.setIdTipoFactura((short) 101);
        renglon1.setPrecioProducto(10.01);
        renglon1.setPrecioVtaReal(10.01);

        ArrayList<RenglonFacturaVO> renglones = new ArrayList<RenglonFacturaVO>();
        renglones.add(renglon1);

        FacturaVO fvo = new FacturaVO();
        fvo.setDescuento(10.01);
        fvo.setFecha(new Timestamp(new Date().getTime()));
        fvo.setIdCliente(1);
        fvo.setIdTipoFactura((short) 101);
        fvo.setMontoNetoGravIva(10.01);
        fvo.setMontoNetoGravIvaMin(10.01);
        fvo.setMontoNetoTotal(10.01);
        fvo.setMontoTotal(10.01);
        fvo.setMontoTotalAPagar(10.01);
        fvo.setRUT("rut");
        fvo.setRazonSocial("razo social");
        fvo.setRenglones(renglones);
        instance.ingresarFactura(fvo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
