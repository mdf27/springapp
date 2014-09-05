
package uy.com.dusa.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para resultGetStockUpdates complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="resultGetStockUpdates">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="laboratorios" type="{http://ws.dusa.com.uy/}dataInfoProducto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="mensaje" type="{http://ws.dusa.com.uy/}mensajeError" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultGetStockUpdates", propOrder = {
    "laboratorios",
    "mensaje"
})
public class ResultGetStockUpdates {

    @XmlElement(nillable = true)
    protected List<DataInfoProducto> laboratorios;
    protected MensajeError mensaje;

    /**
     * Gets the value of the laboratorios property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the laboratorios property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLaboratorios().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataInfoProducto }
     * 
     * 
     */
    public List<DataInfoProducto> getLaboratorios() {
        if (laboratorios == null) {
            laboratorios = new ArrayList<DataInfoProducto>();
        }
        return this.laboratorios;
    }

    /**
     * Obtiene el valor de la propiedad mensaje.
     * 
     * @return
     *     possible object is
     *     {@link MensajeError }
     *     
     */
    public MensajeError getMensaje() {
        return mensaje;
    }

    /**
     * Define el valor de la propiedad mensaje.
     * 
     * @param value
     *     allowed object is
     *     {@link MensajeError }
     *     
     */
    public void setMensaje(MensajeError value) {
        this.mensaje = value;
    }

}