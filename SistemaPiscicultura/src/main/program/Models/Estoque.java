package Models;

import Application.EstoqueApp;
import Application.TanqueApp;
import Interface.EstouraException;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Estoque extends Entidade {
    //Declarações
    private String Marca;
    private Integer Quantidade;

    //getters
    public String getMarca() {
        return Marca;
    }

    public Integer getQuantidade() {
        return Quantidade;
    }

    //setters
    public void setMarca(String marca) {
        this.Marca = marca;
    }

    public void setQntEstoque(Integer quantidade) {
        this.Quantidade = quantidade;
    }

    public Estoque() {
    }

<<<<<<< HEAD
    public Estoque (String marca, Integer quantidade) throws Exception {
=======
    public Estoque(String marca, Integer quantidade) {
>>>>>>> f9c76c88962873aaeb646bef4cfdd1676d5bfbb4
        this.Marca = marca;
        this.Quantidade = quantidade;
        validar();
    }

    //Validações
    @Override
    public void validar() throws Exception {
<<<<<<< HEAD
        if(Quantidade <= 0) { throw new Exception("Quantidade deve ser maior que 0.\n"); }
=======
        EstouraException EE = new EstouraException();

        if (Marca.isBlank()) {
            EE.RaiseException("Marca em branco !");
        }
        if (Quantidade < 0) {
            EE.RaiseException("Quantidade do estoque inválida.");
        }

>>>>>>> f9c76c88962873aaeb646bef4cfdd1676d5bfbb4
    }

}
