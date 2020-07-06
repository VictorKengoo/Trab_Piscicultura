package Models.Enums;

public enum TipoUsuario {
    USUARIO("USUARIO"),
    ADMINISTRADOR("ADMINISTRADOR");

    private String label;

    TipoUsuario(String label) {
        this.label = label;
    }

    public String TipoUsuario() {
        return label;
    }
    @Override public String toString() { return label; }
}

