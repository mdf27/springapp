<%-- 
    Document   : Start
    Created on : 02-sep-2014, 17:19:59
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prototipo Web Services D.U.S.A</title>
    </head>
    <body>
        
        <center>
            
            <h1> Prototipo Web Services D.U.S.A  </h1>
            
            <h2> Consulta Stock: </h2>
        
            <form action="ObtenerLaboratorios" method="POST">
            <input type="submit" value="Listar Laboratorios" name="botonLaboratorios" onclick="submit();"/>
            </form>
            <br/>

            <form action="ObtenerOfertas" method="POST">
            <input type="submit" value="Listar Ofertas" name="botonOfertas" onclick="submit();"/>
            </form>
            <br/>

            <form action="PreciosRecetas" method="POST">
            <input type="submit" value="Precios Recetas (TimeOut)" name="botonOfertas" onclick="submit();"/>
            </form>
            <br/>
            
            <form action="PruebaStock" method="POST">
            <input type="submit" value="Ver Stock (Lista Vacia!)" name="botonStock" onclick="submit();"/>
            </form>
            <br/>
            
            <form action="TiposIva" method="POST">
            <input type="submit" value="Ver Tipos IVA" name="botonTiposIva" onclick="submit();"/>
            </form>
            <br/>
            
            <form action="PruebaPDF" method="POST">
            <input type="submit" value="PruebaPDF" name="botonPruebaPDF" onclick="submit();"/>
            </form>
            <br/>
            
            <h2> Consulta Comprobantes: </h2>
            
            <form action="ObtenerComprobantesFecha" method="POST">
            <input type="submit" value="Obtener Comprobantes desde 4/9/2013 (Not Supported Yet)" name="botonComprobantesFecha" onclick="submit();"/>
            </form>
            <br/>
            
            <form action="ObtenerComprobantesNumero" method="POST">
            <input type="submit" value="Obtener Comprobantes desde 0 null 0 (Not Supported Yet)" name="botonComprobantesNumero" onclick="submit();"/>
            </form>
            <br/>
            
            <h2> Pedidos: </h2>
            
            <form action="RealizarPedido" method="POST">
            <input type="submit" value="Realizar Pedido (Not Supported Yet)" name="botonRealizarPedido" onclick="submit();"/>
            </form>
            <br/>
            
        </center>
        
    </body>
</html>
