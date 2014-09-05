
package uy.com.dusa.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para dataOferta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataOferta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroArticulo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cantidadVenta" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cantidadBonificado" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="porcentajeBonificado" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fechaFin" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataOferta", propOrder = {
    "numeroArticulo",
    "cantidadVenta",
    "descripcion",
    "cantidadBonificado",
    "porcentajeBonificado",
    "fechaFin"
})
public class DataOferta {

    protected int numeroArticulo;
    protected int cantidadVenta;
    protected String descripcion;
    protected int cantidadBonificado;
    protected int porcentajeBonificado;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaFin;

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
     * Obtiene el valor de la propiedad cantidadVenta.
     * 
     */
    public int getCantidadVenta() {
        return cantidadVenta;
    }

    /**
     * Define el valor de la propiedad cantidadVenta.
     * 
     */
    public void setCantidadVenta(int value) {
        this.cantidadVenta = value;
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
     * Obtiene el valor de la propiedad cantidadBonificado.
     * 
     */
    public int getCantidadBonificado() {
        return cantidadBonificado;
    }

    /**
     * Define el valor de la propiedad cantidadBonificado.
     * 
     */
    public void setCantidadBonificado(int value) {
        this.cantidadBonificado = value;
    }

    /**
     * Obtiene el valor de la propiedad porcentajeBonificado.
     * 
     */
    public int getPorcentajeBonificado() {
        return porcentajeBonificado;
    }

    /**
     * Define el valor de la propiedad porcentajeBonificado.
     * 
     */
    public void setPorcentajeBonificado(int value) {
        this.porcentajeBonificado = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaFin.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaFin() {
        return fechaFin;
    }

    /**
     * Define el valor de la propiedad fechaFin.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaFin(XMLGregorianCalendar value) {
        this.fechaFin = value;
    }

}
