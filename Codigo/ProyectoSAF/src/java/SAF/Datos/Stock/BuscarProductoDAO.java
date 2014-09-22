/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Stock;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Stock.LaboratorioVO;
import SAF.VO.Stock.MedicamentoVO;
import SAF.VO.Stock.ProductoVO;
import SAF.VO.Stock.ProveedorVO;
import SAF.VO.Stock.StockVO;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author majo
 */
@Repository
public class BuscarProductoDAO extends AbstractDAO{
    
    public List<ProductoVO> obtenerProductosBusqueda() {
        String sql = "select p.idProducto, p.descripcion, p.precioCompra, p.precioVenta, p.habilitado\n" +
                     "from producto p\n";   

        /*DecimalFormat formateador = new DecimalFormat("#####.##");        
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        DecimalFormat precioCompraD = new DecimalFormat("#####.##",simbolos);        
        DecimalFormat precioVentaD = new DecimalFormat("#####.##",simbolos);*/
                
        List<ProductoVO> productos = new ArrayList<>();
        
	List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
	for (Map row : rows) {
		ProductoVO producto = new ProductoVO();
		producto.setDescripcion((String)(row.get("descripcion")));
                
                BigDecimal bd = (BigDecimal)row.get("precioCompra");
		producto.setPrecioCompra(bd.doubleValue());
                
                bd = (BigDecimal)row.get("precioVenta");         
		producto.setPrecioVenta(bd.doubleValue());
                
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
        //return getJdbcTemplate().query(sql,new StockRowMapper());
    }        
    
    public List<LaboratorioVO> obtenerLaboratorios() {
        String sql = "select p.idProducto, l.nombre, l.idLaboratorio\n" +
                     "from producto p, laboratorio l, medicamento m\n" +
                     "where m.idProducto=p.idProducto and m.idLaboratorio=l.idLaboratorio"; 

        List<LaboratorioVO> laboratorios = new ArrayList<LaboratorioVO>();
        
	List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);        
	for (Map row : rows) {
            LaboratorioVO lab = new LaboratorioVO();
            lab.setNombre((String)row.get("nombre"));
            lab.setIdLaboratorio((int)row.get("idLaboratorio"));
            laboratorios.add(lab);
        }
        return laboratorios;
    }        
    
    public List<MedicamentoVO> obtenerMedicamentos(){
        String sql = "select p.idProducto, l.idLaboratorio, m.requiereReceta\n" +
                     "from producto p, laboratorio l, medicamento m\n" +
                     "where m.idProducto=p.idProducto and m.idLaboratorio=l.idLaboratorio"; 

        List<MedicamentoVO> medicamentos = new ArrayList<MedicamentoVO>();
        
	List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);        
	for (Map row : rows) {
            MedicamentoVO m = new MedicamentoVO();
            m.setIdProducto((int)row.get("idProducto"));
            m.setIdLaboratorio((int)row.get("idLaboratorio"));
            m.setRequiereReceta((boolean)row.get("requireReceta"));
            medicamentos.add(m);
        }
        return medicamentos;
    }
    
    public List<ProveedorVO> obtenerProveedores(){ //ver
        String sql = "select p.idProducto, prov.nombre\n" +
                     "from producto p, proveedor prov\n" +
                     "where exists (select * from productoproveedor pv where p.idProducto=pv.idProducto and prov.idProveedor=pv.idProveedor)"; 

        List<ProveedorVO> proveedores = new ArrayList<ProveedorVO>();
        
	List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);        
	for (Map row : rows) {
            ProveedorVO p = new ProveedorVO();
            p.setNombre((String)row.get("nombre"));
            proveedores.add(p);
        }
        return proveedores;
    }
}    

