package Application;

import Interface.EstouraException;
import Models.Usuario;
import Repository.UsuarioRepository;

import java.util.ArrayList;

public class UsuarioApp extends BaseApp<Usuario>{

    private UsuarioRepository _usuaruioRepository;

    public UsuarioApp() { _usuaruioRepository = new UsuarioRepository(); }

    public boolean hasDuplicate(String username) {
        EstouraException EE = new EstouraException();
        UsuarioApp usuarioApp = new UsuarioApp();
        ArrayList<String> listUserExistente = new ArrayList<String>();
        for (Usuario user : usuarioApp.getAll(Usuario.class)) {
            listUserExistente.add(String.valueOf(user.getUsuario()));
        }

        for (String userExistente : listUserExistente) {
            if (username.toLowerCase().trim().equals(userExistente.toLowerCase().trim())) {
                EE.RaiseException("Já existe um usuário registrado com este nome.");
                return true;
            }
        }

        return false;
    }
}
