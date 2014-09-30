<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src='Librerias/jquery.js' type='text/javascript'></script>
        <link href="CSS/contenedorPrincipal.css" rel="stylesheet">
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
                <h1 class="text-info">Productos Actualizados con EXITO!</h1><br>
                
                <h3> <u>Última actualización</u> </h3>
                
                <p>Fecha </p> 
                
                <p>Reporte de Actualización: </p>
                
                <c:forEach items="${productosActualizados}" var="map">
                    
                    <c:if test="${map.key == 'agregados'}">
                    <c:forEach items="${map.value}" var="prod">
                        Se agregó un nuevo producto, ${prod.getDescripcion()}.
                        <br/>
                    </c:forEach>
                    </c:if>  
                        
                    <c:if test="${map.key == 'aumentaron'}">
                    <c:forEach items="${map.value}" var="prod">
                        ${prod.getDescripcion()} aumentó algo.
                        <br/>
                    </c:forEach>
                    </c:if>  
                        
                    <c:if test="${map.key == 'disminuyeron'}">
                    <c:forEach items="${map.value}" var="prod">
                        ${prod.getDescripcion()} disminuyó algo.
                        <br/>
                    </c:forEach>  
                    </c:if>   
                     
                    <c:if test="${map.key == 'habilitaron'}">
                    <c:forEach items="${map.value}" var="prod">
                        ${prod.getDescripcion()} se habilitó
                        <br/>
                    </c:forEach>
                    </c:if>  
                        
                    <c:if test="${map.key == 'deshabilitaron'}">
                    <c:forEach items="${map.value}" var="prod">
                        ${prod.getDescripcion()} se deshabilitó
                        <br/>
                    </c:forEach>  
                    </c:if>     
                </c:forEach>
            </div>
        
        </div>
        
        
        
        
        
        
    </body>
</html>
