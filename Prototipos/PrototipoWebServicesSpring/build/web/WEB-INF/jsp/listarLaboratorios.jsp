
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Laboratorios</title>
    </head>
    <body>
        
        <div id="infoLaboratorio">
            
        </div>
        
        <h1>Lista de Laboratorios</h1>       
        
        <table border="2">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>CodPostal</th>
                    <th>Dpto</th>
                    <th>Direccion</th>
                    <th>Localidad</th>
                    <th>Razon Social</th>
                    <th>RUC</th>
                    <th>Imprimir</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${laboratorios}" var="lab">
                    <tr>
                        <td><a href="verLaboratorio.html?id=${lab.getIdLaboratorio()}"><c:out value="${lab.getIdLaboratorio()}"/></a></td> 
                        <td><c:out value="${lab.getNombre()}"/></td>
                        <td><c:out value="${lab.getCodigoPostal()}"/></td>
                        <td><c:out value="${lab.getDepartamento()}"/></td>
                        <td><c:out value="${lab.getDireccion()}"/></td>
                        <td><c:out value="${lab.getLocalidad()}"/></td>
                        <td><c:out value="${lab.getRazonSocial()}"/></td>
                        <td><c:out value="${lab.getRuc()}"/></td>
                        <td><c:out value="${lab.getIdLaboratorio()}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
    </body>
</html>
