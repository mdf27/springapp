/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Facade.Stock;

import SAF.Logica.Stock.BuscarProductoManager;
<<<<<<< HEAD
import SAF.VO.Stock.DatosCompletosMedProdVO;
import SAF.VO.Stock.ProductoVO;
=======
import SAF.Logica.Stock.ModificarProductoManager;
import SAF.VO.Stock.DataInfoProductoVO;
>>>>>>> 63cb351baa2d31bd88135006a9cc942906cd89a1
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
    
<<<<<<< HEAD
    public List<DatosCompletosMedProdVO>  buscarProducto(String texto_buscar, String filtro) throws ClassNotFoundException, ParseException, SQLException, IOException, java.text.ParseException{
=======
//    @Autowired
//    ModificarProductoManager mpm;
    
    public String buscarProducto(String texto_buscar, String filtro) throws ClassNotFoundException, ParseException, SQLException, IOException, java.text.ParseException{
>>>>>>> 63cb351baa2d31bd88135006a9cc942906cd89a1
        return bpm.buscarProducto(texto_buscar, filtro);
    }
    
//    public void actualizarProductosDUSA(List<DataInfoProductoVO> productos) {
//        mpm.actualizarProductosDUSA(productos);
//    }    
}
