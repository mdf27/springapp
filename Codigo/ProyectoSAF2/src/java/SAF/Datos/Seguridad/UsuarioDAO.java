/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Seguridad;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Seguridad.FuncionalidadVO;
import SAF.VO.Seguridad.PerfilVO;
import SAF.VO.Seguridad.UsuarioVO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juanes
 */
@Repository
public class UsuarioDAO extends AbstractDAO{
    
    public UsuarioVO devolverUsuario(int codigo){
        
        String sql = "select * from usuario where codigo=?"; 
        try{
                UsuarioVO usuario = (UsuarioVO)getJdbcTemplate().queryForObject(
                sql, new Object[] { codigo }, new BeanPropertyRowMapper(UsuarioVO.class));  
                              
                
            return usuario;
            
        }catch (EmptyResultDataAccessException e) {
		return null;
	}   
    }
    public PerfilVO devolverRol(int codigo){
        String sql = "select p.idPerfil,p.descripcion from\n"+
                "perfilUsuario pu , perfil p where\n" +
                "pu.idPerfil = p.idperfil and idUsuario in\n" +
                "(select idUsuario from usuario where codigo = ?)";

        try{
                PerfilVO perfil = (PerfilVO)getJdbcTemplate().queryForObject(
                sql, new Object[] { codigo }, new BeanPropertyRowMapper(PerfilVO.class));          
            return perfil;
            
        }catch (EmptyResultDataAccessException e) {
		return null;
	}
    }
    public List<FuncionalidadVO> devolverFuncionalidad(PerfilVO id){
        String sql = "SELECT * FROM funcionalidad WHERE\n" +
                "idFuncionalidad in (SELECT idFuncionalidad\n" +
                "FROM funcionalidadperfil WHERE idPerfil = ?)";
        Object[] parametros = new Object[]{id.getIdPerfil()};
        List<FuncionalidadVO> funcionalidades = new ArrayList<>();
        
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,parametros);   
        for (Map row : rows) {
                FuncionalidadVO funcionalidad = new FuncionalidadVO();
                funcionalidad.setIdFuncionalidad((int)(row.get("idFuncionalidad")));
                funcionalidad.setDescripcion((String)(row.get("descripcion")));
                funcionalidad.setCodigo((String)(row.get("codigo")));
                funcionalidades.add(funcionalidad);
        }
        return funcionalidades;

    }
    

}
