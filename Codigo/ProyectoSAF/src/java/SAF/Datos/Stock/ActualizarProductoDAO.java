package SAF.Datos.Stock;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Stock.DataInfoProductoVO;
import SAF.VO.Stock.DatosCompletosProductoVO;
import SAF.VO.Stock.ProductoVO;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
            // ver como funcionan los precios!  no es asi
            precioCompraNuevo = prodDUSA.getPrecioVenta();
            precioVentaNuevo = prodDUSA.getPrecioPublico();
            // Investigar como funciona el habilitado! no es asi
            habilitadoNuevo = (prodDUSA.getHabilitado() == 1);  
            tipoIva = prodDUSA.getTipoIVA();
            
            // busco si existe el producto y obtengo el idTipoIVA
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
            
            // si existia el producto le actualizo los datos
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
            
            // si no existia producto entonces debo agregarlo
            } else { 
                sql = "SELECT idTipoIva FROM tipoiva WHERE descripcion = ?";
                idTipoIva = (int)getJdbcTemplate().queryForObject(
			sql, new Object[] { prodDUSA.getTipoIVA() }, Integer.class); 
                
                // agrego a producto               
                agregarProducto(idProd,idTipoIva,descripcion,
                        precioCompraNuevo,precioVentaNuevo,habilitadoNuevo);
                
                // agrego a codigoProducto
                String codBarra = prodDUSA.getCodigoBarra();
                agregarCodigoProducto(idProd, codBarra);
                
                agregarProductoProveedor ( idProd);
                productosAgregados.add(getProducto(idProd));
            }   
        }
        Map<String,List<ProductoVO>> productosActualizados = new HashMap<>();
        productosActualizados.put("agregados", productosAgregados);
        productosActualizados.put("aumentaron", productosAumentaron);
        productosActualizados.put("disminuyeron", productosDisminuyeron);
        productosActualizados.put("habilitaron", productosHabilitados);
        productosActualizados.put("deshabilitaron", productosDeshabilitados);
        return productosActualizados;
    }
    
    public void agregarProducto (int idProd, int idTipoIva, String descripcion, 
            BigDecimal precioCompraNuevo, BigDecimal precioVentaNuevo, boolean habilitadoNuevo){
        String sql = "INSERT INTO producto (idProducto, idTipoIVA, descripcion, precioCompra, "
                + "precioVenta, habilitado)  VALUES (?,?,?,?,?,?)";
        //idTransaccion = super.getLastID();
        Object[] parametros = new Object[]{idProd, idTipoIva, descripcion, 
                precioCompraNuevo, precioVentaNuevo, habilitadoNuevo};
        this.getJdbcTemplate().update(sql, parametros);
    } 
    
    public void agregarCodigoProducto (int idProd, String codBarra){
        String sql = "INSERT INTO CodigoProducto (idProducto, codigo)  VALUES (?,?)";
        //idTransaccion = super.getLastID();
        Object[] parametros = new Object[]{idProd, codBarra};
        this.getJdbcTemplate().update(sql, parametros);
    }
    
     public void agregarProductoProveedor (int idProd){
        String sql = "SELECT idProveedor FROM Proveedor WHERE nombre = \"DUSA\" ";
        int idProveedor=(int)this.getJdbcTemplate().queryForObject(sql, Integer.class);
        sql = "INSERT INTO ProductoProveedor (idProducto, idProveedor)  VALUES (?,?)";
        //idTransaccion = super.getLastID();
        Object[] parametros = new Object[]{idProd,idProveedor};
        this.getJdbcTemplate().update(sql, parametros);
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
    
    // funcion copiada de Majo
     public Map <Integer,DatosCompletosProductoVO> obtenerDatosCompletosProducto() throws ParseException{ //ver
        String sql ="select distinct p.idProducto, p.descripcion, p.precioCompra, p.precioVenta, p.habilitado,\n" +
                        "c.codigo, s.cantidad, v.fecha, pv.nombre as 'proveedor', t.descripcion as 'tipoiva', o.porcentBonif as 'porcentajeDescuento', o.descripcion as 'descDescuento'\n" +
                    "from producto p,proveedor pv, codigoproducto c, stock s, tipoiva t, vencimientostock v, ofertadescuento o\n" +
                    "where (exists (select * from productoproveedor pp where p.idProducto=pp.idProducto and pv.idProveedor=pp.idProveedor)) -- existe proveedor\n" +
                    "and (p.idProducto=s.idProducto) -- stock\n" +
                    "and (c.idProducto = p.idProducto) -- obtengo codigo de barras\n" +
                    "and (p.idTipoIVA=t.idTipoIVA)\n" +
                    "and (v.idProducto=p.idProducto)\n" +
                    "and (o.idProducto=p.idProducto)\n" +
                    "and p.idProducto = ?;";

        Map <Integer,DatosCompletosProductoVO> productos = new HashMap<Integer,DatosCompletosProductoVO>();
        
	List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);        
	for (Map row : rows) {
            int idProducto=(int)row.get("idProducto");
            if (productos.get(idProducto)==null){
                DatosCompletosProductoVO prodCompleto = new DatosCompletosProductoVO();
                prodCompleto.setIdProducto((int)row.get("idProducto"));
                prodCompleto.setCantidadStock((int)row.get("cantidad"));
                prodCompleto.setCodigoBarras((String)row.get("codigo"));
                prodCompleto.setDescripcion((String)row.get("descripcion"));
                prodCompleto.setHabilitado((boolean)row.get("habilitado"));
                BigDecimal bd = (BigDecimal)row.get("precioCompra");
                prodCompleto.setPrecioCompra(bd.doubleValue());
                bd = (BigDecimal)row.get("precioVenta");
                prodCompleto.setPrecioVenta(bd.doubleValue());
                prodCompleto.setProveedor((String)row.get("proveedor"));
                prodCompleto.setTipoIVA((String)row.get("tipoiva"));
                prodCompleto.setVencimientoStock((Date)row.get("fecha"));
                String descripcionDescuento= (String)row.get("descDescuento");
                prodCompleto.setDescripcionDescuento(descripcionDescuento);
                bd= (BigDecimal)row.get("porcentajeDescuento");
                prodCompleto.setDescuentos(bd.doubleValue());                
                productos.put(idProducto,prodCompleto);
            }else{
                DatosCompletosProductoVO p1 = productos.get(idProducto);
                String codigo =(String)row.get("codigo");
                if (!p1.getCodigoBarras().contains(codigo))
                    p1.setCodigoBarras(codigo);
                Date d = (Date)row.get("fecha");
                if (!p1.getVencimientoStock().contains(d))
                    p1.setVencimientoStock(d);
                String descripcionDescuento= (String)row.get("descDescuento");
                if (!p1.getDescripcionDescuento().contains(descripcionDescuento))
                    p1.setDescripcionDescuento(descripcionDescuento);
                BigDecimal bd= (BigDecimal)row.get("porcentajeDescuento");
                if (!p1.getDescuentos().contains(bd.doubleValue()))
                    p1.setDescuentos(bd.doubleValue());        
                productos.put(idProducto, p1);                
            }
        }
        return productos;
    }    
}

