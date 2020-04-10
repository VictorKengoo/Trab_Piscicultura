package main.program.Models;

import main.program.Interface.EstouraException;

public class Estoque extends Entidade{
    //Declarações
    private String Marca;
    private int QntEstoque;

    //getters
    public String getMarca() { return Marca; }
    public int getQntEstoque() { return QntEstoque; }

    //setters
    public void setMarca(String marca) { this.Marca = marca; }
    public void setQntEstoque(int qntEstoque) { this.QntEstoque = qntEstoque; }

    //Validações
    @Override
    public void validar() throws Exception {
        EstouraException EE = new EstouraException();

        if(Marca.isBlank()){ EE.RaiseException("Marca em branco !"); }
        if(QntEstoque < 0){ EE.RaiseException("Quantidade do estoque inválida."); }

    }
}
