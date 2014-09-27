/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.VO.Facturacion;

import java.util.Map;

/**
 *
 * @author Fernanda
 */
public class FormaPagoFacturaVO {

    private short idTipoFormaPago;
    private short idTipoFactura;
    private int idFactura;
    private int nroTarjeta;
    private int idCuenta;
    private long idTransaccion;

    public FormaPagoFacturaVO() {
    }

    public FormaPagoFacturaVO(Map<String, Object> query) {

        idFactura = (int) query.get("idFactura");
        idTipoFactura = ((Integer) query.get("idTipoFactura")).shortValue();
        idTipoFormaPago = ((Integer) query.get("idTipoFormaPago")).shortValue();
        if (query.get("nroTarjeta") != null) {
            nroTarjeta = (int) query.get("nroTarjeta");
        }
        if (query.get("idCuenta") != null) {
            idCuenta = (int) query.get("idCuenta");
        }
        if (query.get("idTransaccion") != null) {
            idTransaccion = ((Long) query.get("idTransaccion"));
        }

    }

    public short getIdTipoFormaPago() {
        return idTipoFormaPago;
    }

    public void setIdTipoFormaPago(short idTipoFormaPago) {
        this.idTipoFormaPago = idTipoFormaPago;
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

    public int getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(int nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

}
