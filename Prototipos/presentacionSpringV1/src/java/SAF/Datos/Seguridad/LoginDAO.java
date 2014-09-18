/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.Datos.Seguridad;

import SAF.Datos.Abstract.AbstractDAO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Guillermo
 */
@Repository
public class LoginDAO extends AbstractDAO{
    
    public boolean validarUsuario(int codigo){
        if (codigo == 1)
            return true;
        return false;
    }
}
