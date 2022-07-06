# language: es
# creado por DiegoPinzon el 05/07/2022
# autor: diego.pizon@sofka.com.co

Característica: Agregar productos al carrito de compras

  Regla: Los articulos agregados desde la pagina del catalogo deben aparecer en el carrito
  Como usuario, quiero agregar articulos al carrito de compras.

    Antecedentes: El usuario ha iniciado sesion
      Dado que el usuario navega a la pagina de inicio de sesion
      Y el usuario inicia sesion con credenciales validas

    @AgregarProductosAlCarrito
    Escenario: El usuario agrega algunos articulos al carrito de compras
      Cuando el usuario agrega los siguientes productos al carrito
        | Sauce Labs Backpack      |
        | Sauce Labs Fleece Jacket |
        | Sauce Labs Onesie        |
      Entonces la cantidad de productos en el carrito de compras debe ser 3
      Y los articulos deberian aparecer en el carrito.

    @AgregarElProductoConElPrecioMasBajo
    Escenario: El usuario agrega el producto mas barato en el catalogo
      Cuando el usuario ordena por precio mas bajo
      Y selecciona el primer producto de la lista
      Entonces la cantidad de productos en el carrito de compras debe ser 1