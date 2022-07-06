package co.com.segurossura.certificacion.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/agregar_productos_al_carrito.feature",
        glue = "co.com.segurossura.certificacion.definitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "pretty",
                "html:target/serenity-reports/agregar_productos/serenity-html-report.html",
                "rerun:target/serenity-reports/agregar_productos/rerun.txt"
        }
)
public class AgregarProductosRunner {

}