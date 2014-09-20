/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Logica.Stock;

import SAF.Datos.Stock.BuscarProductoDAO;
import SAF.VO.Stock.ProductoVO;
import SAF.VO.Stock.StockVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author majo
 */
@Service
public class BuscarProductoManager {
    @Autowired
    private BuscarProductoDAO bdDao1;
    @Autowired
    private BuscarProductoDAO bdDao2;
    
    @Transactional(rollbackFor=Exception.class)
    public List<ProductoVO> buscarProductos(){
        return bdDao1.obtenerProductosBusqueda();
    }
    
    @Transactional(rollbackFor=Exception.class)
    public List<StockVO> buscarProductoStock(){
        return bdDao2.obtenerStockBusqueda();
    }
}
