/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.Logica.Facturacion;

import SAF.Datos.Facturacion.FacturaDAO;
import SAF.Datos.Facturacion.RenglonFacturaDAO;
import SAF.Datos.Facturacion.TipoFacturaDAO;
import SAF.Logica.Abstract.AbstractManejador;
import java.text.DecimalFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fernanda
 */
public class FacturacionManager extends AbstractManejador{
    
    @Autowired
    private FacturaDAO facturaDAO;
    private RenglonFacturaDAO renglonFacturaDAO;
    private TipoFacturaDAO tipoFacturaDAO;
    
    @Transactional(rollbackFor = Exception.class)
    public void ingresarFactura(short idTipoFactura, int idFactura, int idCliente, String RUT, String razonSocial, Date fecha, DecimalFormat descuento, DecimalFormat montoNetoTotal, DecimalFormat montoNetoGravIva,
            DecimalFormat montoNetoGravIvaMin, DecimalFormat montoTotal, DecimalFormat montoTotalAPagar, DecimalFormat idTransaccion){
        
        facturaDAO.insertarFactura (idTipoFactura, idFactura, idCliente, RUT, razonSocial, fecha, descuento, montoNetoTotal, montoNetoGravIva,
            montoNetoGravIvaMin, montoTotal, montoTotalAPagar, idTransaccion);
        
        
    
    }
}
