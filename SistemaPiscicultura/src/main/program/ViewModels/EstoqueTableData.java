package ViewModels;

import Models.Estoque;
import javafx.beans.property.SimpleStringProperty;

public class EstoqueTableData {

    public SimpleStringProperty estoqueId;
    public SimpleStringProperty produto;
    public SimpleStringProperty quantidade;

    public EstoqueTableData(Estoque estoque) {
        this.estoqueId  = new SimpleStringProperty(String.valueOf(estoque.id));
        this.produto    = new SimpleStringProperty(String.valueOf(estoque.getMarca()));
        this.quantidade = new SimpleStringProperty(String.valueOf(estoque.getQuantidade()));
    }

    public String getEstoqueId() {
        return estoqueId.get();
    }

    public void setEstoqueId(String estoqueId) {
        this.estoqueId.set(estoqueId);
    }

    public String getProduto() {
        return produto.get();
    }

    public void setProduto(String produto) {
        this.produto.set(produto);
    }

    public String getQuantidade() {
        return quantidade.get();
    }

    public void setQuantidade(String quantidade) {
        this.quantidade.set(quantidade);
    }

}
