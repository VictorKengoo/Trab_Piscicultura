package main.program.Interface.Telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CadastroController {
    Stage stage = new Stage();
    public void CadastroPeixe(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CadastroPeixe.fxml"));
        Scene scene = new Scene(root, 200, 400);
        stage.setScene(scene);
        stage.show();
    }
    public void CadastroTanque(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CadastroTanque.fxml"));
        Scene scene = new Scene(root, 200, 400);
        stage.setScene(scene);
        stage.show();
    }
}
