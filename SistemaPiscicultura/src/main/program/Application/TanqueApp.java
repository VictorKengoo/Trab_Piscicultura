package Application;

import Interface.EstouraException;
import Models.Peixe;
import Models.Tanque;
import Repository.TanqueRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class TanqueApp extends BaseApp<Tanque> {

    private TanqueRepository _tanqueRepository;

    public static String errorMsg = "";

    public static Boolean showAtentionPopUp = false;

    public TanqueApp() { _tanqueRepository = new TanqueRepository(); }

    public ObservableList<Tanque> getTanque() throws Exception {
        EstouraException ex = new EstouraException();
        ObservableList<Tanque> tanqueList = FXCollections.observableArrayList();

        PeixeApp peixeApp = new PeixeApp();

        TanqueApp tanqueApp = new TanqueApp();
        var lista = tanqueApp.getAll(Tanque.class);
        Peixe peixe;
        errorMsg = "Tanque(s) em alerta:\n";
        for(Tanque tanque : lista) {
            for(Peixe p : peixeApp.getAll(Peixe.class)) {
                if (tanque.getPeixe() != null) {
                    if (p.id == tanque.getPeixe().id) {
                        String StatusGeral = "";
                        peixe = p;
                        if (tanque.getStatusPh().equals("OK") && tanque.getStatusTemp().equals("OK")) {
                            StatusGeral = "OK";
                        } else {
                            showAtentionPopUp = true;
                            errorMsg += tanque.getNomeTanque() + (tanque.getStatusPh().equals("OK") ? " - Temperatura fora das necessidades do peixe.\n" : tanque.getStatusTemp().equals("OK") ? " - pH fora das necessidades do peixe.\n" : " - Temperatura e pH fora das necessidades do peixe.\n");
                            StatusGeral = "ALERTA";
                        }
                        tanqueList.add(new Tanque(peixe, tanque.getNomeTanque(), tanque.getStatusPh(), tanque.getStatusTemp(), StatusGeral, tanque.getVolume()));
                    }
                }
            }
        }
        if (showAtentionPopUp) {
            ex.RaiseOK(errorMsg);
        }

        return tanqueList;
    }

    public boolean hasDuplicate(String nomeTanque) {
        EstouraException EE = new EstouraException();
        TanqueApp tanqueApp = new TanqueApp();
        ArrayList<String> listTanqueExistente = new ArrayList<String>();
        for (Tanque tank : tanqueApp.getAll(Tanque.class)) {
            listTanqueExistente.add(String.valueOf(tank.getNomeTanque()));
        }

        for (String tanqueExistente : listTanqueExistente) {
            if (nomeTanque.toLowerCase().trim().equals(tanqueExistente.toLowerCase().trim())) {
                EE.RaiseException("Já existe um tanque registrado com este nome.");
                return true;
            }
        }
        return false;
    }

}
