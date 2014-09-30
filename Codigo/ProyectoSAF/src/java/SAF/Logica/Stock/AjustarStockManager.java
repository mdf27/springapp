/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Logica.Stock;

import SAF.Datos.Stock.AjustarStockDAO;
import SAF.Datos.Stock.BuscarProductoDAO;
import SAF.Datos.Stock.LuceneProductosDAO;
import SAF.Logica.Abstract.AbstractManejador;
import SAF.VO.Stock.DatosCompletosMedProdVO;
import SAF.VO.Stock.DatosCompletosMedicamentoVO;
import SAF.VO.Stock.DatosCompletosProductoVO;
import SAF.VO.Stock.StockVO;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author majo
 */
@Service
public class AjustarStockManager extends AbstractManejador{
    @Autowired
    private BuscarProductoDAO buscarDao;    
    @Autowired
    private LuceneProductosDAO luceneDao;   
    @Autowired
    private AjustarStockDAO ajustarDAO;    
    
    public Map <Integer,DatosCompletosProductoVO> buscarProductos() throws java.text.ParseException{
        return buscarDao.obtenerDatosCompletosProducto();
    }
    
    public Map <Integer,DatosCompletosMedicamentoVO> buscarMedicamentos(){
        return buscarDao.obtenerDatosCompletosMedicamento();
    }
    
    @Transactional(rollbackFor=Exception.class)
    public List<DatosCompletosMedProdVO> ajustarStock () throws ClassNotFoundException, ParseException, SQLException, IOException, java.text.ParseException{
        LuceneProductosDAO ldao = LuceneProductosDAO.getInstance();
        if (!ldao.indiceCargado()){//indiceCargado?
            ldao.cargarProductos(buscarProductos(),buscarMedicamentos());
        }          
    
        List<DatosCompletosMedProdVO> salida = ldao.obtenerTodosLosProductos();
        return salida;
    } 

    
    @Transactional(rollbackFor=Exception.class)
    public void ajustarCantidadStock (StockVO stock) throws java.text.ParseException, ClassNotFoundException, SQLException, IOException, ParseException{
        //solicito id de transaccion
        //long idTransaccion = super.getIDTransaccion();
        BigInteger idTransaccion = BigInteger.valueOf(0);
        stock.setIdTransaccion(idTransaccion);
        ajustarDAO.ajustarCantidadStock(stock);        
        //se tiene que hacer una vez
        luceneDao.actualizarIndiceProductosLucene(buscarDao.obtenerDatosCompletosProducto(), buscarDao.obtenerDatosCompletosMedicamento());
    }     
}
