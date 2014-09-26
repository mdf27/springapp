package SAF.Datos.Facturacion;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Facturacion.TipoFormaPagoVO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


@Repository
public class TipoFormaPagoDAO extends AbstractDAO {
    
    public Map<Short,TipoFormaPagoVO> obtenerTiposFormaPago() {
        
        String sql = "select tfp.idTipoFormaPago, tfp.nombre from tipoFormaPago tfp";
        List<Map<String, Object>> filasConsulta = getJdbcTemplate().queryForList(sql);
        
        Map <Short, TipoFormaPagoVO> formasDePago = new HashMap<Short, TipoFormaPagoVO>();
        for(Map fila: filasConsulta){
            TipoFormaPagoVO formaPago = new TipoFormaPagoVO();
            formaPago.setIdTipoFormaPago((short)fila.get("idTipoFormaPago"));
            formaPago.setNombre((String)fila.get("nombre"));
            formasDePago.put((short)fila.get("idTipoFormaPago"), formaPago);
            
        }
        
        return formasDePago;
    };
    
}
