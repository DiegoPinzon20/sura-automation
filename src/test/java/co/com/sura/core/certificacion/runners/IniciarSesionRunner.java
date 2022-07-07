package co.com.sura.core.certificacion.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/inicio_de_sesion.feature",
        glue = "co.com.segurossura.certificacion.definitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "pretty",
                "html:target/serenity-reports/iniciar_sesion/serenity-html-report.html",
                "rerun:target/serenity-reports/iniciar_sesion/rerun.txt"
        }
)
public class IniciarSesionRunner {
}
