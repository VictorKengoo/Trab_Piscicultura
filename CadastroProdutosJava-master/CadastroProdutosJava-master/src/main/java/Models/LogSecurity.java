package Models;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class LogSecurity extends Entidade {
    private Funcionario funcionario;
    private String acao;
    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    @Override
    public void validar() throws Exception {

    }
}
