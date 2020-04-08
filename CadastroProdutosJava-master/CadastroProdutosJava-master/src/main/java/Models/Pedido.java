package Models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Pedido extends Entidade {

    @OneToMany(targetEntity = Produto.class, fetch = FetchType.EAGER)
    private List<Produto> Produtos;

    private int idFuncionario;

    private int idCliente;

    public List<Produto> getProdutos() {
        return Produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        Produtos = produtos;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void validar() throws Exception {
        if (Produtos.isEmpty())
            throw new Exception("Produtos estão invalidos");

        if (idFuncionario <= 0)
            throw new Exception("Funcionario inválido");

        if (idCliente <= 0)
            throw new Exception("Cliente inválido");
    }

    @Override
    public String toString() {
        String header = String.format("-----------PEDIDO: %s -----------\n\n" +
                "--CLIENTE: %s\n" +
                "--FUNCIONARIO: %s\n" +
                "---------LISTA DE PRODUTOS-------\n", this.id, this.idCliente, this.idFuncionario);

        StringBuilder sbListaDeProdutosDaCompra = new StringBuilder();
        for (Produto produto : this.Produtos) {
            sbListaDeProdutosDaCompra.append(produto.toString() + "\n");
        }

        String listaDeProdutoDaCompra = sbListaDeProdutosDaCompra.toString();

        return header + listaDeProdutoDaCompra;
    }
}
