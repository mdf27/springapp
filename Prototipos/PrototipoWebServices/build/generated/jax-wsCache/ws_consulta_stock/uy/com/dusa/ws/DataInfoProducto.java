
package uy.com.dusa.ws;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para dataInfoProducto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataInfoProducto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroArticulo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idLaboratorio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clave1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clave2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clave3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoIVA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="precioVenta" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="precioOferta" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="precioPublico" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="habilitado" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="porcentajeDescuentoOferta" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="hasCodigoBarra" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="codigoBarra" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaActualizacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ofertas" type="{http://ws.dusa.com.uy/}dataOferta" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="preciosRecetas" type="{http://ws.dusa.com.uy/}dataPreciosReceta" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="idProductoNoritel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idPresentacionNoritel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataInfoProducto", propOrder = {
    "numeroArticulo",
    "idLaboratorio",
    "clave1",
    "clave2",
    "clave3",
    "descripcion",
    "tipoIVA",
    "precioVenta",
    "precioOferta",
    "precioPublico",
    "habilitado",
    "porcentajeDescuentoOferta",
    "hasCodigoBarra",
    "codigoBarra",
    "fechaActualizacion",
    "ofertas",
    "preciosRecetas",
    "idProductoNoritel",
    "idPresentacionNoritel"
})
public class DataInfoProducto {

    protected int numeroArticulo;
    protected String idLaboratorio;
    protected String clave1;
    protected String clave2;
    protected String clave3;
    protected String descripcion;
    protected String tipoIVA;
    protected BigDecimal precioVenta;
    protected BigDecimal precioOferta;
    protected BigDecimal precioPublico;
    @XmlSchemaType(name = "unsignedShort")
    protected int habilitado;
    protected BigDecimal porcentajeDescuentoOferta;
    protected boolean hasCodigoBarra;
    protected String codigoBarra;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaActualizacion;
    @XmlElement(nillable = true)
    protected List<DataOferta> ofertas;
    @XmlElement(nillable = true)
    protected List<DataPreciosReceta> preciosRecetas;
    protected int idProductoNoritel;
    protected int idPresentacionNoritel;

    /**
     * Obtiene el valor de la propiedad numeroArticulo.
     * 
     */
    public int getNumeroArticulo() {
        return numeroArticulo;
    }

    /**
     * Define el valor de la propiedad numeroArticulo.
     * 
     */
    public void setNumeroArticulo(int value) {
        this.numeroArticulo = value;
    }

    /**
     * Obtiene el valor de la propiedad idLaboratorio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdLaboratorio() {
        return idLaboratorio;
    }

    /**
     * Define el valor de la propiedad idLaboratorio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdLaboratorio(String value) {
        this.idLaboratorio = value;
    }

    /**
     * Obtiene el valor de la propiedad clave1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClave1() {
        return clave1;
    }

    /**
     * Define el valor de la propiedad clave1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClave1(String value) {
        this.clave1 = value;
    }

    /**
     * Obtiene el valor de la propiedad clave2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClave2() {
        return clave2;
    }

    /**
     * Define el valor de la propiedad clave2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClave2(String value) {
        this.clave2 = value;
    }

    /**
     * Obtiene el valor de la propiedad clave3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClave3() {
        return clave3;
    }

    /**
     * Define el valor de la propiedad clave3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClave3(String value) {
        this.clave3 = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoIVA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoIVA() {
        return tipoIVA;
    }

    /**
     * Define el valor de la propiedad tipoIVA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoIVA(String value) {
        this.tipoIVA = value;
    }

    /**
     * Obtiene el valor de la propiedad precioVenta.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    /**
     * Define el valor de la propiedad precioVenta.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrecioVenta(BigDecimal value) {
        this.precioVenta = value;
    }

    /**
     * Obtiene el valor de la propiedad precioOferta.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrecioOferta() {
        return precioOferta;
    }

    /**
     * Define el valor de la propiedad precioOferta.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrecioOferta(BigDecimal value) {
        this.precioOferta = value;
    }

    /**
     * Obtiene el valor de la propiedad precioPublico.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrecioPublico() {
        return precioPublico;
    }

    /**
     * Define el valor de la propiedad precioPublico.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrecioPublico(BigDecimal value) {
        this.precioPublico = value;
    }

    /**
     * Obtiene el valor de la propiedad habilitado.
     * 
     */
    public int getHabilitado() {
        return habilitado;
    }

    /**
     * Define el valor de la propiedad habilitado.
     * 
     */
    public void setHabilitado(int value) {
        this.habilitado = value;
    }

    /**
     * Obtiene el valor de la propiedad porcentajeDescuentoOferta.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPorcentajeDescuentoOferta() {
        return porcentajeDescuentoOferta;
    }

    /**
     * Define el valor de la propiedad porcentajeDescuentoOferta.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPorcentajeDescuentoOferta(BigDecimal value) {
        this.porcentajeDescuentoOferta = value;
    }

    /**
     * Obtiene el valor de la propiedad hasCodigoBarra.
     * 
     */
    public boolean isHasCodigoBarra() {
        return hasCodigoBarra;
    }

    /**
     * Define el valor de la propiedad hasCodigoBarra.
     * 
     */
    public void setHasCodigoBarra(boolean value) {
        this.hasCodigoBarra = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoBarra.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoBarra() {
        return codigoBarra;
    }

    /**
     * Define el valor de la propiedad codigoBarra.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoBarra(String value) {
        this.codigoBarra = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaActualizacion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaActualizacion() {
        return fechaActualizacion;
    }

    /**
     * Define el valor de la propiedad fechaActualizacion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaActualizacion(XMLGregorianCalendar value) {
        this.fechaActualizacion = value;
    }

    /**
     * Gets the value of the ofertas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ofertas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOfertas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataOferta }
     * 
     * 
     */
    public List<DataOferta> getOfertas() {
        if (ofertas == null) {
            ofertas = new ArrayList<DataOferta>();
        }
        return this.ofertas;
    }

    /**
     * Gets the value of the preciosRecetas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the preciosRecetas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPreciosRecetas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataPreciosReceta }
     * 
     * 
     */
    public List<DataPreciosReceta> getPreciosRecetas() {
        if (preciosRecetas == null) {
            preciosRecetas = new ArrayList<DataPreciosReceta>();
        }
        return this.preciosRecetas;
    }

    /**
     * Obtiene el valor de la propiedad idProductoNoritel.
     * 
     */
    public int getIdProductoNoritel() {
        return idProductoNoritel;
    }

    /**
     * Define el valor de la propiedad idProductoNoritel.
     * 
     */
    public void setIdProductoNoritel(int value) {
        this.idProductoNoritel = value;
    }

    /**
     * Obtiene el valor de la propiedad idPresentacionNoritel.
     * 
     */
    public int getIdPresentacionNoritel() {
        return idPresentacionNoritel;
    }

    /**
     * Define el valor de la propiedad idPresentacionNoritel.
     * 
     */
    public void setIdPresentacionNoritel(int value) {
        this.idPresentacionNoritel = value;
    }

}
