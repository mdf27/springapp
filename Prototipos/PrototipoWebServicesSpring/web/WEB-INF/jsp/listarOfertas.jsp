<%-- 
    Document   : listarOfertas
    Created on : 15-sep-2014, 17:03:28
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Obtener Ofertas</title>
    </head>
    <body>
        <h1>Lista de Ofertas!</h1>
         <table border="2">
            <thead>
                <tr>
                    <th>Cant. Bonificado</th>
                    <th>Cant. Venta</th>
                    <th>Descripcion</th>
                    <th>Fecha Fin</th>
                    <th>Num. Articulo</th>
                    <th>Porcentaje Bonificado</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ofertas}" var="oferta">
                    <tr>
                        <td><c:out value="${oferta.getCantidadBonificado()}"/></td>
                        <td><c:out value="${oferta.getCantidadVenta()}"/></td>
                        <td><c:out value="${oferta.getDescripcion()}"/></td>
                        <td><c:out value="${oferta.getFechaFin()}"/></td>
                        <td><c:out value="${oferta.getNumeroArticulo()}"/></td>
                        <td><c:out value="${oferta.getPorcentajeBonificado()}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
    </body>
</html>
