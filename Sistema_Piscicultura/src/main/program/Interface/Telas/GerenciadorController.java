package main.program.Interface.Telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GerenciadorController {
    @FXML
    private Stage stage;

    public void Gerenciador(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Gerenciador.fxml"));
        Scene scene = new Scene(root, 300, 400);
        stage.setScene(scene);
        stage.show();
    }
}