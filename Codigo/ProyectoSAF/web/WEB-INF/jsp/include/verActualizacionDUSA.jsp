<p>Reporte de Actualizaci�n: </p>

<div style="margin-left: 10px" data-bind="foreach: $root.agregaron"> 
<p>Se agreg� un nuevo producto,</p><p data-bind="text: $data.descripcion"></p>
</div>

<div data-bind="foreach: $root.aumentaron"> 
<p data-bind="text: $data.descripcion"></p><p> aument� algo</p>
</div>

<div data-bind="foreach: $root.disminuyeron"> 
<p data-bind="text: $data.descripcion"></p><p> disminuy� algo</p>
</div>

<div data-bind="foreach: $root.habilitaron"> 
<p data-bind="text: $data.descripcion"></p><p> se habilit�</p>
</div>

<div data-bind="foreach: $root.deshabilitaron"> 
<p data-bind="text: $data.descripcion"></p><p> se deshabilit�</p>
</div>