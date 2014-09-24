/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.Datos.Stock;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Stock.DataInfoProductoVO;
import SAF.VO.Stock.ProductoVO;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manu
 */

@Repository
public class ProductoDAO extends AbstractDAO {
    public void actualizarProductosDUSA(List<DataInfoProductoVO> productos) {
        String sql;
        int idTipoIva;
        int idProd;
        long idTransaccion;
        Iterator it = productos.iterator();
        DataInfoProductoVO prod;
        while(it.hasNext()){
            prod = (DataInfoProductoVO) it.next();
            idProd = prod.getNumeroArticulo();
            sql = "SELECT ti.idTipoIva FROM Producto p, tipoiva ti WHERE p.idProducto = ? AND "
                    + "ti.descripcion = ? AND p.idTipoIva = ti.idTipoIva";
            Object[] params = new Object[] { idProd, prod.getTipoIVA() };
            try {
                idTipoIva = (int)getJdbcTemplate().queryForObject(sql, params, Integer.class);
            } catch (Exception e) {
                idTipoIva = -1;                       
            }
            // ya existia => solo actualizo precio
            if (idTipoIva != -1) {
                sql = "UPDATE Producto SET precioCompra =" + prod.getPrecioVenta() +", precioVenta =" 
                        + prod.getPrecioPublico() +" WHERE idProducto = " + idProd 
                        + " AND idTipoIva = " + idTipoIva;
                this.getJdbcTemplate().update(sql);
            } else { // no existia producto entonces debo agregarlo
                sql = "SELECT idTipoIva FROM tipoiva WHERE descripcion = ?";
                idTipoIva = (int)getJdbcTemplate().queryForObject(
			sql, new Object[] { prod.getTipoIVA() }, Integer.class); 
                sql = "INSERT INTO producto (idProducto, idTipoIVA, descripcion, precioCompra, "
                        + "precioVenta, habilitado)  VALUES (?,?,?,?,?,?)";
                //idTransaccion = super.getLastID();
                Object[] parametros = new Object[]{idProd, idTipoIva, prod.getDescripcion(), 
                        prod.getPrecioVenta(), prod.getPrecioPublico(), prod.getHabilitado()};
                this.getJdbcTemplate().update(sql, parametros);
            }
        }
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

