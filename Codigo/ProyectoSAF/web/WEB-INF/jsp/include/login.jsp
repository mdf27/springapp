        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!-- Archivos javaScript -->
        <script src='Librerias/jquery.js' type='text/javascript'></script>
        <script type="text/javascript" src="js/validarLogin.js"></script>
        <link rel='stylesheet' href='CSS/login.css'>
        <div id="login">
		<%  
                    Object user =  request.getSession(true).getAttribute("codigoUsuario");
                    String resLogin = (String) request.getAttribute("resultadoLogin");
                    
                    out.print("<h2><span></span>Iniciar sesi�n</h2>");
                    if (user == null && resLogin == null ){        
                        out.print("<form action=\"controlLogin.html\" method=\"POST\">");
                        out.print("<fieldset>");
                        out.print("<p><label for=\"idUsuario\">Codigo de usuario</label></p>");
                        out.print("<p><input type=\"password\" id=\"idUsuario\" name=\"usuario\" value=\"Codigo de usuario\" onBlur=\"if(this.value=='')this.value='Codigo de usuario'\" onFocus=\"if(this.value=='Codigo de usuario')this.value=''\"></p>");
                        out.print("<div id=\"errorNombreCaracter\" class=\"errores\">Solo estan permitidos caracteres alfabeticos.</div>");
                        out.print("<div id=\"errorNombreVacio\" class=\"errores\">Debe ingresar algun codigo de usuario.</div>");	
                        out.print("<p><input type=\"submit\" value=\"Iniciar sesi�n\" id=\"botonLogin\"></p>");
                        out.print("</fieldset>");
                        out.print("</form>");
                    }
                    else{   
                        if (resLogin.equals("Exito")){
                            out.print("<form action=\"inicio.html\" method=\"POST\">");
                            out.print("<fieldset>");
                            out.print("<p id=\"exitoLogin\">Se a logeado de forma correcta.</p>");
                            out.print("<p><input type=\"submit\" value=\"Continuar\" id=\"botonLogin\"></p>");
                            out.print("</fieldset>");
                            out.print("</form>");
                        }
                        else{
                            
                            out.print("<form action=\"controlLogin.html\" method=\"POST\">");
                            out.print("<fieldset>");
                            out.print("<p id=\"errorLogin\">Error, usuario incorrecto</p>");
                            out.print("<p><label for=\"idUsuario\">Codigo de usuario</label></p>");
                            out.print("<p><input type=\"password\" id=\"idUsuario\" name=\"usuario\" value=\"Codigo de usuario\" onBlur=\"if(this.value=='')this.value='Codigo de usuario'\" onFocus=\"if(this.value=='Codigo de usuario')this.value=''\"></p>");
                            out.print("<div id=\"errorNombreCaracter\" class=\"errores\">Solo estan permitidos caracteres alfabeticos.</div>");
                            out.print("<div id=\"errorNombreVacio\" class=\"errores\">Debe ingresar algun codigo de usuario.</div>");
                            out.print("<p><input type=\"submit\" value=\"Iniciar sesi�n\" id=\"botonLogin\"></p>");
                            out.print("</fieldset>");
                            out.print("</form>");
                        }
                    }
                    
                
                %>                
                
		
	</div>
