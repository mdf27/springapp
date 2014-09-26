/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Facade.Facturacion;

import SAF.Logica.Facturacion.FacturacionManager;
import SAF.VO.Facturacion.FacturaVO;
import SAF.VO.Facturacion.TipoFormaPagoVO;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fernanda
 */
@Service
public class FacadeFacturacion {
    @Autowired
    FacturacionManager facturacionManager;
    
    public void registrarFactura(FacturaVO fvo){
        
        facturacionManager.ingresarFactura(fvo);
    }
    
    public Map<Short,TipoFormaPagoVO> obtenerFormasDePago(){
    
        return facturacionManager.consultarFormasDePago();
        
    }
}
