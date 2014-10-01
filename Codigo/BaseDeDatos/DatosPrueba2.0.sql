USE safdb;
INSERT INTO TipoIVA (idTipoIVA, descripcion, porcentaje) values (0, "excento", 0);
INSERT INTO TipoIVA (idTipoIVA, descripcion, porcentaje) values (1, "minimo", 10);
INSERT INTO TipoIVA (idTipoIVA, descripcion, porcentaje) values (2, "basico", 22);


INSERT INTO Producto (idTipoIVA, descripcion, precioCompra, precioVenta, habilitado) values (2, "PROT.LABIAL BLISTEX MENTA
", 47,47,true);
INSERT INTO Producto (idTipoIVA, descripcion, precioCompra, precioVenta, habilitado) values (2, "VOLTAREN  75  5 AMP", 240,220.8,true);
INSERT INTO Producto (idTipoIVA, descripcion, precioCompra, precioVenta, habilitado) values (2, "VOLTAREN RETARD 100 MG", 207,190.44,true);
INSERT INTO Producto (idTipoIVA, descripcion, precioCompra, precioVenta, habilitado) values (1, "ATARAXONE 25MG 20COMP", 142,142,true);
INSERT INTO Producto (idTipoIVA, descripcion, precioCompra, precioVenta, habilitado) values (1, "AMOXIDAL 250 MG SUSP", 111.85,111.85,false);
INSERT INTO Producto (idTipoIVA, descripcion, precioCompra, precioVenta, habilitado) values (0, "SINCRONEX 10MG 20CAP", 76,76,true);

-- select * from producto;

INSERT INTO Stock (idProducto, cantidad) values (100000,10);
INSERT INTO Stock (idProducto, cantidad) values (100001,5);
INSERT INTO Stock (idProducto, cantidad) values (100002,15);
INSERT INTO Stock (idProducto, cantidad) values (100003,8);
INSERT INTO Stock (idProducto, cantidad) values (100004,20);
INSERT INTO Stock (idProducto, cantidad) values (100005,10);
-- use safdb;
-- select * from stock;
-- select * from producto;

INSERT INTO CodigoProducto (idProducto, codigo) values (100000,9241);
INSERT INTO CodigoProducto (idProducto, codigo) values (100001,1568);
INSERT INTO CodigoProducto (idProducto, codigo) values (100002,1570);
INSERT INTO CodigoProducto (idProducto, codigo) values (100003,4589);
INSERT INTO CodigoProducto (idProducto, codigo) values (100004,486);
INSERT INTO CodigoProducto (idProducto, codigo) values (100005,1160);

-- update codigoproducto set codigo="TAJ03" where idProducto=1;
-- update codigoproducto set codigo="7730202059867" where idProducto=2;
-- update codigoproducto set codigo="7795306152135" where idProducto=3;
-- update codigoproducto set codigo="7795347000044" where idProducto=4;
-- update codigoproducto set codigo="7730482001013" where idProducto=5;
-- update codigoproducto set codigo="7730941120316" where idProducto=6;

-- select * from codigoproducto;

-- delete from codigoproducto where idcodigoproducto=9;
-- delete from codigoproducto where idcodigoproducto=10;
-- delete from codigoproducto where idcodigoproducto=11;
-- delete from codigoproducto where idcodigoproducto=12;
-- delete from codigoproducto where idcodigoproducto=13;
-- delete from codigoproducto where idcodigoproducto=14;

INSERT INTO Laboratorio (nombre) values ("CAI");
INSERT INTO Laboratorio (nombre) values ("TAJ");
INSERT INTO Laboratorio (nombre) values ("GRA");
INSERT INTO Laboratorio (nombre) values ("LAZ");
INSERT INTO Laboratorio (nombre) values ("ANT");

-- delete from laboratorio where idlaboratorio=0;
-- select * from laboratorio;
-- select * from presentacion;

INSERT INTO Presentacion (descripcion) values ("comprimidos");

INSERT INTO Medicamento (idProducto,idPresentacion, idLaboratorio,requiereReceta) values (100001,1,3,true);
INSERT INTO Medicamento (idProducto,idPresentacion,idLaboratorio,requiereReceta) values (100002,1,3,true);
INSERT INTO Medicamento (idProducto,idPresentacion,idLaboratorio,requiereReceta) values (100003,1,4,true);
INSERT INTO Medicamento (idProducto,idPresentacion,idLaboratorio,requiereReceta) values (100004,1,5,false);
INSERT INTO Medicamento (idProducto,idPresentacion,idLaboratorio,requiereReceta) values (100005,1,1,true);

-- select * from medicamento;
-- select * from proveedor;
INSERT INTO Proveedor (documento,nombre,telefono,email,web,habilitado,fcreacion) values ("38654060","Ma José Rabaza", "24089876", "majo@hotmail.com","www.majo.com.uy",1,CURRENT_DATE);
INSERT INTO Proveedor (documento,nombre,telefono,email,web,habilitado,fcreacion) values ("41621431","Johann Pérez", "24256754", "johann@hotmail.com","www.johann.com.uy",0,CURRENT_DATE);
INSERT INTO Proveedor (documento,nombre,telefono,email,web,habilitado,fcreacion) values ("34562341","Daniela Fagúndez", "24321754", "dani@gmail.com","www.dani.com.uy",1,CURRENT_DATE);
INSERT INTO Proveedor (documento,nombre,telefono,email,web,habilitado,fcreacion) values ("43162345","Fernanda Toledo", "24091114", "fer@gmail.com","www.fer.com.uy",1,CURRENT_DATE);
INSERT INTO Proveedor (documento,nombre,telefono,email,web,habilitado,fcreacion) values ("42111621","Gonzalo Mercadante", "24123354", "gonza@gmail.com","www.gonza.com.uy",1,CURRENT_DATE);

-- select * from productoproveedor;

INSERT INTO ProductoProveedor (idProducto,idProveedor) values (100000,1);
INSERT INTO ProductoProveedor (idProducto,idProveedor) values (100001,3);
INSERT INTO ProductoProveedor (idProducto,idProveedor) values (100002,1);
INSERT INTO ProductoProveedor (idProducto,idProveedor) values (100003,5);
INSERT INTO ProductoProveedor (idProducto,idProveedor) values (100004,4);
INSERT INTO ProductoProveedor (idProducto,idProveedor) values (100005,2);

INSERT INTO Droga (idDroga,nombre) values (1,"drogaVolateren");
INSERT INTO Droga (idDroga,nombre) values (2,"drogaAtaraxone");
INSERT INTO Droga (idDroga,nombre) values (3,"drogaXylo");
INSERT INTO Droga (idDroga,nombre) values (4,"drogaSincronex");

INSERT INTO DrogaMedicamento (idDroga,idProducto) values (1,100001);
INSERT INTO DrogaMedicamento (idDroga,idProducto) values (1,100002);
INSERT INTO DrogaMedicamento (idDroga,idProducto) values (2,100003);
INSERT INTO DrogaMedicamento (idDroga,idProducto) values (3,100004);
INSERT INTO DrogaMedicamento (idDroga,idProducto) values (4,100005);

INSERT INTO AccionTerapeutica (descripcion) values ("atVoltaren");
INSERT INTO AccionTerapeutica (descripcion) values ("atAtaraxone");
INSERT INTO AccionTerapeutica (descripcion) values ("atXylo");
INSERT INTO AccionTerapeutica (descripcion) values ("atSincronex");

INSERT INTO AccionTerapeuticaMedicamento (idAccionTerapeutica,idProducto) values (1,100001);
INSERT INTO AccionTerapeuticaMedicamento (idAccionTerapeutica,idProducto) values (1,100002);
INSERT INTO AccionTerapeuticaMedicamento (idAccionTerapeutica,idProducto) values (2,100003);
INSERT INTO AccionTerapeuticaMedicamento (idAccionTerapeutica,idProducto) values (3,100004);
INSERT INTO AccionTerapeuticaMedicamento (idAccionTerapeutica,idProducto) values (4,100005);

INSERT INTO VencimientoStock (idProducto,fecha) values (100000,'2014-08-30 19:05:00');
INSERT INTO VencimientoStock (idProducto,fecha) values (100001,'2015-08-30 19:05:00');
INSERT INTO VencimientoStock (idProducto,fecha) values (100002,'2016-09-15 19:05:00');
INSERT INTO VencimientoStock (idProducto,fecha) values (100002,'2020-01-11 19:05:00');
INSERT INTO VencimientoStock (idProducto,fecha) values (100002,'2023-10-05 19:05:00');
INSERT INTO VencimientoStock (idProducto,fecha) values (100003,'2016-08-25 19:05:00');
INSERT INTO VencimientoStock (idProducto,fecha) values (100004,'2023-10-05 19:05:00');
INSERT INTO VencimientoStock (idProducto,fecha) values (100005,'2023-10-05 19:05:00');

-- INSERT INTO CLIENTE (nombres,apellidos, telefono,direccion, fcreacion) VALUES ("Juan", "Garcia", 2144575,"Uruguay 123", CURRENT_DATE);
-- update cliente set email="juan_garcia@gmail.com", cedula=21223331, razon_social = "JG S.A", rut=11111111111, descuento=10.5 where idCliente=1;
-- update cliente set cedula=21223331, rut=111111111 where idCliente=1;
INSERT INTO TipoFactura VALUES(101,"Factura");
INSERT INTO TipoFactura VALUES(102,"Nota de credito");
-- select * from cliente
INSERT INTO TipoOfertaDescuento (idTipoOfertaDescuento,descripcion) VALUES (1,"Receta");
INSERT INTO TipoOfertaDescuento (idTipoOfertaDescuento,descripcion) VALUES (2,"Cliente");
INSERT INTO TipoOfertaDescuento (idTipoOfertaDescuento,descripcion) VALUES (3,"Producto");

INSERT INTO OfertaDescuento (idTipoOfertaDescuento,descripcion,porcentBonif) VALUES (3,"Producto",5); -- 100000
INSERT INTO OfertaDescuento (idTipoOfertaDescuento,descripcion,porcentBonif) VALUES (1,"Receta",40); -- 100001
INSERT INTO OfertaDescuento (idTipoOfertaDescuento,descripcion,porcentBonif) VALUES (1,"Receta",25); -- 100002
INSERT INTO OfertaDescuento (idTipoOfertaDescuento,descripcion,porcentBonif) VALUES (1,"Receta",40); -- 100003
INSERT INTO OfertaDescuento (idTipoOfertaDescuento,descripcion,porcentBonif) VALUES (1,"Receta",40); -- 100004
INSERT INTO OfertaDescuento (idTipoOfertaDescuento,descripcion,porcentBonif) VALUES (1,"Receta",25); -- 100005

INSERT INTO OfertaDescuentoProducto (idProducto,idOfertaDescuento) VALUES (100000,1);
INSERT INTO OfertaDescuentoProducto (idProducto,idOfertaDescuento) VALUES (100001,2);
INSERT INTO OfertaDescuentoProducto (idProducto,idOfertaDescuento) VALUES (100002,3);
INSERT INTO OfertaDescuentoProducto (idProducto,idOfertaDescuento) VALUES (100003,4);
INSERT INTO OfertaDescuentoProducto (idProducto,idOfertaDescuento) VALUES (100004,5);
INSERT INTO OfertaDescuentoProducto (idProducto,idOfertaDescuento) VALUES (100005,6);

-- select * from ofertadescuento
-- Usuarios
INSERT INTO Usuario values (0,"user1",1); 

-- Perfiles
INSERT INTO Perfil values (0,"Administrador");
INSERT INTO Perfil values (1,"Cajero");
INSERT INTO Perfil values (2,"Vendedor");
INSERT INTO Perfil values (3,"Cadete");
INSERT INTO Perfil values (4,"Encargado");

-- Funcionalidad
INSERT INTO Funcionalidad values (0,"Manejo de usuario","MU");
INSERT INTO Funcionalidad values (1,"Crear Nota de credito","CNC");
INSERT INTO Funcionalidad values (2,"Realizar devolucion de productos","RDP");
INSERT INTO Funcionalidad values (3,"Facturacion","F");
INSERT INTO Funcionalidad values (4,"Manejo de Clientes","MCLI");
INSERT INTO Funcionalidad values (5,"Crea cuenta corriente","CCC");
INSERT INTO Funcionalidad values (6,"Modificaciones de stock y precio","MSP");
INSERT INTO Funcionalidad values (7,"Ver productos","VP");
INSERT INTO Funcionalidad values (8,"Ver recomendaciones","VR");
INSERT INTO Funcionalidad values (9,"Ingresar compra","IC");
INSERT INTO Funcionalidad values (10,"Realizar compra recomendacion","RCR");
INSERT INTO Funcionalidad values (11,"Ver compras","VC");
INSERT INTO Funcionalidad values (12,"Manejo de caja","MCaja");
INSERT INTO Funcionalidad values (13,"Ver descuentos","VD");
INSERT INTO Funcionalidad values (14,"Administrar descuentos","AD");
INSERT INTO Funcionalidad values (15,"Actualizar stock y precios con DUSA","ASPD");
INSERT INTO Funcionalidad values (16,"Configurar Alertas","CA");


-- Perfil Usuario
INSERT INTO PerfilUsuario values (0,0);

-- Funcionalidad por Perfil

-- Funcionalidades perfil Administrador
INSERT INTO FuncionalidadPerfil values (0,0);
INSERT INTO FuncionalidadPerfil values (0,1);
INSERT INTO FuncionalidadPerfil values (0,2);
INSERT INTO FuncionalidadPerfil values (0,3);
INSERT INTO FuncionalidadPerfil values (0,4);
INSERT INTO FuncionalidadPerfil values (0,5);
INSERT INTO FuncionalidadPerfil values (0,6);
INSERT INTO FuncionalidadPerfil values (0,7);
INSERT INTO FuncionalidadPerfil values (0,8);
INSERT INTO FuncionalidadPerfil values (0,9);
INSERT INTO FuncionalidadPerfil values (0,10);
INSERT INTO FuncionalidadPerfil values (0,11);
INSERT INTO FuncionalidadPerfil values (0,12);
INSERT INTO FuncionalidadPerfil values (0,13);
INSERT INTO FuncionalidadPerfil values (0,14);
INSERT INTO FuncionalidadPerfil values (0,15);
INSERT INTO FuncionalidadPerfil values (0,16);
-- Funcionalidades perfil Cajero
INSERT INTO FuncionalidadPerfil values (1,3);
INSERT INTO FuncionalidadPerfil values (1,0);
INSERT INTO FuncionalidadPerfil values (1,7);
INSERT INTO FuncionalidadPerfil values (1,8);
INSERT INTO FuncionalidadPerfil values (1,9);
INSERT INTO FuncionalidadPerfil values (1,13);
-- Funcionalidad perfil Vendedor
INSERT INTO FuncionalidadPerfil values (2,3);
INSERT INTO FuncionalidadPerfil values (2,0);
INSERT INTO FuncionalidadPerfil values (2,7);
INSERT INTO FuncionalidadPerfil values (2,8);
INSERT INTO FuncionalidadPerfil values (2,9);
INSERT INTO FuncionalidadPerfil values (2,13);
-- Funcionalidad perfil Encargado
INSERT INTO FuncionalidadPerfil values (4,1);
INSERT INTO FuncionalidadPerfil values (4,2);
INSERT INTO FuncionalidadPerfil values (4,3);
INSERT INTO FuncionalidadPerfil values (4,4);
INSERT INTO FuncionalidadPerfil values (4,5);
INSERT INTO FuncionalidadPerfil values (4,6);
INSERT INTO FuncionalidadPerfil values (4,7);
INSERT INTO FuncionalidadPerfil values (4,8);
INSERT INTO FuncionalidadPerfil values (4,9);
INSERT INTO FuncionalidadPerfil values (4,10);
INSERT INTO FuncionalidadPerfil values (4,11);
INSERT INTO FuncionalidadPerfil values (4,12);
INSERT INTO FuncionalidadPerfil values (4,13);
INSERT INTO FuncionalidadPerfil values (4,14);
INSERT INTO FuncionalidadPerfil values (4,15);
INSERT INTO FuncionalidadPerfil values (4,16);


-- clientes 
-- select * from cliente
INSERT INTO Cliente (nombres,apellidos, telefono,direccion, fcreacion,email,cedula,razon_social,rut,descuento) VALUES ("Pablo", "Pérez", 21221175,"Sarandí 123", CURRENT_DATE,"pablo_perez@hotmail.com", 1223446,"PP S.A",222222,12.1);
INSERT INTO Cliente (nombres,apellidos, telefono,direccion, fcreacion,email,cedula,razon_social,rut,descuento) VALUES ("Sonia", "Chávez", 21299175,"Ejido 2111", CURRENT_DATE,"sonia_chavez@hotmail.com", 23431113,"SC S.A",33333333,9.0);
INSERT INTO Cliente (nombres,apellidos, telefono,direccion, fcreacion,email,cedula,razon_social,rut,descuento) VALUES ("Camila", "Rodríguez", 41233213,"18 de Julio 1234", CURRENT_DATE,"cami_rod@hotmail.com", 36547890,"CR S.A",4561563,22.9);
INSERT INTO Cliente (nombres,apellidos, telefono,direccion, fcreacion,email,cedula,razon_social,rut,descuento) VALUES ("Juan", "Garcia", 2144575,"Uruguay 123", CURRENT_DATE,"juan_garcia@hotmail.com", 3421232,"JG S.A",2223322,15.6);
INSERT INTO CuentaCliente (idCliente, saldo, tope,fcreacion) values (1,300,1000,current_date);
INSERT INTO CuentaCliente (idCliente, saldo, tope,fcreacion) values (2,200,1000,current_date);
INSERT INTO CuentaCliente (idCliente, saldo, tope,fcreacion) values (3,100,1000,current_date);
INSERT INTO CuentaCliente (idCliente, saldo, tope,fcreacion) values (4,50,1000,current_date);

