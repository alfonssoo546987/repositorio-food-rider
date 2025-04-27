<%-- 
    Document   : index.jsp
    Created on : 26 abr 2025, 20:47:12
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
        <h1>Food Rider</h1>
        <ul>
            <li><a href="ServletListarSolicitudes">Continuar sin registro</a></li>
            <li><a href="formulario_registro_empresa_cliente.jsp">Registre su negocio hostelero</a></li>
        </ul>
        <h2>Introduzca su nick y contraseña</h2>
        <h3>Usted entrará como propietario de negocio hostelero, repartidor, o administrador, en función de las credenciales que introduza; y por ende, su navegación por este sitio web se ajustará a dicho rol.</h3>

        <form action="ServletInicioSesion" method="POST">
            <label for="nick">Nick:</label><br>
            <input type="text" id="nick" name="nick" required><br><br>

            <label for="contrasenia">Contraseña:</label><br>
            <input type="password" id="contrasenia" name="contrasenia" required><br><br>

            <input type="submit" value="Iniciar sesión">
        </form>
    </body>
</html>
