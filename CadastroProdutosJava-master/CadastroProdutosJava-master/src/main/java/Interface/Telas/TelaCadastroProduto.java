package Interface.Telas;

import Application.ProdutoApp;
import Models.Enums.EnumEstadoConsole;
import Models.EstadoConsole;
import Models.Produto;

import java.util.Scanner;

import static Interface.Main.telaAtual;

public class TelaCadastroProduto extends EstadoConsole {
    @Override
    public boolean executa() {

        boolean cadastrandoProduto = true;

        while(cadastrandoProduto) {
            cadastrarProduto();
            cadastrandoProduto = continuarCadastroProduto();
        }

        System.out.print("\n\n");
        telaAtual = EnumEstadoConsole.MENU.getEstadoMaquina();
        return false;
    }

    public static void cadastrarProduto() {
        try {
            Scanner scan = new Scanner(System.in);
            Produto produto = new Produto();
            ProdutoApp produtoApp = new ProdutoApp();

            System.out.print("Nome do Produto: ");
            produto.setNome(scan.next());

            System.out.print("Preço do Produto: ");
            produto.setPreco(Double.parseDouble(scan.next()));

            produtoApp.Adicionar(produto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean continuarCadastroProduto() {
        Scanner scan = new Scanner(System.in);
        String opcao;
        System.out.print("Deseja cadastrar outro Produto? Y/N: ");
        opcao = scan.next().toUpperCase();
        switch (opcao) {
            case "Y":
                return true;
            case "N":
                return false;
            default:
                System.out.print("Digite Y ou N para responder! ");
        }
        continuarCadastroProduto();
        return false;
    }
}