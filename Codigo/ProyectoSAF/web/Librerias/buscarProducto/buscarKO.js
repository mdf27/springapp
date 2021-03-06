function ViewModel() {
    var self = this;
    
    self.lista = ko.observableArray();
    self.filtro = ko.observable();
    
    //mostrar error utilizado para cuando no hay resultados en la busqueda
    self.mostrarError = ko.observable(false);
    
    //paginado
    self.pageNumber = ko.observable(1);
    self.rowPerPage = 5;
    self.indicePaginado = ko.observable(-1);

    self.timerID;
    self.buscar = function() {
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
        } else {
            self.lista.removeAll();
            self.pageNumber(1);
            self.totalPages();
        }
    };


    //ordenar
    self.ordenarSelected=ko.observable(false);
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
        } else if (self.selectedOptionValue() == "Laboratorio descendente") {
            self.lista.sort(function(a, b) {
                return a.laboratorio > b.laboratorio ? -1 : 1;
            });
        } else if (self.selectedOptionValue() == "Laboratorio ascendente") {
            self.lista.sort(function(a, b) {
                return a.laboratorio < b.laboratorio ? -1 : 1;
            });
        }
        ;
    };

    self.actualizarLista = function(d) {
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
            self.lista.push(d[i]);
        }
        self.ordenar();
    };

    //paginado
    self.topePaginado = self.rowPerPage;
    self.totalPages = ko.computed(function() {
        var div = Math.floor(self.lista().length / self.rowPerPage);
        div += self.lista().length % self.rowPerPage > 0 ? 1 : 0;
        /*if (div !== 0)
            div -= 1;
        else
            div += 1;
        */
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
            self.selectedResult(null);
        }
    };

    self.previous = function() {
        if (self.pageNumber() >1) {
            self.pageNumber(self.pageNumber() - 1);
            self.indicePaginado(self.topePaginado - 2 * self.rowPerPage - 1);
            self.topePaginado -= self.rowPerPage;
            self.selectedResult(null);
        }
    };

    self.hayResultado = ko.computed(function() {
        return (self.lista().length > 0);
    });

    self.paginated = ko.computed(function() {
        var first = (self.pageNumber() - 1) * self.rowPerPage;
        return self.lista.slice(first, first + self.rowPerPage);
    });

    //ordenar                    
    self.optionValues = ["Nombre descendente", "Nombre ascendente", "Laboratorio descendente", "Laboratorio ascendente", "Precio Lista descendente", "Precio Lista ascendente", "Precio Venta descendente", "Precio Venta ascendente", "Farmadescuento descendente", "Farmadescuento ascendente"],
            //self.selectedChoice = ko.observable();
            self.selectionChanged = function(event) {
                self.ordenar();
                self.ordenarSelected(true);
            };//evento ordenar 

    self.filtroSelectionChanged = function(event) {
        self.buscar();
    };//evento buscar con filtro 

    //filtros
    self.optionValueFiltros = ["Nombre:", "Código:", "Laboratorio:", "Droga:", "Presentación:", "Todo:"],
            self.selectedOptionValueFiltro = ko.observable("Nombre:")

    //mostrar info producto
    self.mostrarBuscar = ko.observable(true);
    self.mostrarVer = ko.observable(false);
    self.selectedResult = ko.observable();
    self.selectResult = function(item) {
        self.selectedResult(item);
        self.indicePaginado(self.lista().indexOf(self.selectedResult()));
    };

    self.link = function (){
        self.mostrarVer(true);
        self.mostrarBuscar(false);
    };
    
    self.atras = function() {
        self.mostrarVer(false);
        self.mostrarBuscar(true);
    };
    
    //seleccion con teclado
    self.selectResult = function (item) {
        self.selectedResult(item);
        self.indicePaginado(self.lista().indexOf(self.selectedResult()));
    };
    self.selectedResult = ko.observable();                                       

    self.selectPrevious = function() {
        var index = self.indicePaginado() - 1;
        if (index < 0){
            if (self.lista().length<self.topePaginado)
                index = self.lista().length - 1;
            else
                index = self.topePaginado - 1;
        }else if(index < (self.topePaginado - self.rowPerPage)) {
            var dif = self.topePaginado - self.lista().length;
            if ((dif < self.rowPerPage) && (dif > 0))
                index = self.topePaginado - (self.topePaginado - self.lista().length) - 1;//self.rowPerPage;
            else
                index = self.topePaginado - 1;//self.rowPerPage;
        }
        self.selectedResult(self.lista()[index]);
        self.indicePaginado(index);
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
    };

    self.inputSelected=ko.observable(true);
    
    self.seleccionarInput = function (){
        self.selectedResult(null);
        self.inputSelected(true);
    };
    self.seleccionarOrdenar = function (){
        self.ordenarSelected(true);
    };
    
    self.enter = function(){
        if (self.inputSelected()){
            self.inputSelected(false);
        }else{    
            if (self.mostrarBuscar()==true){
                if (!self.ordenarSelected()){
                    self.mostrarBuscar(false);
                    self.mostrarVer(true);
                }else{
                    self.ordenarSelected(false);
                }
            }
        }
        
    };
    
    self.backspace = function(){
        if (self.mostrarVer()==true){
            self.mostrarBuscar(true);
            self.mostrarVer(false);
            self.inputSelected(true);
       }
    };

    self.tab = function (){
        self.selectedResult(null);
        self.inputSelected(false);
        self.ordenarSelected(true);
    };
}

var vm = new ViewModel();
ko.applyBindings(vm);

//eventos del teclado
$(window).keydown(function (evt) {
    if (evt.keyCode == 38) { //arriba
        if ((!vm.ordenarSelected())&&(!vm.inputSelected()))
            vm.selectPrevious();
    } else if (evt.keyCode == 40) { //abajo
        if ((!vm.ordenarSelected())&&(!vm.inputSelected()))
            vm.selectNext();
    } else if (evt.keyCode == 13){ //enter
        vm.enter();
    }else if (evt.keyCode == 8){ //backspace
        if (vm.mostrarVer())
            evt.preventDefault();
        vm.backspace();
    }else if (evt.keyCode == 9){ //tab
        if (vm.inputSelected()){
            if(evt.preventDefault) {
                evt.preventDefault();
            }
            vm.tab();
        }
    }else if ((evt.altKey)&&(evt.keyCode == 66)) { //ctrl-b
        vm.inputSelected(true);
    }else if (evt.keyCode == 37) { //left 
        vm.previous();
    }else if (evt.keyCode == 39) { //right
        vm.next();
    };
}); 
