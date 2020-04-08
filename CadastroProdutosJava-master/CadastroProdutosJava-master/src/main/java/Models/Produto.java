package Models;

import javax.persistence.Entity;

@Entity
public class Produto extends Entidade {

    private String nome;
    private double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void validar() throws Exception {

        if (this.getNome().isBlank()) {
            throw new Exception("Produto não tem nome");
        }

        if (this.getPreco() <= 0) {
            throw new Exception("Produto tem preço menor ou igual a 0");
        }
    }

    @Override
    public String toString() {
        String print = "Cod.: " + this.id + " Descricao: " + this.nome + " Preço: " + this.preco;
        return print;
    }

}
