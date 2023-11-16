package com.curso.model;
/**
 * @author David Gavilanes de Dios
 * @since 2023
 * @version 1.0
 */


/**
 * Clase que representa un producto en la tienda.
 * Contiene información como nombre, sección, precio y stock.
 */
public class Producto {
	private String nombre;
	private String seccion;
	private double precio;
	private int stock;
	
	public Producto() {
		
	}

	public Producto(String nombre, String seccion, double precio, int stock) {
		super();
		this.nombre = nombre;
		this.seccion = seccion;
		this.precio = precio;
		this.stock = stock;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}
