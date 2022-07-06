package co.com.segurossura.certificacion.definitions;

import co.com.segurossura.certificacion.pages.PaginaInicioSesion;
import co.com.segurossura.certificacion.pages.PaginaPrincipalDeProductos;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Entonces;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class IniciarSesionDefinitions {

    private PaginaInicioSesion paginaInicioSesion;
    private PaginaPrincipalDeProductos paginaPrincipalDeProductos;

    private final String invalidCredentialsMessage = "Epic sadface: Username and password do not match any user in this service";
    private final String lockedUserMessage = "Epic sadface: Sorry, this user has been locked out.";
    private final String requiredUsernameMessage = "Epic sadface: Username is required";
    private final String requiredPasswordMessage = "Epic sadface: Password is required";

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
        assertThat(paginaInicioSesion.obtenerMensajeDeErrorInicioSesion(), equalTo(invalidCredentialsMessage));
    }

    @Cuando("el usuario inicia sesion con credenciales bloqueadas")
    public void elUsuarioIniciaSesionConCredencialesBloqueadas() {
        paginaInicioSesion.iniciarSesion("locked_out_user", "secret_sauce");
    }

    @Entonces("deberia ver el mensaje de usuario bloqueado")
    public void deberiaVerElMensajeDeUsuarioBloqueado() {
        assertThat(paginaInicioSesion.obtenerMensajeDeErrorInicioSesion(), equalTo(lockedUserMessage));
    }

    @Cuando("el usuario inicia sesion con clave de acceso vacia")
    public void elUsuarioIniciaSesionConContrasenaVacia() {
        paginaInicioSesion.iniciarSesion("problem_user", "");
    }

    @Entonces("deberia ver el mensaje de clave de acceso requerida")
    public void deberiaVerElMensajeDeContrasenaRequerida() {
        assertThat(paginaInicioSesion.obtenerMensajeDeErrorInicioSesion(), equalTo(requiredPasswordMessage));
    }

    @Cuando("el usuario inicia sesion con usuario vacio")
    public void elUsuarioIniciaSesionConUsuarioVacio() {
        paginaInicioSesion.iniciarSesion("", "secret_sauce");
    }

    @Entonces("deberia ver el mensaje de nombre de usuario requerido")
    public void deberiaVerElMensajeDeNombreDeUsuarioRequerido() {
        assertThat(paginaInicioSesion.obtenerMensajeDeErrorInicioSesion(), equalTo(requiredUsernameMessage));
    }
}