# language: es
# creado por DiegoPinzon el 05/07/2022
# autor: diego.pizon@sofka.com.co

Característica: Inicio de Sesión en SauceDemo Labs

  Regla: Un usuario registrado puede iniciar sesión
  Como usuario, necesito iniciar sesión en Sauce Demo Web con mis credenciales

    Antecedentes: El usuario está ubicado en la página de inicio de sesión
      Dado que el usuario navega a la página de inicio de sesión

    @InicioDeSesionExitoso
    Escenario: Inicio de sesión exitoso
      Cuando el usuario inicia sesión con credenciales válidas
      Entonces debería ver la página del catálogo de productos

    @InicioDeSesionFallido_CredencialesInvalidas
    Escenario: Inicio de sesión fallido
      Cuando el usuario inicia sesión con credenciales no válidas
      Entonces debería ver el mensaje de credenciales no válidas

    @InicioDeSesionFallido_UsuarioBloqueado
    Escenario: Iniciar sesión con usuario bloqueado
      Cuando el usuario inicia sesión con credenciales bloqueadas
      Entonces debería ver el mensaje de usuario bloqueado

    @InicioDeSesionFallido_CampoDeClaveVacio
    Escenario: Iniciar sesión con contraseña vacía
      Cuando el usuario inicia sesión con contraseña vacía
      Entonces debería ver el mensaje de contraseña requerida

    @InicioDeSesionFallido_CampoDeUsuarioVacio
    Escenario: Iniciar sesión con usuario vacío
      Cuando el usuario inicia sesión con usuario vacío
      Entonces debería ver el mensaje de nombre de usuario requerido