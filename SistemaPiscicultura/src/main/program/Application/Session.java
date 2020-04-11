package Application;

import Models.Usuario;

public class Session {
    private static Session INSTANCE = null;
    private Usuario usuarioLogado;

    private Session() {

    }

    public static Session getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Session();

        return INSTANCE;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void LogarUsuario(Usuario user) {
        usuarioLogado = user;
    }
}
