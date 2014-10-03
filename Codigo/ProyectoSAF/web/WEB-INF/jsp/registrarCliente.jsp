

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
                <form  method = "POST">
                    <table width="264" >
                          <tr>
                            <td width="108"><div align="center"><strong>Nombres</strong></div></td>
                            <td width="144">                             
                                <input title = "Debe ingresar al menos un nombre" required class="input-large" data-bind="value:nombres"/>                            </td>
                          </tr>
                           <tr>
                            <td><div align="center"><strong>Apellidos</strong></div></td>
                            <td><input class="input-large" name="apellidos" data-bind="value:apellidos"/>
                            </td>
                          </tr>
                          <tr>
                            <td><div align="center"><strong>Cedula</strong></div></td>
                            <td>
                                <input type="text" required="required" maxlength="8" pattern="[d ]{8,}" class="input-large" data-bind="value:cedula"/>                            </td>
                          </tr>
                          <tr>
                            <td><div align="center"><strong>Direccion</strong></div></td>
                            <td>          
                                <input class="input-large" data-bind="value:direccion"/>                            </td>
                          </tr>
                          <tr>
                            <td><div align="center"><strong>Telefono</strong></div></td>
                            <td>
                                <input class="input-large" data-bind="value:telefono"/>                            </td>
                          </tr>
                          <tr>
                              <td><div align="center"><strong>E-mail</strong></div></td>
                            <td>
                                <input type="email" placeholder="name@example.com" required="required" class="input-large" data-bind="value:email"/>                            </td>
                          </tr>
                          <tr>
                            <td><div align="center"><strong>Raz&oacute;n Social</strong></div>
                               <div align="center"></div></td>
                            <td>
                                <input class="input-large" data-bind="value:razon_social"/>                            </td>
                          </tr>
                          <tr>
                            <td><div align="center"><strong>RUT</strong></div></td>
                            <td>
                                <input class="input-large" data-bind="value:rut"/>                            </td>
                          </tr>
                          <tr>
                            <td><div align="center"><strong>Descuento</strong></div></td>
                            <td>
                                <input class="input-large" data-bind="value:descuento"/>                            </td>
                          </tr>
                    </table>                   

                        <div align="center"></div>
                        <div align="center">
                          <button type="submit" class="btn btn-primary" data-bind="click:altaCliente">Ingresar</button>
                        </div>
                </form>   

            </div>    
        </div>  
        <script type="text/javascript" language="javascript" charset="utf-8" src="Librerias/Clientes/ClienteKO.js"></script>
    </body>
</html>
