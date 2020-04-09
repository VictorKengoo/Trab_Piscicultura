package main.program.Models;

import main.program.Interface.EstouraException;

public class Racao extends Entidade{
    //Declarações
    private String Marca;
    private double Preco;
    private int QntEstoque;

    //getters
    public String getMarca() { return Marca; }
    public double getPreco() { return Preco; }
    public int getQntEstoque() { return QntEstoque; }

    //setters
    public void setMarca(String marca) { this.Marca = marca; }
    public void setPreco(int preco) { this.Preco = preco; }
    public void setQntEstoque(int qntEstoque) { this.QntEstoque = qntEstoque; }

    //Validações
    @Override
    public void validar() throws Exception {
        EstouraException EE = new EstouraException();

        if(Marca.isBlank()){ EE.RaiseException("Marca em branco !"); }
        if(Preco < 0){ EE.RaiseException("Valor de preço inválido."); }
        if(QntEstoque < 0){ EE.RaiseException("Quantidade do estoque inválida."); }

    }
}
