<table width="912" border="0">
  <tr>
    <td height="41" colspan="4"><span style="font-weight: bold;">INFORMACIÓN DEL PRODUCTO</span></td>
  </tr>
  <tr>
    <td height="50" colspan="4"><span style="font-weight: bold; text-decoration: underline">Datos Básicos</span></td>
  </tr>
  <tr>
    <td width="306" height="27">Nombre: <span data-bind="text: $root.selectedResult().descripcion"></span></td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td height="40">Códigos de barra: <span data-bind="text: $root.selectedResult().codigos"></span></td>
    <td colspan="3">Proveedores: <span data-bind="text: $root.selectedResult().proveedor"></span></td>
  </tr>
  <tr>
    <td height="63" colspan="4"><span style="font-weight: bold; text-decoration: underline">Detalles</span></td>
  </tr>
  <tr>
    <td height="30">Marca/Laboratorio: <span data-bind="text: $root.selectedResult().laboratorio"></span> </td>
    <td colspan="3">Cantidad: <span data-bind="text: $root.selectedResult().cantidad"></span></td>
  </tr>
  <tr>
    <td height="39">Drogas: <span data-bind="text: $root.selectedResult().drogas"></span></td>
    <td colspan="3">Vencimientos: <span data-bind="text: $root.selectedResult().vencimientos"></span> </td>
  </tr>
  <tr>
    <td height="38">Venta sólo Receta: <span data-bind="text: $root.selectedResult().receta"></span> </td>
    <td colspan="3"></td>
  </tr>
  <tr>
    <td height="38">Categoía:</td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td height="41">Acciones Terapéuticas: <span data-bind="text: $root.selectedResult().accion"></span> </td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td height="52" colspan="4"><span style="font-weight: bold; text-decoration: underline">Precios y costos</span></td>
  </tr>
  <tr>
    <td height="33">Precio de lista: <span data-bind="text: $root.selectedResult().precioLista"></span>  </td>
    <td width="167" style="color: red">Descuento: <span data-bind="text: $root.selectedResult().descuento"></span> % </td>
    <td width="203">Precio de venta: $ <span data-bind="text: $root.selectedResult().precioVenta"></span>  </td>
    <td width="208" style="color: red">Farma Descuento:</td>
  </tr>
  <tr>
    <td height="43" style="color: red">Costo real: $</td>
    <td>Costo de lista: $<span data-bind="text: $root.selectedResult().precioCompra"></span> </td>
    <td style="color: red">Costo última compra: $  ultima factura </td>
    <td>&nbsp;</td>
  </tr>
  <tr></tr>
  <tr>
      <td height="41" colspan="4" align="center"><a data-bind="click: atras"style="font-weight: bold;">Atras</a></td>
  </tr>
</table>
<p>&nbsp;</p>                    
