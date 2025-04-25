<%-- 
    Document   : formulario_registro_empresa_cliente
    Created on : 22 abr 2025, 22:12:45
    Author     : alfon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Formulario para registrar negocios hosteleros -->

        <h1>Introduzca los datos de su negocio hostelero</h1>

        <form action="ServletRegistroEmpresaCliente" method="POST" id="formulario_registro">
            <label for="nick">Nick:</label><br>
            <input type="text" id="nick" name="nick" required><br><br>

            <label for="email">Email:</label><br>
            <input type="email" id="email" name="email" required><br><br>

            <label for="telefono">Teléfono:</label><br>
            <input type="text" id="telefono" name="telefono" required><br><br>

            <label for="contrasenia">Contraseña:</label><br>
            <input type="password" id="contrasenia" name="contrasenia" required><br><br>

            <label for="nombre_empresa_cliente">Nombre de la Empresa:</label><br>
            <input type="text" id="nombre_empresa_cliente" name="nombre_empresa_cliente" required><br><br>

            <label for="cif">CIF:</label><br>
            <input type="text" id="cif" name="cif" required><br><br>

            <label for="direccion">Dirección:</label><br>
            <input type="text" id="direccion" name="direccion" required><br><br>

            <input type="submit" value="Registrar">
        </form>

    </body>
</html>
