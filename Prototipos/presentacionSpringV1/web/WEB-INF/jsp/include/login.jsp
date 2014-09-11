        <!-- Archivos javaScript -->
        <script src='Librerias/jquery.js' type='text/javascript'></script>
        <script type="text/javascript" src="js/validarLogin.js"></script>
        <link rel='stylesheet' href='CSS/login.css'>
        <div id="login">
		<h2><span></span>Iniciar sesión</h2>
		<form action="inicio.html" method="POST">
                        <fieldset>
				<p><label for="idUsuario">Codigo de usuario</label></p>
				<p><input type="password" id="idUsuario" name="usuario" value="Codigo de usuario" onBlur="if(this.value=='')this.value='Codigo de usuario'" onFocus="if(this.value=='Codigo de usuario')this.value=''"></p> 				        
                                <div id="errorNombreCaracter" class="errores">Solo estan permitidos caracteres alfabeticos.</div>                     
                                <div id="errorNombreVacio" class="errores">Debe ingresar algun codigo de usuario.</div>	
                                <p><input type="submit" value="Iniciar sesión" id="botonLogin"></p>
			</fieldset>
		</form>
	</div>
