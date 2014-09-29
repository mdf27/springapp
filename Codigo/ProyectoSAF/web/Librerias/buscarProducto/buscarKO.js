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

    self.isSelected = ko.observable(true);
    self.recetaSelected = ko.observable(false);
    self.hiddenSelected = ko.observable(false);
    self.setIsSelected = function(data) {
        this.isSelected(data);
        //this.hiddenSelected(true)
    };
    self.setSelectedReceta = function(data) {
        this.recetaSelected(data);
        //this.hiddenSelected(true)
    };
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
    self.selectPrevious = function() {
        var index = self.indicePaginado() - 1;
        if (index < 0)
            index = self.topePaginado - 1;
        else if (index < (self.topePaginado - self.rowPerPage)) {
            var dif = self.topePaginado - self.lista().length;
            if ((dif < self.rowPerPage) && (dif > 0))
                index = self.topePaginado - (self.topePaginado - self.lista().length) - 1;//self.rowPerPage;
            else
                index = self.topePaginado - 1;//self.rowPerPage;
        }
        self.selectedResult(self.lista()[index]);
        self.indicePaginado(index);
        self.guardarProducto(self.lista()[index]);

    };


    self.selectNext = function() {
        var index = self.indicePaginado() + 1;
        if (index >= self.topePaginado) {
            index = (self.topePaginado - self.rowPerPage);
            if (index < 0)
                index = index * (-1);
        }
        else if (index >= self.lista().length)
            index = (self.topePaginado - self.rowPerPage);
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
    //Nuevo
    // Para posterior registro de clientes.
    self.registrarCliente = function() {
    };

    // Traer del controlador.
    self.formasPago = [{formaPago: "Contado"}];
    self.formaPago = ko.observable();
//    self.formasPago = ko.computed(function() {
//        $.ajax({
//            url: "obtenerFormasPago.htm",
//            type: 'GET',
//            dataType: 'json',
//            responseType: "application/json",
//            headers: {
//                Accept: "application/json",
//                "Access-Control-Allow-Origin": "*"
//            },
//            success: function(result) {
//
//                alert(result);
//                return result;
//            }
//
//
//        });
//        
//    });

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
        self.actualizarLista();
        self.setIsSelected(true);
    };

    self.montoNetoGravIva = ko.observable(0);
    self.montoNetoGravIvaMin = ko.observable(0);
    self.montoTotal = ko.observable(0);
    self.montoTotalAPagar = ko.observable(0);
    self.productoSeleccionado = ko.observable(null);
    self.conRut = ko.observable();
    self.rSocial = ko.observable();
    self.nroRut = ko.observable();
    self.renglonesVacios = ko.observableArray([1, 1, 1, 1, 1]) // Chanchada para rengoles vacios.
    self.renglonesFactura = ko.observableArray();
    self.renglonesFacturaVO = ko.observableArray();
    self.conReceta = ko.observable(false);
    self.cantProd = ko.observable(1);
    self.descuento = ko.observable(0);
    self.total = ko.observable(parseFloat(0).toFixed(2));
    var f = new Date();
    self.fecha = ko.observable(f.getDate() + "/" + (f.getMonth() + 1) + "/" + f.getFullYear());
    self.guardarProducto = function(data) {
        self.productoSeleccionado(data);

    };

    self.estaProductoEnFactura = function(item) {
        var largo = parseInt(self.renglonesFactura().length);
        var esta = false;
        for (i = 0; (i < largo) && !esta; i++) {
            var renglon = self.renglonesFactura()[i];
            // Es el mismo producto si tiene el mismo descuento, mismo codigo y ambos tienen o no receta.
            //var id = parseInt(renglon.codigo());
            var descuento = self.descuento();
            if (self.conReceta()) {
                if (item.descuentoReceta > descuento) {
                    descuento = item.descuentoReceta;
                }
            }
            if ((parseInt(renglon.codigo()) === item.idProducto) &&
                    (renglon.descuento() === descuento) &&
                    (renglon.receta() === self.conReceta())) {
                // Parsear a entero porque javascript toma el + como concatenacion.
                var cantAnterior = parseInt(renglon.cantidad());
                var subtotalAnterior = parseFloat(renglon.subtotal()).toFixed(2);
                self.renglonesFactura()[i].cantidad(cantAnterior + parseInt(self.cantProd()));
                self.renglonesFactura()[i].subtotal(subtotalAnterior + (parseFloat(renglon.precioVenta())).toFixed(2) * parseInt(self.cantProd()));
                esta = true;

            }

        }
        ;
        return esta;

    };

    // Cuando se seleccionar con click, primero se guardan los datos y despues se selecciona.
    self.selecccionarProductoClick = function(data) {
        self.guardarProducto(data);
        self.selecccionarProducto();
    };

    self.selecccionarProducto = function() {

        var item = self.productoSeleccionado();
        //var algo = self.descuento().match(/[0-9]+/);
        if ((self.descuento().length !== 0) && (self.cantProd().length !== 0)
                && (self.descuento() <= 100) && (self.descuento() >= 0) && (self.cantProd() >= 0)) {

            if (!self.estaProductoEnFactura(item)) {
                //Dependiendo del descuento, el precioVenta puede cambiar.
//                if(self.descuento() > item.descuento)
//                    var descuento // cambia.
                var descuento = (parseFloat(item.precioVenta) * parseFloat(self.descuento())) / 100;
                var precioConDesc = parseFloat(parseFloat(item.precioVenta) - descuento).toFixed(2);
                if (self.conReceta()) {
                    if (item.farmaDescuento < precioConDesc)
                        precioConDesc = item.farmaDescuento;
                    self.descuento(item.descuentoReceta);
                }



                self.precioVenta = ko.observable(precioConDesc);
                var subtotal = parseFloat(self.precioVenta()) * parseFloat(self.cantProd());
                self.subtotal = ko.observable(parseFloat(subtotal).toFixed(2));

                self.renglonesFactura.push(new renglonFactura({cantidad: self.cantProd(),
                    descripcion: item.descripcion,
                    precio: item.precioLista,
                    receta: self.conReceta(),
                    subtotal: self.subtotal(),
                    descuento: self.descuento(),
                    precioVenta: self.precioVenta(),
                    codigo: item.idProducto, // Nuevo
                    tipoIVA: item.tipoIVA,
                    porcentajeIVA: item.porcentajeIva


                })

                        );
                self.renglonesFacturaVO.push(new renglonFacturaVO({
                    idTipoFactura: 0, // Falta integrar tipo factura.
                    idFactura: 0,
                    idProducto: item.idProducto,
                    precioProducto: item.precioLista,
                    precioVtaReal: self.precioVenta(),
                    descDescripcion: null,
                    descCantBonif: 0,
                    descPorcentBonif: self.descuento(),
                    idTransaccion: 0,
                    idRenglonFactura: self.renglonesFacturaVO().length + 1,
                    cantidad: self.cantProd(),
                    conReceta: self.conReceta()
                })
                        );
                self.renglonesVacios.pop();

                // Renglon recien insertado.
                var renglon = self.renglonesFactura()[self.renglonesFactura().length - 1];

                // Actualizo montos.
                var precioListaSinIva = (parseFloat(renglon.precio()) * 100) / (parseFloat(100 + parseFloat(renglon.porcentajeIVA())));
                var descIva = parseFloat(renglon.precio()) - precioListaSinIva;
                // Calculos montoIva
                if (renglon.tipoIVA() === "basico") {
                    var montoAnterior = parseFloat(self.montoNetoGravIva());
                    self.montoNetoGravIva(montoAnterior + (descIva * parseInt(renglon.cantidad())));

                } else if (renglon.tipoIVA() === "minimo") {
                    var montoAnterior = parseFloat(self.montoNetoGravIvaMin());
                    self.montoNetoGravIvaMin(montoAnterior + descIva * parseInt(renglon.cantidad()));
                }
                // Calculo monto total sin iva.
                var montoTotalAnterior = parseFloat(self.montoTotal());
                self.montoTotal(montoTotalAnterior + parseFloat(renglon.precioVenta() - descIva) * parseInt(renglon.cantidad()));
                // Calculo monto total con iva.
                var subtotal = parseFloat(renglon.subtotal());
                var totalAnterior = parseFloat(self.total());
                self.total(parseFloat(totalAnterior + subtotal).toFixed(2));

            }
            ;
            self.realizandoFactura(true);
            self.buscarProd(false);

            // Seteo variables a valores por defecto
            self.cantProd(1);
            self.descuento(0);
        }

        self.productoSeleccionado(null);
    };

