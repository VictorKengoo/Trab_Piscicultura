package Application;

import Models.Usuario;
import Repository.UsuarioRepository;

public class UsuarioApp extends BaseApp<Usuario> {

    private UsuarioRepository _usuaruioRepository;

    public UsuarioApp() {
        _usuaruioRepository = new UsuarioRepository();
    }

    public void hasDuplicate(Usuario newUser) throws Exception {
        Usuario existente = _usuaruioRepository.getUserByUsername(newUser);
        if (existente != null) {
            if ((newUser.id != existente.id) && (newUser.getUsuario().toLowerCase().trim().equals(existente.getUsuario().toLowerCase().trim()))) {
                throw new Exception("Já existe um usuário registrado com este nome.");
            }
        }
    }

    public Usuario getById(int id) throws Exception {
        return super.getById("Usuario", id);
    }
}