package Application;

import Interface.EstouraException;
import Models.Peixe;
import Repository.PeixeRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PeixeApp extends BaseApp<Peixe> {

    private final PeixeRepository _peixeRepository;

<<<<<<< HEAD
    public PeixeApp() { _peixeRepository = new PeixeRepository();}

    public boolean hasDuplicate(String especie) {
        EstouraException EE = new EstouraException();
        PeixeApp peixeApp = new PeixeApp();
        ArrayList<String> listEspecieExistente = new ArrayList<String>();
        for (Peixe peixe : peixeApp.getAll(Peixe.class)) {
            listEspecieExistente.add(String.valueOf(peixe.getEspecie()));
        }

        for (String especieExistente : listEspecieExistente) {
            if (especie.toLowerCase().trim().equals(especieExistente.toLowerCase().trim())) {
                EE.RaiseException("Já existe um peixe registrado com esta espécie.");
                return true;
            }
        }
        return false;
=======
    public PeixeApp() {
        _peixeRepository = new PeixeRepository();
>>>>>>> f9c76c88962873aaeb646bef4cfdd1676d5bfbb4
    }
}
