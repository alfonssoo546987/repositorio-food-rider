<%-- 
    Document   : empresas_proveedora
    Created on : 27 abr 2025, 1:07:23
    Author     : alfon
--%>

<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <fmt:setBundle basename="internacionalizacion.mensajes"/>
        <fmt:setLocale value="${sessionScope.idioma}"/>

        <!-- Lista de registros de la base de  datos -->

        <h2><fmt:message key="titulo.empresas_proveedora"/></h2>
        <core:forEach var="elementoEmpresasProveedora" items="${empresasProveedoraAt}">
            <p><fmt:message key="campo.nombre_empresa"/>${elementoEmpresasProveedora.nombre_empresa_proveedora}</p>
            <p><fmt:message key="campo.cif"/>${elementoEmpresasProveedora.cif}</p>
            <p><fmt:message key="campo.direccion"/>${elementoEmpresasProveedora.direccion}</p>
            <p><fmt:message key="campo.especialidad"/>${elementoEmpresasProveedora.especialidad}</p>
            <p><fmt:message key="campo.telefono"/>${elementoEmpresasProveedora.telefono}</p>
            <p><fmt:message key="campo.email"/>${elementoEmpresasProveedora.email}</p>
        </core:forEach>

        <!-- Botón cierre de sesión -->
        <form action="/proyecto_food_rider/" method="POST">
            <button type="submit"><fmt:message key="boton.cerrarSesion"/></button>
        </form>

        <!-- Botón cierre vuelta a la página anterior -->
        <form action="ServletIdiomas" method="GET">
            <button type="submit"><fmt:message key="boton.regresoPaginaPrincipal"/></button>
        </form>
    </body>
</html>
