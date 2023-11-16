package com.curso.controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class BusquedaServlet
 */
@WebServlet("/busqueda")
public class BusquedaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoDAO productoDAO = new ProductoDAOImpl();
        List<Producto> productos = productoDAO.obtenerTodos();
        request.setAttribute("productos", productos);
        List<String> secciones = productoDAO.obtenerSeccionesUnicas();
        request.setAttribute("secciones", secciones);

        request.getRequestDispatcher("jsp/busqueda.jsp").forward(request, response);
	}
	
	/**
	 * Función que permite filtrar en la página de búsqueda por secciones
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String seccionSeleccionada = request.getParameter("seccion");

        ProductoDAO productoDAO = new ProductoDAOImpl();
        List<Producto> productosFiltrados = productoDAO.buscarPorSeccion(seccionSeleccionada);
        request.setAttribute("productos", productosFiltrados);

        List<String> secciones = productoDAO.obtenerSeccionesUnicas();
        request.setAttribute("secciones", secciones);

        request.getRequestDispatcher("jsp/busqueda.jsp").forward(request, response);
    }
}
