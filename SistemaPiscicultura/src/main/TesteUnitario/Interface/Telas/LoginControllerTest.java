package Interface.Telas;

import Models.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LoginControllerTest {
    @FXML
    private Label lblStatus;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnLogin;

    private static final List<Usuario> massa = new ArrayList<Usuario>();

    @Before
    public void setUp(){

    }

    @Test
    public void login() throws Exception {
        Stage stage = new Stage();
        LoginController loginController = new LoginController();
        txtPassword.setText("admin");
        txtUsername.setText("admin");
        loginController.Login(new ActionEvent());

        Assert.assertEquals("Status: Success", lblStatus.getText());

    }
}