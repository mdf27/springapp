/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAF.Datos.Stock;

import java.util.Iterator;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import uy.com.dusa.ws.DataLaboratorio;

/**
 *
 * @author esti
 */
public class ActualizacionServiceTest {
    
    private ActualizarProductoDAO productoDao;    
    private ApplicationContext context;
    private ActualizacionService service;

    @Before
    public void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext("file:web/WEB-INF/dispatcher-servlet.xml");
        productoDao = (ActualizarProductoDAO) context.getBean(ActualizarProductoDAO.class);
        service = (ActualizacionService) context.getBean(ActualizacionService.class);
    
    }

    /**
     * Test of obtenerActualizacionDUSA method, of class ActualizacionService.
     */
    @Test
    public void testObtenerActualizacionDUSA() {
        List <DataLaboratorio> labs = service.obtenerLaboratoriosDUSA();
        Iterator it = labs.iterator();
        DataLaboratorio lab;
//        int no = 969;
//        while(it.hasNext() && no < 1362) {
//            it.next();
//            no ++;
//        }
        // contando desde 50 me falto agregar el 443: FUP
        // FUPI(FABRICA URUGUAYA DE PROTECCIONES INDUSTRIALES)
        // porque el nombre era muy largo!!!
        while (it.hasNext()){
            lab = (DataLaboratorio) it.next();
            productoDao.agregarLaboratorio(lab.getIdLaboratorio(),labs);
        }
    }

    
}
