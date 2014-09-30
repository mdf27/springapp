package SAF.Datos.Facturacion;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Facturacion.TipoFormaPagoVO;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


@Repository
public class TipoFormaPagoDAO extends AbstractDAO {
    
    public List<TipoFormaPagoVO> obtenerTiposFormaPago() {
        
        String sql = "select tfp.idTipoFormaPago, tfp.nombre from tipoFormaPago tfp";
        List<Map<String, Object>> filasConsulta = getJdbcTemplate().queryForList(sql);
        
        List <TipoFormaPagoVO> formasDePago = new LinkedList<TipoFormaPagoVO>();
        for(Map fila: filasConsulta){
            TipoFormaPagoVO formaPago = new TipoFormaPagoVO();
            formaPago.setIdTipoFormaPago(((Integer)fila.get("idTipoFormaPago")).shortValue());
            formaPago.setNombre((String)fila.get("nombre"));
            formasDePago.add(formaPago);
            
        }
        
        return formasDePago;
    };
    
}
