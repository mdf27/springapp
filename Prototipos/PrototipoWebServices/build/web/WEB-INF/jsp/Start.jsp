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
            <input type="submit" value="Listar Ofertas (NO Funciona!)" name="botonOfertas" onclick="submit();"/>
            </form>
            <br/>

            <form action="PreciosRecetas" method="POST">
            <input type="submit" value="Precios Recetas (NO Funciona!)" name="botonOfertas" onclick="submit();"/>
            </form>
            <br/>
            
            <form action="PruebaStock" method="POST">
            <input type="submit" value="Ver Stock (NO Funciona!)" name="botonStock" onclick="submit();"/>
            </form>
            <br/>
            
            <form action="VerInfoProducto" method="POST">
            <input type="submit" value="Ver Informacion Producto 77 (NO Funciona!)" name="botonInfoProd77" onclick="submit();"/>
            </form>
            <br/>
            
            <h2> Consulta Stock: </h2>
            
            <form action="ObtenerComprobantesFecha" method="POST">
            <input type="submit" value="Obtener Comprobantes desde 4/9/2013 (NO Funciona!)" name="botonComprobantesFecha" onclick="submit();"/>
            </form>
            <br/>
            
            <form action="ObtenerComprobantesNumero" method="POST">
            <input type="submit" value="Obtener Comprobantes desde 0 null 0 (NO Funciona!)" name="botonComprobantesnumero" onclick="submit();"/>
            </form>
            <br/>
            
        </center>
        
    </body>
</html>
