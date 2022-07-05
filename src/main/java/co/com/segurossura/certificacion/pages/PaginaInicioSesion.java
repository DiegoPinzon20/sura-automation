package co.com.segurossura.certificacion.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.saucedemo.com/")
public class PaginaInicioSesion extends PageObject {

    @FindBy( id = "user-name")
    WebElementFacade campoDeUsuario;

    @FindBy( id = "password")
    WebElementFacade campoDeClave;

    @FindBy( id = "login-button")
    WebElementFacade botonIngresar;

    @FindBy(xpath = "//h3[@data-test= 'error']")
    WebElementFacade mensajeDeErrorInicioSesion;

    @WhenPageOpens
    public void esperarHastaQueLaPaginaCargue() {
        element(campoDeUsuario).waitUntilVisible();
    }

    @Step("User logs in by entering username and password")
    public void iniciarSesion(String username, String password){
        ingresarUsuario(username);
        ingresarClave(password);
        ingresarAlSistema();
    }
    private void ingresarUsuario(String usuario){
        enter(usuario).into(campoDeUsuario);
    }

    private void ingresarClave(String clave){
        enter(clave).into(campoDeClave);
    }

    private void ingresarAlSistema(){
        botonIngresar.click();
    }

    public String obtenerMensajeDeErrorInicioSesion(){
        return mensajeDeErrorInicioSesion.getText();
    }

}
