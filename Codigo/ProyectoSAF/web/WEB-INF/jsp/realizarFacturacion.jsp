
<%@page import="SAF.Datos.Facturacion.TipoFacturaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Facturación</title>
        <link href="CSS/contenedorPrincipal.css" rel="stylesheet">    
        
        <!-- /menu -->
        <jsp:include page="include/menu.jsp"/>   
    </head>
    <body>
<% TipoFacturaDAO fd = new TipoFacturaDAO(); 
            short aux = 101;
            fd.insertarTipoFactura(aux, "Factura");
            aux = 102;
            fd.insertarTipoFactura(aux, "Nota de crédito");
            

%>
        
        <div id="contenedor">

            <div id = "leftColuma">  
                <jsp:include page="include/menuFacturacion.jsp"/>  
            </div>

            <script type="text/javascript">
                
            function getAway() {
                // Replace current site with another benign site
                window.location.replace('index.html');
            }

            $(function() {

                $("#get-away").on("click", function(e) {
                    getAway();
                });

                $("#get-away a").on("click", function(e) {
                    // allow the (?) link to work
                    e.stopPropagation();
                });

                $(document).keyup(function(e) {
                    if (e.keyCode == 27) { // escape key
                        getAway();
                    }
                });

            });
        </script>
        
            <div align="center" id ="contenedorPrincipal">
                <table width="90%">
                    <tr>
                        <td>
                            <!--Primera Linea-->
                            <table class="table table-bordered">
                                <tr class="well">
                                    <td>
                                        <div class="row-fluid"> 
                                            <div class="span6">
                                                <div class="row-fluid">
                                                    <i class="icon-user"></i><strong>Vendedor: </strong> <br>
                                                </div>
                                            </div>

                                            <div class="span6">
                                                <i class="icon-calendar"></i> <strong>Fecha: </strong> 
                                            </div>
                                            <!--
                                            <div class="span6">
                                                <form name="form2" action="" method="post">
                                                    <strong>Codigo o Nombre del Producto</strong><br>
                                                    <input type="text" autofocus list="browsers" name="buscar" autocomplete="off" class="input-xxlarge" required>
                                                    <datalist id="browsers">
                                                    </datalist>
                                                </form>
                                            </div>
                                            -->
                                        </div>
                                    </td>
                                </tr>
                                <tr >
                                    <td>
                                        <div class="span6">
                                            <form name="form2" action="" method="post">
                                                <strong class="textoLugarMedio" >Cliente</strong>
                                                <input type="text" autofocus list="browsers" name="buscar" autocomplete="off" class="input-medium" required>
                                                <datalist id="browsers">
                                                </datalist>
                                            </form>
                                        </div>
                                    </td>   
                                </tr>

                            </table>
                            <!--Fin Primera Linea-->


                        </td>
                    </tr>
                </table>  
            </div>
        </div>


    </body>
</html>
