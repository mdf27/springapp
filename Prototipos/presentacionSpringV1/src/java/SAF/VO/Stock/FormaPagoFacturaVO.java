/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.VO.Stock;

import java.math.BigInteger;

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
    private BigInteger idTransaccion;

    public FormaPagoFacturaVO() {
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

    public BigInteger getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(BigInteger idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
    
    
}
