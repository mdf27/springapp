/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Stock;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Stock.ProductoVO;
import SAF.VO.Stock.StockVO;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author majo
 */
public class BuscarProductoDAO extends AbstractDAO{
    
    public List<ProductoVO> obtenerProductosBusqueda() {
        String sql = "select p.idProducto, p.descripcion, p.precioCompra, p.precioVenta, p.habilitado\n" +
                     "from producto p\n";   

        List<ProductoVO> productos = new ArrayList<ProductoVO>();
      
	List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
	for (Map row : rows) {
		ProductoVO producto = new ProductoVO();
		producto.setDescripcion((String)(row.get("descripcion")));
		producto.setPrecioCompra((DecimalFormat)row.get("precioCompra"));
		producto.setPrecioVenta((DecimalFormat)row.get("precioVenta"));
                producto.setHabilitado((boolean)row.get("habilitado"));
		productos.add(producto);
	}
        return productos;
	
    }
    
    public List<StockVO> obtenerStockBusqueda() {
        String sql = "select p.idProducto, s.cantidad\n" +
                     "from producto p, stock s\n" +
                     "where p.idProducto=s.idProducto"; 

        List<StockVO> stock = new ArrayList<StockVO>();
        
	List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);        
	for (Map row : rows) {
            StockVO sk = new StockVO();
            sk.setIdProducto((int)row.get("idProducto"));
            sk.setCantidad((int)row.get("cantidad"));
            stock.add(sk);
        }
        return stock;
    }        
}    

