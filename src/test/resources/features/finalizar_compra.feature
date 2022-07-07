# language: es
# creado por DiegoPinzon el 05/07/2022
# autor: diego.pizon@sofka.com.co

Característica: Realizar una compra

  Regla: Un usuario puede finalizar el proceso de compra
  Como usuario quiero finalizar la compra de los productos añadidos al carrito.

    Antecedentes: Iniciar sesion y agregar productos al carrito
      Dado que el usuario agrega productos al carrito de compras

    @CompraExitosa
    Escenario: Compra exitosa
      Cuando el usuario navega a la pagina de finalizacion de compra
      E ingresa la siguiente informacion de facturacion
        | nombre | apellido | codigoPostal |
        | Diego  | Pinzon   | 540010       |
      Entonces deberia ver el mensaje de compra finalizada con exito