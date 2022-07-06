package co.com.segurossura.certificacion.models;

public enum CredencialesModelo {
    USUARIO_ESTANDAR("standard_user", "secret_sauce"),
    USUARIO_INVALIDO("standard_user", "admin123"),
    USUARIO_BLOQUEADO("locked_out_user", "secret_sauce"),
    USUARIO_CLAVE_VACIA("usuario", ""),
    USUARIO_USUARIO_VACIO("", "claveDeAcceso");

    private final String usuario;
    private final String claveDeAcceso;

    CredencialesModelo(String usuario, String claveDeAcceso) {
        this.usuario = usuario;
        this.claveDeAcceso = claveDeAcceso;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClaveDeAcceso() {
        return claveDeAcceso;
    }
}
