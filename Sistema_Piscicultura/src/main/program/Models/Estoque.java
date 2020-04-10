package main.program.Models;

import main.program.Interface.EstouraException;

import javax.persistence.Entity;

@Entity
public class Estoque extends Entidade{
    //Declarações
    private String Marca;
    private Integer Quantidade;

    //getters
    public String getMarca() { return Marca; }
    public Integer getQntEstoque() { return Quantidade; }

    //setters
    public void setMarca(String marca) { this.Marca = marca; }
    public void setQntEstoque(Integer qntEstoque) { this.Quantidade = qntEstoque; }

    public Estoque (String marca, Integer qtdEstoque) {
        this.Marca = marca;
        this.Quantidade = qtdEstoque;
    }

    //Validações
    @Override
    public void validar() throws Exception {
        EstouraException EE = new EstouraException();

        if(Marca.isBlank()){ EE.RaiseException("Marca em branco !"); }
        if(Quantidade < 0){ EE.RaiseException("Quantidade do estoque inválida."); }

    }
}
