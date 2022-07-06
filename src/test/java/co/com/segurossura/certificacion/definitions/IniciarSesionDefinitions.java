package co.com.segurossura.certificacion.definitions;

import co.com.segurossura.certificacion.pages.PaginaInicioSesion;
import co.com.segurossura.certificacion.pages.PaginaPrincipalDeProductos;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static co.com.segurossura.certificacion.constants.Constantes.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class IniciarSesionDefinitions {

    private PaginaInicioSesion paginaInicioSesion;
    private PaginaPrincipalDeProductos paginaPrincipalDeProductos;

    @Dado("que el usuario navega a la pagina de inicio de sesion")
    public void queElUsuarioNavegaALaPaginaDeInicioDeSesion() {
        paginaInicioSesion.open();
    }

    @Cuando("el usuario inicia sesion con credenciales validas")
    public void elUsuarioIniciaSesionConCredencialesValidas() {
        paginaInicioSesion.iniciarSesion("standard_user", "secret_sauce");
    }

    @Entonces("deberia ver la pagina del catalogo de productos")
    public void deberiaVerLaPaginaDelCatalogoDeProductos() {
        assertThat(paginaPrincipalDeProductos.esVisibleElTituloDeLaPagina(), is(true));
    }

    @Cuando("el usuario inicia sesion con credenciales no validas")
    public void elUsuarioIniciaSesionConCredencialesNoValidas() {
        paginaInicioSesion.iniciarSesion("standard_user", "admin123");
    }

    @Entonces("deberia ver el mensaje de credenciales no validas")
    public void deberiaVerElMensajeDeCredencialesNoValidas() {
        assertThat(paginaInicioSesion.obtenerMensajeDeErrorInicioSesion(), equalTo(MENSAJE_CREDENCIALES_INVALIDAS));
    }

    @Cuando("el usuario inicia sesion con credenciales bloqueadas")
    public void elUsuarioIniciaSesionConCredencialesBloqueadas() {
        paginaInicioSesion.iniciarSesion("locked_out_user", "secret_sauce");
    }

    @Entonces("deberia ver el mensaje de usuario bloqueado")
    public void deberiaVerElMensajeDeUsuarioBloqueado() {
        assertThat(paginaInicioSesion.obtenerMensajeDeErrorInicioSesion(), equalTo(MENSAJE_USUARIO_BLOQUEADO));
    }

    @Cuando("el usuario inicia sesion con clave de acceso vacia")
    public void elUsuarioIniciaSesionConContrasenaVacia() {
        paginaInicioSesion.iniciarSesion("problem_user", "");
    }

    @Entonces("deberia ver el mensaje de clave de acceso requerida")
    public void deberiaVerElMensajeDeContrasenaRequerida() {
        assertThat(paginaInicioSesion.obtenerMensajeDeErrorInicioSesion(), equalTo(MENSAJE_NOMBRE_USUARIO_REQUERIDO));
    }

    @Cuando("el usuario inicia sesion con usuario vacio")
    public void elUsuarioIniciaSesionConUsuarioVacio() {
        paginaInicioSesion.iniciarSesion("", "secret_sauce");
    }

    @Entonces("deberia ver el mensaje de nombre de usuario requerido")
    public void deberiaVerElMensajeDeNombreDeUsuarioRequerido() {
        assertThat(paginaInicioSesion.obtenerMensajeDeErrorInicioSesion(), equalTo(MENSAJE_CONTRASENA_REQUERIDA));
    }
}