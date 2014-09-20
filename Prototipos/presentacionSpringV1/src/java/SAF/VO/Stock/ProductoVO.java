/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.VO.Stock;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author majo
 */
public class ProductoVO {
    String descripcion;
    DecimalFormat precioCompra;
    DecimalFormat precioVenta;
    int idTipoIva;
    boolean habilitado;
    BigInteger idTransaccion;

    public ProductoVO() {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        precioCompra = new DecimalFormat("#####.##",simbolos);
        precioVenta = new DecimalFormat("#####.##",simbolos);        
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public DecimalFormat getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(DecimalFormat precioCompra) {
        this.precioCompra = precioCompra;
    }

    public DecimalFormat getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(DecimalFormat precioVenta) {
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
