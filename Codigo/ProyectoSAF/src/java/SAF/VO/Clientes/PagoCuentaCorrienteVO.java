/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.VO.Clientes;

import java.math.BigDecimal;

/**
 *
 * @author Juanes
 */
public class PagoCuentaCorrienteVO {
     
    private int idPagoCuentaCorriente;
    private int idCuenta;
    private double monto;
    private BigDecimal idTransaccion;

    public PagoCuentaCorrienteVO() {
    }

    public int getIdPagoCuentaCorriente() {
        return idPagoCuentaCorriente;
    }

    public void setIdPagoCuentaCorriente(int idPagoCuentaCorriente) {
        this.idPagoCuentaCorriente = idPagoCuentaCorriente;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public BigDecimal getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(BigDecimal idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
    
    
}
