package co.com.segurossura.certificacion.definitions;

import co.com.segurossura.certificacion.models.InformacionDelUsuarioModelo;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class InformacionUsuarioTypeDef {
    @DataTableType
    public InformacionDelUsuarioModelo defineProfileInformation(Map<String, String> entry) {
        return new InformacionDelUsuarioModelo(
                entry.get("nombre"),
                entry.get("apellido"),
                entry.get("codigoPostal")
        );
    }
}
