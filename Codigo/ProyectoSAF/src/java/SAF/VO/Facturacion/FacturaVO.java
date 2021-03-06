package SAF.VO.Facturacion;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
    private int nroFactura;
    private String nroSerieFactura;
    private int idCliente;
    private String RUT;
    private String razonSocial;
    @JsonDeserialize(using = ShortDateDeserializer.class)
    private Timestamp fecha;
    private double descuento;
    private double montoNetoTotal;
    private double montoNetoGravIva;
    private double montoNetoGravIvaMin;
    private double montoTotal;
    private double montoTotalAPagar;
    private long idTransaccion;
    private List<RenglonFacturaVO> renglones;
    private FormaPagoFacturaVO formaDePago;
    private EnvioFacturaVO datosEnvio;

    public FormaPagoFacturaVO getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaPagoFacturaVO formaDePago) {
        this.formaDePago = formaDePago;
    }
    
    public List<RenglonFacturaVO> getRenglones() {
        return renglones;
    }

    public void setRenglones(List<RenglonFacturaVO> renglones) {
        this.renglones = renglones;
    }

    public EnvioFacturaVO getDatosEnvio() {
        return datosEnvio;
    }

    public void setDatosEnvio(EnvioFacturaVO datosEnvio) {
        this.datosEnvio = datosEnvio;
    }
    
    

    public FacturaVO() {
        renglones = new LinkedList<>();
        idCliente = -1;
    }

    public FacturaVO(Map<String, Object> query) {

        idTipoFactura = ((Integer) query.get("idTipoFactura")).shortValue();
        nroFactura = (int) query.get("nroFactura");
        nroSerieFactura = (String) query.get("nroSerie");
        if (query.get("idCliente") != null) {
            idCliente = (int) query.get("idCliente");
        }
        if (query.get("RUT") != null) {
            RUT = (String) query.get("RUT");
        }
        if (query.get("RazonSocial") != null) {
            razonSocial = (String) query.get("RazonSocial");
        }
        fecha = (Timestamp) query.get("fecha");
        if (query.get("descuento") != null) {
            descuento = ((BigDecimal) query.get("descuento")).doubleValue();
        }
        montoNetoTotal = ((BigDecimal) query.get("montoNetoTotal")).doubleValue();
        montoNetoGravIva = ((BigDecimal) query.get("montoNetoGralIva")).doubleValue();
        montoNetoGravIvaMin = ((BigDecimal) query.get("montoNetoGralIvaMin")).doubleValue();
        montoTotal = ((BigDecimal) query.get("montoTotal")).doubleValue();
        montoTotalAPagar = ((BigDecimal) query.get("montoTotalAPagar")).doubleValue();
        if (query.get("idTransaccion") != null) {
            idTransaccion = ((Long) query.get("idTransaccion"));
        }

    }

    public String getNroSerieFactura() {
        return nroSerieFactura;
    }

    public void setNroSerieFactura(String nroSerieFactura) {
        this.nroSerieFactura = nroSerieFactura;
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

    public void setNroFactura(int idFactura) {
        this.nroFactura = idFactura;
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

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getMontoNetoTotal() {
        return montoNetoTotal;
    }

    public void setMontoNetoTotal(double montoNetoTotal) {
        this.montoNetoTotal = montoNetoTotal;
    }

    public double getMontoNetoGravIva() {
        return montoNetoGravIva;
    }

    public void setMontoNetoGravIva(double montoNetoGravIva) {
        this.montoNetoGravIva = montoNetoGravIva;
    }

    public double getMontoNetoGravIvaMin() {
        return montoNetoGravIvaMin;
    }

    public void setMontoNetoGravIvaMin(double montoNetoGravIvaMin) {
        this.montoNetoGravIvaMin = montoNetoGravIvaMin;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public double getMontoTotalAPagar() {
        return montoTotalAPagar;
    }

    public void setMontoTotalAPagar(double montoTotalAPagar) {
        this.montoTotalAPagar = montoTotalAPagar;
    }

    public long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

}
