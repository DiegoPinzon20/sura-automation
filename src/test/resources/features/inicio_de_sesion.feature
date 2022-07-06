# language: es
# creado por DiegoPinzon el 05/07/2022
# autor: diego.pizon@sofka.com.co

Característica: Inicio de Sesion en SauceDemo Labs

  Regla: Un usuario registrado puede iniciar sesion
  Como usuario, necesito iniciar sesion en Sauce Demo Web con mis credenciales

    Antecedentes: El usuario esta ubicado en la pagina de inicio de sesion
      Dado que el usuario navega a la pagina de inicio de sesion

    @InicioDeSesionExitoso
    Escenario: Inicio de sesion exitoso
      Cuando el usuario inicia sesion con credenciales validas
      Entonces deberia ver la pagina del catalogo de productos

    @InicioDeSesionFallido_CredencialesInvalidas
    Escenario: Inicio de sesion fallido
      Cuando el usuario inicia sesion con credenciales no validas
      Entonces deberia ver el mensaje de credenciales no validas

    @InicioDeSesionFallido_UsuarioBloqueado
    Escenario: Iniciar sesion con usuario bloqueado
      Cuando el usuario inicia sesion con credenciales bloqueadas
      Entonces deberia ver el mensaje de usuario bloqueado

    @InicioDeSesionFallido_CampoDeClaveVacio
    Escenario: Iniciar sesion con clave de acceso vacia
      Cuando el usuario inicia sesion con clave de acceso vacia
      Entonces deberia ver el mensaje de clave de acceso requerida

    @InicioDeSesionFallido_CampoDeUsuarioVacio
    Escenario: Iniciar sesion con usuario vacio
      Cuando el usuario inicia sesion con usuario vacio
      Entonces deberia ver el mensaje de nombre de usuario requerido