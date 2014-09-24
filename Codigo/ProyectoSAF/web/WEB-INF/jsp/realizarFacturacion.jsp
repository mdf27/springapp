
<%@page import="SAF.Datos.Facturacion.TipoFacturaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Facturación</title>
        <link href="CSS/contenedorPrincipal.css" rel="stylesheet">
        <script type="text/javascript" language="javascript" src="Librerias/buscarProducto/knockout-3.0.0.js"></script>
        <script type="text/javascript" language="javascript" src="Librerias/buscarProducto/jquery-1.11.1.min.js"></script>

        <!-- /menu -->
        <jsp:include page="include/menu.jsp"/>   
    </head>
    <body>
        <%-- 
       <% TipoFacturaDAO fd = new TipoFacturaDAO(); 
                   short aux = 101;
                   fd.insertarTipoFactura(aux, "Factura");
                   aux = 102;
                   fd.insertarTipoFactura(aux, "Nota de crédito");
                   

%>
        --%>

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


            <div id ="contenedorPrincipal" align="center" data-bind="visible: $root.buscarProd"> <jsp:include page="include/buscarProductoFactura.jsp"/>  </div>
            <div id ="contenedorPrincipal" align="center" data-bind="visible: $root.realizandoFactura">
                <div id="rF">

                    <table width="100%">
                        <tr>
                            <td>
                                <!--Primera Linea-->
                                <table>
                                    <%-- Fila 1 --%>
                                    <tr>


                                        <td>
                                            <i class="icon-user"></i>&nbsp<strong>Cajero: </strong> 
                                        </td>
                                        <td>
                                            <i class="icon-calendar"></i>&nbsp <strong>Fecha: </strong>
                                        </td>

                                    </tr>
                                    <tr>
                                        <td><br><i class="icon-user"></i>&nbsp<strong> Vendedor &nbsp &nbsp</strong><select data-bind="options: $root.vendedores, value: vendedor, optionsText: 'nombreVendedor'"></select></td>
                                    </tr>
                                    <%-- Fila 2 --%>
                                    <%--
                                    <tr>
                                            <td>
                                                    <div class="row-fluid">
                                                            <form name="form2" action="" method="post">
                                                                    <strong class="textoLugarMedio" >Cliente</strong>
                                                                    <input type="text" autofocus list="browsers" name="buscar" autocomplete="off" class="input-medium" required>
                                                                    <datalist id="browsers">
                                                                    </datalist>
                                                            </form>
                                                            
                                                    </div>
                                            </td>  
                                            <td>
                                                    <input type="submit" value="Nuevo cliente" />
                                            </td>
                                    </tr>
                                    --%>
                                    <%-- Fila 3 --%>
                                    <%--
                                    <tr >
                                    <table>
                                            <tbody>
                                                    <tr>                                       
                                                            <td> <strong>RUT </strong><input type="checkbox" name="RUT" value="ON" /> </td>
                                                            <td> <strong>Razón social</strong><input type="text" name="rSocial" value="" /></td>
                                                            <td> <strong>RUT</strong> <input type="text" name="rut" value="" /></td>
                                                    
                                                    </tr>
                                            </tbody>
                                    </table>
                                    </tr>
                                    --%>
                                    <%-- Fila 4 --%>
                                    <tr>

                                        <td>
                                            <div >
                                                <form name="form2" action="" method="post">
                                                    <br><br><i class="icon-barcode"></i>&nbsp<strong> Producto &nbsp &nbsp</strong><input type="text" autofocus list="browsers" name="buscar" autocomplete="off" class="input-xlarge" required 
                                                                                                                                          data-bind="value: textoProducto, valueUpdate: 'input', executeOnEnter: buscarProducto" 
                                                                                                                                          placeholder="Ingrese nombre o codigo del producto"/>
                                                </form>
                                            </div> 
                                        </td>
                                        <td> 
                                            <button class="btn btn-primary" data-bind="click: buscarProducto">Buscar el puto producto</button> <br>
                                        </td>

                                    </tr>
                                    <%-- Fila 5 --%>
                                    <tr>

                                        <%-- Tabla productos--%>
                                        <td width="70%">
                                            <br>
                                            <table class="table table-bordered">
                                                <thead>
                                                        <th>Cantidad</th>
                                                        <th>Nombre</th>
                                                        <th>Precio</th>
                                                        <th>Descuento</th>
                                                        <th>Receta</th>
                                                        <th>Precio venta</th>
                                                        <th>Subtotal</th>
                                                </thead>
                                                <tbody data-bind="foreach: renglonesFactura">
                                                    <tr>
                                                        <td ><strong data-bind="text: cantidad" /></td> <%--Cantidad --%>
                                                        <td ><strong data-bind="text: descripcion" /></td> <%--Nombre --%>
                                                        <td ><strong data-bind="text: precio" /></td> <%--Precio --%>
                                                        <td ><strong data-bind="text: descuento" /></td> <%--Descuento --%>
                                                        <td ><strong data-bind="text: receta" /></td> <%--Receta --%>
                                                        <td ><strong data-bind="text: precioVenta" /></td> <%--Precio venta --%>
                                                        <td ><strong data-bind="text: subtotal" /></td> <%--Subtotal --%>
                                                        
                                                    </tr>  
                                                </tbody>

                                            </table>
                                        </td>

                                        <%--Total--%>
                                        <td>
                                            <table>
                                                <tbody>
                                                    <tr height="60%">
                                                        <td>
                                                            <h3>&nbsp TOTAL </h3>
                                                            <h4>&nbsp $168.75</h4>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <button class="btn btn-primary" data-bind="click: realizarFactura">Realizar</button> <br>
                                                    </tr>

                                                </tbody>
                                            </table>


                                        </td>


                                    </tr>
                                   
                                </table>
                                <!--Fin Primera Linea-->


                            </td>
                        </tr>
                    </table> 
                </div>
            </div>
        </div>


    </body>
<script id="buscarScript" type="text/javascript" language="javascript" charset="utf-8" src="Librerias/buscarProducto/buscarKO.js"></script>

</html>
