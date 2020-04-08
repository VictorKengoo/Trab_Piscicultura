package Models;

import javax.persistence.Entity;

@Entity
public class Cliente extends Entidade {
    private String nome;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void validar() throws Exception {
        if (nome.isBlank()) {
            throw new Exception("Nome em branco");
        }
        if (telefone.isBlank()) {
            throw new Exception("Telefone em branco");
        }
    }
}
