

package SAF.UI.Seguridad;

import SAF.Facade.Seguridad.FacadeSeguridad;
import SAF.VO.Seguridad.FuncionalidadVO;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



//@Service /*Service declarado a nivel de UI, por simplicidad de codigo*/
public class ControlDeAcceso {
      
    public static ControlDeAcceso instancia;
    
    @Autowired
    FacadeSeguridad facadeSeguridad; 
    
   
    public static ControlDeAcceso getInstancia(){
        if (instancia == null){
            instancia = new ControlDeAcceso();
        }
        return instancia;
    }
    
    
    
        /*Descripcion y Codigo De rol*/
        /*
        Manejo de usuario - MU
        Crear Nota de credito - CNC
        Realizar devolucion de productos - RDP
        Facturacion - F
        Manejo de Clientes - MCLI
        Crea cuenta corriente - CCC
        Modificaciones de stock y precio - MSP
        Ver productos - VP
        Ver recomendaciones - VR
        Ingresar compra - IC
        Realizar compra recomendacion - RCR
        Ver compras - VC
        Manejo de caja - MCaja
        Ver descuentos - VD
        Administrar descuentos - AD
        Actualizar stock y precios con DUSA - ASPD
        Configurar Alertas - CA
        */
    
    
    
    //Para casos no contemplados en el Modelo de datos, como ventana principal
    public boolean controlDeLogin(HttpSession session){
             Object cUsuario =  session.getAttribute("codigoUsuario");;
             return (cUsuario != null);      
    }

    //Para casos contemplados en el Modelo de datos
    public boolean controlDeSeguridadRol(HttpSession session,String codigoFuncionalidad){       
        
        int codigoUsuario;
        boolean encontro = false;
        Object cUsuario =  session.getAttribute("codigoUsuario");

        if (cUsuario != null){
            codigoUsuario = (int) cUsuario;
            List<FuncionalidadVO> lista = facadeSeguridad.getfuncionalidad(codigoUsuario);
            for (int i = 0;((i < lista.size()-1) && (!encontro)); i++){
                encontro = lista.get(i).getCodigo().equals(codigoFuncionalidad);
            }
            return encontro;            
        }
        else
            return false;  
    }
    

    
}
