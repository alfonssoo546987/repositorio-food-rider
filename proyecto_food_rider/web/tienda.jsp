<%-- 
    Document   : tienda
    Created on : 23 abr 2025, 20:04:28
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
        <title>Listado de Productos</title>
    </head>
    <body>
        <fmt:setBundle basename="internacionalizacion.mensajes"/>
        <fmt:setLocale value="${sessionScope.idioma}"/>

        <h1>Tienda Food Rider</h1>

        <h2>Listado de Productos</h2>

        <core:forEach var="producto" items="${productos}">
            <div>
                <p><strong>ID:</strong> ${producto.id}</p>
                <p><strong>Nombre:</strong> ${producto.nombreProducto}</p>
                <p><strong>Marca:</strong> ${producto.marca}</p>
                <p><strong>Peso:</strong> ${producto.peso}</p>
                <p><strong>Volumen:</strong> ${producto.volumen}</p>
                <p><strong>Descripción:</strong> ${producto.descripcion}</p>
                <p><strong>Tipo:</strong> ${producto.tipoProducto.nombreTipo}</p>
                <p><strong>Imagen:</strong>
                <core:if test="${not empty producto.rutaImagen}">
                    <img src="${pageContext.request.contextPath}/${producto.rutaImagen}" width="100"/>
                </core:if>
                <core:if test="${empty producto.rutaImagen}">
                    No disponible
                </core:if>
                </p>
                <hr />
        </div>
    </core:forEach>
</body>
</html>
