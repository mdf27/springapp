/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Logica.Stock;

import SAF.Datos.Stock.BuscarProductoDAO;
import SAF.Datos.Stock.LuceneDAO;
import SAF.VO.Stock.ProductoVO;
import SAF.VO.Stock.StockVO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.store.Directory;
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
    @Autowired
    private BuscarProductoDAO buscarDao;
    
    @Transactional(rollbackFor=Exception.class)
    public List<ProductoVO> buscarProductos(){
        return bdDao1.obtenerProductosBusqueda();
    }
    
    @Transactional(rollbackFor=Exception.class)
    public List<StockVO> buscarProductoStock(){
        return bdDao2.obtenerStockBusqueda();
    }
    
    @Transactional(rollbackFor=Exception.class)
    public String buscarProducto(String texto_buscar, String filtro) throws ClassNotFoundException, ParseException, SQLException, IOException{
        LuceneDAO ldao = LuceneDAO.getInstance();
        if (!ldao.indiceCargado()){//indiceCargado?
            ldao.cargarProductos(buscarProductos(),buscarProductoStock());
        }          
    
        String salida = ldao.buscarProducto(texto_buscar, filtro);
        return salida;
    }
}
