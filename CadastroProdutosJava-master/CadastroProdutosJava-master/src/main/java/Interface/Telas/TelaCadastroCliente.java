package Interface.Telas;

import Application.ClienteApp;
import Models.Cliente;
import Models.Enums.EnumEstadoConsole;
import Models.EstadoConsole;

import java.util.Scanner;

import static Interface.Main.telaAtual;

public class TelaCadastroCliente extends EstadoConsole {

    public static void cadastrarCliente() {
        try {
            Scanner scan = new Scanner(System.in);
            Cliente cliente = new Cliente();
            ClienteApp clienteApp = new ClienteApp();

            System.out.print("Nome do cliente: ");
            cliente.setNome(scan.next());

            System.out.print("Telefone do cliente: ");
            cliente.setTelefone(scan.next());

            clienteApp.Adicionar(cliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean continuarCadastroCliente() {
        Scanner scan = new Scanner(System.in);
        String opcao;
        System.out.print("Deseja cadastrar outro cliente? Y/N: ");
        opcao = scan.next().toUpperCase();
        switch (opcao) {
            case "Y":
                return true;
            case "N":
                return false;
            default:
                System.out.print("Digite Y ou N para responder! ");
        }
        continuarCadastroCliente();
        return true;
    }

    @Override
    public boolean executa() {

        boolean cadastrandoCliente = true;

        while (cadastrandoCliente) {
            cadastrarCliente();
            cadastrandoCliente = continuarCadastroCliente();
        }

        System.out.print("\n\n");
        telaAtual = EnumEstadoConsole.MENU.getEstadoMaquina();

        return false;
    }
}