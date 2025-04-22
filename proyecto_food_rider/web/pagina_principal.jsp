<%-- 
    Document   : pagina_principal
    Created on : 15 abr 2025, 22:48:02
    Author     : alfon
--%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="titulo.miAplicacion" /></title>
    </head>
    <body>
        <fmt:setBundle basename="internacionalizacion.mensajes"/>
        <fmt:setLocale value="${sessionScope.idioma}"/>



        <form action="ServletRegistro" method="POST" id="formulario">
            <div id="campo-profesion">
                <label for="profesion-empleado"><fmt:message key="campo.profesion" /></label>                
                <input type="text" name="profesion-empleado" placeholder="<fmt:message key='campo.profesion' />" required>
            </div>
            <div id="campo-salario" style="display:none;">
                <label for="salario-profesion"><fmt:message key="campo.salario" /></label>                
                <input type="number" name="salario-profesion" placeholder="<fmt:message key='campo.salario' />" required>
            </div>
            <button type="submit"><fmt:message key="boton.actualizarLista" /></button>
        </form>

        <ul id="lista-empleados">
            <core:forEach var="empleado" items="${empleados}">
                <li data-salario="${empleado.salario}">
                    ${empleado.profesion}
                </li>
            </core:forEach>
        </ul>

        <!-- Botón independiente para realizar los cambios -->
        <button id="btnCambiar"><fmt:message key="boton.cambiarContenido" /></button>

        <!-- Texto traducido oculto para el botón actualizado -->
        <span id="texto-actualizado" style="display:none;">
            <fmt:message key="mensaje.listaActualizada" />
        </span>

        <h1>-----------------------------------------</h1>

        <h1>Food Rider</h1>
        <form action="/proyecto_food_rider/">
            <button><fmt:message key="boton.cerrarSesion"/></button>
        </form>   
        <form action="formulario_registro.jsp">
            <button><fmt:message key="boton.registrarRider"/></button>
        </form>
        <form action="formulario_registro.jsp">
            <button><fmt:message key="boton.registrarComprador"/></button>
        </form>      
        <button><fmt:message key="boton.proveedores"/></button>
        <button><fmt:message key="boton.clientes"/></button>
        <button><fmt:message key="boton.riders"/></button>
        <button><fmt:message key="boton.compradores"/></button>
        <button><fmt:message key="boton.socios"/></button>
        <form action="pp.jsp" method="GET">
            <button type="submit">prueba dom</button>
        </form>
        <button><fmt:message key="boton.rutaSugerida"/></button>
        <form action="ServletListarSolicitudes" method="GET">
            <button type="submit"><fmt:message key="boton.solicitudes"/></button>
        </form>
        <button><fmt:message key="boton.rutaPendiente"/></button>
        <button><fmt:message key="boton.administracionRutas"/></button>
        <button><fmt:message key="boton.historicoRutas"/></button>
        <button><fmt:message key="boton.productosFrecuentes"/></button>
        <button><fmt:message key="boton.almacen"/></button>
        <button><fmt:message key="boton.incidencias"/></button>
        <button><fmt:message key="boton.historicoIncidencia"/></button>
        <button><fmt:message key="boton.estadisticas"/></button>
        <button><fmt:message key="boton.contabilidad"/></button>
        <a href="contacto.jsp"><fmt:message key="enlace.contacto"/></a>

        <script src="scripts/scripts_dom/dom_pagina_principal.js" defer></script>
    </body>
</html>
