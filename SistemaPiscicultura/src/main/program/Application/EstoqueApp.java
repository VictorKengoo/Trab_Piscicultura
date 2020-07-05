package Application;

import Interface.EstouraException;
import Models.Estoque;
import Repository.EstoqueRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class EstoqueApp extends BaseApp<Estoque> {

    private EstoqueRepository _estoqueRepository;

    public EstoqueApp() {
        _estoqueRepository = new EstoqueRepository();
    }

    public boolean hasDuplicate(String marca) {
        EstouraException EE = new EstouraException();
        EstoqueApp estoqueApp = new EstoqueApp();
        ArrayList<String> listEstoqueExistente = new ArrayList<String>();
        for (Estoque estoque : estoqueApp.getAll(Estoque.class)) {
            listEstoqueExistente.add(String.valueOf(estoque.getMarca()));
        }

        for (String produtoExistente : listEstoqueExistente) {
            if (marca.toLowerCase().trim().equals(produtoExistente.toLowerCase().trim())) {
                EE.RaiseException("Já existe um produto registrado com este nome.");
                return true;
            }
        }

        return false;
    }

}
