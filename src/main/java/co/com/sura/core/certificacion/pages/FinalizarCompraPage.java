package co.com.sura.core.certificacion.pages;

import co.com.sura.core.certificacion.models.InformacionDelUsuarioModelo;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import org.openqa.selenium.support.FindBy;

@At("https://www.saucedemo.com/checkout-step-one.html")
public class FinalizarCompraPage extends PageObject {

    @FindBy(id = "continue")
    WebElementFacade btnContinuar;

    @FindBy(id = "cancel")
    WebElementFacade btnCancelar;

    @FindBy(id = "first-name")
    WebElementFacade entradaPrimerNombre;

    @FindBy(id = "last-name")
    WebElementFacade entradaDeApellido;

    @FindBy(id = "postal-code")
    WebElementFacade entradaCodigoPostal;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElementFacade mensajeDeErrorFinalizarCompra;

    @FindBy(id = "finish")
    WebElementFacade btnFinalizarCompra;

    @FindBy(xpath = "//h2[text()='THANK YOU FOR YOUR ORDER']")
    WebElementFacade mensajeDeCompraExitosa;

    public void ingresarInformacionDelUsuario(InformacionDelUsuarioModelo informacionDelUsuario){
        ingresarPrimerNombre(informacionDelUsuario.getNombre());
        ingresarApellido(informacionDelUsuario.getApellido());
        ingresarCodigoPostal(informacionDelUsuario.getCodigoPostal());
        finalizarProcesoDeCompra();
    }
    private void ingresarPrimerNombre(String primerNombre){
        entradaPrimerNombre.type(primerNombre);
    }

    private void ingresarApellido(String apellido){
        entradaDeApellido.type(apellido);
    }

    private void ingresarCodigoPostal(String codigoPostal){
        entradaCodigoPostal.type(codigoPostal);
    }

    private void finalizarProcesoDeCompra(){
        btnContinuar.click();
        btnFinalizarCompra.click();
    }

    public boolean fueExitosaLaCompra(){
        return mensajeDeCompraExitosa.isVisible();
    }
}
