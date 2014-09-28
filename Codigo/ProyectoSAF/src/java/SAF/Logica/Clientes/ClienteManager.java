/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Logica.Clientes;

import SAF.Datos.Clientes.RegistrarClienteDAO;
import SAF.Logica.Abstract.AbstractManejador;
import SAF.VO.Clientes.ClienteVO;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Juanes
 */
@Service
public class ClienteManager extends AbstractManejador{
    
    @Autowired
    private RegistrarClienteDAO clienteDAO;
    
    @Transactional(rollbackFor = Exception.class)
    public void registrarCliente(ClienteVO cli){
        //super.getIDTransaccion();
        BigInteger idT = BigInteger.valueOf(0);
        cli.setIdTransaccion(idT);
        clienteDAO.altaCliente(cli);
    }
    
}
