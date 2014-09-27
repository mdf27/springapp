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
import java.util.List;
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
    public boolean compararRenglones(List<RenglonFacturaVO> renglones1, List<RenglonFacturaVO> renglones2){
       
        boolean result = renglones1.size() == renglones2.size();
        
        for (int i = 0; i < renglones1.size() && result; i++){
            
            result = result && compararRenglonFacturaVO(renglones1.get(i), renglones2.get(i));
        }
        
        return result;
    }
    
    public boolean compararRenglonFacturaVO(RenglonFacturaVO f1,RenglonFacturaVO f2){
        boolean result = f1.getIdFactura() == f2.getIdFactura() && f1.getIdTipoFactura() == f2.getIdTipoFactura();
        result = result && f1.getCantidad() == f2.getCantidad() && f1.getDescCantBonif() == f2.getDescCantBonif();
        result = result && f1.getDescDescripcion().equals(f2.getDescDescripcion())&& f1.getIdTransaccion() == f2.getIdTransaccion();
        result = result && f1.getDescPorcentBonif()== f2.getDescPorcentBonif();
        result = result && f1.getIdProducto()== f2.getIdProducto();
       // result = result && f1.getIdRenglonFactura()== f2.getIdRenglonFactura(); //el idrenglonfactura es ai, mal!
        result = result && f1.getPrecioProducto()== f2.getPrecioProducto();
        result = result && f1.getPrecioVtaReal()== f2.getPrecioVtaReal();
        return result;
    }
    
    public boolean compararFacturaVO(FacturaVO f1, FacturaVO f2){
        boolean result = f1.getIdFactura() == f2.getIdFactura() && f1.getIdTipoFactura() == f2.getIdTipoFactura();
        result = result && f1.getIdCliente() == f2.getIdCliente();
        result = result && f1.getDescuento() == f2.getDescuento() && f1.getIdTransaccion() == f2.getIdTransaccion();
        result = result && f1.getMontoNetoGravIva() == f2.getMontoNetoGravIva();
        result = result && f1.getMontoNetoGravIvaMin() == f2.getMontoNetoGravIvaMin();
        result = result && f1.getMontoNetoTotal() == f2.getMontoTotal();
        result = result && f1.getMontoTotal() == f2.getMontoTotal();
        result = result && f1.getMontoTotalAPagar()== f2.getMontoTotalAPagar();
        result = result && f1.getRUT().equals(f2.getRUT()) && f1.getRazonSocial().equals(f2.getRazonSocial());
        result = result && compararRenglones(f1.getRenglones(),f2.getRenglones());
        
        return result;
    }
    
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
        renglon1.setIdProducto(100001);
        renglon1.setIdTipoFactura((short) 102);
        renglon1.setPrecioProducto(10.01);
        renglon1.setPrecioVtaReal(10.01);

        ArrayList<RenglonFacturaVO> renglones = new ArrayList<RenglonFacturaVO>();
        renglones.add(renglon1);

        FacturaVO fvo = new FacturaVO();
        fvo.setDescuento(10.01);
        fvo.setFecha(new Timestamp(new Date().getTime()));
        fvo.setIdCliente(1);
        fvo.setIdTipoFactura((short) 102);
        fvo.setMontoNetoGravIva(10.01);
        fvo.setMontoNetoGravIvaMin(10.01);
        fvo.setMontoNetoTotal(10.01);
        fvo.setMontoTotal(10.01);
        fvo.setMontoTotalAPagar(10.01);
        fvo.setRUT("rut");
        fvo.setRazonSocial("razo social");
        fvo.setRenglones(renglones);
        int idFactura = instance.ingresarFactura(fvo);
        fvo.setIdFactura(idFactura);
        FacturaVO fvo2= instance.obtenerFactura(idFactura, (short)102);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(compararFacturaVO(fvo,fvo2));
    }

}
