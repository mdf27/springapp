/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Logica.Stock;

import SAF.Datos.Stock.BuscarProductoDAO;
import SAF.Datos.Stock.LuceneProductosDAO;
import SAF.VO.Stock.DatosCompletosMedProdVO;
import SAF.VO.Stock.DatosCompletosMedicamentoVO;
import SAF.VO.Stock.DatosCompletosProductoVO;
import java.io.IOException;
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
public class BuscarProductoManager {
    @Autowired
    private BuscarProductoDAO buscarDao;
    
    public Map <Integer,DatosCompletosProductoVO> buscarProductos() throws java.text.ParseException{
        return buscarDao.obtenerDatosCompletosProducto();
    }
    
    public Map <Integer,DatosCompletosMedicamentoVO> buscarMedicamentos(){
        return buscarDao.obtenerDatosCompletosMedicamento();
    }
    
    @Transactional(rollbackFor=Exception.class)
    public List<DatosCompletosMedProdVO> buscarProducto(String texto_buscar, String filtro) throws ClassNotFoundException, ParseException, SQLException, IOException, java.text.ParseException{
        LuceneProductosDAO ldao = LuceneProductosDAO.getInstance();
        if (!ldao.indiceCargado()){//indiceCargado?
            ldao.cargarProductos(buscarProductos(),buscarMedicamentos());
        }else if (ldao.isActualizarIndice()){
            ldao.actualizarIndiceProductosLucene(buscarDao.obtenerDatosCompletosProducto(), buscarDao.obtenerDatosCompletosMedicamento());
            ldao.setActualizarIndice(false);
        }
    
        List<DatosCompletosMedProdVO> salida = ldao.buscarProducto(texto_buscar, filtro);
        return salida;
    }    
}
