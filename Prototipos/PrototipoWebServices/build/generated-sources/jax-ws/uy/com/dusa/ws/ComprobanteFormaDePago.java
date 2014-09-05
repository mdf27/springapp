
package uy.com.dusa.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para comprobanteFormaDePago.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="comprobanteFormaDePago">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CONTADO"/>
 *     &lt;enumeration value="CREDITO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "comprobanteFormaDePago")
@XmlEnum
public enum ComprobanteFormaDePago {

    CONTADO,
    CREDITO;

    public String value() {
        return name();
    }

    public static ComprobanteFormaDePago fromValue(String v) {
        return valueOf(v);
    }

}
