<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <!-- Formulario para introducir registros en la base de  datos -->
    <body>
        <form action="ServletRegistro" method="POST">
            <label for="nick">Nick:</label><br>
            <input type="text" id="nick" name="nick" required><br><br>

            <label for="email">Email:</label><br>
            <input type="email" id="email" name="email" required><br><br>

            <label for="telefono">Teléfono:</label><br>
            <input type="text" id="telefono" name="telefono" required><br><br>

            <label for="contrasenia">Contraseña:</label><br>
            <input type="password" id="contrasenia" name="contrasenia" required><br><br>

            <input type="submit" value="Registrar">
        </form>
    </body>

   


</html>
