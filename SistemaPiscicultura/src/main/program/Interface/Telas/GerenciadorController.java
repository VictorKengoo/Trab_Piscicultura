package Interface.Telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class GerenciadorController {
    @FXML
    private Button btnVoltar;

    Stage stage;

    public void Gerenciador(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Gerenciador.fxml"));
        Scene scene = new Scene(root, 300, 400);
        stage.setScene(scene);
        stage.show();
    }

    public void Voltar(ActionEvent event) throws Exception {
        stage = (Stage) btnVoltar.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root, 530, 300);
        stage.setScene(scene);
        stage.show();
    }
} 