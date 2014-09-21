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
public class FacturaDAO extends AbstractDAO {

    public void insertarFactura(short idTipoFactura, int idCliente, String RUT, String razonSocial, Date fecha, DecimalFormat descuento, DecimalFormat montoNetoTotal, DecimalFormat montoNetoGravIva,
            DecimalFormat montoNetoGravIvaMin, DecimalFormat montoTotal, DecimalFormat montoTotalAPagar, DecimalFormat idTransaccion) {

        //Genero sentencia SQL
        String sql = "INSERT INTO Factura (idTipoFactura,  idCliente, RUT, razonSocial, fecha, descuento, montoNetoTotal, montoNetoGravIva,"
                + " montoNetoGravIvaMin, montoTotal, montoTotalAPagar, idTransaccion) VALUES = (" + idTipoFactura + "," + idCliente + "," + RUT + "," + razonSocial + ","
                + fecha + "," + descuento + "," + montoNetoTotal + "," + montoNetoGravIva + "," + montoNetoGravIvaMin + "," + montoTotal + ","
                + montoTotalAPagar + "," + idTransaccion + ")";

        this.getJdbcTemplate().update(sql);
    }
}
