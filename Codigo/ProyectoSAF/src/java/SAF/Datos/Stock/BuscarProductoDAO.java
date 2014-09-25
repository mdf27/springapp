/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Stock;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Stock.DatosCompletosMedicamentoVO;
import SAF.VO.Stock.DatosCompletosProductoVO;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author majo
 */
@Repository
public class BuscarProductoDAO extends AbstractDAO{
    
    public Map <Integer, DatosCompletosMedicamentoVO> obtenerDatosCompletosMedicamento(){ //ver
        String sql = "select distinct p.idProducto, m.requiereReceta, l.nombre as 'laboratorio' , d.nombre as 'droga', act.descripcion as 'accionter', pr.descripcion as 'presentacion'\n" +
                 "from producto p, medicamento m, laboratorio l, droga d, accionterapeutica act, presentacion pr\n" +
                 "where (exists (select * from medicamento m, producto p where m.idProducto=p.idProducto))\n" +
                 " and (m.idProducto = p.idProducto and m.idLaboratorio = l.idLaboratorio)\n" +
                 " and (exists (select * from drogamedicamento dm where dm.idProducto=m.idProducto and dm.idDroga=d.idDroga))\n" +
                 " and (exists (select * from accionterapeuticamedicamento atm where m.idProducto=atm.idProducto and atm.idAccionTerapeutica=act.idAccionTerapeutica))";

        Map <Integer, DatosCompletosMedicamentoVO> medicamentos = new HashMap<Integer,DatosCompletosMedicamentoVO>();
                
	List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);        
	for (Map row : rows) {
            int idProducto=(int)row.get("idProducto");
            if (medicamentos.get(idProducto)==null){
                DatosCompletosMedicamentoVO medCompleto = new DatosCompletosMedicamentoVO();
                medCompleto.setIdProducto((int)row.get("idProducto"));
                medCompleto.setAccionTerapeutica((String)row.get("accionter"));
                medCompleto.setNombreDroga((String)row.get("droga"));
                medCompleto.setNombreLaboratorio((String)row.get("laboratorio"));
                medCompleto.setRequiereReceta((boolean)row.get("requiereReceta"));
                medCompleto.setPresentacion((String)row.get("presentacion"));
                medicamentos.put((int)row.get("idProducto"),medCompleto);
            }else{
                DatosCompletosMedicamentoVO m=medicamentos.get(idProducto);
                m.setNombreDroga((String)row.get("droga"));
                m.setAccionTerapeutica((String)row.get("accionter"));
                medicamentos.put(idProducto, m);
            }           
        }
        return medicamentos;
    }
    
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
                    "order by p.idProducto;";

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

