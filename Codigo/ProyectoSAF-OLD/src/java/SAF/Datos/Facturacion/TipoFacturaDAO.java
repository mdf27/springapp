/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Facturacion;

import SAF.Datos.Abstract.AbstractDAO;
import java.text.DecimalFormat;
import java.util.Date;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fernanda
 */
@Repository
public class TipoFacturaDAO extends AbstractDAO {

    public void insertarTipoFactura(short idTipoFactura, String descripcion) {

        //Genero sentencia SQL
        String sql = "INSERT INTO TipoFactura VALUES(?,?)";

        //Genero lista de parametros
        Object[] parametros = new Object[]{idTipoFactura, descripcion};
        //Ejecuto sentencia con parametros
        this.getJdbcTemplate().update(sql, parametros);

    }
}
