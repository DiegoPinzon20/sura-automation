package co.com.sura.core.certificacion.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/finalizar_compra.feature",
        glue = "co.com.segurossura.certificacion.definitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "pretty",
                "html:target/serenity-reports/finalizar_compra/serenity-html-report.html",
                "rerun:target/serenity-reports/finalizar_compra/rerun.txt"
        }
)
public class FinalizarCompraRunner {
}