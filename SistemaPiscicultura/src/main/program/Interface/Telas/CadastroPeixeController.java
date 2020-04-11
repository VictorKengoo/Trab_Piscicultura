package Interface.Telas;

import Application.PeixeApp;
import Interface.EstouraException;
import Models.Peixe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroPeixeController {
    @FXML
    private Button btnVoltar;
    @FXML
    private TextField txtEspecie;
    @FXML
    private TextField txtTempMax;
    @FXML
    private TextField txtTempMin;
    @FXML
    private TextField txtPhMax;
    @FXML
    private TextField txtPhMin;

    Stage stage = new Stage();

    public void Voltar(ActionEvent event) throws Exception {
        stage = (Stage) btnVoltar.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Cadastro.fxml"));
        Scene scene = new Scene(root, 200, 300);
        stage.setScene(scene);
        stage.show();
    }

    public void CadastrarPeixe(ActionEvent event) throws Exception {
        EstouraException ex = new EstouraException();
        PeixeApp peixeApp = new PeixeApp();

        Peixe peixe = new Peixe(txtEspecie.getText(), Double.parseDouble(txtTempMax.getText()), Double.parseDouble(txtTempMin.getText()), Double.parseDouble(txtPhMax.getText()), Double.parseDouble(txtPhMin.getText()));

        try {
            peixeApp.Adicionar(peixe);
            ex.RaiseOK("Peixe cadastrado com sucesso!");
            stage = (Stage) btnVoltar.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("CadastroPeixe.fxml"));
            Scene scene = new Scene(root, 400, 600);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
        }
    }


}
