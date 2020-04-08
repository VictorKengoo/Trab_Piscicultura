package Interface.Telas;

import Application.Session;
import Models.Enums.EnumEstadoConsole;
import Models.Enums.TipoFuncionario;
import Models.EstadoConsole;
import Models.Funcionario;

import java.util.Scanner;

import static Interface.Main.telaAtual;

/**
 * Após login ser realizado com sucesso, usuário terá a possibilidade de:
 * Cadastrar cliente, Cadastrar produto, Cadastrar funcionario (caso seja gerente), Realizar pedido
 */
public class TelaMenu extends EstadoConsole {
    public static void checarOpcao() {
        Funcionario funcionarioLogado = Session.getInstance().getFuncionarioLogado();

        System.out.println("MENU - Selecione a opção desejada: ");

        System.out.println("0 - Cadastrar cliente");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Realizar pedido");
        System.out.println("3 - Imprimir um pedido");
        if (funcionarioLogado.getTipoFuncionario() == TipoFuncionario.GERENTE) {
            System.out.println("4 - Cadastrar funcionario");
        }
        System.out.println("5 - Sair");


        Scanner scan = new Scanner(System.in);
        int opcao = scan.nextInt();
        switch (opcao) {
            case 0:
                System.out.print("\n\n");
                System.out.println("Tela de Cadastro de cliente!");
                telaAtual = EnumEstadoConsole.TELA_CLIENTE.getEstadoMaquina();
                break;

            case 1:
                System.out.print("\n\n");
                System.out.println("Tela de Cadastro de produto");
                telaAtual = EnumEstadoConsole.TELA_PRODUTO.getEstadoMaquina();
                break;

            case 2:
                System.out.print("\n\n");
                System.out.print("Tela de pedido");
                telaAtual = EnumEstadoConsole.PEDIDO.getEstadoMaquina();
                break;

            case 3:
                System.out.print("\n\n");
                System.out.println("Tela de Impressão");
                telaAtual = EnumEstadoConsole.IMPRESSAO.getEstadoMaquina();
                break;

            case 4:
                if (funcionarioLogado.getTipoFuncionario() == TipoFuncionario.GERENTE) {
                    System.out.print("\n\n");
                    System.out.println("Cadastrar funcionario");
                    telaAtual = EnumEstadoConsole.TELA_FUNCIONARIO.getEstadoMaquina();
                } else {
                    System.out.println("Escolha uma opção possível!");
                    checarOpcao();
                }

                break;

            case 5:
                telaAtual = EnumEstadoConsole.BEM_VINDO.getEstadoMaquina();
                break;

            default:
                System.out.println("Escolha uma opção possível!");
                checarOpcao();
                break;
        }
    }

    @Override
    public boolean executa() {
        checarOpcao();
        return false;
    }
}
