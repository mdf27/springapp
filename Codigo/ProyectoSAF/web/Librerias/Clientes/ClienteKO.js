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
    
    
    self.registrarCliente =  function(){
        var data = ko.toJSON({nombres: self.nombres(), apellidos: self.apellidos(), cedula: self.cedula(), direccion: self.direccion(),
        razon_social: self.razon_social(), fcreacion: f, descuento: self.descuento(), telefono: self.telefono(),
        email: self.email(), idTransaccion: 0});
        $.ajax({
            url:"guardarCliente.htm",
            datatype:'json',
            data: data,
            type: "post",
            contentType: 'application/json; charset=utf-8',
            success: function (data) {
                var message = data.Message;
            }
        });
        
     
    };   
 };
 

var vm = new ViewModel();
ko.applyBindings(vm);