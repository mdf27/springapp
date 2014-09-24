/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.VO.Stock;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author majo
 */
public class DatosCompletosProductoVO {
    private int idProducto;
    private String descripcion;
    private double precioCompra;
    private double precioVenta;
    private boolean habilitado;
    private int cantidad;
    private List<Date> vencimientos;
    private List<String> codigos;
    
    private String tipoIVA;
    private String proveedor;

    public DatosCompletosProductoVO() {
        vencimientos = new LinkedList<>();
        codigos= new LinkedList<>();
    }

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

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public int getCantidadStock() {
        return cantidad;
    }

    public void setCantidadStock(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<Date> getVencimientoStock() {
        return vencimientos;
    }

    public void setVencimientoStock(Date vencimientos) {
        this.vencimientos.add(vencimientos);
    }

    public List<String> getCodigoBarras() {
        return codigos;
    }

    public void setCodigoBarras(String codigos) {
        this.codigos.add(codigos);
    }

    public String getTipoIVA() {
        return tipoIVA;
    }

    public void setTipoIVA(String tipoIVA) {
        this.tipoIVA = tipoIVA;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    
}
