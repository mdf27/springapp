/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Facturacion;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Facturacion.FacturaVO;
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
public class RenglonFacturaDAO extends AbstractDAO {

    public void insertarRenglonFactura(RenglonFacturaVO renglon) {

        //Genero sentencia SQL
        String sql = "INSERT INTO RenglonFactura (idTipoFactura, idFactura,idProducto,cantidad,conReceta,"
                + "precioProducto,precioVentaReal, descDescripcion, descCantBonif, descPorcentBonif,descMontoBonif)"
                + "VALUES(? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Object[] parametros ={renglon.getIdTipoFactura(), 
            renglon.getIdFactura(), renglon.getIdProducto(), renglon.getCantidad(), renglon.isConReceta(),
            renglon.getPrecioProducto(), renglon.getPrecioVtaReal(), renglon.getDescDescripcion(), 
            renglon.getDescCantBonif(), renglon.getDescPorcentBonif(), renglon.getDescMontoBonif()};
        
        this.getJdbcTemplate().update(sql, parametros);
    }
    
    public List<RenglonFacturaVO> getRenglonesDeFactura(int idFactura,short idTipoFactura){
        
         String sql = "SELECT * FROM renglonfactura where idFactura = ? AND idTipoFactura = ?";

        Object[] params = {idFactura, idTipoFactura};
        
        List<Map<String, Object>> resultQuery = getJdbcTemplate().queryForList(sql, params);

        List<RenglonFacturaVO> resultado = null;

        if (resultQuery.size() >0) {
            resultado = new ArrayList<>();
            for (Map map : resultQuery) {

                resultado.add( new RenglonFacturaVO(map));
            }

        }

        return resultado;
    }
}
