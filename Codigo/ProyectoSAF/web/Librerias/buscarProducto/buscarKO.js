function ViewModel(){
		var self = this;
		self.lista = ko.observableArray();
                var scriptPram = document.getElementById('buscarScript');
                var lala = scriptPram.getAttribute('data-buscar');
		self.filtro = ko.observable(lala);		
		//paginado
		self.pageNumber = ko.observable(1);
		self.rowPerPage = 5;
		self.indicePaginado=ko.observable(-1);

		self.timerID;
		self.buscar= function(){
			if (self.filtro() && self.filtro().length >2){
					var buscar="";
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
                                            url: "busqueda.json",
                                            type:'GET',    
                                            dataType: 'json',
                                            data : "buscar=" + self.filtro() + "&filtro="+buscar,
                                            responseType:"application/json",
                                            headers: {
                                                Accept:"application/json",
                                                "Access-Control-Allow-Origin": "*"
                                            },
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
		
		self.atras = function(){
			self.mostrarVer(false);
			self.mostrarBuscar(true);
		};
                if (lala!=null){
                    self.buscar();
                    lala=null;
                }		
	};    
var vm = new ViewModel();
ko.applyBindings(vm);
