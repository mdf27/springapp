/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Facturacion;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Facturacion.EnvioFacturaVO;
import SAF.VO.Facturacion.FormaPagoFacturaVO;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fernanda
 */
@Repository
public class EnvioFacturaDAO extends AbstractDAO {

    public void insertarEnvioFactura(EnvioFacturaVO envioFactura) {

        //Genero sentencia SQL
        //fernanda--> el idUsuarioDelivery deberia ser idUsuario;
        String sql = "INSERT INTO (idFactura, idUsuarioDelivery , Direccion, Telefono, Observaciones) EnvioFactura VALUES(? ,?, ?, ?, ?)";

        Object[] parametros ={envioFactura.getIdFactura(), 
            envioFactura.getIdUsuarioDelivery(), envioFactura.getDireccion(), envioFactura.getTelefono(), 
            envioFactura.getObservaciones()};
        
        this.getJdbcTemplate().update(sql, parametros);
    }
    
    public EnvioFacturaVO getEnvioFactura(int idTipoFormaPago, int idFactura,short idTipoFactura){
        
         String sql = "select envio.idFactura, envio.idUsuarioDelivery, envio.Direccion,envio.Telefono, envio.Observaciones "
                 + "where envio.idFactura = ?";

        Object[] params = {idFactura};
        
        List<Map<String, Object>> resultQuery = getJdbcTemplate().queryForList(sql, params);

        EnvioFacturaVO resultado = null;

        if (resultQuery.size() == 1) {
            for (Map map : resultQuery) {

                resultado = new EnvioFacturaVO(map);
            }

        }

        return resultado;
    }
}
