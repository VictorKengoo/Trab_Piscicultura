package ViewModels;

import Models.Usuario;
import javafx.beans.property.SimpleStringProperty;

public class UsuarioTableData {

    public SimpleStringProperty usuarioId;
    public SimpleStringProperty username;
    public SimpleStringProperty tipo;

    public UsuarioTableData(Usuario user) {
        this.usuarioId = new SimpleStringProperty(String.valueOf(user.id));
        this.username  = new SimpleStringProperty(String.valueOf(user.getUsuario()));
        this.tipo      = new SimpleStringProperty(String.valueOf(user.getTipoUser()));
    }

    public String getUsuarioId() {
        return usuarioId.get();
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId.set(usuarioId);
    }

    public String getUsername() {
        return username.get();
    }

    public void getUsername(String username) {
        this.username.set(username);
    }

    public String getTipo() {
        return tipo.get();
    }

    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }
}
