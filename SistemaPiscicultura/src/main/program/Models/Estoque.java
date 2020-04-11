package Models;

import Interface.EstouraException;

import javax.persistence.Entity;

@Entity
public class Estoque extends Entidade{
    //Declarações
    private String Marca;
    private Integer Quantidade;

    //getters
    public String getMarca() { return Marca; }
    public Integer getQuantidade() { return Quantidade; }

    //setters
    public void setMarca(String marca) { this.Marca = marca; }
    public void setQntEstoque(Integer quantidade) { this.Quantidade = quantidade; }

    public Estoque () { };

    public Estoque (String marca, Integer quantidade) {
        this.Marca = marca;
        this.Quantidade = quantidade;
    }

    //Validações
    @Override
    public void validar() throws Exception {
        EstouraException EE = new EstouraException();

        if(Marca.isBlank()){ EE.RaiseException("Marca em branco !"); }
        if(Quantidade < 0){ EE.RaiseException("Quantidade do estoque inválida."); }

    }
}
