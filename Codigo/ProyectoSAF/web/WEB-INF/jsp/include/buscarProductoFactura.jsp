<div> 
    <table   width="100%" cellpadding="18" >
        <tbody>
            <%-- Fila 1 --%>

            <tr>
                <td colspan="6"><div align="left" style="font-family: Arial; font-size: 19px; font-weight: bold">Seleccione un producto</div></td>
            </tr>
            <tr>
                <td colspan="1"><span class="container body-content">
                        <select id="filtrosBusqueda" style="width:110px" name="select" class="form-control"  data-bind="options: optionValueFiltros, value: selectedOptionValueFiltro, event: { change: filtroSelectionChanged }" ></select>
                    </span>
                </td>
                <td colspan="2"><span style="font-size:14px; font-family:Arial">
                        <input class="form-control" type="text" data-bind="hasFocus: isSelected, value: filtro, valueUpdate: 'afterkeydown', event: { input: actualizarLista, keyup: actualizarLista}">

                    </span>
                </td>
                <td colspan="1" data-bind="visible: lista().length>0"><span style="font-size:14px; font-family:Arial">Ordenar:</span></td>
                <td colspan="2">
                    <div align="left"><span class="container body-content">
                            <select name="select2" class="form-control" style="width: 100% !important" data-bind="options: optionValues, value: selectedOptionValue,visible: hayResultado, event: { change: selectionChanged }"></select>
                        </span>
                    </div>
                    <%--  
                    <input class="form-control" type="hidden" data-bind="hasFocus: isSelected"> 
                    --%>  
                </td>
            </tr>
            <%-- Fila 2 --%>

            <%-- Fila 3 --%>

            <tr>
                <td colspan="6">
                    <table  class="tableF"  data-bind="visible: $root.lista().length>0 ">
                        <thead>

                            <tr><th ><div align="center">Nombre</div></th><th ><div align="center">Estado</div></th><th ><div align="center">Cantidad</div></th><th ><div align="center">Precio Lista</div></th><th ><div align="center">Farmadescuento</div></th><th ><div align="center">Precio Venta</div></th></tr>
            </thead>
        <tbody data-bind="foreach: paginated">
            <tr data-bind="click: $parent.selecccionarProductoClick ,executeOnEnter: $parent.selecccionarProducto, css: { 'btn-infobuscar': ($parent.selectedResult() == $data)}">                            
                <td><a><p align="left" data-bind="text: descripcion"></p></a></li></td>
                <td><p style="color: #d43f3a; font-weight: bold" align="center" data-bind="text: habilitado"></p></td>
                <td><p style="color: #d43f3a; font-weight: bold" align="center" data-bind="text: cantidad"></p></td>
                <td><p style="color: #d43f3a; font-weight: bold" align="center" data-bind="text: precioLista"></p></td>
                <td><p style="color: #d43f3a; font-weight: bold" align="center" data-bind="text: farmaDescuento"></p></td>
                <td><p style="color: #d43f3a; font-weight: bold" align="center" data-bind="text: precioVenta"></p></td>

            </tr>
        </tbody>
    </table>
</td>
</tr>
<tr>
    <td colspan="3">
        <div class="pager">   
            <div align="center">
                <ul class="pager">
                    <li><a href="#" data-bind="click: previous, visible: hasPrevious">&laquo;</a><span class="pages" data-bind="text: $root.paginado() ,visible: lista().length >0"></span><a href="#" data-bind="click: next, visible: hasNext">&raquo;</a></li>
                </ul>
            </div>
            <p align="center"></p>
        </div>
    </td>
    <td colspan="1">
        <strong>Receta</strong>
        <input type="checkbox" data-bind="hasFocus: recetaSelected, checked: conReceta" />

    </td>
    <td colspan="1">
        <strong data-bind=" css: { 'btn-error': ((cantProd().length == 0)||(cantProd()<0)) }">Cantidad</strong>
        <input type="number" class="input-mini" data-bind="value: cantProd"/>

    </td>
    <td colspan="1">
        <strong data-bind=" css: { 'btn-error': ((descuento().length == 0)||(descuento() > 100) || (descuento()<0)) }">Descuento (%)</strong>
        <input type="number" class="input-mini" data-bind="hasFocus: descuento().length == 0 ,value: descuento" max="100" size="100"/>

    </td>


</tr>
<tr>
    <td colspan="1">&nbsp</td>
    <td colspan="1">&nbsp</td>
    <td colspan="1">&nbsp</td>
    <td colspan="1">&nbsp</td>
    <td colspan="1">&nbsp</td>
    <td colspan="1">
        <button style="width:110px; height:30px" class="btn btn-primary" data-bind="click: selecccionarProducto">Seleccionar</button>
    </td>
</tr>


</tbody>
</table>

</div>
