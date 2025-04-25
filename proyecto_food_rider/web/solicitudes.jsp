<%-- 
    Document   : solicitudes
    Created on : 16 abr 2025, 18:16:49
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
        <h2><fmt:message key="titulo.solicitud"/></h2>
        <core:forEach var="elementoEmpresaCliente" items="${empresasClienteNoAceptadoAt}">
            <core:forEach var="elementoUsuario" items="${usuariosNoAceptadoAt}">
                <core:if test="${elementoUsuario.id_usuario_no_aceptado == elementoEmpresaCliente.usuarioNoAceptado.id_usuario_no_aceptado}">
                    <h3><fmt:message key="titulo.empresa"/></h3>
                    <p><fmt:message key="campo.nick"/>${elementoUsuario.nick}</p>
                    <p><fmt:message key="campo.contrasenia"/>${elementoUsuario.contrasenia}</p>
                    <p><fmt:message key="campo.telefono"/>${elementoUsuario.telefono}</p>
                    <p><fmt:message key="campo.nombre_empresa"/>${elementoEmpresaCliente.nombre_empresa_cliente}</p>
                    <p><fmt:message key="campo.CIF"/>${elementoEmpresaCliente.cif}</p>
                    <p><fmt:message key="campo.direccion"/>${elementoEmpresaCliente.direccion}</p>
                    <form action="ServletAceptaORechazaSolicitud" method="POST">                                
                        <label>
                            <input type="radio" name="accion" value="aceptar" required> Aceptar
                        </label>
                        <label>
                            <input type="radio" name="accion" value="rechazar"> Rechazar
                        </label>

                        <input type="hidden" name="id_usuario" value="${elementoUsuario.id_usuario_no_aceptado}">
                        <input type="hidden" name="id_empresa" value="${elementoEmpresaCliente.usuarioNoAceptado.id_usuario_no_aceptado}">
                        <button type="submit">Enviar</button>
                    </form>
                </core:if>
            </core:forEach>
        </core:forEach>

        <!-- Botón cierre de sesión -->
        <form action="/proyecto_food_rider" method="POST">
            <%
                session.invalidate();
            %>
            <button type="submit"><fmt:message key="boton.cerrarSesion"/></button>
        </form>

        <!-- Botón cierre vuelta a la página anterior -->
        <form action="pagina_principal.jsp">
            <button type="submit"><fmt:message key="boton.regresoPaginaPrincipal"/></button>
        </form>
    </body>
</html>