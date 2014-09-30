/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Facade.Clientes;

import SAF.Logica.Stock.BuscarClienteManager;
import SAF.Logica.Stock.ModificarProductoManager;
import SAF.VO.Clientes.DatosCompletosClienteVO;
import SAF.VO.Stock.DatosCompletosMedProdVO;
import SAF.VO.Stock.ProductoVO;
import SAF.VO.Stock.StockVO;
import java.io.IOException;
import java.sql.SQLException;
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
public class FacadeBuscarCliente {
    @Autowired
    BuscarClienteManager buscarClienteManager;

    public List<DatosCompletosClienteVO> buscarCliente(String texto_buscar, String filtro) throws ClassNotFoundException, ParseException, SQLException, IOException, java.text.ParseException{
        return buscarClienteManager.buscarCliente(texto_buscar, filtro);
    }
}