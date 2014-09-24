/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.VO.Stock;

import java.math.BigDecimal;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Manu
 */
public class DataInfoProductoVO {

    protected int numeroArticulo;
    protected String idLaboratorio;
    protected String idLineaLaboratorio;
    protected String clave1;
    protected String clave2;
    protected String clave3;
    protected String descripcion;
    protected String tipoIVA;
    protected BigDecimal precioVenta;
    protected BigDecimal precioOferta;
    protected BigDecimal precioPublico;
    protected int habilitado;
    protected BigDecimal porcentajeDescuentoOferta;
    protected boolean hasCodigoBarra;
    protected String codigoBarra;
    protected String codigoLaboratorio;
    protected XMLGregorianCalendar fechaUlitmoPrecio;
    protected XMLGregorianCalendar fechaUltimaActualizacion;
   // protected List<DataOferta> ofertas;
   // protected List<DataPreciosReceta> preciosRecetas;
    protected int idProductoNoritel;
    protected int idPresentacionNoritel;

    public DataInfoProductoVO() {
         
    }

    public int getNumeroArticulo() {
        return numeroArticulo;
    }

    public void setNumeroArticulo(int numeroArticulo) {
        this.numeroArticulo = numeroArticulo;
    }

    public String getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(String idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public String getIdLineaLaboratorio() {
        return idLineaLaboratorio;
    }

    public void setIdLineaLaboratorio(String idLineaLaboratorio) {
        this.idLineaLaboratorio = idLineaLaboratorio;
    }

    public String getClave1() {
        return clave1;
    }

    public void setClave1(String clave1) {
        this.clave1 = clave1;
    }

    public String getClave2() {
        return clave2;
    }

    public void setClave2(String clave2) {
        this.clave2 = clave2;
    }

    public String getClave3() {
        return clave3;
    }

    public void setClave3(String clave3) {
        this.clave3 = clave3;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoIVA() {
        return tipoIVA;
    }

    public void setTipoIVA(String tipoIVA) {
        this.tipoIVA = tipoIVA;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public BigDecimal getPrecioOferta() {
        return precioOferta;
    }

    public void setPrecioOferta(BigDecimal precioOferta) {
        this.precioOferta = precioOferta;
    }

    public BigDecimal getPrecioPublico() {
        return precioPublico;
    }

    public void setPrecioPublico(BigDecimal precioPublico) {
        this.precioPublico = precioPublico;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    public BigDecimal getPorcentajeDescuentoOferta() {
        return porcentajeDescuentoOferta;
    }

    public void setPorcentajeDescuentoOferta(BigDecimal porcentajeDescuentoOferta) {
        this.porcentajeDescuentoOferta = porcentajeDescuentoOferta;
    }

    public boolean isHasCodigoBarra() {
        return hasCodigoBarra;
    }

    public void setHasCodigoBarra(boolean hasCodigoBarra) {
        this.hasCodigoBarra = hasCodigoBarra;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getCodigoLaboratorio() {
        return codigoLaboratorio;
    }

    public void setCodigoLaboratorio(String codigoLaboratorio) {
        this.codigoLaboratorio = codigoLaboratorio;
    }

    public XMLGregorianCalendar getFechaUlitmoPrecio() {
        return fechaUlitmoPrecio;
    }

    public void setFechaUlitmoPrecio(XMLGregorianCalendar fechaUlitmoPrecio) {
        this.fechaUlitmoPrecio = fechaUlitmoPrecio;
    }

    public XMLGregorianCalendar getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(XMLGregorianCalendar fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public int getIdProductoNoritel() {
        return idProductoNoritel;
    }

    public void setIdProductoNoritel(int idProductoNoritel) {
        this.idProductoNoritel = idProductoNoritel;
    }

    public int getIdPresentacionNoritel() {
        return idPresentacionNoritel;
    }

    public void setIdPresentacionNoritel(int idPresentacionNoritel) {
        this.idPresentacionNoritel = idPresentacionNoritel;
    }
    
}
