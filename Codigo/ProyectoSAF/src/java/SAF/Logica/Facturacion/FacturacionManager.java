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
import SAF.VO.Facturacion.FacturaVO;
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
    public void ingresarFactura(FacturaVO factura){
        
        facturaDAO.insertarFactura(factura);
        
        
    
    }
}
