/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Seguridad;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Juanes
 */

public class LoginDAOTest {
    
    private LoginDAO loginDao;    
    private ApplicationContext context;
    
    
    /**
     * Test of validarUsuario method, of class LoginDAO.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext("file:web/WEB-INF/dispatcher-servlet.xml");
        loginDao = (LoginDAO) context.getBean(LoginDAO.class);
    
    }

    /**
     *
     */
    @Test
    public void testValidarUsuario() {
        System.out.println("validarUsuario");
        int codigo = 2;
        boolean expResult = false;
        boolean result = loginDao.validarUsuario(codigo);
        assertEquals(expResult, result);
        System.out.println("notexist");
        codigo = 1;
        expResult = true;
        result = loginDao.validarUsuario(codigo);
        assertEquals(expResult, result);
        System.out.println("exist");
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
