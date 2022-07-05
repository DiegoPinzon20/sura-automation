# language: es
# creado por DiegoPinzon el 05/07/2022
# autor: diego.pizon@sofka.com.co

Característica: Realizar una compra

  Regla: Un usuario puede finalizar el proceso de compra
  Como usuario quiero finalizar la compra de los productos añadidos al carrito.

    Antecedentes: Iniciar sesión y agregar productos al carrito
      Dado que el usuario navega a la página de inicio de sesión
      E inicia sesión, agrega productos y va a la página del carrito de compras

    @CompraExitosa
    Escenario: Compra exitosa
      Cuando el usuario navega a la página de finalización de compra
      E ingresa la siguiente información de facturación
        | nombre | apellido | codigoPostal |
        | Diego  | Pinzon   | 540010       |
      Entonces debería ver el mensaje de compra finalizada con éxito