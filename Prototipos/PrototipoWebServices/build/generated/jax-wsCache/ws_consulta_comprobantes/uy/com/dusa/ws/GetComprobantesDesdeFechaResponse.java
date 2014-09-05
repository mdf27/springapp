
package uy.com.dusa.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getComprobantesDesdeFechaResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getComprobantesDesdeFechaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ws.dusa.com.uy/}resultGetComprobantes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getComprobantesDesdeFechaResponse", propOrder = {
    "_return"
})
public class GetComprobantesDesdeFechaResponse {

    @XmlElement(name = "return")
    protected ResultGetComprobantes _return;

    /**
     * Obtiene el valor de la propiedad return.
     * 
     * @return
     *     possible object is
     *     {@link ResultGetComprobantes }
     *     
     */
    public ResultGetComprobantes getReturn() {
        return _return;
    }

    /**
     * Define el valor de la propiedad return.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultGetComprobantes }
     *     
     */
    public void setReturn(ResultGetComprobantes value) {
        this._return = value;
    }

}
