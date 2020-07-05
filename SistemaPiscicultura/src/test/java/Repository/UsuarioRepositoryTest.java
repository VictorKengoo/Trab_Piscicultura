package Repository;

import Models.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class UsuarioRepositoryTest {

    UsuarioRepository usuarioRepository = new UsuarioRepository();
    Usuario usuarioAdmin = new Usuario("admin", "admin", null);
    Usuario usuarioTeste = new Usuario("usuarioteste", "usuarioteste", null);

    @Test
    public void getUserByUsername() {
        Assert.assertEquals(usuarioAdmin, usuarioRepository.getUserByUsername(usuarioAdmin));
        Assert.assertEquals(null, usuarioRepository.getUserByUsername(usuarioTeste));
    }
}