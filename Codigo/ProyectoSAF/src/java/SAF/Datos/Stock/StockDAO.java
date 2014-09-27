/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.Datos.Stock;

import SAF.Datos.Abstract.AbstractDAO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fernanda
 */
@Repository
public class StockDAO extends AbstractDAO {

    public void actualizarCantidadStock(int idProducto, int cantidad) {

        //Genero sentencia SQL
        String sql = "UPDATE Stock set cantidad = ? where idProducto = ?";

        Object[] parametros = new Object[] {cantidad,idProducto};
        this.getJdbcTemplate().update(sql, parametros);
    }
    
    public int getCantidadStock(int idProducto) {

        //Genero sentencia SQL
        String sql = "SELECT cantidad FROM Stock where idProducto = ?" ;

        return (int)getJdbcTemplate().queryForObject(
			sql, new Object[] { idProducto }, Integer.class);
    }
}
