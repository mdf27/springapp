<br>
<br>
<p>Reporte de Actualizaci�n: </p>

<div style="margin-left: 40px" data-bind="foreach: $root.agregados"> 
Se agreg� un nuevo producto,&nbsp;<span data-bind="text: $data.descripcion"></span><br>
</div>

<div style="margin-left: 40px" data-bind="foreach: $root.aumentaron"> 
<span data-bind="text: $data.descripcion">&nbsp;</span> &nbsp; aument� algo <br>
</div>

<div style="margin-left: 40px" data-bind="foreach: $root.disminuyeron"> 
<span data-bind="text: $data.descripcion"></span> &nbsp; disminuy� algo <br>
</div>

<div style="margin-left: 40px" data-bind="foreach: $root.habilitaron"> 
<span data-bind="text: $data.descripcion"></span>&nbsp; se habilit� <br>
</div>

<div style="margin-left: 40px" data-bind="foreach: $root.deshabilitaron"> 
<span data-bind="text: $data.descripcion"></span>&nbsp; se deshabilit� <br>
</div>