package co.com.sura.core.certificacion.definitions;

import co.com.sura.core.certificacion.pages.CarritoDeComprasPage;
import co.com.sura.core.certificacion.pages.CatalogoProductosPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AgregarProductosDefinitions {

    private List<String> cartItems;
    private CatalogoProductosPage catalogoProductosPage;
    private CarritoDeComprasPage carritoDeComprasPage;

    @Cuando("el usuario agrega los siguientes productos al carrito")
    public void elUsuarioAgregaLosSiguientesProductosAlCarrito(List<String> items) {
        this.cartItems = items;
        items.forEach(itemName -> catalogoProductosPage.agregarProductoAlCarrito(itemName));
    }

    @Entonces("la cantidad de productos en el carrito de compras debe ser {int}")
    public void laCantidadDeProductosEnElCarritoDeComprasDebeSer(int expectedCount) {
        assertThat(catalogoProductosPage.obtenerNumeroDeProductosEnElCarrito(), is(expectedCount));
    }

    @Y("los articulos deberian aparecer en el carrito.")
    public void losArticulosDeberianAparecerEnElCarrito() {
        catalogoProductosPage.verProductosEnElCarrito();
        cartItems.forEach(itemName -> assertThat(carritoDeComprasPage.estaElProductoEnElCarrito(itemName), is(true)));
    }

    @Cuando("el usuario ordena por precio mas bajo")
    public void elUsuarioOrdenaPorPrecioMasBajo() {
        catalogoProductosPage.ordenarProductosPorMenorPrecio();
    }

    @Y("selecciona el primer producto de la lista")
    public void seleccionaElPrimerProductoDeLaLista() {
        catalogoProductosPage.agregarElPrimerProducto();
    }
}