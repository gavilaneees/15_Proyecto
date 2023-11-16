# Gestión de Productos en Tienda

Este proyecto Java EE realizado en el Máster de Java de Viwenext es una aplicación web simple para la gestión de productos en una tienda. Entre sus funcionalidades destacan poder realizar operaciones como altas, eliminaciones, modificaciones y búsquedas de productos.

## Características

- **Búsquedas:** Permite buscar productos por sección o globalmente.
- **Altas:** Permite dar de alta nuevos productos llenando todas sus propiedades.
- **Eliminaciones:** Permite eliminar un producto existente.
- **Modificaciones:** Permite cambiar el precio de un producto existente.

## Tecnologías Utilizadas

- Java EE
- Servlets
- JSP (JavaServer Pages)
- HTML
- CSS (hojas de estilo en cascada)

## Estructura del Proyecto

- **`src/com/tienda/controller`:** Contiene los servlets que manejan las solicitudes HTTP.
- **`src/com/tienda/dao`:** Contiene la interfaz y la implementación de la interfaz DAO para acceder a los productos y sus funciones.
- **`src/com/tienda/model`:** Contiene la clase `Producto` que representa un producto en la tienda.
- **`webapp`:** Contiene las páginas JSP y otros archivos como el CSS o HTML.

## Configuración y Ejecución

1. Clona este repositorio.
2. Importa el proyecto en tu entorno de desarrollo.
3. Configura un servidor web, como Tomcat, en tu entorno.
4. Despliega la aplicación en el servidor web.