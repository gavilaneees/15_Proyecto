/**
 * 
 */
package com.curso.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.curso.model.Producto;

/**
 * @author David Gavilanes de Dios
 * @since 2023
 * @version 1.0
 *
 */
public class ProductoDAOImpl implements ProductoDAO {

	private static List<Producto> productos = new ArrayList<>();
	
	/**
	 * @return Lista de productos
	 */
	@Override
	public List<Producto> obtenerTodos() {
		return productos;
	}

	/**
	 * @param nombre El nombre del producto
	 * @return producto El producto buscado si existe
	 */
	@Override
	public Producto obtenerPorNombre(String nombre) {
		for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null;
	}

	/**
	 * @param producto El producto a agregar
	 */
	@Override
	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}

	/**
	 * @param nombre El nombre del producto a eliminar
	 */
	@Override
	public void eliminarProducto(String nombre) {
		Producto producto = obtenerPorNombre(nombre);
        if (producto != null) {
            productos.remove(producto);
        }
	}

	/**
	 * @param nombre del producto a modificar
	 * @param nuevoPrecio a establecer
	 */
	@Override
	public void modificarPrecio(String nombre, double nuevoPrecio) {
		Producto producto = obtenerPorNombre(nombre);
        if (producto != null) {
            producto.setPrecio(nuevoPrecio);
        }
	}
	
	/**
	 * @return Listado de secciones de producto únicas
	 */
	@Override
    public List<String> obtenerSeccionesUnicas() {
        Set<String> seccionesUnicas = new HashSet<>();
        for (Producto producto : productos) {
            seccionesUnicas.add(producto.getSeccion());
        }
        return new ArrayList<>(seccionesUnicas);
    }

	/**
	 * @param seccion del producto a buscar
	 * @return Listado de productos de esa seccion
	 */
    @Override
    public List<Producto> buscarPorSeccion(String seccion) {
        List<Producto> productosEnSeccion = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getSeccion().equals(seccion)) {
                productosEnSeccion.add(producto);
            }
        }
        return productosEnSeccion;
    }

}
