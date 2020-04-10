package main.program.Interface.Telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label lblStatus;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;

    public void Login(ActionEvent event) throws Exception {
        if (txtUsername.getText().equals("user") && txtPassword.getText().equals("1234")) {
            lblStatus.setText("Status: Success");
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Scene scene = new Scene(root, 200, 400);
            stage.setScene(scene);
            stage.show();
        } else {
            lblStatus.setText("Status: Failed");
        }

    }
}

