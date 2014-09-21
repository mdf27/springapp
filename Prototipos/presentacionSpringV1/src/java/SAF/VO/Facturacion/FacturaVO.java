package SAF.VO.Facturacion;

import java.text.DecimalFormat;
import java.util.Date;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernanda
 */
public class FacturaVO {
    
    private short idTipoFactura;
    private int idFactura;
    private int idCliente;
    private String RUT;
    private String razonSocial;
    private Date fecha;
    private DecimalFormat descuento;
    private DecimalFormat montoNetoTotal;
    private DecimalFormat montoNetoGravIva;
    private DecimalFormat montoNetoGravIvaMin;
    private DecimalFormat montoTotal;
    private DecimalFormat montoTotalAPagar;
    private DecimalFormat idTransaccion;

    public FacturaVO() {
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getRUT() {
        return RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public DecimalFormat getDescuento() {
        return descuento;
    }

    public void setDescuento(DecimalFormat descuento) {
        this.descuento = descuento;
    }

    public DecimalFormat getMontoNetoTotal() {
        return montoNetoTotal;
    }

    public void setMontoNetoTotal(DecimalFormat montoNetoTotal) {
        this.montoNetoTotal = montoNetoTotal;
    }

    public DecimalFormat getMontoNetoGravIva() {
        return montoNetoGravIva;
    }

    public void setMontoNetoGravIva(DecimalFormat montoNetoGravIva) {
        this.montoNetoGravIva = montoNetoGravIva;
    }

    public DecimalFormat getMontoNetoGravIvaMin() {
        return montoNetoGravIvaMin;
    }

    public void setMontoNetoGravIvaMin(DecimalFormat montoNetoGravIvaMin) {
        this.montoNetoGravIvaMin = montoNetoGravIvaMin;
    }

    public DecimalFormat getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(DecimalFormat montoTotal) {
        this.montoTotal = montoTotal;
    }

    public DecimalFormat getMontoTotalAPagar() {
        return montoTotalAPagar;
    }

    public void setMontoTotalAPagar(DecimalFormat montoTotalAPagar) {
        this.montoTotalAPagar = montoTotalAPagar;
    }

    public DecimalFormat getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(DecimalFormat idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
    
}
