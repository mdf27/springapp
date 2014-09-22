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
    private BuscarProductoDAO buscarDao;
    
    public List<ProductoVO> buscarProductos(){
        return buscarDao.obtenerProductosBusqueda();
    }
    
    public List<StockVO> buscarProductoStock(){
        return buscarDao.obtenerStockBusqueda();
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
