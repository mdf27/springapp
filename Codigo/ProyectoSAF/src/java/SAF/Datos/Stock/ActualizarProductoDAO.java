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
import uy.com.dusa.ws.DataInfoProducto;
import uy.com.dusa.ws.DataLaboratorio;

/**
 *
 * @author Manu
 */

@Repository
public class ActualizarProductoDAO extends AbstractDAO {
    public Map <String, List<ProductoVO>> actualizarProductosDUSA(List<DataInfoProducto> productos, 
        List<DataLaboratorio> laboratorios) {
        List <ProductoVO> productosAgregados = new ArrayList<>();
        List <ProductoVO> productosAumentaron = new ArrayList<>();
        List <ProductoVO> productosDisminuyeron = new ArrayList<>();
        List <ProductoVO> productosHabilitados = new ArrayList<>();
        List <ProductoVO> productosDeshabilitados = new ArrayList<>();
        String sql;
        int idTipoIva;
        int idProd;
        String descripcion;
        BigDecimal precioCompraNuevo;
        BigDecimal precioVentaNuevo = null;
        BigDecimal precioVentaActual = null;
        boolean habilitadoNuevo = false;
        boolean habilitadoActual = false;
        boolean encontrado;
        //long idTransaccion;
        Iterator it = productos.iterator();
        DataInfoProducto prodDUSA;
        Object[] params;
        while(it.hasNext()){
            prodDUSA = (DataInfoProducto) it.next();
            idProd = prodDUSA.getNumeroArticulo();
            descripcion = prodDUSA.getDescripcion();
            // ver como funcionan los precios!  no es asi
            precioCompraNuevo = prodDUSA.getPrecioVenta();
            precioVentaNuevo = prodDUSA.getPrecioPublico();
            // Investigar como funciona el habilitado! no es asi
            habilitadoNuevo = (prodDUSA.getHabilitado() == 1);  
            idTipoIva = Integer.parseInt(prodDUSA.getTipoIVA());
            
            // busco si existe el producto y obtengo el idTipoIVA
            sql = "SELECT precioVenta, habilitado FROM Producto WHERE idProducto = ?";
            params = new Object[] {idProd};
            try {
                Map<String, Object> resultQuery = getJdbcTemplate().queryForMap(sql, params);
                precioVentaActual = (BigDecimal) resultQuery.get("precioVenta");
                habilitadoActual = (boolean) resultQuery.get("habilitado");
                encontrado = true;
            } catch (Exception e) {
                encontrado = false;                      
            }            
            
            // si existia el producto le actualizo los datos
            if (encontrado) {
                sql = "UPDATE Producto SET precioCompra =" + "?" +", precioVenta =" 
                        + "?" + ", descripcion =" + "?" +
                        ", habilitado = " + "?" + 
                        ", idTipoIva = " + "?" + 
                        " WHERE idProducto = " + "?";
                params = new Object [] { precioCompraNuevo.doubleValue(), precioVentaNuevo.doubleValue(), 
                    descripcion, habilitadoNuevo, idTipoIva, idProd};
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
//                sql = "SELECT idTipoIva FROM tipoiva WHERE descripcion = ?";
//                String iva;
//                if (prodDUSA.getTipoIVA().length() < 10) {
//                    iva = prodDUSA.getTipoIVA();
//                } else {
//                    iva = prodDUSA.getTipoIVA().substring(0,10);
//                }
//                idTipoIva = (int)getJdbcTemplate().queryForObject(
//			sql, new Object[] { iva }, Integer.class); 
//              
                agregarLaboratorio(prodDUSA.getIdLaboratorio(),laboratorios);
                
                // agrego a producto               
                agregarProducto(idProd,idTipoIva,descripcion,
                        precioCompraNuevo,precioVentaNuevo,habilitadoNuevo);
                
                // agrego a codigoProducto
                String codBarra = prodDUSA.getCodigoBarra();
                agregarCodigoProducto(idProd, codBarra);
                
                // aregar productoProveedor
                agregarProductoProveedor ( idProd);
                
                agregarLaboratorio(prodDUSA.getIdLaboratorio(),laboratorios);
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
     
    
     public void agregarLaboratorio (String idLab, List<DataLaboratorio> laboratorios){
         boolean encontrado=false;
         
         // busco si existe el Laboratorio - como es todo en una misma transacción 
         // no encuentra que ya esta y lo agrega  todas las veces que apareza el nuevo
         // al ppio deberiamos ya tener cargados todos los laboratorios
         // que nos da DUSA en su lista.  
         String sql = "SELECT idLaboratorio FROM Laboratorio"
                    + " WHERE nombre = ?";
        
        
        Iterator it = laboratorios.iterator();
        encontrado=false;
        DataLaboratorio dl = null;
        while(it.hasNext() && !encontrado){
            dl=(DataLaboratorio)it.next();
            if(dl.getIdLaboratorio().equals(idLab))
                encontrado=true;
        }
        Object [] params = new Object[] {dl.getNombre()};  
        try{
            int id = (int) this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
            encontrado=true;
        } catch (Exception e) {
            encontrado = false;                      
        }  
        
        if(!encontrado){
          sql = "INSERT INTO Laboratorio (nombre, direccion, departamento, "
                  + "localidad,telefono)  VALUES (?,?,?,?,?)";
        //idTransaccion = super.getLastID();
         String telefono = "";
         if (!dl.getTelefonos().isEmpty())
             telefono = dl.getTelefonos().get(0);
         // We take only first phone number 
        Object[] parametros = new Object[]{dl.getNombre(), dl.getDireccion(), dl.getDepartamento(),
        dl.getLocalidad(), telefono};
        this.getJdbcTemplate().update(sql, parametros);   
        }
        
       
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

