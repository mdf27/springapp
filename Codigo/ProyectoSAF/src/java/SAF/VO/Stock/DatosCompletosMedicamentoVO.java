/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.VO.Stock;

/**
 *
 * @author majo
 */
public class DatosCompletosMedicamentoVO {
    private int idProducto;
    private boolean requiereReceta;
    private String nombreLaboratorio;
    private String nombreDroga;
    private String accionTerapeutica;

    public DatosCompletosMedicamentoVO() {
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

    public String getNombreDroga() {
        return nombreDroga;
    }

    public void setNombreDroga(String nombreDroga) {
        this.nombreDroga = nombreDroga;
    }

    public String getAccionTerapeutica() {
        return accionTerapeutica;
    }

    public void setAccionTerapeutica(String accionTerapeutica) {
        this.accionTerapeutica = accionTerapeutica;
    }   
}
