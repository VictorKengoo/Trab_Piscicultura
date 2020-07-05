package Models;

import Application.EstoqueApp;
import Application.UsuarioApp;
import Interface.EstouraException;
import Models.Enums.TipoUsuario;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
public class Usuario extends Entidade{
    /*    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;*/

    private String Usuario;
    private String Senha;
    private String TipoUser;

    //getters
    //public TipoUsuario getTipoUsuario() { return tipoUsuario; }
    public String getUsuario() {
        return Usuario;
    }

    public String getSenha() {
        return Senha;
    }

    public String getTipoUser() {
        return TipoUser;
    }

    public Usuario () {
        this.Usuario = "";
        this.Senha = "";
        this.TipoUser = "";
    }

    public Usuario (String usuario, String senha, String userType) {
        this.Usuario = usuario;
        this.Senha = senha;
        this.TipoUser = userType;
    }

    //setters
    public void setUsuario(String usuario) {
        this.Usuario = usuario;
    }
    public void setSenha(String senha) {
        this.Senha = senha;
    }
    public void setTipoUser(String tipoUser) {
        this.TipoUser = tipoUser;
    }

    //Validações
    @Override
    public void validar() { }
}
