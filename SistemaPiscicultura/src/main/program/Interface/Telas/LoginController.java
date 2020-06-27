package Interface.Telas;

import Application.LoginApp;
import Models.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private Label lblStatus;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnLogin;

    Stage stage = new Stage();

    public void Login(ActionEvent event) throws Exception {
        LoginApp logApp = new LoginApp();
        Usuario user = new Usuario();
        user.setUsuario(txtUsername.getText());
        user.setSenha(txtPassword.getText());

        if (logApp.doLogin(user) != null) {
            lblStatus.setText("Status: Success");
            stage = (Stage) btnLogin.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Scene scene = new Scene(root, 300, 475);
            stage.setTitle("Menu");
            stage.setScene(scene);
            stage.show();
        } else {
            lblStatus.setText("Login/Senha incorretos!");
        }
    }
}

