package Application;


import Models.Usuario;
import Repository.UsuarioRepository;

public class LoginApp {

    private final UsuarioRepository _usuarioRepository;

    public LoginApp() {
        _usuarioRepository = new UsuarioRepository();
    }

    public Usuario doLogin(Usuario username) {

        Usuario searchedUser = _usuarioRepository.getUserByUsername(username);

        if (searchedUser != null && searchedUser.getSenha().equals(username.getSenha())) {
            Session.getInstance().LogarUsuario(searchedUser);

            return searchedUser;
        }
        return null;
    }
}
