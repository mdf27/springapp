/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Logica.Stock;

import SAF.Datos.Clientes.BuscarClienteDAO;
import SAF.Datos.Clientes.LuceneClientesDAO;
import SAF.VO.Clientes.DatosCompletosClienteVO;
import SAF.VO.Stock.DatosCompletosMedProdVO;
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
public class BuscarClienteManager {
    @Autowired
    private BuscarClienteDAO buscarDao;
    
    public Map <Integer,DatosCompletosClienteVO> buscarClientes(){
        return buscarDao.obtenerClientes();
    }

    
    @Transactional(rollbackFor=Exception.class)
    public List<DatosCompletosClienteVO> buscarCliente(String texto_buscar, String filtro) throws ClassNotFoundException, ParseException, SQLException, IOException, java.text.ParseException{
        LuceneClientesDAO ldao = LuceneClientesDAO.getInstance();
        if (!ldao.indiceCargado()){//indiceCargado?
            ldao.cargarClientes(buscarClientes());
        }          
    
        List<DatosCompletosClienteVO> salida = ldao.buscarCliente(texto_buscar, filtro);
        return salida;
    }    
}
