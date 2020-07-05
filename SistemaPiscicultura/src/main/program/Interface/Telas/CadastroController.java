package Interface.Telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CadastroController {
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnCadastrarTanque;
    @FXML
    private Button btnCadastrarPeixe;

    Stage stage = new Stage();

    public void CadastroPeixe(ActionEvent event) throws Exception {
        stage = (Stage) btnCadastrarPeixe.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("CadastroPeixe.fxml"));
        Scene scene = new Scene(root, 400, 600);
        stage.setTitle("Cadastro de Peixe");
        stage.setScene(scene);
        stage.show();
    }

    public void CadastroTanque(ActionEvent event) throws Exception {
        stage = (Stage) btnCadastrarTanque.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("CadastroTanque.fxml"));
        Scene scene = new Scene(root, 450, 300);
        stage.setTitle("Cadastro de Tanque");
        stage.setScene(scene);
        stage.show();
    }

    public void Voltar(ActionEvent event) throws Exception {
        stage = (Stage) btnVoltar.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root, 300, 475);
        stage.setScene(scene);
        stage.show();
    }
}
