package Interface.Telas;

import Application.FuncionarioApp;
import Models.Enums.EnumEstadoConsole;
import Models.Enums.TipoFuncionario;
import Models.EstadoConsole;
import Models.Funcionario;

import java.util.Scanner;

import static Interface.Main.telaAtual;

public class TelaCadastroFuncionario extends EstadoConsole {

    @Override
    public boolean executa() {

        boolean cadastrandoFuncionario = true;

        while(cadastrandoFuncionario) {
            cadastrarFuncionario();
            cadastrandoFuncionario = continuarCadastroFuncionario();
        }

        System.out.print("\n\n");
        telaAtual = EnumEstadoConsole.MENU.getEstadoMaquina();

        return false;
    }

    public static void cadastrarFuncionario() {
        try {
            Scanner scan = new Scanner(System.in);
            Funcionario funcionario = new Funcionario();
            FuncionarioApp funcionarioApp = new FuncionarioApp();

            System.out.print("Username do funcionario: ");
            funcionario.setUsername(scan.next());

            System.out.print("Senha do funcionario: ");
            funcionario.setSenha(scan.next());

            String opcao;
            System.out.println("Tipo do funcionario: ");
            System.out.println("0 - GERENTE");
            System.out.println("1 - VENDEDOR");
            opcao = scan.next();
            switch (opcao) {
                case "0":
                    funcionario.setTipoFuncionario(TipoFuncionario.GERENTE);
                    break;
                case "1":
                    funcionario.setTipoFuncionario(TipoFuncionario.VENDEDOR);
                    break;
                default:
                    System.out.println("Digite 0 ou 1 para um tipo de funcionário válido!");
                    cadastrarFuncionario();
            }

            funcionarioApp.Adicionar(funcionario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static boolean continuarCadastroFuncionario() {
        Scanner scan = new Scanner(System.in);
        String opcao;
        System.out.print("Deseja cadastrar outro funcionario? Y/N: ");
        opcao = scan.next().toUpperCase();
        switch (opcao) {
            case "Y":
                return true;
            case "N":
                return false;
            default:
                System.out.print("Digite Y ou N para responder! ");
        }
        continuarCadastroFuncionario();
        return true;
    }
}