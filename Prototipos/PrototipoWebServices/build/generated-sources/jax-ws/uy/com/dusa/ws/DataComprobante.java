
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
 * <p>Clase Java para dataComprobante complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataComprobante">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="serie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fechaComprobante" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaEmision" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="formaDePago" type="{http://ws.dusa.com.uy/}comprobanteFormaDePago" minOccurs="0"/>
 *         &lt;element name="ordenDeCompra" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="montoNoGravado" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="montoNetoGravadoIvaMinimo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="montoNetoGravadoIvaBasico" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="totalIvaMinimo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="totalIvaBasico" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="montoTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="cantidadLineas" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="montoRetenidoIVA" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="montoRetenidoIRAE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="montoNoFacturable" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="montoTotalAPagar" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="montoTributoIvaMinimo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="montoTributoIvaBasico" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="detalle" type="{http://ws.dusa.com.uy/}dataLineaComprobante" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vencimientos" type="{http://ws.dusa.com.uy/}dataVencimiento" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataComprobante", propOrder = {
    "tipo",
    "serie",
    "numero",
    "fechaComprobante",
    "fechaEmision",
    "formaDePago",
    "ordenDeCompra",
    "montoNoGravado",
    "montoNetoGravadoIvaMinimo",
    "montoNetoGravadoIvaBasico",
    "totalIvaMinimo",
    "totalIvaBasico",
    "montoTotal",
    "cantidadLineas",
    "montoRetenidoIVA",
    "montoRetenidoIRAE",
    "montoNoFacturable",
    "montoTotalAPagar",
    "montoTributoIvaMinimo",
    "montoTributoIvaBasico",
    "detalle",
    "vencimientos"
})
public class DataComprobante {

    protected int tipo;
    protected String serie;
    protected int numero;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaComprobante;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEmision;
    protected ComprobanteFormaDePago formaDePago;
    protected long ordenDeCompra;
    protected BigDecimal montoNoGravado;
    protected BigDecimal montoNetoGravadoIvaMinimo;
    protected BigDecimal montoNetoGravadoIvaBasico;
    protected BigDecimal totalIvaMinimo;
    protected BigDecimal totalIvaBasico;
    protected BigDecimal montoTotal;
    protected Integer cantidadLineas;
    protected BigDecimal montoRetenidoIVA;
    protected BigDecimal montoRetenidoIRAE;
    protected BigDecimal montoNoFacturable;
    protected BigDecimal montoTotalAPagar;
    protected BigDecimal montoTributoIvaMinimo;
    protected BigDecimal montoTributoIvaBasico;
    @XmlElement(nillable = true)
    protected List<DataLineaComprobante> detalle;
    @XmlElement(nillable = true)
    protected List<DataVencimiento> vencimientos;

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
     * Obtiene el valor de la propiedad fechaComprobante.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaComprobante() {
        return fechaComprobante;
    }

    /**
     * Define el valor de la propiedad fechaComprobante.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaComprobante(XMLGregorianCalendar value) {
        this.fechaComprobante = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaEmision.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Define el valor de la propiedad fechaEmision.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEmision(XMLGregorianCalendar value) {
        this.fechaEmision = value;
    }

    /**
     * Obtiene el valor de la propiedad formaDePago.
     * 
     * @return
     *     possible object is
     *     {@link ComprobanteFormaDePago }
     *     
     */
    public ComprobanteFormaDePago getFormaDePago() {
        return formaDePago;
    }

    /**
     * Define el valor de la propiedad formaDePago.
     * 
     * @param value
     *     allowed object is
     *     {@link ComprobanteFormaDePago }
     *     
     */
    public void setFormaDePago(ComprobanteFormaDePago value) {
        this.formaDePago = value;
    }

    /**
     * Obtiene el valor de la propiedad ordenDeCompra.
     * 
     */
    public long getOrdenDeCompra() {
        return ordenDeCompra;
    }

    /**
     * Define el valor de la propiedad ordenDeCompra.
     * 
     */
    public void setOrdenDeCompra(long value) {
        this.ordenDeCompra = value;
    }

