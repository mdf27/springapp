function ViewModel() {
    var self = this;
    var f = new Date(2014,8,20);
    self.fechaActualizar = ko.observable(f.getDate() + "/" + (f.getMonth() + 1) + "/" + f.getFullYear());
    self.agregados = ko.observableArray();
    self.aumentaron = ko.observableArray();
//    self.disminuyeron = ko.observableArray();
//    self.habilitaron = ko.observableArray();
//    self.deshabilitaron = ko.observableArray();
//    self.mostrarError = ko.observable(false);
//
    self.primeraVez = ko.observable(true);
    self.mostrarVerActualizacion = ko.observable(false);
   // self.selectedActualizacion = ko.observable(false);
    self.actualizar = function() {
        $.ajax({
            url: "actualizar.json",
            type: 'GET',
            dataType: 'json',
            data: "fecha="+ self.fechaActualizar(),
            responseType: "application/json",
            headers: {
                Accept: "application/json",
                "Access-Control-Allow-Origin": "*"
            },
            success: function(d) {
                if (self.primeraVez()){
                    self.primeraVez(false);
                } else {
                    self.cargarListas(d);
                    self.setFecha();
                    self.mostrarVerActualizacion(true);  
                } 
            }
        });
    };
    
    
//    self.cargarListas = function(d) {
//        self.mostrarError(false);
//        self.agregados.removeAll();
//        for (var i = 0; i < d.size(); i++) {
//            self.agregados.push(d[i]);
//        }
//    };
    
    
    self.cargarListas = function(d) {
        self.agregados.removeAll();
        self.aumentaron.removeAll();
        for (var i = 0; i < d.agregados.length; i++) {
            self.agregados.push(d.agregados[i]);
        }
        for (var i = 0; i < d.aumentaron.length; i++) {
            self.aumentaron.push(d.aumentaron[i]);
        }
    };
//    
//    
//    
//    
//    
//    self.cargarListas = function(d) {
//        self.mostrarError(false);
//        self.agregados.removeAll();
//        self.aumentaron.removeAll();
//        self.disminuyeron.removeAll();
//        self.habilitaron.removeAll();
//        self.deshabilitaron.removeAll();
//        for (var i = 0; i < d.get("agregados").size(); i++) {
//            self.agregados.push(d.get("agregados")[i]);
//        }
//        for (var i = 0; i < d.get("aumentaron").size(); i++) {
//            self.aumentaron.push(d.get("aumentaron")[i]);
//        }
//        for (var i = 0; i < d.get("disminuyeron").size(); i++) {
//            self.disminuyeron.push(d.get("disminuyeron")[i]);
//        }
//        for (var i = 0; i < d.get("habilitaron").size(); i++) {
//            self.habilitaron.push(d.get("habilitaron")[i]);
//        }
//        for (var i = 0; i < d.get("deshabilitaron").size(); i++) {
//            self.deshabilitaron.push(d.get("deshabilitaron")[i]);
//        }
//    };
    
    self.setFecha = function() {
        var f = new Date();
        self.fechaActualizar(f.getDate() + "/" + (f.getMonth() + 1) + "/" + f.getFullYear());
    };
    

    //paginado
//    self.pageNumber = ko.observable(1);
//    self.rowPerPage = 5;
//    self.indicePaginado = ko.observable(-1);

};

var vm = new ViewModel();
ko.applyBindings(vm);