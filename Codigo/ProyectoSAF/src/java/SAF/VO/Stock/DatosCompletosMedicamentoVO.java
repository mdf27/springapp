/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.VO.Stock;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author majo
 */
public class DatosCompletosMedicamentoVO {
    private int idProducto;
    private boolean receta;
    private String laboratorios;
    private List<String> drogas;
    private List<String> accion;
    private List<String> presentacion;
    
    public DatosCompletosMedicamentoVO() {
        drogas= new LinkedList<>();
        accion= new LinkedList<>();
        presentacion= new LinkedList<>();
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public boolean isRequiereReceta() {
        return receta;
    }

    public void setRequiereReceta(boolean receta) {
        this.receta = receta;
    }

    public String getNombreLaboratorio() {
        return laboratorios;
    }

    public void setNombreLaboratorio(String laboratorios) {
        this.laboratorios = laboratorios;
    }

    public List<String> getNombreDroga() {
        return drogas;
    }

    public void setNombreDroga(String drogas) {
        this.drogas.add(drogas);
    }

    public List<String> getAccionTerapeutica() {
        return accion;
    }

    public void setAccionTerapeutica(String accion) {
        this.accion.add(accion);
    }   

    public List<String> getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion.add(presentacion);
    }
    
}