//    // Enviar la factura
    self.realizarFactura = function() {
        var date = new Date();
        var timestamp = date.getTime();


        //var renglonData = ko.toJSON(self.renglonesFacturaVO()[0]) // Ver que pasa cuando no hay rut y r social, que manda?
        var data = ko.toJSON({idTipoFactura: 101, idFactura: 0, idCliente: 1, rut: self.nroRut(),
            razonSocial: self.rSocial(), fecha: timestamp, descuento: 0, montoNetoGravIva: self.montoNetoGravIva(),
            montoNetoGravIvaMin: self.montoNetoGravIvaMin(), montoTotal: self.montoTotal(), montoTotalAPagar: self.total(), idTransaccion: 100, renglones: self.renglonesFacturaVO});
        alert(data);
        $.ajax("ingresarFactura.htm", {
            data: "json=" + data,
            type: "post",
            headers: {
                "Access-Control-Allow-Origin": "*",
            },
        });

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
    this.codigo = ko.observable(data.codigo);
    this.tipoIVA = ko.observable(data.tipoIVA);
    this.porcentajeIVA = ko.observable(data.porcentajeIVA);
}
;

function renglonFacturaVO(data) {
    this.idTipoFactura = 101;
    this.idFactura = 0;
    this.idProducto = ko.observable(data.idProducto);
    ;
    this.precioProducto = ko.observable(data.precioProducto);
    this.precioVtaReal = ko.observable(data.precioVtaReal);
    this.descDescripcion = ko.observable("");
    this.descCantBonif = ko.observable(0);
    this.descPorcentBonif = ko.observable(data.descPorcentBonif);
    this.idTransaccion = 0;
    this.idRenglonFactura = ko.observable(data.idRenglonFactura);
    this.cantidad = ko.observable(data.cantidad);
    this.conReceta = ko.observable(data.conReceta);
}
;

var vm = new ViewModel();
ko.applyBindings(vm);

$(window).keyup(function(evt) {
    if (evt.keyCode == 38) { //arriba
        vm.setIsSelected(false);
        vm.setSelectedReceta(true);
        vm.selectPrevious();
        
    } else if (evt.keyCode == 40) { //abajo
        vm.setIsSelected(false);
        vm.setSelectedReceta(true);
        vm.selectNext();
    } else if (evt.keyCode == 13) { //enter
        if(vm.productoSeleccionado()!== null){
            vm.selecccionarProducto();
        }
        
    }
});