    /**
     * Obtiene el valor de la propiedad montoNoGravado.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoNoGravado() {
        return montoNoGravado;
    }

    /**
     * Define el valor de la propiedad montoNoGravado.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoNoGravado(BigDecimal value) {
        this.montoNoGravado = value;
    }

    /**
     * Obtiene el valor de la propiedad montoNetoGravadoIvaMinimo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoNetoGravadoIvaMinimo() {
        return montoNetoGravadoIvaMinimo;
    }

    /**
     * Define el valor de la propiedad montoNetoGravadoIvaMinimo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoNetoGravadoIvaMinimo(BigDecimal value) {
        this.montoNetoGravadoIvaMinimo = value;
    }

    /**
     * Obtiene el valor de la propiedad montoNetoGravadoIvaBasico.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoNetoGravadoIvaBasico() {
        return montoNetoGravadoIvaBasico;
    }

    /**
     * Define el valor de la propiedad montoNetoGravadoIvaBasico.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoNetoGravadoIvaBasico(BigDecimal value) {
        this.montoNetoGravadoIvaBasico = value;
    }

    /**
     * Obtiene el valor de la propiedad totalIvaMinimo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalIvaMinimo() {
        return totalIvaMinimo;
    }

    /**
     * Define el valor de la propiedad totalIvaMinimo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalIvaMinimo(BigDecimal value) {
        this.totalIvaMinimo = value;
    }

    /**
     * Obtiene el valor de la propiedad totalIvaBasico.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalIvaBasico() {
        return totalIvaBasico;
    }

    /**
     * Define el valor de la propiedad totalIvaBasico.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalIvaBasico(BigDecimal value) {
        this.totalIvaBasico = value;
    }

    /**
     * Obtiene el valor de la propiedad montoTotal.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    /**
     * Define el valor de la propiedad montoTotal.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoTotal(BigDecimal value) {
        this.montoTotal = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidadLineas.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCantidadLineas() {
        return cantidadLineas;
    }

    /**
     * Define el valor de la propiedad cantidadLineas.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCantidadLineas(Integer value) {
        this.cantidadLineas = value;
    }

    /**
     * Obtiene el valor de la propiedad montoRetenidoIVA.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoRetenidoIVA() {
        return montoRetenidoIVA;
    }

    /**
     * Define el valor de la propiedad montoRetenidoIVA.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoRetenidoIVA(BigDecimal value) {
        this.montoRetenidoIVA = value;
    }

    /**
     * Obtiene el valor de la propiedad montoRetenidoIRAE.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoRetenidoIRAE() {
        return montoRetenidoIRAE;
    }

    /**
     * Define el valor de la propiedad montoRetenidoIRAE.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoRetenidoIRAE(BigDecimal value) {
        this.montoRetenidoIRAE = value;
    }

    /**
     * Obtiene el valor de la propiedad montoNoFacturable.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoNoFacturable() {
        return montoNoFacturable;
    }

    /**
     * Define el valor de la propiedad montoNoFacturable.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoNoFacturable(BigDecimal value) {
        this.montoNoFacturable = value;
    }

    /**
     * Obtiene el valor de la propiedad montoTotalAPagar.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoTotalAPagar() {
        return montoTotalAPagar;
    }

    /**
     * Define el valor de la propiedad montoTotalAPagar.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoTotalAPagar(BigDecimal value) {
        this.montoTotalAPagar = value;
    }

    /**
     * Obtiene el valor de la propiedad montoTributoIvaMinimo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoTributoIvaMinimo() {
        return montoTributoIvaMinimo;
    }

    /**
     * Define el valor de la propiedad montoTributoIvaMinimo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoTributoIvaMinimo(BigDecimal value) {
        this.montoTributoIvaMinimo = value;
    }

    /**
     * Obtiene el valor de la propiedad montoTributoIvaBasico.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoTributoIvaBasico() {
        return montoTributoIvaBasico;
    }

    /**
     * Define el valor de la propiedad montoTributoIvaBasico.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoTributoIvaBasico(BigDecimal value) {
        this.montoTributoIvaBasico = value;
    }

    /**
     * Gets the value of the detalle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detalle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetalle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataLineaComprobante }
     * 
     * 
     */
    public List<DataLineaComprobante> getDetalle() {
        if (detalle == null) {
            detalle = new ArrayList<DataLineaComprobante>();
        }
        return this.detalle;
    }

    /**
     * Gets the value of the vencimientos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vencimientos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVencimientos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataVencimiento }
     * 
     * 
     */
    public List<DataVencimiento> getVencimientos() {
        if (vencimientos == null) {
            vencimientos = new ArrayList<DataVencimiento>();
        }
        return this.vencimientos;
    }

}
