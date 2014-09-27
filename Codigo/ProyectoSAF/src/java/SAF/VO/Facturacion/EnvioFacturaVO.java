/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.VO.Facturacion;

/**
 *
 * @author Fernanda
 */
public class EnvioFacturaVO {
    
    private int idFactura;
    private int idUsuarioDelivery;
    private String Direccion;
    private String Telefono;
    private String Observaciones;

    public EnvioFacturaVO() {
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdUsuarioDelivery() {
        return idUsuarioDelivery;
    }

    public void setIdUsuarioDelivery(int idUsuarioDelivery) {
        this.idUsuarioDelivery = idUsuarioDelivery;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    
}
