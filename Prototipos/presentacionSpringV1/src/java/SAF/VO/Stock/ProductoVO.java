/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.VO.Stock;

import java.math.BigInteger;
import java.text.DecimalFormat;

/**
 *
 * @author majo
 */
public class ProductoVO {
    String descripcion;
    DecimalFormat precioCompra;
    /*
    precioCompra
    precioVenta
    */
    int idTipoIva;
    boolean habilitado;
    BigInteger idTransaccion;
}
