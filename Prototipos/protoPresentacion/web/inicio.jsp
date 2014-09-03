<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src='Librerias/jquery.js' type='text/javascript'></script>
         <link href="CSS/bootstrap.css" rel="stylesheet">
          <link href="CSS/principal.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>

       
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="brand" href="#" style="color:#FFF">Drogueria Uruguay</a>
                    <div class="nav-collapse collapse">
                        
                        <ul class="nav">
                            <li><a href="inicio.jsp" style="color:#FFF">Principal</a></li>
                            <li><a href="#" style="color:#FFF">Facturación</a></li> 
                            <li><a href="#" style="color:#FFF">Clientes</a></li> 
                            <li><a href="#" style="color:#FFF">Stock</a></li> 
                            <li><a href="#" style="color:#FFF">Compras</a></li>                            
                            <li><a href="#" style="color:#FFF">Estadisticas</a></li> 
                            <li><a href="#" style="color:#FFF">Ajustes</a></li> 
                        </ul>
                       
                        <!--Nada por ahora -->
                        
                        <ul class="nav pull-right">
                            <li class="dropdown">
                                <a href="#" style="color:#FFF" class="dropdown-toggle" data-toggle="dropdown">
                                    Hola! <?php echo $_SESSION['user_name']; ?> <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a href="perfil.php"><i class="icon-user"></i> Mi Perfil</a></li>
                                    <li class="divider"></li>
                                    <li><a href="php_cerrar.php"><i class="icon-off"></i> Salir</a></li>
                                </ul>
                            </li>
                        </ul>
                        
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>
               
        <!-- /container -->
        
        
        <div id ="contenedorPrincipal" align="center">
            <img src="img/Sin_logo.png"><br>
            <h1 class="text-info">Bienvenido al Sistema</h1><br>
        </div>

        
        
        
        
        
        
    </body>
</html>
