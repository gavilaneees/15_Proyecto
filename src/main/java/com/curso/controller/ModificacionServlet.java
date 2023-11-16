package com.curso.controller;

import java.io.IOException;

import com.curso.dao.ProductoDAO;
import com.curso.dao.ProductoDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author David Gavilanes de Dios
 * @since 2023
 * @version 1.0
 */

/**
 * Servlet implementation class ModificacionServlet
 */
@WebServlet("/modificacion")
public class ModificacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/modificacion.jsp").forward(request, response);
	}

	/**
	 * Función para modificar el precio del producto y volver a la pagina de busqueda
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
        String nuevoPrecioStr = request.getParameter("nuevoPrecio");
        
        ProductoDAO productoDAO = new ProductoDAOImpl();
        if (productoDAO.obtenerPorNombre(nombre) == null) {
            request.setAttribute("error", "El producto no existe");
            request.getRequestDispatcher("jsp/modificacion.jsp").forward(request, response);
        } else {
            try {
                double nuevoPrecio = Double.parseDouble(nuevoPrecioStr);
                if (nuevoPrecio< 0) {
	                throw new NumberFormatException("Precio debe ser un valor no negativo");
	            }
                productoDAO.modificarPrecio(nombre, nuevoPrecio);
                response.sendRedirect(request.getContextPath() + "/busqueda");
                return;
            } catch (NumberFormatException e) {
                request.setAttribute("error", "Formato incorrecto para el nuevo precio");
                request.getRequestDispatcher("jsp/modificacion.jsp").forward(request, response);
            }
        }
	}
}
