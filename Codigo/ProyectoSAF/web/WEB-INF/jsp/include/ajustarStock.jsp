
<%-- 
    Document   : ajustarStock
    Created on : 27-sep-2014, 15:51:30
    Author     : majo
--%>
<div> 
    <table width="796" border="0">
        <tr>
            <td colspan="5"><div align="left" style="font-family: Arial; font-size: 25px; font-weight: bold">Productos:</div></td>
            <td><div align="right"></div></td>
        </tr>
        <tr>
            <td height="46" colspan="6"><div align="right"></div></td>
        </tr>
        <tr>
            <td width="157"><span class="container body-content">
                                <select name="select" class="form-control" style="width: 85% !important" data-bind="options: optionValueFiltros, value: selectedOptionValueFiltro, event: { change: filtroSelectionChanged }" ></select>
                            </span>
            </td>
            <td width="16">&nbsp;</td>
            <td width="316"><span style="font-size:14px; font-family:Arial">
                                
                    <input class="form-control" type="text" data-bind="value: filtro, valueUpdate: 'afterkeydown', event: { keyup: actualizarLista}">
                            </span>
            </td>
            <td width="26">&nbsp;</td>
            <td width="62" data-bind="visible: lista().length>0"><span style="font-size:14px; font-family:Arial">Ordenar:</span></td>
            <td width="193">
                <div align="left">
                    <div align="left"><span class="container body-content">
                            <select name="select2" class="form-control" style="width: 100% !important" data-bind="options: optionValues, value: selectedOptionValue,visible: hayResultado, event: { change: selectionChanged}"></select>
                        </span>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="6">
                <div class="pager">   
                    <div align="center">
                        <ul class="pager">
                           <li><a href="#" data-bind="click: previous, visible: hasPrevious">&laquo;</a><span class="pages" data-bind="text: $root.paginado() ,selee: lista().length >0"></span><a href="#" data-bind="click: next, visible: hasNext">&raquo;</a></li>
                        </ul>
                    </div>
                    <p align="center"></p>
                </div>
            </td>
        </tr>
    </table>
    <p>&nbsp;</p>

    <div class="container body-content" ></div>
    <p></p>
    <table width="80%" height="48" class="table" style ="width: 95% !important" data-bind="visible: $root.lista().length>0 ">
        <thead>
            
            <tr><th width="20%"><div align="center">Nombre</div></th><th width="13%"><div align="center">Estado</div></th><th width="14%"><div align="center">Cantidad</div></th><th width="12%"><div align="center">Precio Lista</div></th><th width="13%"><div align="center">Farmadescuento</div></th><th width="12%"><div align="center">Precio Venta</div></th>
              <th width="16%">&nbsp;</th>
            </tr>
        </thead>
        <tbody data-bind="foreach: cargadoInicial">
            <tr>                            
                <td><p align="left" data-bind="text: descripcion"></p></td>
                <td><p align="center" data-bind="text: habilitado"></p></td>
                <td data-bind="click: $parent.select"><div align="center">
                  <input type="text"  data-bind="value: $root.filtroCantidad,valueUpdate: 'afterkeydown', visible: $root.isItemEditing($data)" >
                  <p class="read" data-bind="text: $root.cantidad()[$index()], visible: !$root.isItemEditing($data)"></p>
                  </div>
                </td>
                <td><p style="color: #d43f3a;" align="center" data-bind="text: '$ '+ precioLista"></p></td>
                <td><p style="color: #d43f3a;" align="center" data-bind="text: '$ '+ farmaDescuento" ></p></td>
                <td><p style="color: #d43f3a;" align="center" data-bind="text: '$ '+ precioVenta"></p></td>
                <td><button data-bind="click: $root.editar.bind($root,$index()), visible: (!$root.isItemEditing($data) && !$root.editando())" type="button" class="btn btn-primary">Ajustar</button>
                    <button data-bind="click: $root.ajustar.bind($root), visible: $root.isItemEditing($data)" type="button" class="btn btn-primary">Aplicar</button>
                    <button data-bind="click: $root.cancelar.bind(), visible: $root.isItemEditing($data)" type="button" class="btn btn-primary">X</button>
                    <img src="img/tick.png" data-bind="visible: $root.isTickMoment($index())">
                    <img src="img/cross.png" data-bind="visible: $root.isCrossMoment($index())"></td>                
                
            </tr>
        </tbody>
    </table>
  <div align="center" data-bind="visible: ($root.lista().length<=0) && ($root.mostrarError)">No existen resultados para su búsqueda.</div>
</div>

