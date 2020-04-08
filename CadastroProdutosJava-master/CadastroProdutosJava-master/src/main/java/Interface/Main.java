package Interface;

import Application.LoginApp;
import Models.Enums.EnumEstadoConsole;
import Models.EstadoConsole;

import java.util.Scanner;


public class Main {

    public static EstadoConsole telaAtual;

    public static void main(String[] args) throws Exception {

        LoginApp loginApp = new LoginApp();
        System.out.println("***Seja bem vindo a este gerenciador!*** \nEscolha sua opção: ");
        System.out.println("0 - Sair");
        System.out.print("1 - Home");
        System.out.print("\n\n");
        Scanner scan = new Scanner(System.in);
        int opcao = scan.nextInt();
        switch (opcao) {
            case 0:
                System.out.print("Falou!");
                return;
            case 1:
                telaAtual = EnumEstadoConsole.BEM_VINDO.getEstadoMaquina();
                break;
            default:
                System.out.println("teste default");
        }
        boolean saida = false;
        while (!saida) {
            saida = telaAtual.executa();
        }
    }
}
