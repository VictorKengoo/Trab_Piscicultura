package Interface.Telas;

import Application.ClienteApp;
import Application.PedidoApp;
import Application.ProdutoApp;
import Application.Session;
import Models.*;
import Models.Enums.EnumEstadoConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Interface.Main.telaAtual;

public class TelaPedido extends EstadoConsole {

    protected ProdutoApp produtoApp;
    protected ClienteApp clienteApp;
    protected PedidoApp pedidoApp;

    public TelaPedido() {
        produtoApp = new ProdutoApp();
        clienteApp = new ClienteApp();
        pedidoApp = new PedidoApp();
    }

    @Override
    public boolean executa() {

        realizarPedido();

        System.out.print("\n\n");
        telaAtual = EnumEstadoConsole.MENU.getEstadoMaquina();

        return false;
    }

    private void realizarPedido() {
        try {
            Scanner scan = new Scanner(System.in);
            Pedido pedido = new Pedido();

            System.out.println("");
            Cliente cliente = selectCliente(scan);
            List<Produto> produtos = selectProducts(scan);
            Funcionario funcionario = Session.getInstance().getFuncionarioLogado();

            pedido.setIdFuncionario(funcionario.id);
            pedido.setIdCliente(cliente.id);
            pedido.setProdutos(produtos);
            pedido.validar();
            pedidoApp.Adicionar(pedido);

            System.out.println("Deseja Imprimir ?(Y/Qualquer Coisa)");
            String imprimir = scan.next();

            if (imprimir.toUpperCase().equals("Y")) {
                System.out.println(pedido.toString());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            realizarPedido();
        }
    }

    private Cliente selectCliente(Scanner scan) {
        try {
            List<Cliente> clientes = listClientes();

            do {
                int codCliente;
                System.out.println("Selecione o Id do Cliente");
                codCliente = scan.nextInt();
                Cliente clienteSelecionado = clientes.stream().filter(x -> x.id == codCliente).findFirst().orElse(null);
                if (clienteSelecionado != null) {
                    System.out.println("Selecione o Id de Cliente válido");
                    return clienteSelecionado;
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return selectCliente(scan);
        }
    }

    private List<Produto> selectProducts(Scanner scan) {
        try {
            List<Produto> produtos = listProdutos();
            List<Produto> produtosSelecionados = new ArrayList<Produto>();

            boolean selecionandoProdutos;
            do {

                Produto produtoSelecionado = perguntaSelectProduto(scan, produtos);

                if(produtoSelecionado == null){
                    System.out.println("Produto não existe");
                }
                else {
                    produtosSelecionados.add(produtoSelecionado);
                }

                selecionandoProdutos = continuarSelecaoDeProdutos(scan);
            }
            while (selecionandoProdutos);

            return produtosSelecionados;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return selectProducts(scan);
        }
    }

    private Produto perguntaSelectProduto(Scanner scan, List<Produto> produtos) {
        int codProd;
        System.out.print("Id do Produto: ");
        codProd = scan.nextInt();
        return produtos.stream().filter(x -> x.id == codProd).findFirst().orElse(null);
    }

    private List<Produto> listProdutos() {
        List<Produto> produtos = produtoApp.getAll(Produto.class);
        System.out.println("----------- LISTA DE PRODUTOS ----------");
        for (Produto produto : produtos) {
            System.out.println(produto.toString());
        }
        return produtos;
    }

    private List<Cliente> listClientes() {
        List<Cliente> clientes = clienteApp.getAll(Cliente.class);
        System.out.println("----------- LISTA DE CLIENTES ----------");
        for (Cliente cliente : clientes) {
            System.out.println("Cod.: " + cliente.id + " Nome: " + cliente.getNome() + " Telefone: " + cliente.getTelefone());
        }
        return clientes;
    }

    public boolean continuarSelecaoDeProdutos(Scanner scan) {
        String opcao;
        System.out.print("Deseja adicionar outro produto? Y/N: ");
        opcao = scan.next();
        switch (opcao.toUpperCase()) {
            case "Y":
                return true;
            case "N":
                return false;
            default:
                return continuarSelecaoDeProdutos(scan);

        }
    }
}
