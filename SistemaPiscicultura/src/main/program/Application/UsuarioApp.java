package Application;

import Models.Usuario;
import Repository.UsuarioRepository;

public class UsuarioApp extends BaseApp<Usuario> {

    private UsuarioRepository _usuaruioRepository;

    public UsuarioApp() {
        _usuaruioRepository = new UsuarioRepository();
    }

    public void hasDuplicate(Usuario newUser) throws Exception {
        Usuario userExistente = _usuaruioRepository.getUserByUsername(newUser);
        if (userExistente != null) {
            if ((newUser.id != userExistente.id) && (newUser.getUsuario().toLowerCase().trim().equals(userExistente.getUsuario().toLowerCase().trim()))) {
                throw new Exception("Já existe um usuário registrado com este nome.");
            }
        }
    }

//    public Usuario getById(int Id) throws Exception {
//       return _usuaruioRepository.getById(Id);
//    }
}