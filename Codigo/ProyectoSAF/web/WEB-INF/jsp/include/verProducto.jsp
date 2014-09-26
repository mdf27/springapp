<%@ page language="java" contentType="application/json; charset=iso-8859-1" pageEncoding="UTF-8"%>  
<table width="500" border="0">
    <tr>
        <td colspan="3"> <blockquote><h3 style="font-weight: bold;">INFORMACIÓN DEL PRODUCTO</h3></blockquote></td>
    </tr>
    <tr>
      <td colspan="3">&nbsp;</td>
    </tr>
    <tr>
      <td><h4 style="font-weight: bold; text-decoration: underline">Datos Básicos</h4></td>
      <td><div align="left"></div></td>
      <td><button type="button" class="btn btn-primary">Modificar</button>
      <div align="right"></div></td>
    </tr>
    <tr>
      <td width="166" style="font-weight: bold;">Nombre:</td>
      <td width="188"><span data-bind="text: $root.selectedResult().descripcion"></span></td>
      <td width="132"><div align="right"></div></td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Códigos de Barras:</td>
      <td><span data-bind="text: $root.selectedResult().codigos"></span></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Poveedores:</td>
      <td><a href="#"><span data-bind="text: $root.selectedResult().proveedor"></span></a></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td colspan="3">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="3"><h4 style="font-weight: bold; text-decoration: underline">Detalles</h4></td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Laboratorio:</td>
      <td><span data-bind="text: $root.selectedResult().laboratorio"></span> </td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Cantidad:</td>
      <td><span data-bind="text: $root.selectedResult().cantidad"></span></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Droga:</td>
      <td><span data-bind="text: $root.selectedResult().drogas"></span></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Vencimientos:</td>
      <td><span data-bind="text: $root.selectedResult().vencimientos"></span> </td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Venta sólo Receta:</td>
      <td><span data-bind="text: $root.selectedResult().receta"></span> </td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Acciones Terapéuticas:</td>
      <td><span data-bind="text: $root.selectedResult().accion"></span> </td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td colspan="3">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="3"><h4 align="left" style="font-weight: bold; text-decoration: underline">Precios</h4></td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Precio de lista:</td>
      <td> $  <span data-bind="text: $root.selectedResult().precioLista"></span></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Precio de venta:</td>
      <td>$ <span data-bind="text: $root.selectedResult().precioVenta"></span>  </td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Descuento Producto:</td>
      <td><span data-bind="text: $root.selectedResult().descuentoProducto"></span>%</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Descuento de Receta: </td>
      <td><span data-bind="text: $root.selectedResult().descuentoReceta"></span>%</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Farma Descuento:</td>
      <td>$ <span data-bind="text: $root.selectedResult().farmaDescuento"></span></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td colspan="3"><div align="left">
        <button data-bind="click: atras" type="button" class="btn btn-primary">Atras</button>
      </div></td>
    </tr>
  </table>
<blockquote>&nbsp;</blockquote>
<h3 style="font-weight: bold;">&nbsp;</h3>
  <h3 style="font-weight: bold;">&nbsp;</h3>
  <h3 style="font-weight: bold;">&nbsp;</h3>
  <h3 style="font-weight: bold;">&nbsp;</h3>
  <h3 style="font-weight: bold;">&nbsp;</h3>
 
