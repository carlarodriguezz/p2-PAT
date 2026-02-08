# Práctica 2 – API REST Carrito

En esta práctica se ha desarrollado una API REST utilizando Spring Boot que permite gestionar un recurso **Carrito**, representando una compra en curso en un escenario simplificado de e-commerce.  
Cada carrito contiene un único artículo y permite realizar operaciones básicas de creación, consulta, modificación y eliminación.

## Endpoints disponibles

| Método | Ruta | Cuerpo | Descripción | Respuestas |
|-------:|------|--------|-------------|-----------|
| POST | `/api/carrito` | JSON Carrito | Crea un nuevo carrito | 201, 400 |
| GET | `/api/carrito/{idCarrito}` | – | Obtiene un carrito a partir de su identificador | 200, 404 |
| PUT | `/api/carrito/{idCarrito}` | JSON Carrito | Modifica los datos de un carrito existente | 200, 400, 404 |
| DELETE | `/api/carrito/{idCarrito}` | – | Elimina un carrito existente | 204, 404 |

## Formato del recurso Carrito

El recurso **Carrito** se intercambia en formato JSON y contiene la siguiente información:

```json
{
  "idCarrito": 1,
  "idArticulo": 10,
  "descripcion": "Camiseta",
  "unidades": 2,
  "precioFinal": 19.99
}
