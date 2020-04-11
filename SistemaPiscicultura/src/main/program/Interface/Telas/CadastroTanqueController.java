package Interface.Telas;

import Application.PeixeApp;
import Application.TanqueApp;
import Interface.EstouraException;
import Models.Peixe;
import Models.Tanque;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroTanqueController {

    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnAdicionarTanque;
    @FXML
    private TextField txtVolumeTanque;
    @FXML
    private ComboBox<String> cmbPeixes;

    ObservableList<String> peixesList = FXCollections.observableArrayList();

    Stage stage = new Stage();

    public void initialize() {
        PeixeApp peixeApp = new PeixeApp();

        for (Peixe peixe : peixeApp.getAll(Peixe.class)) {
            peixesList.add(peixe.id + " - " + peixe.getEspecie());
        }

        cmbPeixes.setItems(peixesList);
    }

    public void Voltar(ActionEvent event) throws Exception {
        stage = (Stage) btnVoltar.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Cadastro.fxml"));
        Scene scene = new Scene(root, 200, 300);
        stage.setScene(scene);
        stage.show();
    }

    public void CadastrarTanque(ActionEvent event) throws Exception {
        EstouraException ex = new EstouraException();
        TanqueApp tanqueApp = new TanqueApp();

        PeixeApp peixeApp = new PeixeApp();
        Peixe peixe = new Peixe();
        int cod = Integer.parseInt(cmbPeixes.getValue().split(" - ")[0]);
        for (Peixe p : peixeApp.getAll(Peixe.class)) {
            if (p.id == cod) {
                peixe = p;
            }
        }
        Tanque tanque = new Tanque(peixe, "OK",  Double.parseDouble(txtVolumeTanque.getText()));

        try {
            tanqueApp.Adicionar(tanque);
            ex.RaiseOK("Tanque cadastrado com sucesso!");
            stage = (Stage) btnAdicionarTanque.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("CadastroTanque.fxml"));
            Scene scene = new Scene(root, 450, 300);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
        }
    }

}
