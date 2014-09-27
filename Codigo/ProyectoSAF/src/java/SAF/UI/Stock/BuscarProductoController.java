/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.UI.Stock;

import SAF.Facade.Stock.FacadeStock;
import SAF.VO.Stock.DatosCompletosMedProdVO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author majo
 */
@Controller
public class BuscarProductoController {
    @RequestMapping(value = "buscarVerProducto")
    public ModelAndView redireccion(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("buscarVerProducto");
        return (mv);
    }
    
    @Autowired
    private FacadeStock bpm;

    @RequestMapping(value = "busqueda.json",method = RequestMethod.GET)      
    public @ResponseBody List<DatosCompletosMedProdVO> buscarProducto (@RequestParam(value="buscar") String texto_buscar, @RequestParam(value="filtro") String filtro) throws ClassNotFoundException, SQLException, IOException, ParseException, java.text.ParseException{
        return bpm.buscarProducto(texto_buscar, filtro);
    }
    
    @RequestMapping(value = "ajustarStock.json",method = RequestMethod.GET)      
    public @ResponseBody List<DatosCompletosMedProdVO> ajustarStock () throws ClassNotFoundException, SQLException, IOException, ParseException, java.text.ParseException{
        return bpm.ajustarStock();
    }
    
    @RequestMapping(value ="search.htm",method = RequestMethod.POST)      
    public @ResponseBody void setProductoBuscar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String buscar= (String) request.getParameter("search");
        request.getSession().setAttribute("search", buscar); 
    }
}
