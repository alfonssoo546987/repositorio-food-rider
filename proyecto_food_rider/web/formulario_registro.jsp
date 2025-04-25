<%-- 
    Document   : formulario_registro
    Created on : 15 abr 2025, 22:55:14
    Author     : alfon
--%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String usuario = request.getParameter("usuario");
%>

<%
    String action;
    switch (usuario) {
        case "Rider":
            action = "ServletRegistroRider";
            break;
        case "Comprador":
            action = "ServletRegistroComprador";
            break;
        case "Administrador":
            action = "ServletRegistroAdministrador";
            break;
        case "Proveedor":
            action = "ServeletRegistroEmpresaProveedora";
            break;
        default:
            action = "ServletIdiomas";
            break;
    }
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="titulo.formulario_registro"/></title>
    </head>

    <body>
        <fmt:setBundle basename="internacionalizacion.mensajes"/>
        <fmt:setLocale value="${sessionScope.idioma}"/>

        <div id="usuario" data-nombre="<%= usuario%>"></div>

        <!-- Formulario para registrar negocios hosteleros -->
        <h1><fmt:message key="titulo.registrese"/></h1>
        <form action="<%=action%>" method="POST" id="formulario_registro">

            <div>
                <label for="nick"><fmt:message key="campo.nick"/></label><br>
                <input type="text" id="nick" name="nick" required><br><br>
            </div>

            <div>
                <label for="contrasenia"><fmt:message key="campo.contrasenia"/></label><br>
                <input type="password" id="contrasenia" name="contrasenia" required><br><br>
            </div>      

            <div>
                <label for="nombre_empresa_cliente"><fmt:message key="campo.nombre_empresa_proveedora"/></label><br>
                <input type="text" id="nombre_empresa_proveedora" name="nombre_empresa_proveedora" required><br><br>
            </div>

            <div>
                <label for="cif"><fmt:message key="campo.cif"/></label><br>
                <input type="text" id="cif" name="cif"><br><br>
            </div>

            <div>
                <label for="direccion"><fmt:message key="campo.direccion"/></label><br>
                <input type="text" id="direccion" name="direccion" required><br><br>
            </div>

            <div>
                <label for="especialidad"><fmt:message key="campo.especialidad"/></label><br>
                <input type="text" id="especialidad" name="especialidad" required><br><br>
            </div>

            <div>
                <label for="telefono"><fmt:message key="campo.telefono"/></label><br>
                <input type="text" id="telefono" name="telefono" required><br><br>
            </div>

            <div>
                <label for="email"><fmt:message key="campo.email"/></label><br>
                <input type="email" id="email" name="email" required><br><br>
            </div>

            <div>
                <label for="dni""><fmt:message key="campo.dni"/></label><br>
                <input type="text" id="dni" name="dni" required><br><br>
            </div>

            <div>
                <label for="nss"><fmt:message key="campo.nss"/></label><br>
                <input type="text" id="nss" name="nss" required><br><br>
            </div>

            <div>
                <label for="nombre"><fmt:message key="campo.nombre_propio"/></label><br>
                <input type="text" id="nombre" name="nombre" required><br><br>
            </div>

            <div>
                <label for="primer_apellido"><fmt:message key="campo.primer_apellido"/></label><br>
                <input type="text" id="primer_apellido" name="primer_apellido" required><br><br>
            </div>

            <div>
                <label for="segundo_apellido"><fmt:message key="campo.segundo_apellido"/></label><br>
                <input type="text" id="segundo_apellido" name="segundo_apellido"><br><br>
            </div>

            <input type="submit" value="Registrar">
        </form>
        <p></p><p></p><p></p><p></p><p></p><p></p>

        <!-- Botón cierre vuelta a la página anterior -->
        <form action="ServletIdiomas" method="GET">
            <button type="submit"><fmt:message key="boton.regresoPaginaPrincipal"/></button>
        </form>

        <!-- Scripts -->
        <script src="scripts/scripts_dom/dom_formulario_registro.js"></script>

    </body>
</html>
