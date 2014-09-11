
package uy.com.dusa.ws;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dataIVA complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataIVA">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipoIVA" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoTasa" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="indicadorFacturacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="valorIVA" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="valorTributo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="resguardoIVA" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="resguardoIRAE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataIVA", propOrder = {
    "tipoIVA",
    "descripcion",
    "tipoTasa",
    "indicadorFacturacion",
    "valorIVA",
    "valorTributo",
    "resguardoIVA",
    "resguardoIRAE"
})
public class DataIVA {

    @XmlSchemaType(name = "unsignedShort")
    protected int tipoIVA;
    protected String descripcion;
    @XmlSchemaType(name = "unsignedShort")
    protected int tipoTasa;
    protected int indicadorFacturacion;
    protected BigDecimal valorIVA;
    protected BigDecimal valorTributo;
    protected BigDecimal resguardoIVA;
    protected BigDecimal resguardoIRAE;

    /**
     * Obtiene el valor de la propiedad tipoIVA.
     * 
     */
    public int getTipoIVA() {
        return tipoIVA;
    }

    /**
     * Define el valor de la propiedad tipoIVA.
     * 
     */
    public void setTipoIVA(int value) {
        this.tipoIVA = value;
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
     * Obtiene el valor de la propiedad tipoTasa.
     * 
     */
    public int getTipoTasa() {
        return tipoTasa;
    }

    /**
     * Define el valor de la propiedad tipoTasa.
     * 
     */
    public void setTipoTasa(int value) {
        this.tipoTasa = value;
    }

    /**
     * Obtiene el valor de la propiedad indicadorFacturacion.
     * 
     */
    public int getIndicadorFacturacion() {
        return indicadorFacturacion;
    }

    /**
     * Define el valor de la propiedad indicadorFacturacion.
     * 
     */
    public void setIndicadorFacturacion(int value) {
        this.indicadorFacturacion = value;
    }

    /**
     * Obtiene el valor de la propiedad valorIVA.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorIVA() {
        return valorIVA;
    }

    /**
     * Define el valor de la propiedad valorIVA.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorIVA(BigDecimal value) {
        this.valorIVA = value;
    }

    /**
     * Obtiene el valor de la propiedad valorTributo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorTributo() {
        return valorTributo;
    }

    /**
     * Define el valor de la propiedad valorTributo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorTributo(BigDecimal value) {
        this.valorTributo = value;
    }

    /**
     * Obtiene el valor de la propiedad resguardoIVA.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getResguardoIVA() {
        return resguardoIVA;
    }

    /**
     * Define el valor de la propiedad resguardoIVA.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setResguardoIVA(BigDecimal value) {
        this.resguardoIVA = value;
    }

    /**
     * Obtiene el valor de la propiedad resguardoIRAE.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getResguardoIRAE() {
        return resguardoIRAE;
    }

    /**
     * Define el valor de la propiedad resguardoIRAE.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setResguardoIRAE(BigDecimal value) {
        this.resguardoIRAE = value;
    }

}
