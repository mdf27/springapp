
<%@page import="SAF.Datos.Facturacion.TipoFacturaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Facturación</title>
        <link href="CSS/contenedorPrincipal.css" rel="stylesheet">    
        
        <!-- /menu -->
        <jsp:include page="include/menu.jsp"/>   
    </head>
    <body>
<% TipoFacturaDAO fd = new TipoFacturaDAO(); 
            short aux = 101;
            fd.insertarTipoFactura(aux, "Factura");
            aux = 102;
            fd.insertarTipoFactura(aux, "Nota de crédito");
            

%>
        
        <div id="contenedor">

            <div id = "leftColuma">  
                <jsp:include page="include/menuFacturacion.jsp"/>  
            </div>

            <script type="text/javascript">
                
            function getAway() {
                // Replace current site with another benign site
                window.location.replace('index.html');
            }

            $(function() {

                $("#get-away").on("click", function(e) {
                    getAway();
                });

                $("#get-away a").on("click", function(e) {
                    // allow the (?) link to work
                    e.stopPropagation();
                });

                $(document).keyup(function(e) {
                    if (e.keyCode == 27) { // escape key
                        getAway();
                    }
                });

            });
        </script>
        
            <div align="center" id ="contenedorPrincipal">
                <table width="90%">
                    <tr>
                        <td>
                            <!--Primera Linea-->
                            <table class="table table-bordered">
                                <tr class="well">
                                    <td>
                                        <div class="row-fluid"> 
                                            <div class="span6">
                                                <div class="row-fluid">
                                                    <i class="icon-user"></i><strong>Vendedor: </strong> <br>
                                                </div>
                                            </div>

                                            <div class="span6">
                                                <i class="icon-calendar"></i> <strong>Fecha: </strong> 
                                            </div>
                                            <!--
                                            <div class="span6">
                                                <form name="form2" action="" method="post">
                                                    <strong>Codigo o Nombre del Producto</strong><br>
                                                    <input type="text" autofocus list="browsers" name="buscar" autocomplete="off" class="input-xxlarge" required>
                                                    <datalist id="browsers">
                                                    </datalist>
                                                </form>
                                            </div>
                                            -->
                                        </div>
                                    </td>
                                </tr>
                                <tr >
                                    <td>
                                        <div class="span6">
                                            <form name="form2" action="" method="post">
                                                <strong class="textoLugarMedio" >Cliente</strong>
                                                <input type="text" autofocus list="browsers" name="buscar" autocomplete="off" class="input-medium" required>
                                                <datalist id="browsers">
                                                </datalist>
                                            </form>
                                        </div>
                                    </td>   
                                </tr>

                            </table>
                            <!--Fin Primera Linea-->


                        </td>
                    </tr>
                </table>  
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
