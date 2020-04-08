package Models.Enums;

import Interface.Telas.*;
import Models.EstadoConsole;

public enum EnumEstadoConsole {

    BEM_VINDO(new TelaBemVindo()),

    DEVS(new TelaInfoDevs()),

    LOGIN(new TelaLogin()),

    MENU(new TelaMenu()),

    PEDIDO(new TelaPedido()),

    TELA_CLIENTE(new TelaCadastroCliente()),

    TELA_PRODUTO(new TelaCadastroProduto()),

    IMPRESSAO(new TelaImpressaoPedido()),

    TELA_FUNCIONARIO(new TelaCadastroFuncionario());


    private final EstadoConsole estadoMaquina;

    EnumEstadoConsole(EstadoConsole estadoMaquina) {
        this.estadoMaquina = estadoMaquina;
    }

    public EstadoConsole getEstadoMaquina() {
        return estadoMaquina;
    }
}
