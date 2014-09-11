<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Facturacion</title>
        <link href="CSS/contenedorPrincipal.css" rel="stylesheet">
    </head>
    <body>
        <!-- /menu -->
        <jsp:include page="include/menu.jsp"/>   
        <div id="contenedor">

            <div id = "leftColuma">  
                <jsp:include page="include/menuFacturacion.jsp"/>  
            </div>

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
