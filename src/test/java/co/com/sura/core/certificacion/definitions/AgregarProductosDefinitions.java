package co.com.sura.core.certificacion.definitions;

import co.com.sura.core.certificacion.pages.PaginaCarritoDeCompras;
import co.com.sura.core.certificacion.pages.PaginaPrincipalDeProductos;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AgregarProductosDefinitions {

    private List<String> cartItems;
    private PaginaPrincipalDeProductos paginaPrincipalDeProductos;
    private PaginaCarritoDeCompras paginaCarritoDeCompras;

    @Cuando("el usuario agrega los siguientes productos al carrito")
    public void elUsuarioAgregaLosSiguientesProductosAlCarrito(List<String> items) {
        this.cartItems = items;
        items.forEach(itemName -> paginaPrincipalDeProductos.agregarProductoAlCarrito(itemName));
    }

    @Entonces("la cantidad de productos en el carrito de compras debe ser {int}")
    public void laCantidadDeProductosEnElCarritoDeComprasDebeSer(int expectedCount) {
        assertThat(paginaPrincipalDeProductos.obtenerNumeroDeProductosEnElCarrito(), is(expectedCount));
    }

    @Y("los articulos deberian aparecer en el carrito.")
    public void losArticulosDeberianAparecerEnElCarrito() {
        paginaPrincipalDeProductos.verProductosEnElCarrito();
        cartItems.forEach(itemName -> assertThat(paginaCarritoDeCompras.estaElProductoEnElCarrito(itemName), is(true)));
    }

    @Cuando("el usuario ordena por precio mas bajo")
    public void elUsuarioOrdenaPorPrecioMasBajo() {
        paginaPrincipalDeProductos.ordenarProductosPorMenorPrecio();
    }

    @Y("selecciona el primer producto de la lista")
    public void seleccionaElPrimerProductoDeLaLista() {
        paginaPrincipalDeProductos.agregarElPrimerProducto();
    }
}