<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html lang="es">
<head>
	<title>Login</title>
        <link rel='stylesheet' href='CSS/login.css'>
        <link rel='stylesheet' href='CSS/contenedorPrincipal.css'>
        <script src='Librerias/jquery.js' type='text/javascript'></script>
      
</head>

<body>
    
        <!-- /menu -->
        <jsp:include page="menu.jsp"/>  
    
        <div id = "leftColuma">  
                <div id = "tituloLeftMenu">Facturación</div>
                <ul id="leftMenu">
                    <li><a href="realizarFacturacion.jsp"><i class="icon-plus"></i>Realizar factura</a></li>
                    <li><a href="#"><i class="icon-plus"></i>Crear nota de crédito</a></li>
                    <li><a href="#"><i class="icon-search"></i>Facturas</a></li>
                    <li class="divider"></li>
                    <li><a href="#"><i class="icon-inbox"></i>Cerrar caja</a></li>
                </ul>
        </div>
        
	<div id="login">
		<h2><span></span>Iniciar sesión</h2>
		<form action="ValidarUsuario;" method="POST">
                        <fieldset>
				<p><label for="idUsuario">Nombre de usuario</label></p>
				<p><input type="text" id="idUsuario" name="usuario" value="Nombre de usuario" onBlur="if(this.value=='')this.value='Nombre de usuario'" onFocus="if(this.value=='Nombre de usuario')this.value=''"></p> 				        
                                <div id="errorNombreCaracter" class="errores">Solo estan permitidos caracteres alfabeticos.</div>                     
                                <div id="errorNombreVacio" class="errores">Debe ingresar algun el nombre de usuario.</div>
                                <p><label for="password">Password</label></p>
				<p><input type="password" id="password" name="password" value="password" onBlur="if(this.value=='')this.value='password'" onFocus="if(this.value=='password')this.value=''"></p> 	
                                <p><input type="submit" value="Iniciar sesión" id="botonLogin"></p>
			</fieldset>
		</form>
	</div>
    
     <!-- Archivos javaScript -->
    <script type="text/javascript" src="js/validarLogin.js"></script>
</body>	
</html>
