package main.program.Interface.Telas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import main.program.Models.Peixe;

public class CadastroTanqueController {

    @FXML
    private Button btnVoltar;
    @FXML
    private ComboBox<String> cmbPeixes;

    ObservableList<String> peixesList = FXCollections.observableArrayList("peixe1", "peixe2", "peixe3");

    Stage stage = new Stage();

    public void ComboBoxValues (ActionEvent envet) {
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

}
