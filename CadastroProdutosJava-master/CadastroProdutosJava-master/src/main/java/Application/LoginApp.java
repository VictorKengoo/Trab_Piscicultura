package Application;

import Models.Funcionario;
import Models.LogSecurity;
import Repository.FuncionarioRepository;
import Repository.LogSecurityRepository;

import java.util.Date;

public class LoginApp {

    private FuncionarioRepository _funcionarioRepository;
    private LogSecurityRepository _logSecurityRepository;

    public LoginApp() {
        _funcionarioRepository = new FuncionarioRepository();
        _logSecurityRepository = new LogSecurityRepository();
    }

    public Funcionario doLogin(Funcionario func) {
        LogSecurity logSecurity = new LogSecurity();
        logSecurity.setData(new Date());
        logSecurity.setFuncionario(null);
        logSecurity.setAcao("Tentativa de Login " + func.getUsername());


        Funcionario searchedFunc = _funcionarioRepository.getFuncByUsername(func);

        if (searchedFunc != null && searchedFunc.getSenha().equals(func.getSenha())) {
            Session.getInstance().LogarUsuario(searchedFunc);

            LogSecurity logSecurity2 = new LogSecurity();
            logSecurity2.setData(new Date());
            logSecurity2.setFuncionario(func);
            logSecurity2.setAcao("Login " + func.getUsername());

            return searchedFunc;
        }
        return null;
    }
}
