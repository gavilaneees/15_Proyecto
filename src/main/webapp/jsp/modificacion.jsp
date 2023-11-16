<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificación de Precio</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
<h2>Modificación de Precio</h2>

 <% String error = (String)request.getAttribute("error");
        if (error != null && !error.isEmpty()) { %>
        <p style="color: red;"><%= error %></p>
    <% } %>
    
    <form action="${pageContext.request.contextPath}/modificacion" method="post">
        Nombre del Producto: <input type="text" name="nombre" required><br>
        Nuevo Precio: <input type="number" name="nuevoPrecio" step="0.01" required><br>
        <input type="submit" value="Modificar Precio">
    </form>
<a href="${pageContext.request.contextPath}/index.html">Volver al Inicio</a>
</body>
</html>