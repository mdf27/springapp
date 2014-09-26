/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.VO.Facturacion;

import java.math.BigInteger;

/**
 *
 * @author Fernanda
 */
public class RenglonFacturaVO {

    private short idTipoFactura;
    private int idFactura;
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
    private BigInteger idTransaccion;
    private int idRenglonFactura;
    private int cantidad;
    private boolean conReceta;

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

    public RenglonFacturaVO() {
    }

    public short getIdTipoFactura() {
        return idTipoFactura;
    }

    public void setIdTipoFactura(short idTipoFactura) {
        this.idTipoFactura = idTipoFactura;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
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

    public BigInteger getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(BigInteger idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

}
