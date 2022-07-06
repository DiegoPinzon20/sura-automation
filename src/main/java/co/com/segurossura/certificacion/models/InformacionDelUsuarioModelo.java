package co.com.segurossura.certificacion.models;

import lombok.Data;

@Data
public class InformacionDelUsuarioModelo {
    private final String nombre;
    private final String apellido;
    private final String codigoPostal;
}