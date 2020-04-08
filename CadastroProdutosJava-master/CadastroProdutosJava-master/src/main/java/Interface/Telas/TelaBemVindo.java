package Interface.Telas;

import Models.Enums.EnumEstadoConsole;
import Models.EstadoConsole;

import java.util.Scanner;

import static Interface.Main.telaAtual;

public class TelaBemVindo extends EstadoConsole {

    @Override
    public boolean executa() {

        boolean sair = false;

        System.out.println("***HOME!***");
        System.out.println("Digite a opção desejada: ");
        System.out.println("0 - Informação Devs");
        System.out.println("1 - Login");
        Scanner scan = new Scanner(System.in);
        int opcao = scan.nextInt();
        switch (opcao) {
            case 0:
                System.out.print("\n\n");
                telaAtual = EnumEstadoConsole.DEVS.getEstadoMaquina();
                break;
            case 1:
                System.out.print("\n\n");
                telaAtual = EnumEstadoConsole.LOGIN.getEstadoMaquina();
                break;
            default:
                System.out.println("teste default");
        }
        return sair;
    }
}