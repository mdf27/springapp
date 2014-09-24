<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src='Librerias/jquery.js' type='text/javascript'></script>
        <link href="CSS/contenedorPrincipal.css" rel="stylesheet">
        <title>Inicio</title>
        <link href="CSS/bootstrap.css" rel="stylesheet">
        <link href="CSS/bootstrap-responsive.css" rel="stylesheet">
        <link href="CSS/menu.css" rel="stylesheet">
        <script src="Librerias/jquery.js"></script>
        <script src="Librerias/bootstrap/bootstrap-dropdown.js"></script>

        <script type="text/javascript" language="javascript" src="Librerias/buscarProducto/knockout-3.0.0.js"></script>
        <script type="text/javascript" language="javascript" src="Librerias/buscarProducto/jquery-1.11.1.min.js"></script>
        <link rel="stylesheet" href="CSS/style.css" />         
        <link rel="stylesheet" href="CSS/bootstrap.css" />         
        <link rel="stylesheet" href="CSS/search_box.css" />     

        <script type="text/javascript">            
           $(document).ready(function() {
             $('#facturacion').on('click', function() { 
                 $('#leftColuma').html('<div id = "tituloLeftMenu">Facturacion</div> <ul id="leftMenu"> <li><a href="realizarFacturacion.html"><i class="icon-plus"></i>Realizar factura</a></li><li><a href="#"><i class="icon-plus"></i>Crear nota de crédito</a></li> <li><a href="#"><i class="icon-search"></i>Facturas</a></li> <li class="divider"></li> <li><a href="#"><i class="icon-inbox"></i>Cerrar caja</a></li></ul>');
             });

             $('#stock').on('click', function() {      
                 $('#leftColuma').html('<div id = "tituloLeftMenu">Productos</div><ul id="leftMenu"><li><a href="#"><i class="icon-search"></i>Productos</a></li><li><a href="#"><i class="icon-plus"></i>Alta producto</a></li><li><a href="#"><i class="icon-search"></i>Descuntos</a></li> <li><a href="#"><i class="icon-plus"></i>Alta descuento</a></li><li><a href="#"><i class="icon-search"></i>Proveedores</a></li><li><a href="#"><i class="icon-plus"></i>Alta proveedor</a></li><li><a href="#"><i class="icon-refresh"></i>Actualizar base de datos</a></li></ul>');
             });


           });
        </script>  
    </head>
    <body>
        <div class="navbar navbar-inverse navbar-fixed-top">
                <div class="navbar-inner">
                    <div class="container">
                        <a class="brand" href="#" style="color:#FFF">Drogueria Uruguay</a>
                        <div class="nav-collapse collapse">

                            <ul class="nav">                                      
                                <li><a href="inicio.html" style="color:#FFF">Principal</a></li>                                                                            
                                <li><a href="#" id="facturacion" style="color:#FFF">Facturación</a></li> 
                                <li><a href="#" id="stock" style="color:#FFF">Stock</a></li> 

                                <li><a href="#" style="color:#FFF">Compras</a></li> 
                                <li><a href="#" style="color:#FFF">Clientes</a></li>   

                                <li><a href="#" style="color:#FFF">Reponer Stock</a></li> 
                                <li class="dropdown">
                                    <a href="#" style="color:#FFF" class="dropdown-toggle" data-toggle="dropdown">Más<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#"><i class="icon-signal"></i>Estadisticas</a></li>
                                        <li><a href="#"><i class="icon-wrench"></i>Ajustes</a></li>
                                    </ul>
                                </li>    
                            </ul>

                        </div><!--/.nav-collapse -->
                        <div id="contenedor">
                            <%String buscar= request.getParameter("buscar");%> 
                           <div id ="contenedorPrincipal" align="center" data-bind="visible: $root.mostrarBuscar"> <jsp:include page="include/buscarProducto.jsp"/>  </div>
                           <div id ="contenedorPrincipal" align="center" data-bind="if: $root.selectedResult,visible: $root.mostrarVer"> <jsp:include page="include/verProducto.jsp"/>  </div>
                        </div>
                    </div>
                </div>
        </div>
    </body>
    
    <script type="text/javascript">
        
    function ViewModel(){
            var self = this;
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
                        if(self.selectedOptionValueFiltro()=="Código:"){
                            buscar="numero"
                        }else if(self.selectedOptionValueFiltro()=="Laboratorio:"){
                            buscar="laboratorio"
                        }else if(self.selectedOptionValueFiltro()=="Droga:"){
                            buscar="Droga"
                        }else  if(self.selectedOptionValueFiltro()=="Presentacion:"){
                            buscar="presentacion"
                        }else  if(self.selectedOptionValueFiltro()=="Todo:"){
                            buscar="all"
                        }else{
                            buscar="descripcion"
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
                }
            };

            self.previous = function() {
                if(self.pageNumber() !== 0) {
                    self.pageNumber(self.pageNumber() - 1);
                    self.indicePaginado(self.topePaginado-2*self.rowPerPage-1);
                    self.topePaginado-=self.rowPerPage;
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
            };//evento buscar con filtro 

            //filtros
            self.optionValueFiltros = ["Nombre:","Código:", "Laboratorio:","Droga:","Presentación:","Todo:"],
            self.selectedOptionValueFiltro= ko.observable("Nombre:")                                                       
    
            //mostrar info producto
            self.mostrarBuscar=ko.observable(true);
            self.mostrarVer=ko.observable(false);
            self.selectedResult = ko.observable();
            self.selectResult = function (item) {
                self.selectedResult(item);
                self.mostrarVer(true);
                self.mostrarBuscar(false);
            };
            
        };    
    var vm = new ViewModel();
    ko.applyBindings(vm);
</script>
</html>
