package Models;

import Models.Enums.TipoFuncionario;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Funcionario extends Usuario {

    @Enumerated(EnumType.STRING)
    private TipoFuncionario tipoFuncionario;

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public void validar() throws Exception {

        if (this.getSenha().isBlank()) {
            throw new Exception("Funcionário não possui em senha");
        }

        if (this.getUsername().isBlank()) {
            throw new Exception("Funcionário não possui usuário");
        }

        if (this.getTipoFuncionario() == null) {
            throw new Exception("Funcionário não possui Tipo de funcionário");
        }

    }
}
