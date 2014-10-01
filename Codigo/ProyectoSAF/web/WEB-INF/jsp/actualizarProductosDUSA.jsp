<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src='Librerias/jquery.js' type='text/javascript'></script>
        <link href="CSS/contenedorPrincipal.css" rel="stylesheet">
        <script src="Librerias/jquery.js"></script>
        <script type="text/javascript" language="javascript" charset="utf-8" src="Librerias/buscarProducto/knockout-3.0.0.js"></script>
        <script type="text/javascript" language="javascript" src="Librerias/buscarProducto/jquery-1.11.1.min.js"></script>
        <title>Actualizar Productos DUSA</title>
        <script type="text/javascript">            
           $(document).ready(function() {
             $('#facturacion').on('click', function() { 
                 $('#leftColuma').html('<div id = "tituloLeftMenu">Facturacion</div> <ul id="leftMenu"> <li><a href="realizarFacturacion.html"><i class="icon-plus"></i>Realizar factura</a></li><li><a href="#"><i class="icon-plus"></i>Crear nota de crédito</a></li> <li><a href="#"><i class="icon-search"></i>Facturas</a></li> <li class="divider"></li> <li><a href="#"><i class="icon-inbox"></i>Cerrar caja</a></li></ul>');
             });

             $('#stock').on('click', function() {      
                 $('#leftColuma').html('<div id = "tituloLeftMenu">Productos</div><ul id="leftMenu"><li><a href="#"><i class="icon-search"></i>Productos</a></li><li><a href="#"><i class="icon-plus"></i>Alta producto</a></li><li><a href="#"><i class="icon-search"></i>Descuntos</a></li> <li><a href="#"><i class="icon-plus"></i>Alta descuento</a></li><li><a href="#"><i class="icon-search"></i>Proveedores</a></li><li><a href="#"><i class="icon-plus"></i>Alta proveedor</a></li><li><a href="#"><i class="icon-refresh"></i>Actualizar base de datos</a></li></ul>');
             });


           });
        </script>  
    </head>
    <body>
        
        <!-- /menu -->
        <jsp:include page="include/menu.jsp"/>  
        
        <div id="contenedor">
            
              <!-- /container -->
            <!-- <div id ="contenedorPrincipal" align="center">   --> 
            <div id ="contenedorPrincipal"> 
                <h3> Actualizar base de datos </h3> <button data-bind="click: $root.actualizar()">Actualizar</button>
                
                <h5> <u>Última actualización</u> </h5>
                
                Fecha: <p data-bind="text: $root.fechaActualizar"></p> 
                
                <div  data-bind="visible: $root.mostrarVerActualizacion"> <jsp:directive.include file="include/verActualizacionDUSA.jsp"/> </div>
                <script id="actualizarScript" type="text/javascript" language="javascript" charset="utf-8" src="Librerias/actualizarProductos/actualizarKO.js"></script>
       
            </div>
        
        </div>
        
        
        
        
        
        
    </body>
</html>
