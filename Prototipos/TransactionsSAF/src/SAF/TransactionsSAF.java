/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF;

import BusinessLayer.Stock.Manager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Guillermo
 */
public class TransactionsSAF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("ApplicationContext.xml");
        Manager m = (Manager) context.getBean(Manager.class);
        m.test();
    }
    
}
