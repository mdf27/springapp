/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLayer.Stock;

import DataLayer.Stock.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Guillermo
 */
@Service
public class Manager {
    @Autowired
    private Stock1DAO dao1;
    @Autowired
    private Stock2DAO dao2;
    
    @Transactional()
    public void test(){
        dao1.altaProducto();
        //dao2.altaProveedor();
    }
}
