// Para enter en buscar producto.
ko.bindingHandlers.executeOnEnter = {
    init: function(element, valueAccessor, allBindingsAccessor, viewModel) {
        var allBindings = allBindingsAccessor();
        $(element).keypress(function(event) {
            var keyCode = (event.which ? event.which : event.keyCode);
            if (keyCode === 13) {
                allBindings.executeOnEnter.call(viewModel);
                return false;
            }
            return true;
        });
    }
};

function ViewModel() {
    var self = this;
    self.lista = ko.observableArray();
    self.filtro = ko.observable();

    //paginado
    self.pageNumber = ko.observable(1);
    self.rowPerPage = 5;
    self.indicePaginado = ko.observable(-1);

    self.timerID;
    self.buscar = function() {
        if (self.filtro() && self.filtro().length > 2) {
            var buscar = "";
            if (self.selectedOptionValueFiltro() == "Código:") {
                buscar = "numero"
            } else if (self.selectedOptionValueFiltro() == "Laboratorio:") {
                buscar = "laboratorio"
            } else if (self.selectedOptionValueFiltro() == "Droga:") {
                buscar = "Droga"
            } else if (self.selectedOptionValueFiltro() == "Presentacion:") {
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
                success: self.cargarLista
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
                } else if (self.selectedOptionValue() == "Precio descendente") {
                    self.lista.sort(function(a, b) {
                        return a.precio > b.precio ? -1 : 1;
                    });
                } else if (self.selectedOptionValue() == "Precio ascendente") {
                    self.lista.sort(function(a, b) {
                        return a.precio < b.precio ? -1 : 1;
                    });
                } else if (self.selectedOptionValue() == "Laboratorio descendente") {
                    self.lista.sort(function(a, b) {
                        return a.lab > b.lab ? -1 : 1;
                    });
                } else if (self.selectedOptionValue() == "Laboratorio ascendente") {
                    self.lista.sort(function(a, b) {
                        return a.lab < b.lab ? -1 : 1;
                    });
                }
                ;
            };

    self.actualizarLista = function(d) {
        self.timerID = window.clearTimeout(self.timerID);
        self.timerID = window.setTimeout(function() {
            self.buscar();
        }
        , 100);
        return true;
    };

    self.cargarLista = function(d) {
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

    self.isSelected = ko.observable(true);
    self.hiddenSelected = ko.observable(false);
    self.setIsSelected = function() { this.isSelected(false); this.hiddenSelected(true) };
    //ordenar                    
    self.optionValues = ["Nombre descendente", "Nombre ascendente", "Precio descendente", "Precio ascendente", "Laboratorio descendente", "Laboratorio ascendente"],
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

    //teclado
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
        self.guardarProducto(self.lista()[index]);

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
        self.guardarProducto(self.lista()[index]);
    };

    
    // Traer del controlador.
    self.vendedores = [
        {nombreVendedor: "Juan"},
        {nombreVendedor: "Jose"},
        {nombreVendedor: "Pedro"},
        {nombreVendedor: "Armando"},
        {nombreVendedor: "Adelfa"},
        {nombreVendedor: "Daniel"}

    ];
    
    // Traer del controlador.
    self.formasPago = [{formaPago: "Contado"},{formaPago: "Credito"}];
    self.formaPago = ko.observable();

    self.vendedor = ko.observable();
    //mostrar facturacion
    self.textoProducto = ko.observable();
    self.realizandoFactura = ko.observable(true);
    self.buscarProd = ko.observable(false);

    self.buscarProducto = function(item) {
        var facturando = self.realizandoFactura();
        var buscando = self.buscarProd();
        self.realizandoFactura(!facturando);
        self.buscarProd(!buscando);
        var prod = self.textoProducto();
        self.filtro(prod.toString());
    };

    

    self.renglonesFactura = ko.observableArray();
    self.conReceta = ko.observable();
    self.cantProd = ko.observable();
    self.descuento = ko.observable();
//    this.total = ko.computed(function() {
//        var total = 0;
////        for(i= 0; i < renglonesFactura().length; i++){
////            total+= renglonesFactura()[i];
////        }    
//        return total;
//    }, this);
    
    self.selecccionarProducto = function(item) {
        self.precioVenta = ko.observable(parseFloat(item.precioCompra)-
                                        ((parseFloat(item.precioCompra)*parseFloat(self.descuento()))/100)
                                        );
        self.subtotal = ko.observable(parseFloat(self.precioVenta())*parseFloat(self.cantProd()));
        
        self.renglonesFactura.push(new renglonFactura({ cantidad: self.cantProd(),
                                                        descripcion: item.descripcion,
                                                        precio: item.precioCompra,
                                                        receta: self.conReceta(),
                                                        subtotal: self.subtotal(),
                                                        descuento: self.descuento(),
                                                        precioVenta :self.precioVenta()
                                                     })
        );
        self.realizandoFactura(true);
        self.buscarProd(false);
        alert("Esta es la descripcion: " + item.descripcion);
    };

    // Enviar la factura
    self.realizarFactura = function(item) {
        var data = ko.toJSON([{renglones: self.renglonesFactura}, {nombre: "Pepe"}]);
        alert(data);
        $.post("/ingresarFactura.htm", data, function(returnedData) {
            // This callback is executed if the post was successful 
            alert(Ok);
        })
    };
}
;

function renglonFactura(data) {
    this.descripcion = ko.observable(data.descripcion);
    this.cantidad = ko.observable(data.cantidad);
    this.precio = ko.observable(data.precio);
    this.receta = ko.observable(data.receta);
    this.subtotal = ko.observable(data.subtotal);
    this.precioVenta = ko.observable(data.precioVenta);
    this.descuento = ko.observable(data.descuento);
}
;

var vm = new ViewModel();
ko.applyBindings(vm);
