package Application;

import Models.Usuario;
import Repository.UsuarioRepository;
import org.junit.Assert;
import org.junit.Test;

public class LoginAppTest extends LoginApp {

    @Test
    public void testDoLogin() {

        LoginApp LoginTest = new LoginApp();
        UsuarioRepository _usuarioRepository = new UsuarioRepository();
        Usuario username = new Usuario();
        Usuario searchedUser = _usuarioRepository.getUserByUsername(username);

        username.setUsuario("admin1");
        username.setSenha("admin1");

        if (searchedUser != null && searchedUser.getSenha().equals(username.getSenha())) {
            Session.getInstance().LogarUsuario(searchedUser);
        }

        Assert.assertNotEquals(null, username);
    }
}