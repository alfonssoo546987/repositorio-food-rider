<%-- 
    Document   : pagina_principal
    Created on : 15 abr 2025, 22:48:02
    Author     : alfon
--%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String tipoUsuario = (String) session.getAttribute("tipoUsuarioAt");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="titulo.miAplicacion" /></title>

    </head>
    <body data-tipo="<%= tipoUsuario%>">
        <fmt:setBundle basename="internacionalizacion.mensajes"/>
        <fmt:setLocale value="${sessionScope.idioma}"/>

        <h1>Food Rider</h1>
        
        <h3>Pagina principal del usuario <%= tipoUsuario%></h3>

        <form action="/proyecto_food_rider/" id="boton_cerrar_sesion">
            <button><fmt:message key="boton.cerrarSesion"/></button>
        </form>   

        <form action="formulario_registro.jsp" id="boton_registro_rider">
            <input type="hidden" name="usuario" value="Rider">
            <button type="submit"><fmt:message key="boton.registrarRider"/></button>
        </form>

        <form action="formulario_registro.jsp" id="boton_registro_comprador">
            <input type="hidden" name="usuario" value="Comprador">
            <button type="submit"><fmt:message key="boton.registrarComprador"/></button>
        </form>

        <form action="formulario_registro.jsp" id="boton_registro_administrador">
            <input type="hidden" name="usuario" value="Administrador">
            <button type="submit"><fmt:message key="boton.registrarAdministrador"/></button>
        </form> 

        <form action="formulario_registro.jsp" id="boton_registro_proveedor">
            <input type="hidden" name="usuario" value="Proveedor">
            <button type="submit"><fmt:message key="boton.registrarProveedor"/></button>
        </form>

        <form action="ServletListarEmpresasProveedora" id="boton_proveedor">
            <button><fmt:message key="boton.proveedores"/></button>
        </form>

        <form action="ServletListarEmpresaCliente" id="boton_clientes">
            <button><fmt:message key="boton.clientes"/></button>
        </form>

        <form action="ServletListarEmpleadoRider" id="boton_riders">
            <button><fmt:message key="boton.riders"/></button>
        </form>

        <form action="ServletListarCompradores" id="boton_compradores">
            <button><fmt:message key="boton.compradores"/></button>
        </form>
        <form action="ServletListarAdministradores" id="boton_socios">
            <button><fmt:message key="boton.socios"/></button>
        </form>
        <form action="" id="boton_ruta_pendiente">
            <button><fmt:message key="boton.rutaPendiente"/></button>
        </form>

        <form action="" id="boton_administracion_rutas">
            <button><fmt:message key="boton.administracionRutas"/></button>
        </form>
        <form action="" id="boton_historico_rutas">
            <button><fmt:message key="boton.historicoRutas"/></button>
        </form>

        <form action="" id="boton_productos_frecuentes">
            <button><fmt:message key="boton.productosFrecuentes"/></button>
        </form>

        <form action="" id="boton_almacen">
            <button><fmt:message key="boton.almacen"/></button>
        </form>

        <form action="" id="boton_incidencias">
            <button><fmt:message key="boton.incidencias"/></button>
        </form>

        <form action="" id="boton_historico_incidencia">
            <button><fmt:message key="boton.historicoIncidencia"/></button>
        </form>

        <form action="" id="boton_estadisticas">
            <button><fmt:message key="boton.estadisticas"/></button>
        </form>

        <form action="" id="boton_ruta_sugerida">
            <button><fmt:message key="boton.rutaSugerida"/></button>
        </form>

        <form action="ServletListarSolicitudes" method="GET" id="boton_solicitudes">
            <button type="submit"><fmt:message key="boton.solicitudes"/></button>
        </form>

        <form action="ServletListarSolicitudes" method="GET" id="boton_contabilidad">
            <button><fmt:message key="boton.contabilidad"/></button>
        </form>


        <a href="contacto.jsp"><fmt:message key="enlace.contacto"/></a>
        <!-- Script externo -->
        <script src="scripts/scripts_dom/dom_pagina_principal.js"></script>
    </body>
</html>
