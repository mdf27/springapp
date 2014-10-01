function ViewModel() {
    
    var self = this;
    self.lista = ko.observableArray([]);
    self.filtro = ko.observable();
    self.mostrarError = ko.observable(false);
    //paginado
    self.pageNumber = ko.observable(1);
    self.rowPerPage = 5;
    self.indicePaginado = ko.observable(-1);
    
    self.busquedaActivada=ko.observable(false);        
    self.selectedResult = ko.observable();
    self.timerID;
    
    //cantidad
    self.filtroCantidad = ko.observable();
    
    self.mostrarCross = ko.observable(false);
    self.mostrarTick = ko.observable(false);
    
    self.cargaRealizada = ko.observable(false);
    self.cargarProductos= function (){
        if (!self.cargaRealizada()){
            $.ajax({
                url: "ajustarStock.json",
                type: 'GET',
                dataType: 'json',
                responseType: "application/json",
                headers: {
                    Accept: "application/json",
                    "Access-Control-Allow-Origin": "*"
                },
                success: self.cargarLista,
                error: function (jqXHR, textStatus, errorThrown) {
                    self.mostrarError(true);
                }
            });
        }
    };
    
    /*self.scrolled= function(data, event) {
        var elem = event.target;
        if (elem.scrollTop > (elem.scrollHeight - elem.offsetHeight - 200)) {
            getItems(1);
        }
    };*/
    
    self.buscar = function() {
        self.lista.removeAll();
        self.mostrarCross(false);
        self.mostrarTick(false);
        if (self.filtro() && self.filtro().length > 2) {
            var buscar = "";
            if (self.selectedOptionValueFiltro() == "Código:") {
                buscar = "codigos"
            } else if (self.selectedOptionValueFiltro() == "Laboratorio:") {
                buscar = "laboratorio"
            } else if (self.selectedOptionValueFiltro() == "Droga:") {
                buscar = "drogas"
            } else if (self.selectedOptionValueFiltro() == "Presentación:") {
                buscar = "presentacion"
            } else if (self.selectedOptionValueFiltro() == "Todo:") {
                buscar = "all"
            } else {
                buscar = "descripcion"
            }
            $.ajax({
                url: "busqueda.json",
                type: 'GET',
                dataType: 'json',
                data: "buscar=" + self.filtro() + "&filtro=" + buscar,
                responseType: "application/json",
                headers: {
                    Accept: "application/json",
                    "Access-Control-Allow-Origin": "*"
                },
                success: self.cargarLista,
                error: function(jqXHR, textStatus, errorThrown) {
                    self.mostrarError(true);
                }

            });
        }else if (self.filtro()<=0){
            self.cargarProductos();
            self.cargaRealizada(false);
            self.busquedaActivada(false);
            self.pageNumber(1);
            self.totalPages();
        }else{
            
        }
    };


    //ordenar
    self.selectedOptionValue = ko.observable("Nombre ascendente"),
    self.ordenar = function() {
        if (self.selectedOptionValue() == "Nombre descendente") {
            self.lista.sort(function(a, b) {
                return a.descripcion > b.descripcion ? -1 : 1;
            });
        } else if (self.selectedOptionValue() == "Nombre ascendente") {
            self.lista.sort(function(a, b) {
                return a.descripcion < b.descripcion ? -1 : 1;
            });
        } else if (self.selectedOptionValue() == "Precio Lista descendente") {
            self.lista.sort(function(a, b) {
                return a.precioLista > b.precioLista ? -1 : 1;
            });
        } else if (self.selectedOptionValue() == "Precio Lista ascendente") {
            self.lista.sort(function(a, b) {
                return a.precioLista < b.precioLista ? -1 : 1;
            });
        } else if (self.selectedOptionValue() == "Precio Venta descendente") {
            self.lista.sort(function(a, b) {
                return a.precioVenta > b.precioVenta ? -1 : 1;
            });
        } else if (self.selectedOptionValue() == "Farmadescuento descendente") {
            self.lista.sort(function(a, b) {
                return a.precioLista > b.precioLista ? -1 : 1;
            });
        } else if (self.selectedOptionValue() == "Farmadescuento ascendente") {
            self.lista.sort(function(a, b) {
                return a.precioLista < b.precioLista ? -1 : 1;
            });    
        } else if (self.selectedOptionValue() == "Precio Venta ascendente") {
            self.lista.sort(function(a, b) {
                return a.precioLista < b.precioLista ? -1 : 1;
            });    
        };
    };
    
    self.actualizarLista = function(d) {
        self.busquedaActivada(true);
        self.timerID = window.clearTimeout(self.timerID);
        self.timerID = window.setTimeout(function() {
            self.mostrarError(false);
            self.buscar();
        }
        , 100);
        return true;
    };

    self.cargarLista = function(d) {
        self.mostrarError(false);
        self.lista.removeAll();
        for (var i = 0; i < d.length; i++) {
            d[i].cantidad2=ko.observable(d[i].cantidad);
            self.lista.push(d[i]);
        }
       self.ordenar();
    };
    
    //paginado
    self.topePaginado = self.rowPerPage;
    self.totalPages = ko.computed(function() {
        var div = Math.floor(self.lista().length / self.rowPerPage);
        div += self.lista().length % self.rowPerPage > 0 ? 1 : 0;
        if (div !== 0)
            div -= 1;
        else
            div += 1;
        return div;
    });

    self.paginado = ko.computed(function() {
        if (self.totalPages() !== 0)
            return (self.pageNumber() + " de " + self.totalPages());
        else
            return (self.pageNumber() + " de 1");
    });

    self.hasPrevious = ko.computed(function() {
        return (self.pageNumber() !== 1);
    });

    self.hasNext = ko.computed(function() {
        return (self.totalPages() > 1) && (self.pageNumber() !== self.totalPages());
    });

    self.next = function() {
        if (self.pageNumber() < self.totalPages()) {
            self.pageNumber(self.pageNumber() + 1);
            self.indicePaginado(self.topePaginado + self.rowPerPage);
            if (self.indicePaginado < 0)
                self.indicePaginado = 0;
            self.topePaginado += self.rowPerPage;
        }
    };

    self.previous = function() {
        if (self.pageNumber() !== 0) {
            self.pageNumber(self.pageNumber() - 1);
            self.indicePaginado(self.topePaginado - 2 * self.rowPerPage - 1);
            self.topePaginado -= self.rowPerPage;
        }
    };

    self.hayResultado = ko.computed(function() {
        return (self.lista().length > 0);
    });

    self.paginated = ko.computed(function() {
        var first = (self.pageNumber() - 1) * self.rowPerPage;
        return self.lista.slice(first, first + self.rowPerPage);
    });
    
    self.cargadoInicial = ko.computed(function() {
        if (!self.busquedaActivada()){            
                self.cargarProductos();
                self.cargaRealizada(true);
                return self.lista();
            
        }else{
            return self.paginated();
        }
    });



    self.isSelected = ko.observable(true);
    self.hiddenSelected = ko.observable(false);
    self.setIsSelected = function() {
        this.isSelected(false);
        this.hiddenSelected(true)
    };
    //ordenar                    
    self.optionValues = ["Nombre descendente", "Nombre ascendente", "Precio Lista descendente", "Precio Lista ascendente", "Precio Venta descendente", "Precio Venta ascendente", "Farmadescuento descendente", "Farmadescuento ascendente"],
    //self.selectedChoice = ko.observable();
    self.selectionChanged = function(event) {
        self.ordenar();
    };//evento ordenar 

    self.filtroSelectionChanged = function(event) {
        self.buscar();
    };//evento buscar con filtro 

    //filtros
    self.optionValueFiltros = ["Nombre:", "Código:", "Laboratorio:", "Droga:", "Presentación:", "Todo:"],
            self.selectedOptionValueFiltro = ko.observable("Nombre:")

    //teclado
    self.selectPrevious = function() {
        var index = self.indicePaginado() - 1;
        if (index < 0){
            if (!self.busquedaActivada())
                index = self.lista().length - 1;
            else if (self.lista().length<self.topePaginado)
                index = self.lista().length - 1;
            else
                index = self.topePaginado - 1;
        }else if ((self.busquedaActivada())&&(index < (self.topePaginado - self.rowPerPage))) {
            var dif = self.topePaginado - self.lista().length;
            if ((dif < self.rowPerPage) && (dif > 0))
                index = self.topePaginado - (self.topePaginado - self.lista().length) - 1;//self.rowPerPage;
            else
                index = self.topePaginado - 1;//self.rowPerPage;
        }
        self.selectedResult(self.lista()[index]);
        self.indicePaginado(index);
    };

    
    self.selectNext = function() {
        var index = self.indicePaginado() + 1;
        
        if ((self.busquedaActivada())&&(index >= self.topePaginado)) {
            index = (self.topePaginado - self.rowPerPage);
            if (index < 0)
                index = index * (-1);
        }
        else if (index >= self.lista().length)
            index = (self.topePaginado - self.rowPerPage);
        self.selectedResult(self.lista()[index]);
        self.indicePaginado(index);
        //self.guardarProducto(self.lista()[index]);
    };
    
    //editar
    self.habilitarTick = function(){
        self.mostrarTick(true);
        self.mostrarCross(false);        
        
    };
    
    self.habilitarCross = function(cant){
        self.mostrarTick(false);
        self.mostrarCross(true);        
    };
    
    
    
    self.indice = ko.observable();
    
    self.select = function(item) {
        self.selected(item);
    };

    self.selected = ko.observable(self.lista()[0]);
    
    self.editingItem = ko.observable();
    self.isItemEditing = function(itemToTest) {
        return itemToTest== self.editingItem();
    };
    self.editando = ko.observable(false);
    self.ajustando = ko.observable(false);
    
    self.editar= function (i,item) {     
        self.mostrarCross(false);
        self.mostrarTick(false);
        self.ajustando(false);
        if (self.editando()==false){
            self.editando(true);
            self.indice(i);
            self.filtroCantidad(self.lista()[self.indice()].cantidad2());
            if (self.editingItem() == null) {           
                self.editingItem(item);
            }
        }
    };
    self.cancelar = function (){
        self.mostrarTick(false);
        self.mostrarCross(false);          
        self.filtroCantidad("");
        self.editingItem(null);
        self.editando(false);
    };   
    
    
    self.ajustar = function (item,i) { 
        if (self.editando()==true){
            self.ajustando(true);
            var cant = self.filtroCantidad();
            var id = self.lista()[self.indice()].idProducto;
            self.lista()[self.indice()].cantidad2(cant);//.replace(self.cantidad()[self.indice()],cant);
            $.ajax({
                url: "ajustarCantidadStock.htm",
                type: 'POST',
                delay: 20,
                data: {"cant": cant, "id": id},
                succes: self.habilitarTick(),
                error: function (){
                    self.habilitarCross(cantOK);
                }
            });
            self.filtroCantidad("");
            self.editingItem(null);
            self.editando(false);
        }
    };
    
    self.isTickMoment = function (i){
        return (i==self.indice()) && self.mostrarTick();
    };
    
    self.isCrossMoment = function (i){
        return (i==self.indice()) && self.mostrarCross();
    };
    
    self.enter = function (){
        if (self.editando())
            self.ajustar(self.selectedResult(),self.indicePaginado());     
        else
            self.editar(self.indicePaginado(),self.selectedResult());      
        
    };
    
    self.escape = function(){
        if (!self.ajustando())
            self.cancelar();
    };
};

var vm = new ViewModel();
ko.applyBindings(vm);

$(window).keyup(function(evt) {
    if (evt.keyCode == 38) { //arriba
        vm.setIsSelected();
        vm.selectPrevious();
    } else if (evt.keyCode == 40) { //abajo
        vm.setIsSelected();
        vm.selectNext();
    }else if (evt.keyCode == 13) { //enter
        vm.setIsSelected();
        vm.enter();
    }else if (evt.keyCode == 27) { //escape
        vm.escape();
    }
});

