package Interface.Telas;

<<<<<<< HEAD
import Application.UsuarioApp;
import javafx.scene.control.Button;
=======
>>>>>>> f9c76c88962873aaeb646bef4cfdd1676d5bfbb4
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
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
<<<<<<< HEAD
import Models.Usuario;
=======
>>>>>>> f9c76c88962873aaeb646bef4cfdd1676d5bfbb4

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

    public static String currentUser;

    public void Login(ActionEvent event) throws Exception {
        LoginApp logApp = new LoginApp();
        UsuarioApp usuarioApp = new UsuarioApp();
        Usuario user = new Usuario();
        user.setUsuario(txtUsername.getText().trim());
        user.setSenha(txtPassword.getText());

<<<<<<< HEAD
        if (logApp.doLogin(user)!=null) {
            for (Usuario us : usuarioApp.getAll(Usuario.class)) {
                if (us.getUsuario().equals(txtUsername.getText().trim())) {
                    currentUser = us.getTipoUser();
                }
            }
=======
        if (logApp.doLogin(user) != null) {
>>>>>>> f9c76c88962873aaeb646bef4cfdd1676d5bfbb4
            lblStatus.setText("Status: Success");
            stage = (Stage) btnLogin.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Menu");
            stage.setScene(scene);
            stage.show();
        } else {
            lblStatus.setText("Login/Senha incorretos!");
        }
    }

    public void checkKeyReleased() throws Exception {

        txtUsername.setOnKeyReleased(event -> {
            System.out.println("entrou");
            if (event.getCode() == KeyCode.ENTER){
                try {
                    System.out.println("Enter pressed.");
                    Login(null);
                } catch (Exception e) {
                    System.out.println("Failed");
                }
            }
        });
    }
}

