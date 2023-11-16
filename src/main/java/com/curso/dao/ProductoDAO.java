package com.curso.dao;

import java.util.List;

import com.curso.model.Producto;

/**
 * @author David Gavilanes de Dios
 * @since 2023
 * @version 1.0
 */

public interface ProductoDAO {
	List<Producto> obtenerTodos();
	Producto obtenerPorNombre(String nombre);
	void agregarProducto(Producto producto);
	void eliminarProducto(String nombre);
	void modificarPrecio(String nombre, double nuevoPrecio);
	List<String> obtenerSeccionesUnicas();
	List<Producto> buscarPorSeccion(String seccion);
}
