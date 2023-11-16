package com.curso.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.curso.dao.ProductoDAO;
import com.curso.dao.ProductoDAOImpl;
import com.curso.model.Producto;

/**
 * @author David Gavilanes de Dios
 * @since 2023
 * @version 1.0
 */

/**
 * Servlet implementation class AltaServlet
 */
@WebServlet("/alta")
public class AltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("jsp/alta.jsp").forward(request, response);
    }

	/**
	 * Funcion para crear un nuevo producto con sus datos
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String nombre = request.getParameter("nombre");
	        String seccion = request.getParameter("seccion");
	        String precioStr = request.getParameter("precio");
	        String stockStr = request.getParameter("stock");

	        try {
		        if (nombre.isEmpty() || seccion.isEmpty() || precioStr.isEmpty() || stockStr.isEmpty()) {
	                throw new IllegalArgumentException("Todos los campos son obligatorios");
	            }
		        
		        double precio = Double.parseDouble(precioStr);
	            int stock = Integer.parseInt(stockStr);
		        if (precio < 0 || stock < 0) {
	                throw new NumberFormatException("Precio y stock deben ser valores no negativos");
	            }
	            
		        Producto producto = new Producto(nombre, seccion, precio, stock);
	
		        ProductoDAO productoDAO = new ProductoDAOImpl();
		        productoDAO.agregarProducto(producto);
	
		        response.sendRedirect(request.getContextPath() + "/busqueda");
	        } catch (NumberFormatException e) {
	            request.setAttribute("error", "Formato incorrecto para precio o stock");
	            request.getRequestDispatcher("jsp/alta.jsp").forward(request, response);
	        } catch (IllegalArgumentException e) {
	            request.setAttribute("error", e.getMessage());
	            request.getRequestDispatcher("jsp/alta.jsp").forward(request, response);
	        }
	    }
}
