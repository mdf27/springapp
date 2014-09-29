
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
        <jsp:directive.include file="include/menu.jsp"/>   
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
                <jsp:directive.include file="include/menuFacturacion.jsp"/>  
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


            <div style="margin-left: 100px !important; margin-top: 100px !important" class="centerTable" id ="contenedorPrincipal" align="center" data-bind="visible: $root.buscarProd"> <jsp:directive.include file="include/buscarProductoFactura.jsp"/>  </div>
            <div style="margin-left: 100px !important; margin-top: 100px !important" class="centerTable" id ="contenedorPrincipal" align="center" data-bind="visible: $root.realizandoFactura">


                <table  style="margin: 0 auto;" valign="middle"  width="100%" height="100%" cellpadding="6" >
                    <tbody >
                        <%-- Fila 1 --%>

                        <tr>
                            <td align ="left" colspan="1">
                                <i class="icon-user"></i>&nbsp &nbsp<strong>Cajero :</strong>
                            </td>
                            <td colspan="1">
                                <strong>Pepito Perez</strong>
                            </td>
                            <td colspan="3">&nbsp</td>
                            <td colspan="1" align="right">
                                <i class="icon-calendar"></i><strong>Fecha:&nbsp</strong><strong data-bind="text: fecha"></strong>
                            </td>
                        </tr>
                        <%-- Fila 2 --%>

                        <%-- Fila 3 --%>
                        <tr>
                            <td align ="left" colspan="1">
                                <i class="icon-user"></i>&nbsp <strong>Cliente :</strong>
                            </td>  
                            <td colspan="1">
                                <input type="text" autofocus list="browsers" name="buscar" autocomplete="off" class="input-large" >
                            </td>
                            <td colspan="2">
                                <strong>&nbsp RUT&nbsp </strong>
                                <strong>&nbsp</strong><input class="input-medium" type="checkbox" data-bind="checked: conRut" />
                            </td>
                            <td colspan="1">
                                &nbsp
                            </td>

                            <td colspan="2" align="right">
                                <a href="#" data-bind="click: $root.registrarCliente">Registrar cliente</a>
                            </td>
                        </tr>
                        <tr>

                            <td align ="left" colspan="1"> <strong>Razón social</strong>
                            <td colspan="1"><input class="input-large" type="text" data-bind="value: rSocial, enable: conRut" /></td></td>

                            <td colspan="2" align="left"> <strong>&nbsp RUT&nbsp &nbsp</strong><input class="input-medium" type="text" data-bind="value: nroRut, enable: conRut" /> </td>

                            <td colspan="2">&nbsp</td>
                            <%-- Fila 4 --%>
                        <tr>
                            <td align ="left" valign="top" colspan="1">
                                <i class="icon-barcode"></i>&nbsp<strong> Producto</strong>
                            </td>
                            <td valing="middle" colspan="5" >
                                <div >
                                    <form >

                                        <input type="text" autofocus list="browsers" name="buscar" autocomplete="off" class="input-large" 
                                               data-bind="value: textoProducto, valueUpdate: 'input', executeOnEnter: buscarProducto" 
                                               placeholder="Ingrese nombre o codigo del producto">
                                    </form>
                                </div> 
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
                                <div style="height: 100%; overflow-y: scroll;">
                                    <table id="tablita" class="table table-bordered" >
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
                                </div>
                            </td>

                            <%--Total--%>
                            <td colspan="1" align="rigth">
                                <table id="tablaTotal">

                                    <tbody>
                                        <tr>
                                            <td>&nbsp</td>
                                        </tr>
                                        <tr>
                                            <td align="right"><strong>Forma de pago</strong></td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                                <select style="width:110px; height:30px" data-bind="options: $root.formasPago, value: formaPago, optionsText: 'formaPago'"></select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>&nbsp</td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                                <h3>TOTAL </h3>
                                                <h4><strong data-bind="text: total"></strong></h4>
                                            </td>
                                        </tr>
                                        <tr valign="bottom">
                                            <td align="right">
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

        <script id="buscarScript" type="text/javascript" language="javascript" charset="utf-8" src="Librerias/buscarProducto/buscarKO.js"></script>
    </body>



</html>
