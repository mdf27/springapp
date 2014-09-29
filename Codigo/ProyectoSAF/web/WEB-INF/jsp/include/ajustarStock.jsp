
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
                           <li><a href="#" data-bind="click: previous, visible: hasPrevious">&laquo;</a><span class="pages" data-bind="text: $root.paginado() ,visible: lista().length >0"></span><a href="#" data-bind="click: next, visible: hasNext">&raquo;</a></li>
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
            
            <tr><th width="20%"><div align="center">Nombre</div></th><th width="11%"><div align="center">Laboratorio</div></th><th width="11%"><div align="center">Estado</div></th><th width="8%"><div align="center">Cantidad</div></th><th width="10%"><div align="center">Precio Lista</div></th><th width="10%"><div align="center">Farmadescuento</div></th><th width="10%"><div align="center">Precio Venta</div></th>
              <th width="10%">&nbsp;</th>
            </tr>
        </thead>
        <tbody data-bind="foreach: cargadoInicial">
            <tr>                            
                <td><a><p align="left" data-bind="text: descripcion, click: $parent.selectResult"></p></a></td>
                <td><p align="center" data-bind="text: laboratorio"></p></td>
                <td><p align="center" data-bind="text: habilitado"></p></td>
                <td><div align="center">
                  <input type="text" class="edit" size="5" maxlength="5" align="left" data-bind="value: cantidad, visible: $root.isItemEditing($data)" >
                  <label class="read" data-bind="text: cantidad, visible: !$root.isItemEditing($data)" />
                  </div>
                </td>
                <td><p style="color: #d43f3a;" align="center" data-bind="text: '$ '+ precioLista"></p></td>
                <td><p style="color: #d43f3a;" align="center" data-bind="text: '$ '+ farmaDescuento" ></p></td>
                <td><p style="color: #d43f3a;" align="center" data-bind="text: '$ '+ precioVenta"></p></td>
                <td><button data-bind="click: $root.editItem.bind($root), visible: !$root.isItemEditing($data)" type="button" class="btn btn-primary">Ajustar</button><button data-bind="click: $root.applyFruit.bind($root), visible: $root.isItemEditing($data)" type="button" class="btn btn-primary">Aplicar</button></td>                
                
            </tr>
        </tbody>
    </table>
  <div align="center" data-bind="visible: ($root.lista().length<=0) && ($root.mostrarError)">No existen resultados para su búsqueda.</div>
</div>

