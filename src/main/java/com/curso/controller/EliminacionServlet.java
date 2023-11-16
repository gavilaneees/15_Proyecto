package com.curso.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.curso.dao.ProductoDAO;
import com.curso.dao.ProductoDAOImpl;

/**
 * @author David Gavilanes de Dios
 * @since 2023
 * @version 1.0
 */

/**
 * Servlet implementation class EliminacionServlet
 */
@WebServlet("/eliminacion")
public class EliminacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/eliminacion.jsp").forward(request, response);
	}

	/**
	 * Función para eliminar el producto e ir a la página de búsqueda
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");

        ProductoDAO productoDAO = new ProductoDAOImpl();
        if (productoDAO.obtenerPorNombre(nombre) == null) {
            request.setAttribute("error", "El producto no existe");
            request.getRequestDispatcher("jsp//eliminacion.jsp").forward(request, response);
        } else {
            productoDAO.eliminarProducto(nombre);
            response.sendRedirect(request.getContextPath() + "/busqueda");
            return;
        }
	}
}
