/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.Logica.Facturacion;

import SAF.Datos.Facturacion.FacturaDAO;
import SAF.Datos.Facturacion.FormaPagoFacturaDAO;
import SAF.Datos.Facturacion.RenglonFacturaDAO;
import SAF.Datos.Facturacion.TipoFormaPagoDAO;
import SAF.Logica.Abstract.AbstractManejador;
import SAF.Logica.Stock.ModificarStockManager;
import SAF.VO.Facturacion.FacturaVO;
import SAF.VO.Facturacion.FormaPagoFacturaVO;
import SAF.VO.Facturacion.IdFacturaVO;
import SAF.VO.Facturacion.RenglonFacturaVO;
import SAF.VO.Facturacion.TipoFormaPagoVO;import java.util.List;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fernanda
 */
@Service
public class FacturacionManager extends AbstractManejador{
    
    @Autowired
    private FacturaDAO facturaDAO;
    @Autowired
    private RenglonFacturaDAO renglonFacturaDAO;
    @Autowired
    private FormaPagoFacturaDAO formaPagoFactura;
    @Autowired
    private TipoFormaPagoDAO tipoFormaPago;
     @Autowired
    private ModificarStockManager modifStock;
     @Autowired
     private FormaPagoFacturaDAO formaPago;
    
    @Transactional(rollbackFor = Exception.class)
    public IdFacturaVO ingresarFactura(FacturaVO factura) throws Exception{
        
        IdFacturaVO idFactura = facturaDAO.insertarFactura(factura);
                
        FormaPagoFacturaVO pago = factura.getFormaDePago();
        pago.setNroFactura(idFactura.getNroFactura());
        pago.setNroSerie(idFactura.getNroSerie());
        formaPagoFactura.insertarFormaPagoFactura(pago);

        List<RenglonFacturaVO> renglones = factura.getRenglones();
        
        for(RenglonFacturaVO renglon : renglones){
            
            renglon.setNroFactura(idFactura.getNroFactura());
            renglon.setNroSerie(idFactura.getNroSerie());
            renglonFacturaDAO.insertarRenglonFactura(renglon);
            
            if(renglon.getIdTipoFactura() == 101) //resto stock
                modifStock.actualizarCantidadProducto(-renglon.getCantidad(), renglon.getIdProducto());
            else
                modifStock.actualizarCantidadProducto(renglon.getCantidad(), renglon.getIdProducto());
            
        }
        
        
 
        return idFactura;
    
    };
    
    public List<TipoFormaPagoVO> consultarFormasDePago(){
    
        return tipoFormaPago.obtenerTiposFormaPago();
        
    };
    
    public FacturaVO obtenerFactura(int idFactura, String nroSerie, short idTipoFactura){
        
        FacturaVO result = facturaDAO.getFactura(idFactura,nroSerie, idTipoFactura);
        List<RenglonFacturaVO> renglones = renglonFacturaDAO.getRenglonesDeFactura(idFactura,nroSerie,idTipoFactura);
        FormaPagoFacturaVO pago = formaPago.getFormaPagoFactura(idFactura,nroSerie, idTipoFactura);
        result.setFormaDePago(pago);
        result.setRenglones(renglones);
        return result;
    }
}
