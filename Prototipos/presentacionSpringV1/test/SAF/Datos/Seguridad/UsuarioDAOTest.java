/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Seguridad;

import SAF.VO.Seguridad.PerfilVO;
import SAF.VO.Seguridad.UsuarioVO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Juanes
 */
public class UsuarioDAOTest {
    
    /**
     *
     */
    public UsuarioDAOTest() {
    }
    
        
    private UsuarioDAO usuarioDao;    
    private ApplicationContext context;
    
    
    /**
     * Test of validarUsuario method, of class LoginDAO.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext("file:web/WEB-INF/dispatcher-servlet.xml");
        usuarioDao = (UsuarioDAO) context.getBean(UsuarioDAO.class);
    
    }

    /**
     *
     */
    @Test
    public void testDevovlverUsuario() {
        System.out.println("devolverUsuario");
        int codigo = 0;
        UsuarioVO expResult = new UsuarioVO();
        expResult.setNombre("user1");
        UsuarioVO result = usuarioDao.devolverUsuario(codigo);
        assertNull(result);
        codigo = 1;
        expResult = new UsuarioVO();
        expResult.setNombre("user1");
        result = usuarioDao.devolverUsuario(codigo);        
        assertEquals(expResult.getNombre(), result.getNombre());
        String nom = result.getNombre();
        System.out.println(nom);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     *
     */
    @Test
    public void devolverRol(){
        System.out.println("devolverRol");
        int codigo = 0;
        PerfilVO result = usuarioDao.devolverRol(codigo);
        assertNull(result);
        codigo = 1;
        PerfilVO expResult = new PerfilVO();
        expResult.setDescripcion("Administrador");
        result = usuarioDao.devolverRol(codigo);        
        assertEquals(expResult.getDescripcion(), result.getDescripcion());
        String nom = result.getDescripcion();
        System.out.println(nom);
    }
    
}
