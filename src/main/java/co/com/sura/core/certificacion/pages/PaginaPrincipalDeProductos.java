package co.com.sura.core.certificacion.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static co.com.sura.core.certificacion.utils.GenerarNumeroRandom.*;

@At("https://www.saucedemo.com/inventory.html")
public class PaginaPrincipalDeProductos extends PageObject {

    @FindBy(xpath = "//span[@class='title']")
    private WebElementFacade tituloPaginaPrincipal;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElementFacade contadorDeProductosEnElCarro;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElementFacade shoppingButton;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElementFacade listaDeFiltros;

    @FindBy(xpath = "//button[text()='Add to cart']")
    private List<WebElementFacade> botonesParaAgregarAlCarrito;

    public boolean esVisibleElTituloDeLaPagina() {
        return tituloPaginaPrincipal.isVisible();
    }

    public void agregarProductoAlCarrito(String nombreProducto) {
        String buttonLocator = String.format("//div[text()='%s']/../../../div/button", nombreProducto);
        getDriver().findElement(By.xpath(buttonLocator)).click();
    }

    public int obtenerNumeroDeProductosEnElCarrito() {
        return Integer.parseInt(contadorDeProductosEnElCarro.getText());
    }

    public void verProductosEnElCarrito() {
        shoppingButton.click();
    }

    public void ordenarProductosPorMenorPrecio() {
        listaDeFiltros.selectByValue("lohi");
    }

    public void ordenarProductosPorPrecioMayor() {
        listaDeFiltros.selectByValue("hilo");
    }

    public void agregarElPrimerProducto() {
        botonesParaAgregarAlCarrito.get(0).click();
    }

    public void agregarProductosRandom() {
        int productosDisponibles = 6;
        int cantidadProductos = generarNumeroRandom(productosDisponibles);
        List<Integer> indicesDeProductos = generarNumerosRandom(productosDisponibles, cantidadProductos);
        indicesDeProductos.forEach(indice -> botonesParaAgregarAlCarrito.get(indice).click());
    }
}