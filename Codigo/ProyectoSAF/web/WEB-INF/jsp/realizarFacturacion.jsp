
<%@page import="SAF.Datos.Facturacion.TipoFacturaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Facturación</title>
        <link href="CSS/contenedorPrincipal.css" rel="stylesheet">
        <link href="CSS/facturacion.css" rel="stylesheet">
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


            <div class="centerTable" id ="contenedorPrincipal" align="center" data-bind="visible: $root.buscarProd"> <jsp:include page="include/buscarProductoFactura.jsp"/>  </div>
            <div class="centerTable" id ="contenedorPrincipal" align="center" data-bind="visible: $root.realizandoFactura">

                
                <table  style="margin: 0 auto;" valign="middle"  width="100%" cellpadding="18" >
                    <tbody>
                        <%-- Fila 1 --%>

                        <tr>
                            <td colspan="3">
                                <i class="icon-user"></i>&nbsp<strong>Cajero:&nbsp &nbsp Pepito Perez</strong>
                            </td>
                            <td colspan="3">
                                &nbsp &nbsp  <i class="icon-calendar"></i>&nbsp <strong>Fecha:&nbsp 09/09/2014</strong>
                            </td>
                        </tr>
                        <%-- Fila 2 --%>

                        <%-- Fila 3 --%>
                        <tr>
                            <td colspan="4">
                                <i class="icon-user"></i>&nbsp <strong class="textoLugarMedio" >Cliente</strong>
                                <input type="text" autofocus list="browsers" name="buscar" autocomplete="off" class="input-large" >
                            </td>  

                            <td colspan="2">
                                <input style="width:110px; height:30px" class="btn btn-primary" type="submit" value="Nuevo cliente" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="1"> <strong>RUT&nbsp &nbsp</strong><input class="input-medium" type="checkbox" data-bind="checked: conRut" />
                            <td colspan="2"> <strong>R. social&nbsp &nbsp</strong><input class="input-large" type="text" data-bind="value: rSocial, enable: conRut" /></td>
                            <td colspan="1" align="right"> <strong>RUT&nbsp</strong> </td>
                            <td colspan="2"><input class="input-medium" type="text" data-bind="value: nroRut, enable: conRut" /></td>

                            <%-- Fila 4 --%>
                        <tr>

                            <td valing="middle" colspan="4" >
                                <div >
                                    <form name="form2" action="" method="post">
                                        <i class="icon-barcode"></i>&nbsp<strong> Producto &nbsp &nbsp</strong><input type="text" autofocus list="browsers" name="buscar" autocomplete="off" class="input-xlarge" 
                                                                                                                      data-bind="value: textoProducto, valueUpdate: 'input', executeOnEnter: buscarProducto" 
                                                                                                                      placeholder="Ingrese nombre o codigo del producto"/>
                                    </form>
                                </div> 
                            </td>
                            <td colspan="2">
                                <select style="width:110px; height:30px" data-bind="options: $root.formasPago, value: formaPago, optionsText: 'formaPago'"></select>
                            </td>
                            <%--
                            <td colspan="1"> 
                                <button  style="width:110px; height:30px" class="btn btn-primary" data-bind="click: buscarProducto">Buscar</button>
                            </td>
                             --%>
                        </tr>
                        <%-- Fila 5 --%>
                        <tr>

                            <%-- Tabla productos--%>
                            <td colspan="5">

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
                                    <tbody data-bind="foreach: renglonesVacios">
                                        <tr>
                                            <td >&nbsp</td> <%--Cantidad --%>
                                            <td >&nbsp</td> <%--Nombre --%>
                                            <td >&nbsp</td> <%--Precio --%>
                                            <td >&nbsp</td> <%--Descuento --%>
                                            <td >&nbsp</td> <%--Receta --%>
                                            <td >&nbsp</td> <%--Precio venta --%>
                                            <td >&nbsp</td> <%--Subtotal --%>
                                        </tr>
                                    </tbody>

                                </table>
                            </td>

                            <%--Total--%>
                            <td>
                                <table id="tablaTotal">
                                    
                                    <tbody>
                                        <tr>
                                            <td>
                                                <h3>TOTAL </h3>
                                                <h4><strong data-bind="text: total"></strong></h4>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                            <button style="width:110px; height:30px" class="btn btn-primary" data-bind="click: realizarFactura">Realizar</button>
                                            </td>
                                        </tr>

                                    </tbody>
                                 </table>


                            </td>


                </tr>

                </tbody>
                </table> 
                

            </div>
        </div>


    </body>
    <script id="buscarScript" type="text/javascript" language="javascript" charset="utf-8" src="Librerias/buscarProducto/buscarKO.js"></script>


</html>
