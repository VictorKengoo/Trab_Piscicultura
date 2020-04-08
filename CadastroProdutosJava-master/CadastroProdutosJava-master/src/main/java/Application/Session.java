package Application;

import Models.Funcionario;

public class Session {
    private static Session INSTANCE = null;
    private Funcionario funcionarioLogado;

    private Session() {

    }

    public static Session getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Session();

        return INSTANCE;

    }

    public Funcionario getFuncionarioLogado() {
        return funcionarioLogado;
    }

    public void LogarUsuario(Funcionario func) {
        funcionarioLogado = func;
    }
}
