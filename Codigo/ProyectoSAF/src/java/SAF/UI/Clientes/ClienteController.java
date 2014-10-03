/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.UI.Clientes;

import SAF.Facade.Clientes.FacadeBuscarCliente;
import SAF.Facade.Clientes.FacadeClientes;
import SAF.VO.Clientes.ClienteVO;
import SAF.VO.Clientes.DatosCompletosClienteVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
 * @author Juanes
 */

@Controller
public class ClienteController {
    
    @Autowired
    FacadeBuscarCliente buscarClienteFacade;
    
    @Autowired
    FacadeClientes facadeCliente;
    
    @RequestMapping(value = "registrarCliente")
    public ModelAndView redireccion(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("registrarCliente");
        return (mv);
    }
    
     @RequestMapping(value = "buscarCliente.json",method = RequestMethod.GET)      
    public @ResponseBody List<DatosCompletosClienteVO> buscarProducto (@RequestParam(value="buscar") String texto_buscar, @RequestParam(value="filtro") String filtro) throws ClassNotFoundException, SQLException, IOException, ParseException, java.text.ParseException{
        return buscarClienteFacade.buscarCliente(texto_buscar, filtro);
    }
    
    /**
     *
     * @param json
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "guardarCliente.htm", method = RequestMethod.POST)
    public @ResponseBody void guardarCliente(String json) throws IOException {
        ClienteVO cliente = new ObjectMapper().readValue(json, ClienteVO.class);
        facadeCliente.registrarCliente(cliente);
    }
    
    
}
    
