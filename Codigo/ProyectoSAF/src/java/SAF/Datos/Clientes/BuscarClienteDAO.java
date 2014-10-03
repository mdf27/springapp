/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Clientes;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Clientes.DatosCompletosClienteVO;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author majo
 */
@Repository
public class BuscarClienteDAO extends AbstractDAO {

    public Map<Integer, DatosCompletosClienteVO> obtenerClientes() {
        String sql = "SELECT c.idCliente, c.nombres, c.apellidos,"
                + " c.direccion, c.telefono, c.email, c.cedula, c.razon_social, "
                + "c.rut,c.descuento, c.fcreacion, cc.saldo, cc.tope, cc.fcreacion AS 'fcreacionCuenta'\n"
                + "FROM   cliente c\n"
                + "       LEFT OUTER JOIN cuentacliente cc\n"
                + "          ON c.idCliente = cc.idCliente;";

        Map<Integer, DatosCompletosClienteVO> clientes = new HashMap<>();

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            int idCliente = (int) row.get("idCliente");
            if (clientes.get(idCliente) == null) {
                DatosCompletosClienteVO cliente = new DatosCompletosClienteVO();
                cliente.setIdCliente(idCliente);
                cliente.setApellidos((String) row.get("apellidos"));
                cliente.setCedula((int) row.get("cedula"));
                BigDecimal bd = (BigDecimal) row.get("descuento");
                cliente.setDescuento(bd.doubleValue());
                cliente.setDireccion((String) row.get("direccion"));
                cliente.setEmail((String) row.get("email"));
                cliente.setNombres((String) row.get("nombres"));
                cliente.setRazonSocial((String) row.get("razon_social"));
                cliente.setRut((int) row.get("rut"));
                if (row.get("saldo") != null) {
                    cliente.setTieneCuenta(true);
                    bd = (BigDecimal) row.get("saldo");
                    cliente.setSaldo(bd.doubleValue());
                    if (row.get("fcreacionCuenta") != null) {
                        cliente.setfCreacionCuenta((Date) row.get("fcreacionCuenta"));
                    }
                    if (row.get("tope") != null) {
                        bd = (BigDecimal) row.get("tope");
                        cliente.setTope(bd.doubleValue());
                    }
                } else {
                    cliente.setTieneCuenta(false);
                }
                cliente.setTelefono((String) row.get("telefono"));
                cliente.setfCreacion((Date) row.get("fcreacion"));

                clientes.put(idCliente, cliente);
            } else {
                //cuando se agreguen mas datos
            }
        }
        return clientes;
    }

}
