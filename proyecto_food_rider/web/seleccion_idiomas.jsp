<%-- 
    Document   : seleccion_idiomas
    Created on : 15 abr 2025, 22:47:26
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
        <h2>Selecciona un idioma / Choose a language</h2>

        <form action="ServletIdiomas" method="GET">
            <input type="hidden" name="idioma" value="es" />
            <button type="submit">Botón Español</button>
        </form>

        <form action="ServletIdiomas" method="GET">
            <input type="hidden" name="idioma" value="en" />
            <button type="submit">English Button</button>
        </form>
    </body>
</html>
