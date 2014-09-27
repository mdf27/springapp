/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.VO.Facturacion;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Map;

/**
 *
 * @author Fernanda
 */
public class EnvioFacturaVO {
    
    private int idFactura;
    private int idUsuarioDelivery;
    private String direccion;
    private String telefono;
    private String observaciones;

    public EnvioFacturaVO() {
    }
    
        public EnvioFacturaVO(Map<String, Object> query) {

        idFactura = (int) query.get("idFactura");
        if (query.get("idUsuarioDelivery")!=null)
            idUsuarioDelivery = (int) query.get("idUsuarioDelivery");
        direccion = (String) query.get("Direccion");
        if(query.get("Telefono")!=null)
            telefono = (String) query.get("Telefono");
        if (query.get("Observacion")!=null)
             observaciones = (String) query.get("Observaciones");
       

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
        return direccion;
    }

    public void setDireccion(String Direccion) {
        this.direccion = Direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String Telefono) {
        this.telefono = Telefono;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.observaciones = Observaciones;
    }

    
}
