package Interface.Telas;

import Application.UsuarioApp;
import Interface.EstouraException;
import Models.Enums.TipoUsuario;
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
import jdk.jshell.spi.ExecutionControl;

public class UsuarioController {
    ObservableList<UsuarioTableData> obsListUserData = FXCollections.observableArrayList();
    Stage stage = new Stage();

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
    private ComboBox<TipoUsuario> cmbUserType;
    @FXML
    private TableView<UsuarioTableData> tblUsuario;
    @FXML
    private TableColumn<UsuarioTableData, String> columnIdUsuario;
    @FXML
    private TableColumn<UsuarioTableData, String> columnUsuario;
    @FXML
    private TableColumn<UsuarioTableData, String> columnTipo;

    EstouraException ex = new EstouraException();
    UsuarioApp usuarioApp = new UsuarioApp();

    public void initialize() {
        populaTabela();
        populaCombos();
    }

    private void bloqueiaCampos() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Falta implementar Usuario - bloqueiaCampos");
    }

    private void populaTabela() {
        UsuarioApp usuarioApp = new UsuarioApp();
        for (Usuario user : usuarioApp.getAll(Usuario.class)) {
            obsListUserData.add(new UsuarioTableData(user));
        }
        columnIdUsuario.setCellValueFactory(new PropertyValueFactory<UsuarioTableData, String>("usuarioId"));
        columnUsuario.setCellValueFactory(new PropertyValueFactory<UsuarioTableData, String>("username"));
        columnTipo.setCellValueFactory(new PropertyValueFactory<UsuarioTableData, String>("tipo"));
        tblUsuario.setItems(obsListUserData);
    }

    private void populaCombos() {
        cmbUserType.getItems().addAll(TipoUsuario.values());
    }

    private void atualizaPagina() {
        atualizaTabela();
        limpaCampos();
    }

    private void atualizaTabela() {
        obsListUserData.removeAll(obsListUserData);
        populaTabela();
    }

    private void limpaCampos() {
        txtUsuario.clear();
        txtSenha.clear();
        cmbUserType.setValue(null);
        txtIdUsuario.clear();
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

    public void Cadastrar(ActionEvent event) throws Exception {
        try {

            validarCampos();

            Usuario newUser = new Usuario(txtUsuario.getText(), txtSenha.getText(), cmbUserType.getValue().toString());
            usuarioApp.hasDuplicate(newUser);

            usuarioApp.Adicionar(newUser);
            ex.RaiseOK("Usuário cadastrado com sucesso!");

            atualizaPagina();

        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
        }
    }

    public void Excluir(ActionEvent event) throws Exception {

        Usuario selectedUser;
        try {

            UsuarioTableData selectedFromTable = tblUsuario.getSelectionModel().getSelectedItem();
            if (selectedFromTable == null)
                throw new Exception("Selecione um registro na tabela.");

            int selectedId = Integer.parseInt(selectedFromTable.getUsuarioId());
            selectedUser = usuarioApp.getById(selectedId);

            if (ex.RaiseConfirmation("Tem certeza que deseja excluir o registro?")) {
                usuarioApp.delete(selectedUser);
                ex.RaiseOK("Usuário deletado com sucesso!");

                atualizaPagina();
            }
        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
        }
    }

    public void Editar(ActionEvent event) throws Exception {
        try {
            UsuarioTableData selectedFromTable = tblUsuario.getSelectionModel().getSelectedItem();
            if (selectedFromTable == null)
                ex.RaiseException("Não foi selecionado nenhum item na tabela.");

            txtUsuario.setText(selectedFromTable.getUsername());
            cmbUserType.setValue(TipoUsuario.valueOf(selectedFromTable.getTipo()));
            txtIdUsuario.setText(selectedFromTable.getUsuarioId());

        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
        }
    }

    public void Atualizar(ActionEvent event) throws Exception {
        try {
            if (txtIdUsuario.getText().isBlank())
                throw new Exception("Nada selecionado. Selecione um item na tabela e aperte Editar.");

            Usuario oldUser = usuarioApp.getById(Integer.parseInt(txtIdUsuario.getText()));
            validarCampos();

            oldUser.setUsuario(txtUsuario.getText());
            oldUser.setSenha(txtSenha.getText());
            oldUser.setTipoUser(cmbUserType.getValue().toString());
            usuarioApp.hasDuplicate(oldUser);

            usuarioApp.update(oldUser);
            ex.RaiseOK("Usuário atualizado com sucesso!");

            atualizaPagina();
        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
        }
    }

    private void validarCampos() throws Exception {
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
