package Interface.Telas;

import Application.UsuarioApp;
import Interface.EstouraException;
import Models.Usuario;
import ViewModels.UsuarioTableData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;

public class UsuarioController {
    ObservableList<String> userTypes = FXCollections.observableArrayList("ADMINISTRADOR", "USUARIO");
    ObservableList<UsuarioTableData> obsListUserData = FXCollections.observableArrayList();
    Stage stage = new Stage();
    String currentUsuario = "";
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnAdicionar;
    @FXML
    private Button btnDeletar;
    @FXML
    private Button btnAtualizar;
    @FXML
    private TextField txtIdUsuario;
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtSenha;
    @FXML
    private ComboBox<String> cmbUserType;
    @FXML
    private TableView<UsuarioTableData> tblUsuario;
    @FXML
    private TableColumn<UsuarioTableData, String> columnIdUsuario;
    @FXML
    private TableColumn<UsuarioTableData, String> columnUsuario;
    @FXML
    private TableColumn<UsuarioTableData, String> columnTipo;

    public void initialize() {

        cmbUserType.setItems(userTypes);

        UsuarioApp usuarioApp = new UsuarioApp();

        for (Usuario user : usuarioApp.getAll(Usuario.class)) {
            obsListUserData.add(new UsuarioTableData(user));
        }

        columnIdUsuario.setCellValueFactory(new PropertyValueFactory<UsuarioTableData, String>("usuarioId"));
        columnUsuario.setCellValueFactory(new PropertyValueFactory<UsuarioTableData, String>("username"));
        columnTipo.setCellValueFactory(new PropertyValueFactory<UsuarioTableData, String>("tipo"));

        tblUsuario.setItems(obsListUserData);
    }

    public void Voltar(ActionEvent event) throws Exception {
        stage = (Stage) btnVoltar.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }

    public void CadastrarUsuario(ActionEvent event) throws Exception {
        EstouraException ex = new EstouraException();
        UsuarioApp usuarioApp = new UsuarioApp();
        Usuario newUser;
        try {
            ValidarCamposUsuario();
            newUser = new Usuario(txtUsuario.getText(), txtSenha.getText(), cmbUserType.getValue());
            usuarioApp.hasDuplicate(newUser);
            usuarioApp.Adicionar(newUser);
            ex.RaiseOK("Usuário cadastrado com sucesso!");
            stage = (Stage) btnAdicionar.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("Usuario.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
        }

    }

    public void DeletarUsuario(ActionEvent event) throws Exception {
        EstouraException ex = new EstouraException();
        Boolean hasError = false;
        Boolean confirmed = false;
        UsuarioApp usuarioApp = new UsuarioApp();
        Usuario usuario = new Usuario();
        UsuarioTableData userFromTable;
        if (tblUsuario.getSelectionModel().getSelectedItem() != null) {
            userFromTable = tblUsuario.getSelectionModel().getSelectedItem();
            List<Usuario> listUsuario = usuarioApp.getAll(Usuario.class);
            for (Usuario us : listUsuario) {
                if (us.id == Integer.parseInt(userFromTable.getUsuarioId())) {
                    usuario = us;
                }
            }
            confirmed = ex.RaiseConfirmation("Tem certeza que deseja excluir o registro?");
        } else {
            ex.RaiseException("Não foi selecionado nenhum registro na tabela.");
            hasError = true;
        }

        if (!hasError && confirmed) {
            try {
                usuarioApp.delete(usuario);
                ex.RaiseOK("Usuário deletado com sucesso!");
                stage = (Stage) btnDeletar.getScene().getWindow();
                stage.close();
                Parent root = FXMLLoader.load(getClass().getResource("Usuario.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                ex.RaiseException(e.getMessage());
            }
        }
    }

    public void EditarUsuario(ActionEvent event) throws Exception {
        EstouraException ex = new EstouraException();
        Boolean hasError = false;
        UsuarioApp usuarioApp = new UsuarioApp();
        Usuario usuario = new Usuario();
        UsuarioTableData userFromTable;
        if (tblUsuario.getSelectionModel().getSelectedItem() != null) {
            userFromTable = tblUsuario.getSelectionModel().getSelectedItem();
            List<Usuario> listUsuario = usuarioApp.getAll(Usuario.class);
            for (Usuario e : listUsuario) {
                if (e.id == Integer.parseInt(userFromTable.getUsuarioId())) {
                    usuario = e;
                }
            }
        } else {
            ex.RaiseException("Não foi selecionado nenhum item na tabela.");
            hasError = true;
        }

        if (!hasError) {
            try {
                currentUsuario = usuario.getUsuario();
                txtUsuario.setText(usuario.getUsuario());
                txtSenha.setText(usuario.getSenha());
                cmbUserType.setValue(usuario.getTipoUser());
                txtIdUsuario.setText(String.valueOf(usuario.id));
            } catch (Exception e) {
                ex.RaiseException(e.getMessage());
            }
        }
    }

    public void AtualizarUsuario(ActionEvent event) throws Exception {
        EstouraException ex = new EstouraException();
        UsuarioApp usuarioApp = new UsuarioApp();
        Usuario user;
        UsuarioTableData userFromTable;

        try {
            if (txtIdUsuario.getText().isBlank())
                throw new Exception("Nada selecionado. Selecione um item na tabela e aperte Editar.");

            Usuario oldUser = usuarioApp.getById(Integer.parseInt(txtIdUsuario.getText()));
            ValidarCamposUsuario();

            oldUser.setUsuario(txtUsuario.getText());
            oldUser.setSenha(txtSenha.getText());
            oldUser.setTipoUser(cmbUserType.getValue());
            usuarioApp.hasDuplicate(oldUser);

            usuarioApp.update(oldUser);
            ex.RaiseOK("Usuário atualizado com sucesso!");
            stage = (Stage) btnAtualizar.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("Usuario.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
        }

    }

    public void ValidarCamposUsuario() throws Exception {
        EstouraException ex = new EstouraException();
        String erros = "";
        Boolean hasInvalidField = false;
        if (txtUsuario.getText().isBlank()) {
            erros += "Usuario em branco.\n";
            hasInvalidField = true;
        }

        if (txtSenha.getText().isBlank()) {
            erros += "Senha em branco.\n";
            hasInvalidField = true;
        }

        if (cmbUserType.getValue() == null) {
            erros += "Caixa de seleção de tipo de usuário não pode estar em branco.\n";
            hasInvalidField = true;
        }

        if (hasInvalidField) {
            throw new Exception(erros);
        }
    }

}
