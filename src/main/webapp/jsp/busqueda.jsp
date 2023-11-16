<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.curso.model.Producto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Búsqueda de Productos</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
<h2>Lista de Productos</h2>

     <form action="<%= request.getContextPath() %>/busqueda" method="post">
        <label for="seccion">Filtrar por Sección:</label>
        <select name="seccion">
            <option value="">Todas las secciones</option>
            <% 
                List<String> secciones = (List<String>)request.getAttribute("secciones");
                for (String seccion : secciones) {
            %>
                <option value="<%= seccion %>"><%= seccion %></option>
            <% } %>
        </select>
        <input type="submit" value="Filtrar">
    </form>

    <table border="1">
        <tr>
            <th>Nombre</th>
            <th>Sección</th>
            <th>Precio</th>
            <th>Stock</th>
        </tr>
        <% 
            List<Producto> productos = (List<Producto>)request.getAttribute("productos");
            for (Producto producto : productos) {
        %>
            <tr>
                <td><%= producto.getNombre() %></td>
                <td><%= producto.getSeccion() %></td>
                <td><%= producto.getPrecio() %></td>
                <td><%= producto.getStock() %></td>
            </tr>
        <% } %>
    </table>

<a href="${pageContext.request.contextPath}/index.html">Volver al Inicio</a>
</body>
</html>