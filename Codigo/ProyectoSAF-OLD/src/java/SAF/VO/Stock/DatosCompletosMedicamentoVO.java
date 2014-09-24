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
    private boolean requiereReceta;
    private String nombreLaboratorio;
    private List<String> nombreDroga;
    private List<String> accionTerapeutica;
    private List<String> presentacion;
    
    public DatosCompletosMedicamentoVO() {
        nombreDroga= new LinkedList<>();
        accionTerapeutica= new LinkedList<>();
        presentacion= new LinkedList<>();
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public boolean isRequiereReceta() {
        return requiereReceta;
    }

    public void setRequiereReceta(boolean requiereReceta) {
        this.requiereReceta = requiereReceta;
    }

    public String getNombreLaboratorio() {
        return nombreLaboratorio;
    }

    public void setNombreLaboratorio(String nombreLaboratorio) {
        this.nombreLaboratorio = nombreLaboratorio;
    }

    public List<String> getNombreDroga() {
        return nombreDroga;
    }

    public void setNombreDroga(String nombreDroga) {
        this.nombreDroga.add(nombreDroga);
    }

    public List<String> getAccionTerapeutica() {
        return accionTerapeutica;
    }

    public void setAccionTerapeutica(String accionTerapeutica) {
        this.accionTerapeutica.add(accionTerapeutica);
    }   

    public List<String> getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion.add(presentacion);
    }
    
}
