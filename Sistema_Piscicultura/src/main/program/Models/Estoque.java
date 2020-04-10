package main.program.Models;

import main.program.Interface.EstouraException;

public class Estoque extends Entidade{
    //Declarações
    private String Marca;
    private Integer QntEstoque;

    //getters
    public String getMarca() { return Marca; }
    public Integer getQntEstoque() { return QntEstoque; }

    //setters
    public void setMarca(String marca) { this.Marca = marca; }
    public void setQntEstoque(Integer qntEstoque) { this.QntEstoque = qntEstoque; }

    public Estoque (String marca, Integer qtdEstoque) {
        this.Marca = marca;
        this.QntEstoque = qtdEstoque;
    }

    //Validações
    @Override
    public void validar() throws Exception {
        EstouraException EE = new EstouraException();

        if(Marca.isBlank()){ EE.RaiseException("Marca em branco !"); }
        if(QntEstoque < 0){ EE.RaiseException("Quantidade do estoque inválida."); }

    }
}
