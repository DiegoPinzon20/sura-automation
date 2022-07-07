package co.com.sura.core.certificacion.definitions;

import co.com.sura.core.certificacion.pages.PaginaInicioSesion;
import co.com.sura.core.certificacion.pages.PaginaPrincipalDeProductos;
import co.com.sura.core.certificacion.constants.Constantes;
import co.com.sura.core.certificacion.models.CredencialesModelo;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

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
        paginaInicioSesion.iniciarSesion(CredencialesModelo.USUARIO_ESTANDAR);
    }

    @Entonces("deberia ver la pagina del catalogo de productos")
    public void deberiaVerLaPaginaDelCatalogoDeProductos() {
        assertThat(paginaPrincipalDeProductos.esVisibleElTituloDeLaPagina(), is(true));
    }

    @Cuando("el usuario inicia sesion con credenciales no validas")
    public void elUsuarioIniciaSesionConCredencialesNoValidas() {
        paginaInicioSesion.iniciarSesion(CredencialesModelo.USUARIO_INVALIDO);
    }

    @Entonces("deberia ver el mensaje de credenciales no validas")
    public void deberiaVerElMensajeDeCredencialesNoValidas() {
        assertThat(paginaInicioSesion.obtenerMensajeDeErrorInicioSesion(), equalTo(Constantes.MENSAJE_CREDENCIALES_INVALIDAS));
    }

    @Cuando("el usuario inicia sesion con credenciales bloqueadas")
    public void elUsuarioIniciaSesionConCredencialesBloqueadas() {
        paginaInicioSesion.iniciarSesion(CredencialesModelo.USUARIO_BLOQUEADO);
    }

    @Entonces("deberia ver el mensaje de usuario bloqueado")
    public void deberiaVerElMensajeDeUsuarioBloqueado() {
        assertThat(paginaInicioSesion.obtenerMensajeDeErrorInicioSesion(), equalTo(Constantes.MENSAJE_USUARIO_BLOQUEADO));
    }

    @Cuando("el usuario inicia sesion con clave de acceso vacia")
    public void elUsuarioIniciaSesionConContrasenaVacia() {
        paginaInicioSesion.iniciarSesion(CredencialesModelo.USUARIO_USUARIO_VACIO);
    }

    @Entonces("deberia ver el mensaje de clave de acceso requerida")
    public void deberiaVerElMensajeDeContrasenaRequerida() {
        assertThat(paginaInicioSesion.obtenerMensajeDeErrorInicioSesion(), equalTo(Constantes.MENSAJE_NOMBRE_USUARIO_REQUERIDO));
    }

    @Cuando("el usuario inicia sesion con usuario vacio")
    public void elUsuarioIniciaSesionConUsuarioVacio() {
        paginaInicioSesion.iniciarSesion(CredencialesModelo.USUARIO_CLAVE_VACIA);
    }

    @Entonces("deberia ver el mensaje de nombre de usuario requerido")
    public void deberiaVerElMensajeDeNombreDeUsuarioRequerido() {
        assertThat(paginaInicioSesion.obtenerMensajeDeErrorInicioSesion(), equalTo(Constantes.MENSAJE_CONTRASENA_REQUERIDA));
    }
}