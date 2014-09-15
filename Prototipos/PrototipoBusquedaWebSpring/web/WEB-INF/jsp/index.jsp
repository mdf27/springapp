<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8">
        <script type="text/javascript" language="javascript" src="js/knockout-3.0.0.js"></script>
        <script type="text/javascript" language="javascript" src="js/jquery-1.11.1.min.js"></script>
        <link rel="stylesheet" href="css/style.css" />         
        <link rel="stylesheet" href="css/search_box.css" />         
        <link rel="stylesheet" href="css/pagButton.css" />   
    </head>
    <body>
        <center>    
            <div class="CSSTableGenerator" >                
                <form id="search">
                <input type="text" data-bind="value: filtro, valueUpdate: 'afterkeydown', event: { keyup: actualizarLista}">
                </form>               
                <div class="pager">   
                    <button class="botonPag" href="#" data-bind="click: previous, visible: hasPrevious" >&lt;</button>                    
                    <span class="pages" data-bind="text: $root.paginado() ,visible: lista().length >0"></span>               
                    <button class="botonPag" href="#" data-bind="click: next, visible: hasNext" style="margin-left: 6px;">&gt;</button>
                    <p></p>
                    <div>
                        <label data-bind="visible: hasNext">Orden: </label><select data-bind="options: optionValues, value: selectedOptionValue,visible: hayResultado, event: { change: selectionChanged }"></select>
                        <label style = "font-size:14px;	font-family:Arial">Filtros: </label><select data-bind="options: optionValueFiltros, value: selectedOptionValueFiltro, event: { change: filtroSelectionChanged }"></select>
                    </div>
                    <p></p>
                </div>
                <table>
                    <thead>
                        <tr><th>Código</th><th>Laboratorio</th><th>Descripción</th><th>Proveedor</th><th>Precio de Venta</th><th>Descuentos</th><th>Precio de Oferta</th></tr>
                    </thead>
                    <tbody data-bind="foreach: paginated">
                        <tr data-bind="css: { 'btn-info': (($parent.selectedResult() == $data)&&($root.mostrar))}, click: $parent.selectResult">                            
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
                <div  data-bind="if: $root.selectedResult, visible: (hasNext &&($root.mostrar))">
                    <p style="font-weight: bold; text-decoration: underline">INFORMACIÓN DEL PRODUCTO</p>
                    <p>Nombre: <span data-bind="text: $root.selectedResult().descripcion"></span></p>
                    <p>Laboratorio: <span data-bind="text: $root.selectedResult().lab"></span></p>                    
                    <p>Precio: $ <span data-bind="text: $root.selectedResult().precio"></span></p>                    
                </div>
            </div>
        </center>
        <script type="text/javascript">
            function ViewModel(){
                    var self = this;
                    self.mostrar=ko.observable(false);
                    self.lista = ko.observableArray();
                    self.filtro = ko.observable();
                    
                    //paginado
                    self.pageNumber = ko.observable(1);
                    self.rowPerPage = 5;
                    self.indicePaginado=ko.observable(-1);
                  
                    self.timerID;
                    self.buscar= function(){
                        if (self.filtro() && self.filtro().length >2){
                                var buscar;
                                if(self.selectedOptionValueFiltro()=="Código"){
                                    buscar="nro"
                                }else if(self.selectedOptionValueFiltro()=="Laboratorio"){
                                    buscar="lab"
                                }else if(self.selectedOptionValueFiltro()=="Droga"){
                                    buscar="Droga"
                                }else  if(self.selectedOptionValueFiltro()=="Presentacion"){
                                    buscar="presentacion"
                                }else  if(self.selectedOptionValueFiltro()=="Todo"){
                                    buscar="all"
                                }else{
                                    buscar="desc"
                                }
                                $.ajax({
                                    url: "busqueda.htm",
                                    data : "buscar=" + vm.filtro() + "&filtro="+buscar,
                                    dataType: 'json',
                                    success: self.cargarLista
                                    });                                
                            }else{
                                self.lista.removeAll();
                                self.pageNumber(1);
                                self.totalPages();
                            }
                    };
                    
                    
                    //ordenar
                    self.selectedOptionValue= ko.observable("Nombre ascendente"),  
                    self.ordenar = function(){
                        if(self.selectedOptionValue()=="Nombre descendente"){
                            self.lista.sort(function(a, b) {
                                return a.descripcion > b.descripcion ? -1 : 1;
                            });
                        }else if(self.selectedOptionValue()=="Nombre ascendente"){
                            self.lista.sort(function(a, b) {
                                return a.descripcion < b.descripcion ? -1 : 1;
                            });
                        }else if(self.selectedOptionValue()=="Precio descendente"){
                            self.lista.sort(function(a, b) {
                                return a.precio > b.precio ? -1 : 1;
                            });
                        }else if(self.selectedOptionValue()=="Precio ascendente"){
                            self.lista.sort(function(a, b) {
                                return a.precio < b.precio ? -1 : 1;
                            });
                        }else if(self.selectedOptionValue()=="Laboratorio descendente"){
                            self.lista.sort(function(a, b) {
                                return a.lab > b.lab ? -1 : 1;
                            });
                        }else if(self.selectedOptionValue()=="Laboratorio ascendente"){
                            self.lista.sort(function(a, b) {
                                return a.lab < b.lab ? -1 : 1;
                            });
                        };   
                    };
                    
                    self.actualizarLista = function (d){
                        self.timerID = window.clearTimeout(self.timerID);
                        self.timerID = window.setTimeout(function(){
                            self.buscar();  
                        }
                        , 200);
                        return true;
                    };
                    
                    self.cargarLista = function(d){
                        self.lista.removeAll();                        
                        for(var i=0; i<d.length; i++){
                            self.lista.push(d[i]);                            
                        }
                        self.ordenar();                        
                    };
                    
                    //paginado
                    self.topePaginado=self.rowPerPage;
                    self.totalPages = ko.computed(function(){
                        var div = Math.floor(self.lista().length / self.rowPerPage) ;    
                        div += self.lista().length % self.rowPerPage > 0 ? 1 : 0;
                        if (div!==0)
                            div-=1;
                        else
                            div+=1;
                        return div;
                    });
                    
                    self.paginado = ko.computed(function(){
                        self.mostrar(false);
                        if (self.totalPages()!==0)
                            return (self.pageNumber() + " de " + self.totalPages()); 
                        else
                            return (self.pageNumber() + " de 1");
                    });                    
                    
                    self.hasPrevious = ko.computed(function() {
                    	return (self.pageNumber() !== 1);
                    });
                    
                    self.hasNext = ko.computed(function() {
                        return (self.totalPages()>1)&&(self.pageNumber() !== self.totalPages());
                    });
                    
                    self.next = function() {
                        if(self.pageNumber() < self.totalPages()) {
                            self.pageNumber(self.pageNumber() + 1);
                            self.indicePaginado(self.topePaginado+self.rowPerPage);
                            if (self.indicePaginado<0)
                                self.indicePaginado=0;
                            self.topePaginado+=self.rowPerPage;                            
                            self.mostrar(false);
                            //self.selectedResult(self.lista()[self.indicePaginado]);
                            //self.indicePaginado++;                            
                        }
                    };
	
                    self.previous = function() {
                        if(self.pageNumber() !== 0) {
                            self.pageNumber(self.pageNumber() - 1);
                            self.indicePaginado(self.topePaginado-2*self.rowPerPage-1);
                            self.topePaginado-=self.rowPerPage;
                            //self.selectedResult(self.lista()[self.indicePaginado-1]);
                            self.mostrar(false);
                        }
                    };                   
                    
                    self.hayResultado = ko.computed(function() {
                        return (self.lista().length  > 0);                           
                    });                    
                    
                    self.paginated = ko.computed(function() {
                        var first = (self.pageNumber()-1) * self.rowPerPage;
                        return self.lista.slice(first, first + self.rowPerPage);
                    });
                            
                    //ordenar                    
                    self.optionValues = ["Nombre descendente","Nombre ascendente", "Precio descendente", "Precio ascendente","Laboratorio descendente","Laboratorio ascendente"],
                    //self.selectedChoice = ko.observable();
                    self.selectionChanged= function(event) {
                        self.ordenar();
                    };//evento ordenar 
                    
                    self.filtroSelectionChanged= function(event) {
                        self.buscar();
                        self.mostrar(false);
                    };//evento buscar con filtro 
                    
                    //filtros
                    self.optionValueFiltros = ["","Código", "Laboratorio","Droga","Presentación","Todo"],
                    self.selectedOptionValueFiltro= ko.observable(""),                                                       
            
                    //teclado
                    self.selectResult = function (item) {
                        self.selectedResult(item);
                        self.mostrar(true);
                        self.indicePaginado(self.lista().indexOf(self.selectedResult()));
                    };
                    self.selectedResult = ko.observable();                                       
                    
                    self.selectPrevious = function () {
                        var index = self.indicePaginado()-1;
                        if (index < 0) 
                            index = self.topePaginado-1;
                        else if (index<(self.topePaginado-self.rowPerPage)){
                            var dif =self.topePaginado-self.lista().length;                            
                            if ((dif<self.rowPerPage)&&(dif>0))
                                index = self.topePaginado-(self.topePaginado-self.lista().length)-1;//self.rowPerPage;
                            else 
                                index = self.topePaginado-1;//self.rowPerPage;
                        }                       
                        self.selectedResult(self.lista()[index]);
                        self.indicePaginado(index);
                        self.mostrar(true);
                        
                    };
                    
                    
                    self.selectNext = function () {                                           
                        var index = self.indicePaginado()+1;
                        if (index>=self.topePaginado){
                            index = (self.topePaginado-self.rowPerPage);
                            if (index<0)
                                index=index*(-1);
                        }
                        else if (index >= self.lista().length) 
                            index = (self.topePaginado-self.rowPerPage);                       
                        self.selectedResult(self.lista()[index]);
                        self.indicePaginado(index);
                        self.mostrar(true);
                    };
                                      
                    //seleccion del elemento ENTER
                };    
            var vm = new ViewModel();
            ko.applyBindings(vm);
            
            $(window).keyup(function (evt) {
                if (evt.keyCode == 38) { //arriba
                    vm.selectPrevious();
                    vm.mostrar(true);
                } else if (evt.keyCode == 40) { //abajo
                    vm.selectNext();
                    vm.mostrar(true);
                } else if (evt.keyCode == 13){ //enter
                    
                }
            }); 
        </script>
</body>
</html>