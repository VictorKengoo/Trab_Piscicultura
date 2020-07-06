package Application;

import Models.Usuario;
import Repository.UsuarioRepository;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    public String criptografaSenha(String senhaComum) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String senha = senhaComum;
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest = algorithm.digest(senha.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder();
        for (
                byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        return hexString.toString();
    }

    public Usuario getById(int id) throws Exception {
        return super.getById("Usuario", id);
    }
}