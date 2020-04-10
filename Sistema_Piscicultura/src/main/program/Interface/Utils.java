package main.program.Interface;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.program.Models.Estoque;

public class Utils {

    public ObservableList<Estoque> getEstoque() {
        ObservableList<Estoque> estoqueList = FXCollections.observableArrayList();
        estoqueList.add(new Estoque("Marca 1", 20));
        estoqueList.add(new Estoque("Marca 2", 89));
        estoqueList.add(new Estoque("Marca 3", 56));
        estoqueList.add(new Estoque("Marca 4", 38));
        estoqueList.add(new Estoque("Marca 5", 34));
        estoqueList.add(new Estoque("Marca 6", 25));
        estoqueList.add(new Estoque("Marca 7", 27));
        estoqueList.add(new Estoque("Marca 8", 44));
        estoqueList.add(new Estoque("Marca 9", 56));

        return estoqueList;
    }
}
