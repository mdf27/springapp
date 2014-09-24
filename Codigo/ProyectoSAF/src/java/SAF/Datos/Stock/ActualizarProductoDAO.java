package SAF.Datos.Stock;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Stock.DataInfoProductoVO;
import SAF.VO.Stock.ProductoVO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manu
 */

@Repository
public class ActualizarProductoDAO extends AbstractDAO {
    public List <ProductoVO> actualizarProductosDUSA(List<DataInfoProductoVO> productos) {
        // por ahora general, despues veo si tengo que dividir en los que se agregaron nuevos
        // o en de acuerdo a que cambio...
        List <ProductoVO> productosActualizados = new ArrayList<>();
        String sql;
        int idTipoIva;
        int idProd;
        String descripcion;
        BigDecimal precioCompra;
        BigDecimal precioVenta;
        boolean habilitado;
        //long idTransaccion;
        Iterator it = productos.iterator();
        DataInfoProductoVO prodDUSA;
        Object[] params;
        while(it.hasNext()){
            prodDUSA = (DataInfoProductoVO) it.next();
            idProd = prodDUSA.getNumeroArticulo();
            descripcion = prodDUSA.getDescripcion();
            precioCompra = prodDUSA.getPrecioVenta();
            precioVenta = prodDUSA.getPrecioPublico();
            habilitado = (prodDUSA.getHabilitado() == 1);
            sql = "SELECT ti.idTipoIva FROM Producto p, tipoiva ti WHERE p.idProducto = ? AND "
                    + "ti.descripcion = ? AND p.idTipoIva = ti.idTipoIva";
            params = new Object[] { idProd, prodDUSA.getTipoIVA() };
            try {
                idTipoIva = (int)getJdbcTemplate().queryForObject(sql, params, Integer.class);
            } catch (Exception e) {
                idTipoIva = -1;                       
            }
            // ya existia => solo actualizo precio
            if (idTipoIva != -1) {
                sql = "UPDATE Producto SET precioCompra =" + "?" +", precioVenta =" 
                        + "?" + ", descripcion =" + "?" +
                        ", habilitado = " + "?" + 
                        " WHERE idProducto = " + "?" 
                        + " AND idTipoIva = " + "?";
                params = new Object [] { precioCompra.doubleValue(), precioVenta.doubleValue(), 
                    descripcion, habilitado, idProd, idTipoIva};
                this.getJdbcTemplate().update(sql,params);
            } else { // no existia producto entonces debo agregarlo
                sql = "SELECT idTipoIva FROM tipoiva WHERE descripcion = ?";
                idTipoIva = (int)getJdbcTemplate().queryForObject(
			sql, new Object[] { prodDUSA.getTipoIVA() }, Integer.class); 
                sql = "INSERT INTO producto (idProducto, idTipoIVA, descripcion, precioCompra, "
                        + "precioVenta, habilitado)  VALUES (?,?,?,?,?,?)";
                //idTransaccion = super.getLastID();
                Object[] parametros = new Object[]{idProd, idTipoIva, descripcion, 
                        precioCompra, precioVenta, habilitado};
                this.getJdbcTemplate().update(sql, parametros);
            }
//            ProductoVO prod = new ProductoVO();
//            prod.setIdProducto(prodDUSA.getNumeroArticulo());
//            prod.setTipoIva(prodDUSA.getTipoIVA());
//            prod.setDescripcion(prodDUSA.getDescripcion());
//            prod.setPrecioCompra(prodDUSA.getPrecioVenta().doubleValue());
//            prod.setPrecioVenta(prodDUSA.getPrecioPublico().doubleValue());
//            prod.setHabilitado((prodDUSA.getHabilitado() == 1));
            
            productosActualizados.add(getProducto(idProd));
        }
        
        return productosActualizados;
    }
    
    public ProductoVO getProducto(int idProd){
        String sql = "SELECT * FROM Producto WHERE idProducto = ?";
        Object[] params = {idProd};
        List<Map<String, Object>> resultQuery = getJdbcTemplate().queryForList(sql, params);

        ProductoVO resultado = null;

        if (resultQuery.size() == 1) {
            for (Map map : resultQuery) {

                resultado = new ProductoVO(map);
            }

        }

        return resultado;
    }
}

