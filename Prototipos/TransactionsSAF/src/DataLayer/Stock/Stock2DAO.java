/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataLayer.Stock;

import DataLayer.AbstractDAO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Guillermo
 */
@Repository
public class Stock2DAO extends AbstractDAO{
    
    public void altaProveedor() {
        String sql = "INSERT INTO proveedores VALUES (?,?)";

        Object[] parametros = new Object[]{1, "DUSA"};

        this.getJdbcTemplate().update(sql, parametros);
    }    
}
