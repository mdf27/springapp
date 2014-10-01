<p>Reporte de Actualización: </p>

<div style="margin-left: 10px" data-bind="foreach: $root.agregaron"> 
<p>Se agregó un nuevo producto,</p><p data-bind="text: $data.descripcion"></p>
</div>

<div data-bind="foreach: $root.aumentaron"> 
<p data-bind="text: $data.descripcion"></p><p> aumentó algo</p>
</div>

<div data-bind="foreach: $root.disminuyeron"> 
<p data-bind="text: $data.descripcion"></p><p> disminuyó algo</p>
</div>

<div data-bind="foreach: $root.habilitaron"> 
<p data-bind="text: $data.descripcion"></p><p> se habilitó</p>
</div>

<div data-bind="foreach: $root.deshabilitaron"> 
<p data-bind="text: $data.descripcion"></p><p> se deshabilitó</p>
</div>