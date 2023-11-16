<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alta de Producto</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
 <h2>Alta de Producto</h2>
 <% String error = (String)request.getAttribute("error");
        if (error != null && !error.isEmpty()) { %>
        <p style="color: red;"><%= error %></p>
    <% } %>
    
    <form action="${pageContext.request.contextPath}/alta" method="post">
        Nombre: <input type="text" name="nombre" required><br>
        Sección: <input type="text" name="seccion" required><br>
        Precio: <input type="number" name="precio" step="0.01" required><br>
        Stock: <input type="number" name="stock" required><br>
        <input type="submit" value="Agregar Producto">
    </form>
<a href="${pageContext.request.contextPath}/index.html">Volver al Inicio</a>
</body>
</html>