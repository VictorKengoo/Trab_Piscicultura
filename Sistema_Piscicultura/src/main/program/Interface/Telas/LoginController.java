package main.program.Interface.Telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private Label lblStatus;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;

    public void Login(ActionEvent event) {
        if (txtUsername.getText().equals("user") && txtPassword.getText().equals("1234")) {
            lblStatus.setText("Status: Success");
        } else {
            lblStatus.setText("Status: Failed");
        }

    }
}

