/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.UI.Stock;

/**
 *
 * @author majo
 */
import SAF.Logica.Stock.BuscarProductoManager;
import java.io.IOException;
import java.sql.SQLException;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class luceneController {       
    @Autowired
    private BuscarProductoManager bpm;
    
    @RequestMapping(value = "busqueda.htm",method = RequestMethod.GET)  
                  
    public @ResponseBody String buscar (@RequestParam(value="buscar") String texto_buscar, @RequestParam(value="filtro") String filtro) throws ClassNotFoundException, SQLException, IOException, ParseException{
        return bpm.buscarProducto(texto_buscar, filtro);
    }
}
