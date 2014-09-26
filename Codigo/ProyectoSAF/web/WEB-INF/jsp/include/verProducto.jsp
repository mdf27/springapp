<table width="442" border="0">
    <tr>
        <td colspan="2"> <blockquote><h3 style="font-weight: bold;">INFORMACIÓN DEL PRODUCTO</h3></blockquote></td>
    </tr>
    <tr>
      <td colspan="2">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2"><h4 style="font-weight: bold; text-decoration: underline">Datos Básicos</h4></td>
    </tr>
    <tr>
      <td width="170" style="font-weight: bold;">Nombre:</td>
      <td width="262"><span data-bind="text: $root.selectedResult().descripcion"></span></td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Códigos de Barras:</td>
      <td><span data-bind="text: $root.selectedResult().codigos"></span></td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Poveedores:</td>
      <td><a href="#"><span data-bind="text: $root.selectedResult().proveedor"></span></a></td>
    </tr>
    <tr>
      <td colspan="2">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2"><h4 style="font-weight: bold; text-decoration: underline">Detalles</h4></td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Laboratorio:</td>
      <td><span data-bind="text: $root.selectedResult().laboratorio"></span> </td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Cantidad:</td>
      <td><span data-bind="text: $root.selectedResult().cantidad"></span></td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Droga:</td>
      <td><span data-bind="text: $root.selectedResult().drogas"></span></td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Vencimientos:</td>
      <td><span data-bind="text: $root.selectedResult().vencimientos"></span> </td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Venta sólo Receta:</td>
      <td><span data-bind="text: $root.selectedResult().receta"></span> </td> 
    </tr>
    <tr>
      <td style="font-weight: bold;">Acciones Terapéuticas:</td>
      <td><span data-bind="text: $root.selectedResult().accion"></span> </td>
    </tr>
    <tr>
      <td colspan="2">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2"><h4 align="left" style="font-weight: bold; text-decoration: underline">Precios</h4></td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Precio de lista:</td>
      <td> $  <span data-bind="text: $root.selectedResult().precioLista"></span></td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Precio de venta:</td>
      <td>$ <span data-bind="text: $root.selectedResult().precioVenta"></span>  </td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Descuento Producto:</td>
      <td><span data-bind="text: $root.selectedResult().descuentoProducto"></span>%</td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Descuento de Receta: </td>
      <td><span data-bind="text: $root.selectedResult().descuentoReceta"></span>%</td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Farma Descuento:</td>
      <td>$ <span data-bind="text: $root.selectedResult().farmaDescuento"></span></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2"><button data-bind="click: atras" type="button" class="btn btn-primary">Atras</button></td>
    </tr>
  </table>
<h3 style="font-weight: bold;">&nbsp;</h3>
  <h3 style="font-weight: bold;">&nbsp;</h3>
  <h3 style="font-weight: bold;">&nbsp;</h3>
  <h3 style="font-weight: bold;">&nbsp;</h3>
  <h3 style="font-weight: bold;">&nbsp;</h3>
 
