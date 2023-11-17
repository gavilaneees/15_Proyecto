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
 <section>
 <h2>Alta de Producto</h2>
 <% String error = (String)request.getAttribute("error");
        if (error != null && !error.isEmpty()) { %>
        <p style="color: red;"><%= error %></p>
    <% } %>
    
    <form action="${pageContext.request.contextPath}/alta" method="post">
    	<p><label for="nombre">Nombre</label></p>
        <input type="text" name="nombre" required><br>
        <p><label for="seccion">Sección</label></p>
        <input type="text" name="seccion" required><br>
        <p><label for="precio">Precio</label></p>
        <input type="number" name="precio" step="0.01" required><br>
        <p><label for="stock">Stock</label></p>
        <input type="number" name="stock" required><br>
        <div class="button-row"><input type="submit" value="Agregar Producto"></div>
    </form>
<a href="${pageContext.request.contextPath}/index.html">Volver al Inicio</a>
</section>
</body>
</html>