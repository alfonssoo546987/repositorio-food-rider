<%-- 
    Document   : pp
    Created on : 21 abr 2025, 22:37:11
    Author     : alfon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String tipoUsuario = (String) session.getAttribute("tipoUsuario");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body data-tipo="<%= tipoUsuario%>">
        <h1>Tipo de usuario: <%= tipoUsuario%></h1>

        <!-- Sección para Administrador -->
        <div id="administrador">
            <h2>Vista para Administrador</h2>
        </div>

        <!-- Botones numerados -->
        <div id="botonesExtra">
            <button id="btn1">Botón 1</button>
            <button id="btn2">Botón 2</button>
            <button id="btn3">Botón 3</button>
        </div>

        <!-- Sección para Empresa Cliente -->
        <div id="comprador">
            <h2>Vista para el comprador</h2>
        </div>

        <!-- Botón principal con texto dinámico -->
        <button id="botonPrincipal"></button>

        <!-- Sección para Empleado Rider -->
        <div id="rider">
            <h2>Vista para Empleado Rider</h2>
        </div>

        <script src="scripts/scripts_dom/dom_pp.js"></script>
    </body>
</html>
