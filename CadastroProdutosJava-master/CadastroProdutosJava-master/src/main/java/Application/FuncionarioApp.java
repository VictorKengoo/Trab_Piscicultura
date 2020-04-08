package Application;

import Models.Funcionario;
import Repository.FuncionarioRepository;

public class FuncionarioApp extends BaseApp<Funcionario> {

    private FuncionarioRepository _funcionarioRepository;

    public FuncionarioApp() {
        _funcionarioRepository = new FuncionarioRepository();
    }

}
