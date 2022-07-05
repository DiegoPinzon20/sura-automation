# language: es
# creado por DiegoPinzon el 05/07/2022
# autor: diego.pizon@sofka.com.co

Característica: Agregar productos al carrito de compras

  Regla: Los artículos agregados desde la página del catálogo deben aparecer en el carrito
  Como usuario, quiero agregar artículos al carrito de compras.

    Antecedentes: El usuario ha iniciado sesión
      Dado que el usuario navega a la página de inicio de sesión
      Y el usuario inicia sesión con credenciales válidas

    @AgregarProductosAlCarrito
    Escenario: El usuario agrega algunos artículos al carrito de compras
      Cuando el usuario agrega los siguientes productos al carrito
        | Sauce Labs Backpack      |
        | Sauce Labs Fleece Jacket |
        | Sauce Labs Onesie        |
      Entonces la cantidad de productos en el carrito de compras debe ser 3
      Y los artículos deberían aparecer en el carrito.

    @AgregarElProductoConElPrecioMasBajo
    Escenario: El usuario agrega el producto más barato en el catálogo
      Cuando el usuario ordena por precio más bajo
      Y selecciona el primer producto de la lista
      Entonces el conteo del carrito de compras debe ser 1