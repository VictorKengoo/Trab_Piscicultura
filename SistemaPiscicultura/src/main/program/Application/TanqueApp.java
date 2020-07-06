package Application;

import Interface.EstouraException;
import Models.Enums.TipoUsuario;
import Models.Peixe;
import Models.Tanque;
import Repository.TanqueRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public boolean hasPermition(){
       return Session.getInstance().getUsuarioLogado().getTipoUser().equals(TipoUsuario.ADMINISTRADOR.toString());
    }

    public void hasDuplicate(Tanque newTanque) throws Exception {
        Tanque existente = _tanqueRepository.getByName(newTanque);
        if (existente != null) {
            if ((newTanque.id != existente.id) && (newTanque.getNomeTanque().toLowerCase().trim().equals(existente.getNomeTanque().toLowerCase().trim()))) {
                throw new Exception("Já existe um registro com este nome.");
            }
        }
    }
    public Tanque getById(int id) throws Exception {
        return super.getById("Tanque", id);
    }
}
