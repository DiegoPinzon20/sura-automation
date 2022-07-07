package co.com.sura.core.certificacion.definitions;

import co.com.sura.core.certificacion.models.CredencialesModelo;
import co.com.sura.core.certificacion.models.InformacionDelUsuarioModelo;
import co.com.sura.core.certificacion.pages.PaginaCarritoDeCompras;
import co.com.sura.core.certificacion.pages.PaginaFinalizarCompra;
import co.com.sura.core.certificacion.pages.PaginaInicioSesion;
import co.com.sura.core.certificacion.pages.PaginaPrincipalDeProductos;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Entonces;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FinalizarCompraDefinitions {

    private PaginaFinalizarCompra paginaFinalizarCompra;
    private PaginaPrincipalDeProductos paginaPrincipalDeProductos;
    private PaginaCarritoDeCompras paginaCarritoDeCompras;
    private PaginaInicioSesion paginaInicioSesion;

    @E("inicia sesion, agrega productos y va a la pagina del carrito de compras")
    public void iniciaSesionAgregaProductosYVaALaPaginaDelCarritoDeCompras() {
        paginaInicioSesion.iniciarSesion(CredencialesModelo.USUARIO_ESTANDAR);
        paginaPrincipalDeProductos.agregarProductosRandom();
        paginaPrincipalDeProductos.verProductosEnElCarrito();
    }

    @Cuando("el usuario navega a la pagina de finalizacion de compra")
    public void elUsuarioNavegaALaPaginaDeFinalizacionDeCompra() {
        paginaCarritoDeCompras.irAPaginaFinalizarCompra();
    }

    @E("ingresa la siguiente informacion de facturacion")
    public void ingresaLaSiguienteInformacionDeFacturacion(InformacionDelUsuarioModelo informacionDelUsuarioModelo) {
        paginaFinalizarCompra.ingresarInformacionDelUsuario(informacionDelUsuarioModelo);
    }

    @Entonces("deberia ver el mensaje de compra finalizada con exito")
    public void deberiaVerElMensajeDeCompraFinalizadaConExito() {
        assertThat(paginaFinalizarCompra.fueExitosaLaCompra(), is(true));
    }
}