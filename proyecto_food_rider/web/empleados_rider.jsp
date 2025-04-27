<%-- 
    Document   : empleados_rider.jsp
    Created on : 26 abr 2025, 21:41:28
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

        <h2><fmt:message key="titulo.empleado_rider"/></h2>
        <core:forEach var="elementoEmpleadoRider" items="${empresasClienteAt}">
            <core:forEach var="elementoUsuario" items="${usuariosAt}">
                <core:if test="${elementoUsuario.id_usuario == elementoEmpleadoRider.usuario.id_usuario}">
                    <h3>Empleado rider</h3>
                    <p><fmt:message key="campo.nick"/>${elementoUsuario.nick}</p>
                    <p><fmt:message key="campo.contrasenia"/>${elementoUsuario.contrasenia}</p>
                    <p><fmt:message key="campo.telefono"/>${elementoUsuario.telefono}</p>
                    <p><fmt:message key="campo.email"/>${elementoUsuario.email}</p>
                    <p><fmt:message key="campo.dni"/>${elementoEmpleadoRider.numero_documento_administrador}</p>
                    <p><fmt:message key="campo.nss"/>${elementoEmpleadoRider.nss}</p>
                    <p><fmt:message key="campo.nombre_propio"/>${elementoEmpleadoRider.nombre}</p>
                    <p><fmt:message key="campo.primer_apellido"/>${elementoEmpleadoRider.apellido_principal}</p>
                    <p><fmt:message key="campo.segundo_apellido"/>${elementoEmpleadoRider.apellido_secundario}</p>
                </core:if>
            </core:forEach>
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
