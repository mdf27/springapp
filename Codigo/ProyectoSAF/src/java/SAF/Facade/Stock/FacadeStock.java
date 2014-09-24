/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Facade.Stock;

import SAF.Logica.Stock.BuscarProductoManager;
import SAF.Logica.Stock.ModificarProductoManager;
import SAF.VO.Stock.DataInfoProductoVO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
    
//    @Autowired
//    ModificarProductoManager mpm;
    
    public String buscarProducto(String texto_buscar, String filtro) throws ClassNotFoundException, ParseException, SQLException, IOException, java.text.ParseException{
        return bpm.buscarProducto(texto_buscar, filtro);
    }
    
//    public void actualizarProductosDUSA(List<DataInfoProductoVO> productos) {
//        mpm.actualizarProductosDUSA(productos);
//    }    
}
