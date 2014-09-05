
package uy.com.dusa.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getPreciosRecetasResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getPreciosRecetasResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ws.dusa.com.uy/}resultGetPreciosRecetas" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPreciosRecetasResponse", propOrder = {
    "_return"
})
public class GetPreciosRecetasResponse {

    @XmlElement(name = "return")
    protected ResultGetPreciosRecetas _return;

    /**
     * Obtiene el valor de la propiedad return.
     * 
     * @return
     *     possible object is
     *     {@link ResultGetPreciosRecetas }
     *     
     */
    public ResultGetPreciosRecetas getReturn() {
        return _return;
    }

    /**
     * Define el valor de la propiedad return.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultGetPreciosRecetas }
     *     
     */
    public void setReturn(ResultGetPreciosRecetas value) {
        this._return = value;
    }

}
