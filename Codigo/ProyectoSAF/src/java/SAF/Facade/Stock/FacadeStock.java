/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Facade.Stock;

import SAF.Logica.Stock.BuscarProductoManager;
import java.io.IOException;
import java.sql.SQLException;
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
    
    public String buscarProducto(String texto_buscar, String filtro) throws ClassNotFoundException, ParseException, SQLException, IOException, java.text.ParseException{
        return bpm.buscarProducto(texto_buscar, filtro);
    }
}
