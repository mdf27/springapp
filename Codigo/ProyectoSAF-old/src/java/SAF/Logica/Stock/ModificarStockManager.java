/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Logica.Stock;

import SAF.Datos.Stock.StockDAO;
import SAF.Logica.Abstract.AbstractManejador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fernanda
 */
public class ModificarStockManager extends AbstractManejador {

    @Autowired
    private StockDAO stockDAO;

    @Transactional(rollbackFor = Exception.class)
    public void actualizarCantidadProducto (int cantidad, int idProducto) {
        int cantidadActual = stockDAO.getCantidadStock(idProducto);
        stockDAO.actualizarCantidadStock (idProducto, cantidadActual + cantidad);
    }
}
