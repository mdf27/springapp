function ViewModel() {
    var self = this;
    self.nombres = ko.observable();
    self.apellidos = ko.observable();
    self.cedula = ko.observable();
    self.direccion = ko.observable();
    self.telefono = ko.observable();
    self.email = ko.observable();
    self.razon_social = ko.observable();
    self.rut = ko.observable();
    self.descuento = ko.observable(); 
    var f = new Date();
    
    
    self.altaCliente =  function(){
        var data = ko.toJSON({nombres: self.nombres(), apellidos: self.apellidos(), direccion: self.direccion(),
         telefono: self.telefono(),email: self.email(), cedula: self.cedula(),razon_social: self.razon_social(), 
         rut: self.rut(),descuento: self.descuento(),fcreacion: f,idTransaccion: 0});
    
        $.ajax("registrarCliente.html", {
            data: "json=" + data,
            type: "post",
            headers: {
                "Access-Control-Allow-Origin": "*",
            },
                        success: function (data) {
                var message = data.Message;
            }
        });
        
     
    };   
 };
 

var vm = new ViewModel();
ko.applyBindings(vm);