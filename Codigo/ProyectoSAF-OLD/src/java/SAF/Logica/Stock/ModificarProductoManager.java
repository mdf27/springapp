/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.Logica.Stock;

import SAF.Datos.Stock.ProductoDAO;
import SAF.Logica.Abstract.AbstractManejador;
import SAF.VO.Stock.DataInfoProductoVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Manu
 */
//@Service
public class ModificarProductoManager extends AbstractManejador {
    @Autowired
    private ProductoDAO productoDAO;
    
    @Transactional(rollbackFor = Exception.class)
    public void actualizarProductosDUSA (List<DataInfoProductoVO> productos) {
        productoDAO.actualizarProductosDUSA (productos);
    }
}
