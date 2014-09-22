<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table width="912" border="0">
  <tr>
    <td height="39" colspan="4"><span style="font-weight: bold;">INFORMACIÓN DEL PRODUCTO</span></td>
  </tr>
  <tr>
    <td height="50" colspan="4"><span style="font-weight: bold; text-decoration: underline">Datos Básicos</span></td>
  </tr>
  <tr>
    <td width="306">Nombre: <span data-bind="text: $root.selectedResult().descripcion"></span></td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td>Códigos de barra: <span data-bind="text: $root.selectedResult().codigos"></span></td>
    <td colspan="3">Proveedores: <span data-bind="text: $root.selectedResult().proveedor"></span></td>
  </tr>
  <tr>
    <td height="50" colspan="4"><span style="font-weight: bold; text-decoration: underline">Detalles</span></td>
  </tr>
  <tr>
    <td>Marca/Laboratorio: <span data-bind="text: $root.selectedResult().laboratorio"></span> </td>
    <td colspan="3">Cantidad: <span data-bind="text: $root.selectedResult().cantidad"></span></td>
  </tr>
  <tr>
    <td>Drogas: <span data-bind="text: $root.selectedResult().drogas"></span></td>
    <td colspan="3">Vencimientos: <span data-bind="text: $root.selectedResult().vencimientos"></span> </td>
  </tr>
  <tr>
    <td>Venta sólo Receta: <span data-bind="text: $root.selectedResult().receta"></span> </td>
    <td colspan="3"></td>
  </tr>
  <tr>
    <td>Categoía:</td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td>Acciones Terapéuticas: <span data-bind="text: $root.selectedResult().accion"></span> </td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td height="49" colspan="4"><span style="font-weight: bold; text-decoration: underline">Precios y costos</span></td>
  </tr>
  <tr>
    <td>Precio de lista: <span data-bind="text: $root.selectedResult().precioCompra"></span>  </td>
    <td width="167" style="color: red">Descuento:</td>
    <td width="203" style="color: red">Precio de venta: $ </td>
    <td width="208" style="color: red">Farma Descuento:</td>
  </tr>
  <tr>
    <td style="color: red">Costo real: $</td>
    <td>Costo de lista: $<span data-bind="text: $root.selectedResult().precioCompra"></span> </td>
    <td style="color: red">Costo última compra: $  ultima factura </td>
    <td>&nbsp;</td>
  </tr>
</table>
<p>&nbsp;</p>                    
