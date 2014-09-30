/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Stock;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Stock.StockVO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author majo
 */
@Repository
public class AjustarStockDAO extends AbstractDAO{
    public void ajustarCantidadStock (StockVO stock){
        String sql = "UPDATE stock set cantidad=?, idTransaccion=? where idProducto=?";
        Object[] parametros = new Object[]{stock.getCantidad(),stock.getIdTransaccion(),stock.getIdProducto()};
        getJdbcTemplate().update(sql, parametros);            
    }
    
}
