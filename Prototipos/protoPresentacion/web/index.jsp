<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="es">
<head>
	<meta charset="utf-8">
	<title>Login</title>
        <link rel='stylesheet' href='CSS/login.css'>
         <script src='Librerias/jquery.js' type='text/javascript'></script>
      
</head>

<body>
	<div id="login">
		<h2><span class="fontawesome-lock"></span>Iniciar sesión</h2>
		<form action="ValidarUsuario;" method="POST">
			
                    
                        <fieldset>
				<p><label for="ID">Nombre de usuario</label></p>
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
