package Interface.Telas;

import Models.Enums.EnumEstadoConsole;
import Models.EstadoConsole;

import java.util.Scanner;

import static Interface.Main.telaAtual;

public class TelaInfoDevs extends EstadoConsole {

    @Override
    public boolean executa() {
        System.out.println("Douglas Lopes - RA: 082170005");
        System.out.println("Ian Akio - RA: 082170010");

        Scanner scan = new Scanner(System.in);

        System.out.print("\n\n");

        telaAtual = EnumEstadoConsole.BEM_VINDO.getEstadoMaquina();

        return false;
    }
}
