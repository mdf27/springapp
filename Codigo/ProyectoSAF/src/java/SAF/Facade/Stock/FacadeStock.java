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

/**
 *
 * @author majo
 */
public class FacadeStock {
    public String buscarProducto(String texto_buscar, String filtro) throws ClassNotFoundException, ParseException, SQLException, IOException{
        BuscarProductoManager bpm = new BuscarProductoManager();
        return bpm.buscarProducto(texto_buscar, filtro);
    }
}
