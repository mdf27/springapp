/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.Datos.Facturacion;

import SAF.Datos.Seguridad.UsuarioDAO;
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
 * @author Fernanda
 */
public class TipoFacturaDAOTest {
    
      
    /**
     *
     */
    
        
    private TipoFacturaDAO tipoFacturaDao;    
    private ApplicationContext context;
    
    
    /**
     * Test of validarUsuario method, of class LoginDAO.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext("file:web/WEB-INF/dispatcher-servlet.xml");
        tipoFacturaDao = (TipoFacturaDAO) context.getBean(TipoFacturaDAO.class);
    
    }
    @Test
    public void testInsertarTipoFactura() {
        System.out.println("insertarTipoFactura");
        short idTipoFactura = 102;
        String descripcion = "Nota_de_credito";
      //  TipoFacturaDAO instance = new TipoFacturaDAO();
        tipoFacturaDao.insertarTipoFactura(idTipoFactura, descripcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
