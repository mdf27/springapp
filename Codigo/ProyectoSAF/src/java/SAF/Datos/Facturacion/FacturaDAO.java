/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Facturacion;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Facturacion.FacturaVO;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fernanda
 */
@Repository
public class FacturaDAO extends AbstractDAO {

    @Transactional(rollbackFor = Exception.class)
    public int insertarFactura(FacturaVO factura) {

        //Genero sentencia SQL
        String sql = "INSERT INTO Factura (idTipoFactura,  idCliente, RUT, razonSocial, fecha, descuento, montoNetoTotal, montoNetoGralIva,"
                + " montoNetoGralIvaMin, montoTotal, montoTotalAPagar) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        if (factura.getIdCliente() != -1) {
            Object[] parametros = new Object[]{factura.getIdTipoFactura(), factura.getIdCliente(), factura.getRUT(), factura.getRazonSocial(), factura.getFecha(), factura.getDescuento(), factura.getMontoNetoTotal(), factura.getMontoNetoGravIva(), factura.getMontoNetoGravIvaMin(), factura.getMontoTotal(),
                factura.getMontoTotalAPagar()};

            getJdbcTemplate().update(sql, parametros);
        } else {
            Object[] parametros = new Object[]{factura.getIdTipoFactura(), null, factura.getRUT(), factura.getRazonSocial(), factura.getFecha(), factura.getDescuento(), factura.getMontoNetoTotal(), factura.getMontoNetoGravIva(), factura.getMontoNetoGravIvaMin(), factura.getMontoTotal(),
                factura.getMontoTotalAPagar()};

            getJdbcTemplate().update(sql, parametros);
        }
        return super.getLastID().intValue();

    }
    
        /*@Transactional(rollbackFor = Exception.class)
    public int insertarFactura(FacturaVO factura) {

        String sql1 = "SELECT MAX(idFactura) FROM Factura where idTipoFactura = ?";
        Object[] parametros = {factura.getIdTipoFactura()};

        int max = getJdbcTemplate().queryForObject(sql1, parametros, int.class);

        //Genero sentencia SQL
        String sql = "INSERT INTO Factura (idFactura, idTipoFactura,  idCliente, RUT, razonSocial, fecha, descuento, montoNetoTotal, montoNetoGralIva,"
                + " montoNetoGralIvaMin, montoTotal, montoTotalAPagar) VALUES(? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            if (factura.getIdCliente() != -1) {
                parametros = new Object[]{max, factura.getIdTipoFactura(), factura.getIdCliente(), factura.getRUT(), factura.getRazonSocial(), factura.getFecha(), factura.getDescuento(), factura.getMontoNetoTotal(), factura.getMontoNetoGravIva(), factura.getMontoNetoGravIvaMin(), factura.getMontoTotal(),
                    factura.getMontoTotalAPagar()};

                getJdbcTemplate().update(sql, parametros);
            } else {
                parametros = new Object[]{factura.getIdTipoFactura(), null, factura.getRUT(), factura.getRazonSocial(), factura.getFecha(), factura.getDescuento(), factura.getMontoNetoTotal(), factura.getMontoNetoGravIva(), factura.getMontoNetoGravIvaMin(), factura.getMontoTotal(),
                    factura.getMontoTotalAPagar()};

                getJdbcTemplate().update(sql, parametros);

            }
        } catch (DuplicateKeyException e) {
            max = insertarFactura(factura);
            
        }
        return max;

    }*/

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
