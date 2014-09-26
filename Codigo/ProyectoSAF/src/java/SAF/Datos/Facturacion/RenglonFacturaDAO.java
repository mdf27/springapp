/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Facturacion;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Facturacion.RenglonFacturaVO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fernanda
 */
@Repository
public class RenglonFacturaDAO extends AbstractDAO {

    public void insertarRenglonFactura(RenglonFacturaVO renglon) {

        //Genero sentencia SQL
        String sql = "INSERT INTO RenglonFactura VALUES(? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Object[] parametros ={renglon.getIdTipoFactura(), renglon.getIdFactura(), renglon.getIdProducto(), 
            renglon.getPrecioProducto(), renglon.getPrecioVtaReal(), renglon.getDescDescripcion(), 
            renglon.getDescCantBonif(), renglon.getDescPorcentBonif(), renglon.getDescMontoBonif(),
            renglon.getIdTransaccion()};
        
        this.getJdbcTemplate().update(sql, parametros);
    }
}
