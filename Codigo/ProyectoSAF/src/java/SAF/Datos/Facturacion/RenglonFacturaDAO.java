/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Facturacion;

import SAF.Datos.Abstract.AbstractDAO;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Date;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fernanda
 */
@Repository
public class RenglonFacturaDAO extends AbstractDAO {

    public void insertarRenglonFactura(short idTipoFactura, int idFactura, int idProducto, DecimalFormat precioProducto,
            DecimalFormat precioVtaReal, String descDescripcion, int descCantBonif, DecimalFormat descPorcentBonif, DecimalFormat descMontoBonif, BigInteger idTransaccion) {

        //Genero sentencia SQL
        String sql = "INSERT INTO RenglonFactura VALUES = (" + idTipoFactura + "," + idFactura + "," + idProducto + "," + precioProducto + ","
                + precioVtaReal + "," + descDescripcion + "," + descCantBonif + "," + descPorcentBonif + "," + descMontoBonif + "," + idTransaccion + ")";

        this.getJdbcTemplate().update(sql);
    }
}
