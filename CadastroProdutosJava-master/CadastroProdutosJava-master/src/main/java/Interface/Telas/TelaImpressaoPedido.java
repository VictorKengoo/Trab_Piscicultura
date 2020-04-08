package Interface.Telas;

import Application.PedidoApp;
import Models.Enums.EnumEstadoConsole;
import Models.EstadoConsole;
import Models.Pedido;

import java.util.List;
import java.util.Scanner;

import static Interface.Main.telaAtual;

public class TelaImpressaoPedido extends EstadoConsole {

    protected PedidoApp pedidoApp;

    public TelaImpressaoPedido() {
        pedidoApp = new PedidoApp();
    }

    @Override
    public boolean executa() {
        ImprimirPedidoTela();
        telaAtual = EnumEstadoConsole.MENU.getEstadoMaquina();
        return false;
    }

    private void ImprimirPedidoTela() {
        try {
            Scanner scan = new Scanner(System.in);

            List<Pedido> pedidos = pedidoApp.getAll(Pedido.class);
            for (Pedido pedido : pedidos) {
                System.out.println("Pedido: " + pedido.id + " Cliente: " + pedido.getIdCliente() + " Funcionario: " + pedido.getIdFuncionario());
            }

            ImprimirPedido(scan);
        } catch (Exception e) {

        }
    }

    private void ImprimirPedido(Scanner scan) {
        try {
            System.out.println("Id do Pedido:");
            int idDoPedido = scan.nextInt();

            String print = pedidoApp.imprimirPedido(idDoPedido);
            System.out.println(print);
        } catch (Exception e) {
            ImprimirPedido(scan);
        }
    }
}
