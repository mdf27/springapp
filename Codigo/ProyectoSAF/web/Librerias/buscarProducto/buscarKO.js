function ViewModel() {
    var self = this;
    self.lista = ko.observableArray();
    self.filtro = ko.observable();
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

    // Para seleccion y focus de los campos.
    self.isSelected = ko.observable(true);
    self.recetaSelected = ko.observable(false);
    self.hiddenSelected = ko.observable(false);
    self.agregandoProducto = ko.observable(false);
    self.setIsSelected = function(data) {
        this.isSelected(data);
    };
    self.setSelectedReceta = function(data) {
        this.recetaSelected(data);
    };

    self.setSelectedProducto = function(data) {
        this.agregandoProducto(data);
    };
    //ordenar                    
    self.optionValues = ["Nombre descendente", "Nombre ascendente", "Laboratorio descendente", "Laboratorio ascendente", "Precio Lista descendente", "Precio Lista ascendente", "Precio Venta descendente", "Precio Venta ascendente", "Farmadescuento descendente", "Farmadescuento ascendente"],
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

    //mostrar info producto
    self.mostrarBuscar = ko.observable(true);
    self.mostrarVer = ko.observable(false);
    self.selectedResult = ko.observable();
    self.selectResult = function(item) {
        self.selectedResult(item);
        self.mostrarVer(true);
        self.mostrarBuscar(false);
        self.indicePaginado(self.lista().indexOf(self.selectedResult()));
    };

    self.atras = function() {
        self.mostrarVer(false);
        self.mostrarBuscar(true);
    };

}

var vm = new ViewModel();
ko.applyBindings(vm);


