package Models;

import Interface.EstouraException;

import javax.persistence.Entity;


@Entity
public class Usuario extends Entidade {
    //Declarações
/*    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;*/

    //private String Nome;
    //private String CPF;
    private String Usuario;
    private String Senha;

    //getters
    //public TipoUsuario getTipoUsuario() { return tipoUsuario; }
    public String getUsuario() {
        return Usuario;
    }

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
    }

//    public Usuario (String usuario, String senha) {
//        this.Usuario = usuario;
//        this.Senha = senha;
//    }

    //Validações
    @Override
    public void validar() throws Exception {
        EstouraException EE = new EstouraException();

        //if(tipoUsuario == null){ EE.RaiseException("Tipo Usuário em branco."); }
        //if(Nome.isBlank()){ EE.RaiseException("Nome em branco."); }
        //if(CPF.isBlank()){ EE.RaiseException("CPF em branco."); }
        if (Usuario.isBlank()) {
            EE.RaiseException("Usuario em branco.");
        }
        if (Senha.isBlank()) {
            EE.RaiseException("Senha em branco.");
        }

    }
}
