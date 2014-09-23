
<%@page import="SAF.Datos.Facturacion.TipoFacturaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Facturación</title>
        <link href="CSS/contenedorPrincipal.css" rel="stylesheet">
         <script type="text/javascript" language="javascript" src="Librerias/buscarProducto/knockout-3.0.0.js"></script>
        <script type="text/javascript" language="javascript" src="Librerias/buscarProducto/jquery-1.11.1.min.js"></script>
        
        <!-- /menu -->
        <jsp:include page="include/menu.jsp"/>   
    </head>
    <body>
 <%-- 
<% TipoFacturaDAO fd = new TipoFacturaDAO(); 
            short aux = 101;
            fd.insertarTipoFactura(aux, "Factura");
            aux = 102;
            fd.insertarTipoFactura(aux, "Nota de crédito");
            

%>
  --%>
        
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
        
       
        <div id ="contenedorPrincipal" align="center" data-bind="visible: $root.buscarProd"> <jsp:include page="include/buscarProductoFactura.jsp"/>  </div>
        <div id ="contenedorPrincipal" align="center" data-bind="visible: $root.realizandoFactura">
                <div id="rF">
                
                <table width="100%">
                    <tr>
	<td>
		<!--Primera Linea-->
		<table>
			<%-- Fila 1 --%>
			<tr>
				
                                
                                <td>
                                   <i class="icon-user"></i>&nbsp<strong>Cajero: </strong> 
                                </td>
                                <td>
                                   <i class="icon-calendar"></i>&nbsp <strong>Fecha: </strong>
                                </td>
				
			</tr>
                        <tr>
                            <td><br><i class="icon-user"></i>&nbsp<strong> Vendedor &nbsp &nbsp</strong><select data-bind="options: $root.vendedores, value: vendedor, optionsText: 'nombreVendedor'"></select></td>
                        </tr>
			<%-- Fila 2 --%>
			<%--
			<tr>
				<td>
					<div class="row-fluid">
						<form name="form2" action="" method="post">
							<strong class="textoLugarMedio" >Cliente</strong>
							<input type="text" autofocus list="browsers" name="buscar" autocomplete="off" class="input-medium" required>
							<datalist id="browsers">
							</datalist>
						</form>
						
					</div>
				</td>  
				<td>
					<input type="submit" value="Nuevo cliente" />
				</td>
			</tr>
                        --%>
			<%-- Fila 3 --%>
			<%--
			<tr >
			<table>
				<tbody>
					<tr>                                       
						<td> <strong>RUT </strong><input type="checkbox" name="RUT" value="ON" /> </td>
						<td> <strong>Razón social</strong><input type="text" name="rSocial" value="" /></td>
						<td> <strong>RUT</strong> <input type="text" name="rut" value="" /></td>
					
					</tr>
				</tbody>
			</table>
			</tr>
                        --%>
			<%-- Fila 4 --%>
			<tr>
                        
                            <td>
                                <div >
                                    <form name="form2" action="" method="post">
                                        <br><br><i class="icon-barcode"></i>&nbsp<strong> Producto &nbsp &nbsp</strong><input type="text" autofocus list="browsers" name="buscar" autocomplete="off" class="input-xlarge" required 
                                                                                     data-bind="value: textoProducto, valueUpdate: 'input', executeOnEnter: buscarProducto" 
                                                                                     placeholder="Ingrese nombre o codigo del producto"/>
                                    </form>
                                </div> 
                            </td>
                            <td> 
                                <button class="btn btn-primary" data-bind="click: buscarProducto">Buscar el puto producto</button> <br>
                            </td>
			   
			</tr>
			<%-- Fila 5 --%>
			<tr>
				
				<%-- Tabla productos--%>
				<td width="70%">
                                    <br>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Cantidad</th>
								<th>Nombre</th>
								<th>Precio</th>
								<th>Descuento</th>
								<th>Receta</th>
								<th>Precio venta</th>
								<th>Subtotal</th>
							</tr>
						</thead>
                                                
                                                    <tbody>
							<tr>
								<td>2</td>
								<td>Aspirina</td>
								<td>$20</td>
								<td>10%</td>
								<td>...</td>
								<td>$18</td>
								<td>$36</td>
							</tr>
							<tr>
								<td>4</td>
								<td> Jarabe</td>
								<td>$80</td>
								<td>0%</td>
								<td>...</td>
								<td>$80</td>
								<td>$320</td>
							</tr>
                                                    </tbody>
                                                
					</table>
				</td>
						
				<%--Total--%>
				<td>
                                    <table>
                                        <tbody>
                                            <tr height="60%">
                                                <td>
                                                    <h3>&nbsp TOTAL </h3>
                                                    <h4>&nbsp $168.75</h4>
                                                </td>
                                            </tr>
                                            
                                        </tbody>
                                    </table>

					
				</td>
			

			</tr>

		</table>
		<!--Fin Primera Linea-->


	 </td>
</tr>
                </table> 
            </div>
            </div>
        </div>


    </body>
    
        <script type="text/javascript">
    // Para enter en buscar producto.
    ko.bindingHandlers.executeOnEnter = {
    init: function (element, valueAccessor, allBindingsAccessor, viewModel) {
        var allBindings = allBindingsAccessor();
        $(element).keypress(function (event) {
            var keyCode = (event.which ? event.which : event.keyCode);
            if (keyCode === 13) {
                allBindings.executeOnEnter.call(viewModel);
                return false;
            }
            return true;
        });
    }
}; 
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
    
            // Traer del controlador.
            self.vendedores = [
                { nombreVendedor: "Juan"},
                { nombreVendedor: "Jose"},
                { nombreVendedor: "Pedro"},
                { nombreVendedor: "Armando"},
                { nombreVendedor: "Adelfa"},
                { nombreVendedor: "Daniel"}
                
            ];   
            
            self.vendedor = ko.observable();
            //mostrar facturacion
            self.textoProducto = ko.observable();
            self.realizandoFactura=ko.observable(true);
            self.buscarProd=ko.observable(false);
            self.selectedResult = ko.observable();
            self.selectResult = function (item) {
                self.selectedResult(item);
                self.mostrarVer(true);
                self.mostrarBuscar(false);
            };
            self.buscarProducto = function (item) {
                var facturando = self.realizandoFactura();
                var buscando = self.buscarProd();
                self.realizandoFactura(!facturando);
                self.buscarProd(!buscando);
                var prod = self.textoProducto()
                self.filtro(prod.toString());
            };
            
            self.test = function(data , event){

                if (event.which == 13) {
                //call method here
                alert('Enter Key Pressed!');
                }   
            }
            
        };    
    var vm = new ViewModel();
    ko.applyBindings(vm);
</script>

</html>
