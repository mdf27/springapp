/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.Logica.Seguridad;

import SAF.Datos.Seguridad.LoginDAO;
import SAF.Datos.Seguridad.UsuarioDAO;
import SAF.Logica.Abstract.AbstractManejador;
import SAF.VO.Seguridad.FuncionalidadVO;
import SAF.VO.Seguridad.PerfilVO;
import SAF.VO.Seguridad.UsuarioVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Guillermo
 */
@Service
public class LoginManager extends AbstractManejador{
    
    @Autowired
    private LoginDAO loginDAO;
    @Autowired
    private UsuarioDAO usuarioDAO;

    
    @Transactional(rollbackFor = Exception.class)
    public boolean login(int codigo){
        return loginDAO.validarUsuario(codigo);
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public UsuarioVO getUsuario(int codigo){
        return usuarioDAO.devolverUsuario(codigo);
    }
    @Transactional(rollbackFor = Exception.class)
    public PerfilVO getRol(int codigo){
        return usuarioDAO.devolverRol(codigo);  
    }
    @Transactional(rollbackFor = Exception.class)
    public List<FuncionalidadVO> getfuncionalidad(int codigo){
        PerfilVO p = usuarioDAO.devolverRol(codigo);
        return usuarioDAO.devolverFuncionalidad(p);  
    }
    
}
