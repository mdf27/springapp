<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src='Librerias/jquery.js' type='text/javascript'></script>
        <link href="CSS/contenedorPrincipal.css" rel="stylesheet">
        <title>Inicio</title>
        <link href="CSS/bootstrap.css" rel="stylesheet">
        <link href="CSS/bootstrap-responsive.css" rel="stylesheet">
        <link href="CSS/menu.css" rel="�ndezstylesheet">
        <script src="Librerias/jquery.js"></script>
        <script src="Librerias/bootstrap/bootstrap-dropdown.js"></script>

        <script type="text/javascript" language="javascript" charset="utf-8" src="Librerias/buscarProducto/knockout-3.0.0.js"></script>
        <script type="text/javascript" language="javascript" src="Librerias/buscarProducto/jquery-1.11.1.min.js"></script>
        <link rel="stylesheet" href="CSS/style.css" />         
        <link rel="stylesheet" href="CSS/bootstrap.css" />         
        <link rel="stylesheet" href="CSS/search_box.css" />     

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
        
        <div id = "leftColuma"> <jsp:include page="include/menuPrincipal.jsp"/>  </div>
        
        <%request.getSession().setAttribute("menuBuscar","false");%>
        <jsp:include page="include/menu.jsp"/>  
        <div id="contenedor">
            <div id ="contenedorPrincipal" align="center" data-bind="visible: $root.mostrarBuscar"> <jsp:include page="include/buscarProducto.jsp"/>  </div>
            <div style="margin-left: 300px !important; margin-top: 100px !important" id ="contenedorPrincipal" align="center" data-bind="if: $root.selectedResult,visible: $root.mostrarVer"> <jsp:include page="include/verProducto.jsp"/>  </div>
        </div>   
        <script id="buscarScript" type="text/javascript" language="javascript" charset="utf-8" src="Librerias/buscarProducto/buscarKO.js"></script>
    </body>
    
    
    
</html>
