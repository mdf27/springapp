/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Facade.Seguridad;

import SAF.Logica.Seguridad.LoginManager;
import SAF.VO.Seguridad.FuncionalidadVO;
import SAF.VO.Seguridad.PerfilVO;
import SAF.VO.Seguridad.UsuarioVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juanes
 */
@Service
public class FacadeSeguridad {
    @Autowired
    LoginManager lm;
      
    public boolean login(int codigo){
        return lm.login(codigo);
    }
    
    public UsuarioVO getUsuario(int codigo){
        return lm.getUsuario(codigo);
    }
    
    public List<FuncionalidadVO> getfuncionalidad(int codigo){
         return lm.getfuncionalidad(codigo);
     }
}
