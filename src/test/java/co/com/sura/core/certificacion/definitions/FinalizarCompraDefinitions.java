package co.com.sura.core.certificacion.definitions;

import co.com.sura.core.certificacion.models.InformacionDelUsuarioModelo;
import co.com.sura.core.certificacion.pages.PaginaCarritoDeCompras;
import co.com.sura.core.certificacion.pages.PaginaFinalizarCompra;
import co.com.sura.core.certificacion.pages.PaginaInicioSesion;
import co.com.sura.core.certificacion.pages.PaginaPrincipalDeProductos;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Entonces;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FinalizarCompraDefinitions {

    private PaginaFinalizarCompra checkoutPageSauce;
    private PaginaPrincipalDeProductos mainPageSauce;
    private PaginaCarritoDeCompras cartPageSauce;
    private PaginaInicioSesion paginaInicioSesion;

    @E("inicia sesion, agrega productos y va a la pagina del carrito de compras")
    public void iniciaSesionAgregaProductosYVaALaPaginaDelCarritoDeCompras() {
        paginaInicioSesion.iniciarSesion("standard_user", "secret_sauce");
        List<String> listOfProducts = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie");
        listOfProducts.forEach(itemName -> mainPageSauce.agregarProductoAlCarrito(itemName));
        mainPageSauce.verProductosEnElCarrito();
    }

    @Cuando("el usuario navega a la pagina de finalizacion de compra")
    public void elUsuarioNavegaALaPaginaDeFinalizacionDeCompra() {
        cartPageSauce.irAPaginaFinalizarCompra();
    }

    @E("ingresa la siguiente informacion de facturacion")
    public void ingresaLaSiguienteInformacionDeFacturacion(InformacionDelUsuarioModelo informacionDelUsuarioModelo) {
        checkoutPageSauce.ingresarInformacionDelUsuario(informacionDelUsuarioModelo);
    }

    @Entonces("deberia ver el mensaje de compra finalizada con exito")
    public void deberiaVerElMensajeDeCompraFinalizadaConExito() {
        assertThat(checkoutPageSauce.fueExitosaLaCompra(), is(true));
    }
}