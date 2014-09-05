
package uy.com.dusa.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getComprobantesDesdeNumero complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getComprobantesDesdeNumero">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoCFE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="serieCFE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nroCFE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getComprobantesDesdeNumero", propOrder = {
    "usuario",
    "password",
    "tipoCFE",
    "serieCFE",
    "nroCFE"
})
public class GetComprobantesDesdeNumero {

    protected String usuario;
    protected String password;
    protected int tipoCFE;
    protected String serieCFE;
    protected int nroCFE;

    /**
     * Obtiene el valor de la propiedad usuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Define el valor de la propiedad usuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

    /**
     * Obtiene el valor de la propiedad password.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define el valor de la propiedad password.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoCFE.
     * 
     */
    public int getTipoCFE() {
        return tipoCFE;
    }

    /**
     * Define el valor de la propiedad tipoCFE.
     * 
     */
    public void setTipoCFE(int value) {
        this.tipoCFE = value;
    }

    /**
     * Obtiene el valor de la propiedad serieCFE.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerieCFE() {
        return serieCFE;
    }

    /**
     * Define el valor de la propiedad serieCFE.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerieCFE(String value) {
        this.serieCFE = value;
    }

    /**
     * Obtiene el valor de la propiedad nroCFE.
     * 
     */
    public int getNroCFE() {
        return nroCFE;
    }

    /**
     * Define el valor de la propiedad nroCFE.
     * 
     */
    public void setNroCFE(int value) {
        this.nroCFE = value;
    }

}
