/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.VO.Stock;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author majo
 */
public class TipoIvaVO {
    private String descripcion;
    private DecimalFormat porcentaje;

    public TipoIvaVO() {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        porcentaje = new DecimalFormat("###.##",simbolos);

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public DecimalFormat getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(DecimalFormat porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
}
