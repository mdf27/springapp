/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Facturacion;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Facturacion.FacturaVO;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
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

        JdbcTemplate jdbc = this.getJdbcTemplate();
        
        jdbc.update(sql);
    }

    public ArrayList<FacturaVO> getFacturas(short idTipoFactura) {

        //Genero sentencia SQL
        String sql = "SELECT * FROM Factura WHERE idTipoFactura = " + idTipoFactura;

        ArrayList<FacturaVO> facturas = new ArrayList<FacturaVO>();

        List<Map<String, Object>> rows = this.getJdbcTemplate().queryForList(sql);

        for (Map row : rows) {
            FacturaVO factura = new FacturaVO();
            factura.setDescuento((DecimalFormat) (row.get("Descuento")));
            factura.setFecha((Date) row.get("Fecha"));
            factura.setIdCliente((Integer) row.get("IdCliente"));
            factura.setIdFactura((Integer) row.get("IdFactura"));
            factura.setIdTipoFactura((Short) row.get("idTipoFactura"));
            factura.setIdTransaccion((DecimalFormat) row.get("idTransaccion"));
            factura.setMontoNetoGravIva((DecimalFormat) row.get("MontoNetoGralIva"));
            factura.setMontoNetoGravIvaMin((DecimalFormat) row.get("MontoNetoGralIvaMin"));
            factura.setMontoNetoTotal((DecimalFormat) row.get("MontoNetoTotal"));
            factura.setMontoTotal((DecimalFormat) row.get("MontoNetoTotal"));
            factura.setMontoTotalAPagar((DecimalFormat) row.get("MontoTotalAPagar"));
            factura.setRUT((String) row.get("RUT"));
            factura.setRazonSocial((String) row.get("RazonSocial"));

            facturas.add(factura);
        }

        return facturas;

    }
}
