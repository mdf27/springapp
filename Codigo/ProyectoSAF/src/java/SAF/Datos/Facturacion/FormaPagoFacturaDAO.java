/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Facturacion;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Facturacion.FacturaVO;
import SAF.VO.Facturacion.FormaPagoFacturaVO;
import SAF.VO.Facturacion.RenglonFacturaVO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fernanda
 */
@Repository
public class FormaPagoFacturaDAO extends AbstractDAO {

    public void insertarFormaPagoFactura(FormaPagoFacturaVO formaPago) {

        //Genero sentencia SQL
        String sql = "INSERT INTO FormaPagoFactura (idFactura, idTipoFactura,idTipoFormaPago,nroTarjeta,idCuenta) VALUES(? ,?, ?, ?, ?)";
        
        
        if (formaPago.getIdCuenta() != -1){
            Object[] parametros ={formaPago.getIdFactura(), 
            formaPago.getIdTipoFactura(), formaPago.getIdTipoFormaPago(), formaPago.getNroTarjeta(), 
            formaPago.getIdCuenta()};
            
            this.getJdbcTemplate().update(sql, parametros);
        }else{
            Object[] parametros ={formaPago.getIdFactura(), 
            formaPago.getIdTipoFactura(), formaPago.getIdTipoFormaPago(), formaPago.getNroTarjeta(), 
            null};
            
            this.getJdbcTemplate().update(sql, parametros);
        }
            
        
    }
    
    public FormaPagoFacturaVO getFormaPagoFactura(int idFactura,short idTipoFactura){
        
         String sql = "select fpf.idFactura, fpf.idTipoFactura, fpf.idTipoFormaPago, fpf.nroTarjeta,"
                 + "fpf.idCuenta, fpf.idTransaccion from FormaPagoFactura fpf where fpf.idFactura = ? "
                 + "and fpf.idTipoFactura = ?";

        Object[] params = {idFactura, idTipoFactura};
        
        List<Map<String, Object>> resultQuery = getJdbcTemplate().queryForList(sql, params);

        FormaPagoFacturaVO resultado = null;

        if (resultQuery.size() == 1) {
            for (Map map : resultQuery) {

                resultado = new FormaPagoFacturaVO(map);
            }

        }

        return resultado;
    }
}
