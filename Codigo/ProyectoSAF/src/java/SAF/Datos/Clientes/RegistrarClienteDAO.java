/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Clientes;

import SAF.Datos.Abstract.AbstractDAO;
import SAF.VO.Clientes.ClienteVO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juanes
 */
@Repository
public class RegistrarClienteDAO extends AbstractDAO{
    
    public void altaCliente(ClienteVO cli){
        
        //Genero sentencia SQL
        String sql = "INSERT INTO Cliente (nombres, apellidos, direccion, telefono, email,"
                + " cedula, razon_social, rut, descuento, fcreacion, idTransaccion)  "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";  
        Object[] parametros = new Object[]{cli.getNombres(),cli.getApellidos(),cli.getDireccion(),cli.getTelefono(),
        cli.getEmail(),cli.getCedula(),cli.getRazon_social(),cli.getRut(),cli.getDescuento(),cli.getFcreacion(),cli.getIdTransaccion()};
               
        getJdbcTemplate().update(sql, parametros);       
            
 
       

    }
    
}
