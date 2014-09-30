<%-- 
    Document   : ajustarStock
    Created on : 27-sep-2014, 14:35:16
    Author     : majo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src='Librerias/jquery.js' type='text/javascript'></script>
        <link href="CSS/contenedorPrincipal.css" rel="stylesheet">
        <title>Ajustar Stock</title>
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
    </head>
    <body>
        <div id = "leftColuma"> <jsp:directive.include file="include/menuPrincipal.jsp"/>  </div>
        
        <!-- %request.getSession().setAttribute("menuBuscar","false");%-->
        <jsp:include page="include/menu.jsp"/>  
        <div id="contenedor">
            <div id ="contenedorPrincipal" align="center"> <jsp:directive.include file="include/ajustarStock.jsp"/>  </div> 
        </div>   
        <script id="buscarScript" type="text/javascript" language="javascript" charset="utf-8" src="Librerias/ajustarStock/ajustarKO.js"></script>

    </body>
</html>
