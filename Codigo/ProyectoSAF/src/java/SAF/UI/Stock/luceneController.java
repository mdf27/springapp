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
import SAF.Facade.Stock.FacadeStock;
import SAF.VO.Stock.DatosCompletosMedProdVO;
import SAF.VO.Stock.ProductoVO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/service/student/")
public class luceneController {       
    @Autowired
    private FacadeStock bpm;
/*
    @RequestMapping(value = "busqueda.htm",method = RequestMethod.GET)  
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String buscar (@RequestParam(value="buscar") String texto_buscar, @RequestParam(value="filtro") String filtro) throws ClassNotFoundException, SQLException, IOException, ParseException, java.text.ParseException{
        return bpm.buscarProducto(texto_buscar, filtro);
    }
    /*
    */
   @RequestMapping(value = "busqueda.json",method = RequestMethod.GET, headers = "Accept=application/json" )
   @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<DatosCompletosMedProdVO> buscar (@RequestParam(value="buscar") String texto_buscar, @RequestParam(value="filtro") String filtro) throws ClassNotFoundException, SQLException, IOException, ParseException, java.text.ParseException{
        return bpm.buscarProducto(texto_buscar, filtro);
    }
    
}

