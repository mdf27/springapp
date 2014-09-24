/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.VO.Stock;

import java.math.BigInteger;

/**
 *
 * @author majo
 */
public class ProductoVO {
    public String descripcion;
    public double precioCompra;
    public double precioVenta;
    public int idTipoIva;
    public boolean habilitado;
    public BigInteger idTransaccion;

    public ProductoVO() {
     
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

    public BigInteger getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(BigInteger idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
    
    
    
    
}
