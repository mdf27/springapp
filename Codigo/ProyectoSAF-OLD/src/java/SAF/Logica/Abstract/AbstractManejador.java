/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.Logica.Abstract;

import SAF.Datos.Abstract.TransaccionDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Guillermo
 */
public abstract class AbstractManejador {
    
    @Autowired
    private TransaccionDAO daoTransaccion;
    
    protected long getIDTransaccion(){
        long retorno = Long.MIN_VALUE;
        
        //TODO: Obtener id de usuario de contexto
        int idUsuario = 1;
        
        daoTransaccion.getIDTransaccion(idUsuario);
        
        return retorno;
    }
}
