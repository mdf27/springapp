/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAF.Datos.Seguridad;

import SAF.VO.Seguridad.FuncionalidadVO;
import SAF.VO.Seguridad.PerfilVO;
import SAF.VO.Seguridad.UsuarioVO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
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
    
        
    private static UsuarioDAO usuarioDao;    
    private static ApplicationContext context;

   
    /**
     * Test of validarUsuario method, of class LoginDAO.
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext("file:web/WEB-INF/dispatcher-servlet.xml");
        usuarioDao = (UsuarioDAO) context.getBean(UsuarioDAO.class);
    
    }

      /**
     *
     */
    @Test
    public void testDevolverUsuario() {
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

    /**




    /**
     * Test of devolverFuncionalidad method, of class UsuarioDAO.
     */
    @Test
    public void testDevolverFuncionalidad() {
        System.out.println("devolverFuncionalidad");
        PerfilVO id = new PerfilVO();
        id.setIdPerfil(2);
        List<FuncionalidadVO> expResult = new ArrayList();        
        FuncionalidadVO funcionalidad = new FuncionalidadVO();
        funcionalidad.setCodigo((String)"MU");
        funcionalidad.setDescripcion((String)"Manejo de usuario");
        funcionalidad.setIdFuncionalidad((int)0);
        expResult.add(funcionalidad);
        funcionalidad = new FuncionalidadVO();
        funcionalidad.setCodigo((String)"F");
        funcionalidad.setDescripcion((String)"Facturacion");
        funcionalidad.setIdFuncionalidad((int)3);
        expResult.add(funcionalidad);
        funcionalidad = new FuncionalidadVO();
        funcionalidad.setCodigo((String)"VP");
        funcionalidad.setDescripcion((String)"Ver productos");
        funcionalidad.setIdFuncionalidad((int)7);
        expResult.add(funcionalidad);
        funcionalidad = new FuncionalidadVO();
        funcionalidad.setCodigo((String)"VR");
        funcionalidad.setDescripcion((String)"Ver recomendaciones");
        funcionalidad.setIdFuncionalidad((int)8);
        expResult.add(funcionalidad);        
        funcionalidad = new FuncionalidadVO();
        funcionalidad.setCodigo((String)"IC");
        funcionalidad.setDescripcion((String)"Ingresar compra");
        funcionalidad.setIdFuncionalidad((int)9);
        expResult.add(funcionalidad);  
        funcionalidad = new FuncionalidadVO();
        funcionalidad.setCodigo((String)"VD");
        funcionalidad.setDescripcion((String)"Ver descuentos");
        funcionalidad.setIdFuncionalidad((int)13);
        expResult.add(funcionalidad);
        
        List<FuncionalidadVO> result = usuarioDao.devolverFuncionalidad(id);
        for (int i = 0; i < expResult.size(); i++) {
            assertEquals("func - perfil", expResult.get(i).getIdFuncionalidad(), result.get(i).getIdFuncionalidad());
            assertEquals("func - perfil", expResult.get(i).getDescripcion(), result.get(i).getDescripcion());
            assertEquals("func - perfil", expResult.get(i).getCodigo(), result.get(i).getCodigo());
        }
        
        
            

        
    }
    
}
