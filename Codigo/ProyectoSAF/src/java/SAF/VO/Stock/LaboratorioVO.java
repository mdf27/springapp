/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.VO.Stock;

import java.math.BigInteger;

/**
 *
 * @author majo
 */
public class LaboratorioVO {
    private int idLaboratorio;
    private String nombre;
    private String direccion;
    private String departamento;
    private String localidad;
    private String telefono;
    private String observaciones;
    private BigInteger idTransaccion;
    
    public LaboratorioVO() {
    }
    
    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigInteger getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(BigInteger idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
    
}
