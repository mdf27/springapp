<br>
<br>
<p>Reporte de Actualización: </p>

<div style="margin-left: 40px" data-bind="foreach: $root.agregados"> 
Se agregó un nuevo producto,&nbsp;<span data-bind="text: $data.descripcion"></span><br>
</div>

<div style="margin-left: 40px" data-bind="foreach: $root.aumentaron"> 
<span data-bind="text: $data.descripcion">&nbsp;</span> &nbsp; aumentó algo <br>
</div>

<div style="margin-left: 40px" data-bind="foreach: $root.disminuyeron"> 
<span data-bind="text: $data.descripcion"></span> &nbsp; disminuyó algo <br>
</div>

<div style="margin-left: 40px" data-bind="foreach: $root.habilitaron"> 
<span data-bind="text: $data.descripcion"></span>&nbsp; se habilitó <br>
</div>

<div style="margin-left: 40px" data-bind="foreach: $root.deshabilitaron"> 
<span data-bind="text: $data.descripcion"></span>&nbsp; se deshabilitó <br>
</div>