package Models;

import Application.EstoqueApp;
import Application.UsuarioApp;
import Interface.EstouraException;

<<<<<<< HEAD
import javax.persistence.*;
import java.util.ArrayList;


@Entity
public class Usuario extends Entidade{
    /*    @Enumerated(EnumType.STRING)
=======
import javax.persistence.Entity;


@Entity
public class Usuario extends Entidade {
    //Declarações
/*    @Enumerated(EnumType.STRING)
>>>>>>> f9c76c88962873aaeb646bef4cfdd1676d5bfbb4
    private TipoUsuario tipoUsuario;*/

    private String Usuario;
    private String Senha;
    private String TipoUser;

    //getters
    //public TipoUsuario getTipoUsuario() { return tipoUsuario; }
    public String getUsuario() {
        return Usuario;
    }
<<<<<<< HEAD

    public String getSenha() {
        return Senha;
=======

    public String getSenha() {
        return Senha;
    }

    //setters
    //public void setTipoUsuario(TipoUsuario tipoUsuario) { this.tipoUsuario = tipoUsuario; }
    //public void setNome(String nome) { this.Nome = nome; }
    //public void setCPF(String CPF) { this.CPF = CPF; }
    public void setUsuario(String usuario) {
        this.Usuario = usuario;
    }

    public void setSenha(String senha) {
        this.Senha = senha;
>>>>>>> f9c76c88962873aaeb646bef4cfdd1676d5bfbb4
    }

    public String getTipoUser() {
        return TipoUser;
    }

    public Usuario () {
        this.Usuario = "";
        this.Senha = "";
        this.TipoUser = "";
    }

<<<<<<< HEAD
    public Usuario (String usuario, String senha, String userType) {
        this.Usuario = usuario;
        this.Senha = senha;
        this.TipoUser = userType;
    }
=======
        //if(tipoUsuario == null){ EE.RaiseException("Tipo Usuário em branco."); }
        //if(Nome.isBlank()){ EE.RaiseException("Nome em branco."); }
        //if(CPF.isBlank()){ EE.RaiseException("CPF em branco."); }
        if (Usuario.isBlank()) {
            EE.RaiseException("Usuario em branco.");
        }
        if (Senha.isBlank()) {
            EE.RaiseException("Senha em branco.");
        }
>>>>>>> f9c76c88962873aaeb646bef4cfdd1676d5bfbb4

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
