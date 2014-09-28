/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Facade.Clientes;

import SAF.Logica.Clientes.ClienteManager;
import SAF.Logica.Seguridad.LoginManager;
import SAF.VO.Clientes.ClienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juanes
 */
@Service
public class FacadeClientes {
    @Autowired
    ClienteManager cm;
      
    public void registrarCliente(ClienteVO cli){
        cm.registrarCliente(cli);
   
    }
}
