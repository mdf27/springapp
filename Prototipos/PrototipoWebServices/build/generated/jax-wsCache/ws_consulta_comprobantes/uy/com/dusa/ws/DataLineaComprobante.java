
package uy.com.dusa.ws;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dataLineaComprobante complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataLineaComprobante">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="serie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numeroLinea" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numeroArticulo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="precioUnitario" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="descuento" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="descripcionOferta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indicadorDeFacturacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataLineaComprobante", propOrder = {
    "tipo",
    "serie",
    "numero",
    "numeroLinea",
    "numeroArticulo",
    "cantidad",
    "precioUnitario",
    "descuento",
    "descripcionOferta",
    "indicadorDeFacturacion"
})
public class DataLineaComprobante {

    protected int tipo;
    protected String serie;
    protected int numero;
    protected int numeroLinea;
    protected int numeroArticulo;
    protected int cantidad;
    protected BigDecimal precioUnitario;
    protected BigDecimal descuento;
    protected String descripcionOferta;
    protected int indicadorDeFacturacion;

    /**
     * Obtiene el valor de la propiedad tipo.
     * 
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     */
    public void setTipo(int value) {
        this.tipo = value;
    }

    /**
     * Obtiene el valor de la propiedad serie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Define el valor de la propiedad serie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerie(String value) {
        this.serie = value;
    }

    /**
     * Obtiene el valor de la propiedad numero.
     * 
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Define el valor de la propiedad numero.
     * 
     */
    public void setNumero(int value) {
        this.numero = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroLinea.
     * 
     */
    public int getNumeroLinea() {
        return numeroLinea;
    }

    /**
     * Define el valor de la propiedad numeroLinea.
     * 
     */
    public void setNumeroLinea(int value) {
        this.numeroLinea = value;
    }

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
     * Obtiene el valor de la propiedad cantidad.
     * 
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     */
    public void setCantidad(int value) {
        this.cantidad = value;
    }

    /**
     * Obtiene el valor de la propiedad precioUnitario.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Define el valor de la propiedad precioUnitario.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrecioUnitario(BigDecimal value) {
        this.precioUnitario = value;
    }

    /**
     * Obtiene el valor de la propiedad descuento.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDescuento() {
        return descuento;
    }

    /**
     * Define el valor de la propiedad descuento.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDescuento(BigDecimal value) {
        this.descuento = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionOferta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionOferta() {
        return descripcionOferta;
    }

    /**
     * Define el valor de la propiedad descripcionOferta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionOferta(String value) {
        this.descripcionOferta = value;
    }

    /**
     * Obtiene el valor de la propiedad indicadorDeFacturacion.
     * 
     */
    public int getIndicadorDeFacturacion() {
        return indicadorDeFacturacion;
    }

    /**
     * Define el valor de la propiedad indicadorDeFacturacion.
     * 
     */
    public void setIndicadorDeFacturacion(int value) {
        this.indicadorDeFacturacion = value;
    }

}
