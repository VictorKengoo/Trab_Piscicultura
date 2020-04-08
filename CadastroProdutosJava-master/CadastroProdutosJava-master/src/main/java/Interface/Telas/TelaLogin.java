package Interface.Telas;

import Application.LoginApp;
import Models.Enums.EnumEstadoConsole;
import Models.EstadoConsole;
import Models.Funcionario;

import java.util.Scanner;

import static Interface.Main.telaAtual;

public class TelaLogin extends EstadoConsole {

    @Override
    public boolean executa() {
        boolean sair = false;

        System.out.println("***LOGIN***");

        Scanner scan = new Scanner(System.in);
        Funcionario funcionario = new Funcionario();
        LoginApp loginApp = new LoginApp();

        System.out.print("Usuário: ");
        funcionario.setUsername(scan.next());

        System.out.print("Senha: ");
        funcionario.setSenha(scan.next());

        funcionario = loginApp.doLogin(funcionario);

        if (funcionario != null) {
            telaAtual = EnumEstadoConsole.MENU.getEstadoMaquina();
        } else {
            System.out.print("Usuário ou senha incorreto, favor digitar novamente");
            sair = true;
        }

        return sair;
    }
}
