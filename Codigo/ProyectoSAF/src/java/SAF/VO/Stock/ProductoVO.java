/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.VO.Stock;

import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author majo
 */
public class ProductoVO {

    private int idProducto;
    private String descripcion;
    private double precioCompra;
    private double precioVenta;
    private int idTipoIva;
    private boolean habilitado;
    private long idTransaccion;

    // este se borra despues, es solo mientras no soluciono tema IVA
    private String tipoIva;
    ////////////////////////////////////////////////
    
    public ProductoVO() {
     
    }
    
//    public ProductoVO(Map<String,Object> query){
//
//        idProducto = (int) query.get("idProducto");
//        idTipoIva = (int) query.get("idTipoIVA");
//        descripcion = (String) query.get("descripcion");
//        precioCompra = ((BigDecimal) query.get("precioCompra")).doubleValue();
//        precioVenta = ((BigDecimal) query.get("precioVenta")).doubleValue();
//        habilitado = (boolean) query.get("habilitado");
//    }
    
    /// esto se borra despues //////////////////////
    
    public String getTipoIva() {
        return tipoIva;
    }

    public void setTipoIva(String tipoIva) {
        this.tipoIva = tipoIva;
    }

    //////////////////////////////////////////////
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getIdTipoIva() {
        return idTipoIva;
    }

    public void setIdTipoIva(int idTipoIva) {
        this.idTipoIva = idTipoIva;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public double getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
    
    
    
    
}
