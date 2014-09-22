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
    <td>Códigos de barra:</td>
    <td colspan="3">Proveedores:</td>
  </tr>
  <tr>
    <td height="50" colspan="4"><span style="font-weight: bold; text-decoration: underline">Detalles</span></td>
  </tr>
  <tr>
    <td>Marca/Laboratorio:</td>
    <td colspan="3">Mínimo (ofertas):</td>
  </tr>
  <tr>
    <td>Drogas:</td>
    <td colspan="3">Cantidad:</td>
  </tr>
  <tr>
    <td>Venta sólo Receta:</td>
    <td colspan="3">Vencimientos:</td>
  </tr>
  <tr>
    <td>Categoía:</td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td>Acciones Terapéuticas:</td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td height="49" colspan="4"><span style="font-weight: bold; text-decoration: underline">Precios y costos</span></td>
  </tr>
  <tr>
    <td>Precio de lista: </td>
    <td width="167">Descuento:</td>
    <td width="203">Precio de venta: $ <span data-bind="text: $root.selectedResult().precioVenta"></span></td>
    <td width="208">Farama Descuento:</td>
  </tr>
  <tr>
    <td>Costo real: $</td>
    <td>Costo de lista: $ </td>
    <td>Costo última compra: $  <span data-bind="text: $root.selectedResult().precioCompra"></span></td>
    <td>&nbsp;</td>
  </tr>
</table>
<p>&nbsp;</p>                    
