/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.VO.Facturacion;

import java.math.BigInteger;
import java.text.DecimalFormat;

/**
 *
 * @author Fernanda
 */
public class RenglonFacturaVO {

    private short idTipoFactura;
    private int idFactura;
    private int idProducto;
    private DecimalFormat precioProducto;
    private DecimalFormat precioVtaReal;
    /**
     * el desc es de descuento ;)*
     */
    private String descDescripcion;
    private int descCantBonif;
    private DecimalFormat descPorcentBonif;
    private DecimalFormat descMontoBonif;
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

    public DecimalFormat getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(DecimalFormat precioProducto) {
        this.precioProducto = precioProducto;
    }

    public DecimalFormat getPrecioVtaReal() {
        return precioVtaReal;
    }

    public void setPrecioVtaReal(DecimalFormat precioVtaReal) {
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

    public DecimalFormat getDescPorcentBonif() {
        return descPorcentBonif;
    }

    public void setDescPorcentBonif(DecimalFormat descPorcentBonif) {
        this.descPorcentBonif = descPorcentBonif;
    }

    public DecimalFormat getDescMontoBonif() {
        return descMontoBonif;
    }

    public void setDescMontoBonif(DecimalFormat descMontoBonif) {
        this.descMontoBonif = descMontoBonif;
    }

    public BigInteger getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(BigInteger idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

}
