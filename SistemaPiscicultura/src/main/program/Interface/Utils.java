package Interface;

import Application.EstoqueApp;
import Application.PeixeApp;
import Application.TanqueApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Models.Estoque;
import Models.Peixe;
import Models.Tanque;

import java.util.List;
import java.util.Map;

public class Utils {

    public ObservableList<Estoque> getEstoque() {
        ObservableList<Estoque> estoqueList = FXCollections.observableArrayList();

        EstoqueApp estoqueApp = new EstoqueApp();
        var lista = estoqueApp.getAll(Estoque.class);

        for (Estoque est : lista) {
            estoqueList.add(new Estoque(est.getMarca(), est.getQuantidade()));
        }

        return estoqueList;
    }

    public ObservableList<Tanque> getTanque() {
        ObservableList<Tanque> tanqueList = FXCollections.observableArrayList();

        PeixeApp peixeApp = new PeixeApp();

        TanqueApp tanqueApp = new TanqueApp();
        var lista = tanqueApp.getAll(Tanque.class);
        Peixe peixe = new Peixe();

        for(Tanque tanque : lista) {
            for(Peixe p : peixeApp.getAll(Peixe.class)) {
                if (p.id == tanque.getPeixe().id);
                    peixe = p;
            }
            tanqueList.add(new Tanque(peixe.getEspecie(), tanque.getStatus(), tanque.getVolume()));
        }

        return tanqueList;
    }

}
