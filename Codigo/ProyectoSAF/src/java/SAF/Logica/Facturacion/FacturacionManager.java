/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.Logica.Facturacion;

import SAF.Datos.Facturacion.FacturaDAO;
import SAF.Datos.Facturacion.RenglonFacturaDAO;
import SAF.Datos.Facturacion.TipoFacturaDAO;
import SAF.Datos.Facturacion.TipoFormaPagoDAO;
import SAF.Logica.Abstract.AbstractManejador;
import SAF.VO.Facturacion.FacturaVO;
import SAF.VO.Facturacion.RenglonFacturaVO;
import SAF.VO.Facturacion.TipoFormaPagoVO;import java.util.List;import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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
    private TipoFacturaDAO tipoFacturaDAO;
    @Autowired
    private TipoFormaPagoDAO tipoFormaPago;
    
    @Transactional(rollbackFor = Exception.class)
    public int ingresarFactura(FacturaVO factura){
        
        int idFactura = facturaDAO.insertarFactura(factura);
        

        List<RenglonFacturaVO> renglones = factura.getRenglones();
        
        for(RenglonFacturaVO renglon : renglones){
            
            renglon.setIdFactura(idFactura);
            renglonFacturaDAO.insertarRenglonFactura(renglon);
        }
 
        return idFactura;
    
    };
    
    public Map<Short,TipoFormaPagoVO> consultarFormasDePago(){
    
        return tipoFormaPago.obtenerTiposFormaPago();
        
    };
    
    public FacturaVO obtenerFactura(int idFactura, short idTipoFactura){
        
        FacturaVO result = facturaDAO.getFactura(idFactura, idTipoFactura);
        List<RenglonFacturaVO> renglones = renglonFacturaDAO.getRenglonesDeFactura(idFactura,idTipoFactura);
        result.setRenglones(renglones);
        return result;
    }
}
