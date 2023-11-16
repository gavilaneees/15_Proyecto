<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eliminación de Producto</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
<h2>Eliminación de Producto</h2>

    <% String error = (String)request.getAttribute("error");
        if (error != null && !error.isEmpty()) { %>
        <p style="color: red;"><%= error %></p>
    <% } %>
    
    <form action="${pageContext.request.contextPath}/eliminacion" method="post">
        Nombre del Producto a Eliminar: <input type="text" name="nombre" required><br>
        <input type="submit" value="Eliminar Producto">
    </form>
<a href="${pageContext.request.contextPath}/index.html">Volver al Inicio</a>
</body>
</html>