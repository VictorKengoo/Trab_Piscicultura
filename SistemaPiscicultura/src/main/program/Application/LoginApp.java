package Application;

import Models.Usuario;
import Repository.UsuarioRepository;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class LoginApp {

    private UsuarioRepository _usuarioRepository;

    public LoginApp() {
        _usuarioRepository = new UsuarioRepository();
    }

    public Usuario doLogin(Usuario loginUser) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        Usuario searchedUser = _usuarioRepository.getUserByUsername(loginUser);
        UsuarioApp userApp = new UsuarioApp();
        String criptografada = userApp.criptografaSenha(loginUser.getSenha());

        if (searchedUser != null && searchedUser.getSenha().equals(criptografada)) {
            Session.getInstance().LogarUsuario(searchedUser);

            return searchedUser;
        }
        return null;
    }
}
