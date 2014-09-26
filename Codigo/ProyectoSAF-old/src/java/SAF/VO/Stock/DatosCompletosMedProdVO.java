/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.VO.Stock;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author majo
 */
public class DatosCompletosMedProdVO {
    private int idProducto;
    private String descripcion;
    private double precioCompra;
    private double precioVenta;
    private double precioLista;
    private String habilitado;
    private int cantidad;
    private List<String> vencimientos;
    private List<String> codigos;
    private String tipoIVA;
    private String proveedor;
    private String receta;
    private String laboratorio;
    private List<String> drogas;
    private List<String> accion;
    private List<String> presentacion;
    private double descuentoReceta; 
    private double descuentoProducto;
    private double farmaDescuento; //precio lista + %receta
    private double costoReal;
    private List<String> descDescuento;

    public DatosCompletosMedProdVO() {
        vencimientos = new LinkedList<>();
        codigos = new LinkedList<>();
        drogas = new LinkedList<>();
        accion = new LinkedList<>();
        presentacion = new LinkedList<>();
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

    public String getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<String> getVencimientos() {
        return vencimientos;
    }

    public void setVencimientos(String vencimientoStock) {
        this.vencimientos.add(vencimientoStock);
    }

    public List<String> getCodigos() {
        return codigos;
    }

    public void setCodigos(String codigoBarras) {
        this.codigos.add(codigoBarras);
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

    public String getReceta() {
        return receta;
    }

    public void setReceta(String requiereReceta) {
        this.receta = requiereReceta;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String nombreLaboratorio) {
        this.laboratorio = nombreLaboratorio;
    }

    public List<String> getDrogas() {
        return drogas;
    }

    public void setDrogas(String nombreDroga) {
        this.drogas.add(nombreDroga);
    }

    public List<String> getAccion() {
        return accion;
    }

    public void setAccion(String accionTerapeutica) {
        this.accion.add(accionTerapeutica);
    }

    public List<String> getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion.add(presentacion);
    }

    public double getDescuentoReceta() {
        return descuentoReceta;
    }

    public void setDescuentoReceta(double descuento) {
        this.descuentoReceta = descuento;
    }

    public double getDescuentoProducto() {
        return descuentoProducto;
    }

    public void setDescuentoProducto(double descuentoProducto) {
        this.descuentoProducto = descuentoProducto;
    }
    
    public double getCostoReal() {
        return costoReal;
    }

    public void setCostoReal(double costoReal) {
        this.costoReal = costoReal;
    }

    public double getPrecioLista() {
        return precioLista;
    }

    public void setPrecioLista(double precioLista) {
        this.precioLista = precioLista;
    }

    public List<String> getDescDescuento() {
        return descDescuento;
    }

    public void setDescDescuento(String descDescuento) {
        this.descDescuento.add(descDescuento);
    }

    public double getFarmaDescuento() {
        return farmaDescuento;
    }

    public void setFarmaDescuento(double farmaDescuento) {
        this.farmaDescuento = farmaDescuento;
    }
    
    
}
