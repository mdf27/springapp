/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Facturacion;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Facturacion.FacturaVO;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fernanda
 */
@Repository
public class FacturaDAO extends AbstractDAO {

    public void insertarFactura(FacturaVO factura) {

        //Genero sentencia SQL
        String sql = "INSERT INTO Factura (idTipoFactura,  idCliente, RUT, razonSocial, fecha, descuento, montoNetoTotal, montoNetoGralIva,"
                + " montoNetoGralIvaMin, montoTotal, montoTotalAPagar, idTransaccion) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Object[] parametros = new Object[]{factura.getIdTipoFactura(), factura.getIdCliente(), factura.getRUT(), factura.getRazonSocial(), factura.getFecha(), factura.getDescuento(), factura.getMontoNetoTotal(), factura.getMontoNetoGravIva(), factura.getMontoNetoGravIvaMin(), factura.getMontoTotal(),
            factura.getMontoTotalAPagar(), factura.getIdTransaccion()};

        getJdbcTemplate().update(sql, parametros);
    }

    public FacturaVO getFactura(int idFactura, short idTipoFactura) {

        //Genero sentencia SQL
        String sql = "SELECT * from Factura where idFactura = ? AND idTipoFactura= ?";

        Object[] params = {idFactura, idTipoFactura};

        List<Map<String, Object>> resultQuery = getJdbcTemplate().queryForList(sql, params);

        FacturaVO resultado = null;

        if (resultQuery.size() == 1) {
            for (Map map : resultQuery) {

                resultado = new FacturaVO(map);
            }

        }

        return resultado;
    }

}
