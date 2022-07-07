package co.com.sura.core.certificacion.definitions;

import co.com.sura.core.certificacion.models.CredencialesModelo;
import co.com.sura.core.certificacion.models.InformacionDelUsuarioModelo;
import co.com.sura.core.certificacion.pages.CarritoDeComprasPage;
import co.com.sura.core.certificacion.pages.FinalizarCompraPage;
import co.com.sura.core.certificacion.pages.InicioSesionPage;
import co.com.sura.core.certificacion.pages.CatalogoProductosPage;
import io.cucumber.java.DataTableType;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Entonces;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FinalizarCompraDefinition {

    private FinalizarCompraPage finalizarCompraPage;
    private CatalogoProductosPage catalogoProductosPage;
    private CarritoDeComprasPage carritoDeComprasPage;
    private InicioSesionPage inicioSesionPage;

    @E("inicia sesion, agrega productos y va a la pagina del carrito de compras")
    public void iniciaSesionAgregaProductosYVaALaPaginaDelCarritoDeCompras() {
        inicioSesionPage.iniciarSesion(CredencialesModelo.USUARIO_ESTANDAR);
        catalogoProductosPage.agregarProductosRandom();
        catalogoProductosPage.verProductosEnElCarrito();
    }

    @Cuando("el usuario navega a la pagina de finalizacion de compra")
    public void elUsuarioNavegaALaPaginaDeFinalizacionDeCompra() {
        carritoDeComprasPage.irAPaginaFinalizarCompra();
    }

    @E("ingresa la siguiente informacion de facturacion")
    public void ingresaLaSiguienteInformacionDeFacturacion(InformacionDelUsuarioModelo informacionDelUsuarioModelo) {
        finalizarCompraPage.ingresarInformacionDelUsuario(informacionDelUsuarioModelo);
    }

    @Entonces("deberia ver el mensaje de compra finalizada con exito")
    public void deberiaVerElMensajeDeCompraFinalizadaConExito() {
        assertThat(finalizarCompraPage.fueExitosaLaCompra(), is(true));
    }

    @DataTableType
    public InformacionDelUsuarioModelo defineProfileInformation(Map<String, String> entry) {
        return new InformacionDelUsuarioModelo(
                entry.get("nombre"),
                entry.get("apellido"),
                entry.get("codigoPostal")
        );
    }
}