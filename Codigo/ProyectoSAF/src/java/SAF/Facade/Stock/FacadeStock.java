/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Facade.Stock;

import SAF.Logica.Stock.AjustarStockManager;
import SAF.Logica.Stock.BuscarProductoManager;
import SAF.Logica.Stock.ModificarProductoManager;
import SAF.VO.Stock.DatosCompletosMedProdVO;
import SAF.VO.Stock.ProductoVO;
import SAF.VO.Stock.StockVO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author majo
 */
@Service
public class FacadeStock {
    @Autowired
    BuscarProductoManager bpm;

    @Autowired
    AjustarStockManager atm;
//    @Autowired
//    ModificarProductoManager mpm;
    
    public List<DatosCompletosMedProdVO> buscarProducto(String texto_buscar, String filtro) throws ClassNotFoundException, ParseException, SQLException, IOException, java.text.ParseException{
        return bpm.buscarProducto(texto_buscar, filtro);
    }

    public List<DatosCompletosMedProdVO> ajustarStock() throws ClassNotFoundException, ParseException, SQLException, IOException, java.text.ParseException{
        return atm.ajustarStock();
    }
    
    public void ajustarCantidadStock (int idProducto, int cantidad) throws java.text.ParseException, ClassNotFoundException, SQLException, IOException, ParseException{
        StockVO stock = new StockVO();
        stock.setCantidad(cantidad);
        stock.setIdProducto(idProducto);
        atm.ajustarCantidadStock(stock);
    }
    
    @Autowired
    ModificarProductoManager mpm;
    
    public Map <String, List<ProductoVO>> actualizarProductosDUSA(Date fecha) {
        Map <String, List<ProductoVO>> ret = mpm.actualizarProductosDUSA(fecha);
        return  ret;
        //return mpm.actualizarProductosDUSA(fecha);
    }     
}

