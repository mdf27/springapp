      
     <link href="CSS/bootstrap.css" rel="stylesheet">
     <link href="CSS/bootstrap-responsive.css" rel="stylesheet">
     <link href="CSS/menu.css" rel="stylesheet">
     <script src="Librerias/jquery.js"></script>
     <script src="Librerias/bootstrap/bootstrap-dropdown.js"></script>
        

     
     <script type="text/javascript">
        $(document).ready(function() {
          $('#facturacion').on('click', function() { 
              $('#leftColuma').html('<div id = "tituloLeftMenu">Facturacion</div> <ul id="leftMenu"> <li><a href="realizarFacturacion.html"><i class="icon-plus"></i>Realizar factura</a></li><li><a href="#"><i class="icon-plus"></i>Crear nota de cr�dito</a></li> <li><a href="#"><i class="icon-search"></i>Facturas</a></li> <li class="divider"></li> <li><a href="#"><i class="icon-inbox"></i>Cerrar caja</a></li></ul>');
          });
          
          $('#stock').on('click', function() {      
              $('#leftColuma').html('<div id = "tituloLeftMenu">Productos</div><ul id="leftMenu"><li><a href="#"><i class="icon-search"></i>Productos</a></li><li><a href="#"><i class="icon-plus"></i>Alta producto</a></li><li><a href="#"><i class="icon-search"></i>Descuntos</a></li> <li><a href="#"><i class="icon-plus"></i>Alta descuento</a></li><li><a href="#"><i class="icon-search"></i>Proveedores</a></li><li><a href="#"><i class="icon-plus"></i>Alta proveedor</a></li><li><a href="#"><i class="icon-refresh"></i>Actualizar base de datos</a></li></ul>');
          });
          
        
        });
     </script>  
     

     
    <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="brand" href="#" style="color:#FFF">Drogueria Uruguay</a>
                    <div class="nav-collapse collapse">
                        
                        <ul class="nav">                                      
                            <li><a href="inicio.html" style="color:#FFF">Principal</a></li>                                                                            
                            <li><a href="#" id="facturacion" style="color:#FFF">Facturaci�n</a></li> 
                            <li><a href="#" id="stock" style="color:#FFF">Stock</a></li> 

                            <li><a href="#" style="color:#FFF">Compras</a></li> 
                            <li><a href="#" style="color:#FFF">Clientes</a></li>   

                            <li><a href="#" style="color:#FFF">Reponer Stock</a></li> 
                            <li class="dropdown">
                                <a href="#" style="color:#FFF" class="dropdown-toggle" data-toggle="dropdown">M�s<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#"><i class="icon-signal"></i>Estadisticas</a></li>
                                    <li><a href="#"><i class="icon-wrench"></i>Ajustes</a></li>
                                </ul>
                            </li>    
                        </ul>
                        
                    </div><!--/.nav-collapse -->
                    <div id = "buscador"> 
                        <form action="�" method="post" >
                            <input type="search" placeholder="buscar..." name="busqueda" >
                            <input  value="Ir" type="submit" class="btn btn-default">         
                        </form>
                    </div>
                </div>
            </div>
        </div>

     

        
        
    