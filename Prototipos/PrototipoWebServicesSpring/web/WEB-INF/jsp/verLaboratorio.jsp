
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Información del Laboratorio <c:out value="${laboratorio.getIdLaboratorio()}"/></h1>       
        
        <b>Id:</b> <c:out value="${laboratorio.getIdLaboratorio()}"/> <br/> <br/>
        <b>Nombre: </b> <c:out value="${laboratorio.getNombre()}"/> <br/> <br/>
        <b>Código Postal: </b><c:out value="${laboratorio.getCodigoPostal()}"/> <br/> <br/>
        <b>Departamento: </b> <c:out value="${laboratorio.getDepartamento()}"/> <br/> <br/>
        <b>Dirección: </b> <c:out value="${laboratorio.getDireccion()}"/> <br/> <br/>
        <b>Localidad: </b> <c:out value="${laboratorio.getLocalidad()}"/> <br/> <br/>
        <b>Razón Social: </b> <c:out value="${laboratorio.getRazonSocial()}"/> <br/> <br/>
        <b>RUC: </b> <c:out value="${laboratorio.getRuc()}"/> <br/> 
        
        <h3> Líneas del Laboratorio</h3>
        
        <table border="2">
            <thead>
                <tr>
                    <th>IdLaboratorio</th>
                    <th>IdLinea</th>
                    <th>Nombre</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${laboratorio.getLineas()}" var="linea">
                    <tr>
                        <td><c:out value="${linea.getIdLaboratorio()}"/></td> 
                        <td><c:out value="${linea.getIdLinea()}"/></td>
                        <td><c:out value="${linea.getNombre()}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <h3> Teléfonos del Laboratorio</h3>
        
        <table border="2">
            <thead>
                <tr>
                    <th>Teléfono</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${laboratorio.getTelefonos()}" var="telefono">
                    <tr>
                        <td><c:out value="${telefono}"/></td> 
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
