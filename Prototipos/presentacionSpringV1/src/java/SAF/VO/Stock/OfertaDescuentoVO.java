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
public class OfertaDescuentoVO {
    int idTipoOfertaDescuento;
    int idProducto;
    String descripcion;
    int cantBonif;
    DecimalFormat porcentBonif;
    DecimalFormat montoBonif;
    int cantMin;
    DecimalFormat montoMin;
    boolean habilitado;
    BigInteger idTransaccion;

    public OfertaDescuentoVO() {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        porcentBonif = new DecimalFormat("###.##",simbolos);
        montoBonif = new DecimalFormat("#####.##",simbolos);
        montoMin = new DecimalFormat("#####.##",simbolos);    
    }

    public int getIdTipoOfertaDescuento() {
        return idTipoOfertaDescuento;
    }

    public void setIdTipoOfertaDescuento(int idTipoOfertaDescuento) {
        this.idTipoOfertaDescuento = idTipoOfertaDescuento;
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

    public int getCantBonif() {
        return cantBonif;
    }

    public void setCantBonif(int cantBonif) {
        this.cantBonif = cantBonif;
    }

    public DecimalFormat getPorcentBonif() {
        return porcentBonif;
    }

    public void setPorcentBonif(DecimalFormat porcentBonif) {
        this.porcentBonif = porcentBonif;
    }

    public DecimalFormat getMontoBonif() {
        return montoBonif;
    }

    public void setMontoBonif(DecimalFormat montoBonif) {
        this.montoBonif = montoBonif;
    }

    public int getCantMin() {
        return cantMin;
    }

    public void setCantMin(int cantMin) {
        this.cantMin = cantMin;
    }

    public DecimalFormat getMontoMin() {
        return montoMin;
    }

    public void setMontoMin(DecimalFormat montoMin) {
        this.montoMin = montoMin;
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
