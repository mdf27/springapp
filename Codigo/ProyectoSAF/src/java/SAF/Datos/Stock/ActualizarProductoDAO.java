package SAF.Datos.Stock;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Stock.DataInfoProductoVO;
import SAF.VO.Stock.ProductoVO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
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
    public Map <String, List<ProductoVO>> actualizarProductosDUSA(List<DataInfoProductoVO> productos) {
        // por ahora general, despues veo si tengo que dividir en los que se agregaron nuevos
        // o en de acuerdo a que cambio...
        List <ProductoVO> productosAgregados = new ArrayList<>();
        List <ProductoVO> productosAumentaron = new ArrayList<>();
        List <ProductoVO> productosDisminuyeron = new ArrayList<>();
        List <ProductoVO> productosHabilitados = new ArrayList<>();
        List <ProductoVO> productosDeshabilitados = new ArrayList<>();
        String sql;
        int idTipoIva = 0;
        int idProd;
        String descripcion;
        String tipoIva;
        BigDecimal precioCompraNuevo;
        BigDecimal precioVentaNuevo = null;
        BigDecimal precioVentaActual = null;
        boolean habilitadoNuevo = false;
        boolean habilitadoActual = false;
        boolean encontrado;
        //long idTransaccion;
        Iterator it = productos.iterator();
        DataInfoProductoVO prodDUSA;
        Object[] params;
        while(it.hasNext()){
            prodDUSA = (DataInfoProductoVO) it.next();
            idProd = prodDUSA.getNumeroArticulo();
            descripcion = prodDUSA.getDescripcion();
            precioCompraNuevo = prodDUSA.getPrecioVenta();
            precioVentaNuevo = prodDUSA.getPrecioPublico();
            habilitadoNuevo = (prodDUSA.getHabilitado() == 1);  
            tipoIva = prodDUSA.getTipoIVA();
            sql = "SELECT p.precioVenta, p.habilitado, p.idTipoIva FROM Producto p, tipoiva ti  "
                    + "WHERE p.idProducto = ? AND ti.descripcion = ? AND p.idTipoIva = ti.idTipoIva";
            params = new Object[] {idProd, tipoIva};
            try {
                Map<String, Object> resultQuery = getJdbcTemplate().queryForMap(sql, params);
                precioVentaActual = (BigDecimal) resultQuery.get("precioVenta");
                habilitadoActual = (boolean) resultQuery.get("habilitado");
                idTipoIva = (int) resultQuery.get("idTipoIva");
                encontrado = true;
            } catch (Exception e) {
                encontrado = false;                      
            }            
            
            if (encontrado) {
                sql = "UPDATE Producto SET precioCompra =" + "?" +", precioVenta =" 
                        + "?" + ", descripcion =" + "?" +
                        ", habilitado = " + "?" + 
                        " WHERE idProducto = " + "?" 
                        + " AND idTipoIva = " + "?";
                params = new Object [] { precioCompraNuevo.doubleValue(), precioVentaNuevo.doubleValue(), 
                    descripcion, habilitadoNuevo, idProd, idTipoIva};
                this.getJdbcTemplate().update(sql,params);
                // si precioNuevo < precioActual lo agrego a la lista de aumentaron
                if (precioVentaNuevo.compareTo(precioVentaActual) < 0) 
                    productosDisminuyeron.add(getProducto(idProd));
                // si precioNuevo > precioActual lo agrego a la lista de aumentaron
                if (precioVentaNuevo.compareTo(precioVentaActual) > 0) 
                    productosAumentaron.add(getProducto(idProd));
                if (habilitadoActual != habilitadoNuevo)
                    if (habilitadoNuevo)
                        productosHabilitados.add(getProducto(idProd));
                    else
                        productosDeshabilitados.add(getProducto(idProd));
                
            } else { // no existia producto entonces debo agregarlo
                sql = "SELECT idTipoIva FROM tipoiva WHERE descripcion = ?";
                idTipoIva = (int)getJdbcTemplate().queryForObject(
			sql, new Object[] { prodDUSA.getTipoIVA() }, Integer.class); 
                sql = "INSERT INTO producto (idProducto, idTipoIVA, descripcion, precioCompra, "
                        + "precioVenta, habilitado)  VALUES (?,?,?,?,?,?)";
                //idTransaccion = super.getLastID();
                Object[] parametros = new Object[]{idProd, idTipoIva, descripcion, 
                        precioCompraNuevo, precioVentaNuevo, habilitadoNuevo};
                this.getJdbcTemplate().update(sql, parametros);
                
                productosAgregados.add(getProducto(idProd));
            }
//            ProductoVO prod = new ProductoVO();
//            prod.setIdProducto(prodDUSA.getNumeroArticulo());
//            prod.setTipoIva(prodDUSA.getTipoIVA());
//            prod.setDescripcion(prodDUSA.getDescripcion());
//            prod.setPrecioCompra(prodDUSA.getPrecioVenta().doubleValue());
//            prod.setPrecioVenta(prodDUSA.getPrecioPublico().doubleValue());
//            prod.setHabilitado((prodDUSA.getHabilitado() == 1));
            
            
        }
        Map<String,List<ProductoVO>> productosActualizados = new HashMap<>();
        productosActualizados.put("agregados", productosAgregados);
        productosActualizados.put("aumentaron", productosAumentaron);
        productosActualizados.put("disminuyeron", productosDisminuyeron);
        productosActualizados.put("habilitaron", productosHabilitados);
        productosActualizados.put("deshabilitaron", productosDeshabilitados);
        return productosActualizados;
    }
    
    public ProductoVO getProducto(int idProd){
        String sql = "SELECT * FROM Producto WHERE idProducto = ?";
        Object[] params = {idProd};
        List<Map<String, Object>> resultQuery = getJdbcTemplate().queryForList(sql, params);

        ProductoVO resultado = null;

        if (resultQuery.size() == 1) {
            for (Map query : resultQuery) {

                resultado = new ProductoVO();
                resultado.setDescripcion((String) query.get("descripcion"));
                resultado.setHabilitado((boolean) query.get("habilitado"));
                resultado.setIdProducto((int) query.get("idProducto"));
                resultado.setIdTipoIva((int) query.get("idTipoIVA"));
                resultado.setPrecioCompra(((BigDecimal) query.get("precioCompra")).doubleValue());
                resultado.setPrecioVenta(((BigDecimal) query.get("precioVenta")).doubleValue());
            }

        }

        return resultado;
    }
}

