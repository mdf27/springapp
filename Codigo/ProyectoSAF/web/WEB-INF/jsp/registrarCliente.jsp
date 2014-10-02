

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<title>Registrar Cliente</title>
        <link rel='stylesheet' href='CSS/contenedorPrincipal.css'>
        <link href="CSS/bootstrap.css" rel="stylesheet">
        <link href="CSS/bootstrap-responsive.css" rel="stylesheet">
        <script type="text/javascript" language="javascript" src="Librerias/buscarProducto/knockout-3.0.0.js"></script>
        <script type="text/javascript" language="javascript" src="Librerias/buscarProducto/jquery-1.11.1.min.js"></script>
        <jsp:include page="include/menu.jsp"/>   
    </head>
    <body>
        <div id="contenedor">
            <div id = "leftColuma">
                <jsp:include page="include/menuClientes.jsp"/> 
            </div>
            <div id ="contenedorPrincipal" >    
                <form data-bind="submit:$root.registrarCliente()" method = "POST">
                    <table width="264" >
                          <tr>
                            <td width="108"><div align="center">Nombres</div></td>
                            <td width="144">                             
                                <input data-bind="textInput:nombre"/>
                            </td>
                          </tr>
                          <tr>
                            <td><div align="center">Apellidos</div></td>
                            <td>
                                <input name="apellidos" data-bind="textInput:apellidos"/>
                            </td>
                          </tr>
                          <tr>
                            <td><div align="center">Cedula</div></td>
                            <td>
                                <input name="cedula" data-bind="textInput:cedula"/>
                            </td>
                          </tr>
                          <tr>
                            <td><div align="center">Direccion</div></td>
                            <td>          
                                <input name="direccion" data-bind="textInput:direccion"/>
                            </td>
                          </tr>
                          <tr>
                            <td><div align="center">Telefono</div></td>
                            <td>
                                <input name="telefono" data-bind="textInput:telefono"/>
                            </td>
                          </tr>
                          <tr>
                            <td><div align="center">E-mail</div></td>
                            <td>
                                <input name="email" data-bind="textInput:email"/>
                            </td>
                          </tr>
                          <tr>
                            <td><div align="center">Raz&oacute;n Social</div>
                               <div align="center"></div></td>
                            <td>
                                <input name="razon_social" data-bind="textInput:razon_social"/>
                            </td>
                          </tr>
                          <tr>
                            <td><div align="center">RUT</div></td>
                            <td>
                                <input name="rut" data-bind="textInput:rut"/>
                            </td>
                          </tr>
                          <tr>
                            <td><div align="center">Descuento</div></td>
                            <td>
                                <input name="descuento" data-bind="textInput:descuento"/>
                            </td>
                          </tr>
                    </table> 
                        <div align="center">
                          <button type="submit" class="btn btn-primary" >Ingresar</button>
                        </div>
                </form>   

            </div>    
        </div>  
        <script type="text/javascript" language="javascript" charset="utf-8" src="Librerias/Clientes/ClienteKO.js"></script>
    </body>
</html>
