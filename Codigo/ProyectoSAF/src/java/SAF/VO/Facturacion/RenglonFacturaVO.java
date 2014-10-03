/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.VO.Facturacion;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author Fernanda
 */
public class RenglonFacturaVO {

    private short idTipoFactura;
    private int nroFactura;
    private String nroSerie;
    private int idProducto;
    private double precioProducto;
    private double precioVtaReal;
    /**
     * el desc es de descuento ;)*
     */
    private String descDescripcion;
    private int descCantBonif;
    private double descPorcentBonif;
    private double descMontoBonif;
    private long idTransaccion;
    private int idRenglonFactura;
    private int cantidad;
    private boolean conReceta;

    @JsonCreator
    public RenglonFacturaVO() {
    }

    public RenglonFacturaVO(Map<String, Object> query) {

        idTipoFactura = ((Integer) query.get("idTipoFactura")).shortValue();
        nroFactura = (int) query.get("nroFactura");
        nroSerie = (String) query.get("nroSerie");
        idRenglonFactura = (int) query.get("idRenglonfactura");
        idProducto = (int) query.get("idProducto");
        cantidad = (int) query.get("cantidad");
        conReceta = (boolean) query.get("conReceta");
        precioProducto = ((BigDecimal) query.get("precioProducto")).doubleValue();
        precioVtaReal = ((BigDecimal) query.get("precioVentaReal")).doubleValue();
        descDescripcion = (String) query.get("descDescripcion");
        descCantBonif = (int) query.get("descCantBonif");
        descPorcentBonif = ((BigDecimal) query.get("descPorcentBonif")).doubleValue();
        descMontoBonif = ((BigDecimal) query.get("descMontoBonif")).doubleValue();
        if (query.get("idTransaccion") != null) {
            idTransaccion = (long) query.get("idTransaccion");
        }

    }

    public int getIdRenglonFactura() {
        return idRenglonFactura;
    }

    public void setIdRenglonFactura(int idRenglonFactura) {
        this.idRenglonFactura = idRenglonFactura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isConReceta() {
        return conReceta;
    }

    public void setConReceta(boolean conReceta) {
        this.conReceta = conReceta;
    }

    public short getIdTipoFactura() {
        return idTipoFactura;
    }

    public void setIdTipoFactura(short idTipoFactura) {
        this.idTipoFactura = idTipoFactura;
    }

    public int getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    public String getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    }

    

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public double getPrecioVtaReal() {
        return precioVtaReal;
    }

    public void setPrecioVtaReal(double precioVtaReal) {
        this.precioVtaReal = precioVtaReal;
    }

    public String getDescDescripcion() {
        return descDescripcion;
    }

    public void setDescDescripcion(String descDescripcion) {
        this.descDescripcion = descDescripcion;
    }

    public int getDescCantBonif() {
        return descCantBonif;
    }

    public void setDescCantBonif(int descCantBonif) {
        this.descCantBonif = descCantBonif;
    }

    public double getDescPorcentBonif() {
        return descPorcentBonif;
    }

    public void setDescPorcentBonif(double descPorcentBonif) {
        this.descPorcentBonif = descPorcentBonif;
    }

    public double getDescMontoBonif() {
        return descMontoBonif;
    }

    public void setDescMontoBonif(double descMontoBonif) {
        this.descMontoBonif = descMontoBonif;
    }

    public long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

}
