<%-- 
    Document   : index1
    Created on : 11-sep-2014, 22:21:52
    Author     : majo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" language="javascript" src="js/knockout-3.0.0.js"></script>
        <script type="text/javascript" language="javascript" src="js/jquery-1.11.1.min.js"></script>
        <link rel="stylesheet" href="css/style.css" />         
        <link rel="stylesheet" href="css/search_box.css" />         
        <link rel="stylesheet" href="css/pagButton.css" />   
        <title>Buscar Producto</title>
    </head>
    <body>
        <center>    
            <div class="CSSTableGenerator" >                
                <form id="search">
                <input type="text" data-bind="value: filtro, valueUpdate: 'afterkeydown', event: { keyup: actualizarLista}">
                </form>               
                <div class="pager">   
                    <button class="botonPag" href="#" data-bind="click: previous, visible: hasPrevious" >&lt;</button>                    
                    <span class="pages" data-bind="text: $root.pageNumber,visible: hasNext"></span>               
                    <button class="botonPag" href="#" data-bind="click: next, visible: hasNext" style="margin-left: 6px;">&gt;</button>
                    <p></p>
                    <div>
                        <label data-bind="visible: hasNext">Orden: </label><select data-bind="options: optionValues, value: selectedOptionValue,visible: hayResultado, event: { change: selectionChanged }"></select>
                        <label style = "font-size:14px;	font-family:Arial">Filtros: </label><select data-bind="options: optionValueFiltros, value: selectedOptionValueFiltro"></select>
                    </div>
                    <p></p>
                </div>
                <table>
                    <thead>
                        <tr><th>Código</th><th>Laboratorio</th><th>Descripción</th><th>Proveedor</th><th>Precio de Venta</th><th>Descuentos</th><th>Precio de Oferta</th></tr>
                    </thead>
                    <tbody data-bind="foreach: paginated">
                        <tr data-bind="css: { 'btn-info': $parent.selectedResult() === $data }">                            
                            <td><center><p data-bind="text: nro"></p></center></td>
                            <td><center><p data-bind="text: lab"></p></center></td>
                            <td><p data-bind="text: descripcion"></p></td>
                            <td><center><p data-bind="text: prov"></p></center></td>
                            <td><center><p data-bind="text: precio"></p></center></td>
                            <td><center><p data-bind="text: descuento"></p></center></td>
                            <td><center><p data-bind="text: oferta"></p></center></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </center>

        <script type="text/javascript">
            function ViewModel(){
                    var self = this;

                    self.lista = ko.observableArray();
                    self.filtro = ko.observable();
                    self.cantidad = ko.computed(function(){
                        return self.lista().length;
                    });
                   
                    self.timerID;
                    self.actualizarLista = function (d){
                        self.timerID = window.clearTimeout(self.timerID);
                        self.timerID = window.setTimeout(function(){
                            if (self.filtro() && self.filtro().length >2){
                                var buscar;
                                if(self.selectedOptionValueFiltro()==="Código"){
                                    buscar="nro"
                                }else if(self.selectedOptionValueFiltro()==="Laboratorio"){
                                    buscar="lab"
                                }else if(self.selectedOptionValueFiltro()==="Droga"){
                                    buscar="Droga"
                                }else  if(self.selectedOptionValueFiltro()==="Presentacion"){
                                    buscar="presentacion"
                                }else  if(self.selectedOptionValueFiltro()==="Todo"){
                                    buscar="all"
                                }else{
                                    buscar="desc"
                                }
                                $.ajax({
                                    url: "busqueda.htm",
                                    data : "buscar=" + vm.filtro() + "&filtro="+buscar,
                                    type: "GET",
                                    dataType: 'json',
                                    success: self.cargarLista
                                    });
                            }else{
                                self.lista.removeAll();
                            }
                        }
                    , 200);
                    return true;
                    };
                    self.cargarLista = function(d){
                        self.lista.removeAll();
                        for(var i=0; i<d.length; i++){
                            self.lista.push(d[i]);
                        }
                    };
                    
                    //paginado
                    self.pageNumber = ko.observable(0);
                    self.rowPerPage = 15;
                    self.totalPages = ko.computed(function(){
                        var div = Math.floor(self.lista().length / self.rowPerPage) ;    
                        div += self.lista().length % self.rowPerPage > 0 ? 1 : 0;
                        return div - 1;
                    });
                    
                    self.hasPrevious = ko.computed(function() {
                    	return self.pageNumber() !== 0;
                    });
                    
                    self.hasNext = ko.computed(function() {
                        return (self.totalPages()>0)&&(self.pageNumber() !== self.totalPages);
                    });
                    
                    self.next = function() {
                        if(self.pageNumber() < self.totalPages()) {
                            self.pageNumber(self.pageNumber() + 1);
                        }
                    };
	
                    self.previous = function() {
                        if(self.pageNumber() !== 0) {
                            self.pageNumber(self.pageNumber() - 1);
                        }
                    };                    
                    
                    self.hayResultado = ko.computed(function() {
                        return (self.lista().length  > 0);                           
                    });                    
                    
                    self.paginated = ko.computed(function() {
                        var first = self.pageNumber() * self.rowPerPage;
                        return self.lista.slice(first, first + self.rowPerPage);
                    });
                            
                    //ordenar
                    self.optionValues = ["Nombre descendente","Nombre ascendente", "Precio descendente", "Precio ascendente","Laboratorio descendente","Laboratorio ascendente"],
                    self.selectedOptionValue= ko.observable("Nombre descendente"),                            
                    this.selectedChoice = ko.observable();
                    self.selectionChanged= function(event) {
                        if(self.selectedOptionValue()==="Nombre descendente"){
                            self.lista.sort(function(a, b) {
                                return a.descripcion > b.descripcion ? -1 : 1;
                            });
                        }else if(self.selectedOptionValue()==="Nombre ascendente"){
                            self.lista.sort(function(a, b) {
                                return a.descripcion < b.descripcion ? -1 : 1;
                            });
                        }else if(self.selectedOptionValue()==="Precio descendente"){
                            self.lista.sort(function(a, b) {
                                return a.precio > b.precio ? -1 : 1;
                            });
                        }else if(self.selectedOptionValue()==="Precio ascendente"){
                            self.lista.sort(function(a, b) {
                                return a.precio < b.precio ? -1 : 1;
                            });
                        }else if(self.selectedOptionValue()==="Laboratorio descendente"){
                            self.lista.sort(function(a, b) {
                                return a.lab > b.lab ? -1 : 1;
                            });
                        }else if(self.selectedOptionValue()==="Laboratorio ascendente"){
                            self.lista.sort(function(a, b) {
                                return a.lab < b.lab ? -1 : 1;
                            });
                        };                            
                    };//evento ordenar 
                                      
                    
                    //filtros
                    self.optionValueFiltros = ["","Código", "Laboratorio","Droga","Presentación","Todo"],
                    self.selectedOptionValueFiltro= ko.observable(""),                            
                    this.selectedChoiceFiltro = ko.observable();                    
            
                    //teclado
                    self.selectResult = function (item) {
                        self.selectedResult(item);
                    };
                    self.selectedResult = ko.observable();
                    
                    
                    self.selectPrevious = function () {
                        var index = self.lista().indexOf(self.selectedResult()) - 1;
                        if (index < 0) index = 0;
                        self.selectedResult(self.lista()[index]);
                    };

                    self.selectNext = function () {
                        var index = self.lista().indexOf(self.selectedResult()) + 1;
                        if (index >= self.lista().length) index = self.lista().length - 1;
                        self.selectedResult(self.lista()[index]);
                    };
                };    
            var vm = new ViewModel();
            ko.applyBindings(vm);
            
            $(window).keyup(function (evt) {
                if (evt.keyCode === 38) {
                    vm.selectPrevious();
                } else if (evt.keyCode === 40) {
                    vm.selectNext();
                }
            }); 
        </script>
    </body>
</html>
