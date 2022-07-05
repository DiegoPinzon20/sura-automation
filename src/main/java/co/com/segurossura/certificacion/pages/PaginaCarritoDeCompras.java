package co.com.segurossura.certificacion.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@At("https://www.saucedemo.com/cart.html")
public class PaginaCarritoDeCompras extends PageObject {

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElementFacade> listaDeProductosEnElCarrito;

    @FindBy(xpath = "//button[@name='checkout']")
    WebElementFacade botonFinalizarCompra;

    public boolean estaElProductoEnElCarrito(String nombreProducto) {
        return listaDeProductosEnElCarrito.stream().anyMatch(webElementFacade -> webElementFacade.getTextContent().equals(nombreProducto));
    }

    public void irAPaginaFinalizarCompra() {
        botonFinalizarCompra.click();
    }
}