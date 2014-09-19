/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.Datos.Abstract;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Guillermo
 */
@Repository
public class TransaccionDAO extends AbstractDAO{

    @Transactional()
    public long getIDTransaccion(int idUsuario) {
        //Genero sentencia SQL
        String sql = "INSERT INTO Transaccion (idUsuario,fecha) VALUES = (?,CURRENT_DATE)";
        //Genero lista de parametros
        Object[] parametros = new Object[]{idUsuario};
        //Ejecuto sentencia con parametros
        this.getJdbcTemplate().update(sql, parametros);
        //Devuelvo id de transaccion creada
        return super.getLastID();
    }
    
}
