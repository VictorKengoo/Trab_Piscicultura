package Interface.Telas;

import Application.PeixeApp;
import Application.TanqueApp;
import Interface.EstouraException;
import Interface.Utils;
import Models.Peixe;
import Models.Tanque;
import ViewModels.TanqueTableData;
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

import java.util.HashMap;
import java.util.Map;

public class CadastroTanqueController {

    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnAdicionarTanque;
    @FXML
    private Button btnDeletarTanque;
    @FXML
    private Button btnAtualizarTanque;
    @FXML
    private Button btnEditar;
    @FXML
    private TextField txtNomeTanque;
    @FXML
    private TextField txtVolumeTanque;
    @FXML
    private TextField txtIdTanque;
    @FXML
    private ComboBox<String> cmbPeixes;
    @FXML
    private TableView<TanqueTableData> tblTanque;
    @FXML
    private TableColumn<TanqueTableData, String> columnIdTanque;
    @FXML
    private TableColumn<TanqueTableData, String> columnNomeTanque;
    @FXML
    private TableColumn<TanqueTableData, String> columnVolumeTanque;
    @FXML
    private TableColumn<TanqueTableData, String> columnPeixeTanque;

    ObservableList<String> peixesList = FXCollections.observableArrayList();

    ObservableList<TanqueTableData> obsListTableData = FXCollections.observableArrayList();

    Map<String, Integer> mapNameTanqueToIdTanque = new HashMap<String, Integer>();

    Stage stage = new Stage();
    Utils utils = new Utils();
    TanqueApp tanqueApp = new TanqueApp();
    PeixeApp peixeApp = new PeixeApp();
    EstouraException ex = new EstouraException();

    public void initialize() {
        bloqueiaCampos();
        populaTabela();
        populaCombos();
    }

    private void populaTabela() {
        for (Tanque tanque : tanqueApp.getAll(Tanque.class)) {
            obsListTableData.add(new TanqueTableData(tanque));
        }
        columnIdTanque.setCellValueFactory(new PropertyValueFactory<TanqueTableData, String>("tanqueId"));
        columnNomeTanque.setCellValueFactory(new PropertyValueFactory<TanqueTableData, String>("nomeTanque"));
        columnVolumeTanque.setCellValueFactory(new PropertyValueFactory<TanqueTableData, String>("volumeTanque"));
        columnPeixeTanque.setCellValueFactory(new PropertyValueFactory<TanqueTableData, String>("peixeTanque"));
        tblTanque.setItems(obsListTableData);
    }

    private void populaCombos() {
        //comboPeixes
        for (Peixe peixe : peixeApp.getAll(Peixe.class)) {
            peixesList.add(peixe.getEspecie());
            mapNameTanqueToIdTanque.put(peixe.getEspecie(), peixe.id);
        }
        cmbPeixes.setItems(peixesList);
    }

    private void atualizaPagina() {
        atualizaTabela();
        limpaCampos();
    }

    private void atualizaTabela() {
        obsListTableData.removeAll(obsListTableData);
        populaTabela();
    }

    private void limpaCampos() {
        txtNomeTanque.clear();
        txtVolumeTanque.clear();
        cmbPeixes.setValue(null);
        txtIdTanque.clear();
    }

    private void bloqueiaCampos() {
        if (!tanqueApp.hasPermition()) {
            btnDeletarTanque.setDisable(true);
            btnAdicionarTanque.setDisable(true);
            btnAtualizarTanque.setDisable(true);
            btnEditar.setDisable(true);
            txtNomeTanque.setDisable(true);
            txtIdTanque.setDisable(true);
            txtVolumeTanque.setDisable(true);
            cmbPeixes.setDisable(true);
        }
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

            Peixe peixe = peixeApp.getById(mapNameTanqueToIdTanque.get(cmbPeixes.getValue()));
            Tanque tanque = new Tanque(peixe, txtNomeTanque.getText(), "OK", "OK", "OK", Double.parseDouble(txtVolumeTanque.getText()));
            tanqueApp.hasDuplicate(tanque);

            tanqueApp.Adicionar(tanque);
            ex.RaiseOK("Tanque cadastrado com sucesso!");

            atualizaPagina();

        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
        }
    }

    public void Deletar(ActionEvent event) throws Exception {
        try {
            TanqueTableData tanqueFromTable = tblTanque.getSelectionModel().getSelectedItem();
            if (tanqueFromTable == null)
                throw new Exception("Não foi selecionado nenhum registro na tabela.");

            Tanque tanque = tanqueApp.getById(Integer.parseInt(tanqueFromTable.getTanqueId()));
            if (ex.RaiseConfirmation("Tem certeza que deseja excluir o registro?")) {
                tanqueApp.delete(tanque);
                ex.RaiseOK("Tanque deletado com sucesso!");

                atualizaPagina();
            }
        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
        }
    }

    public void Editar(ActionEvent event) throws Exception {
        try {
            TanqueTableData tanqueFromTable = tblTanque.getSelectionModel().getSelectedItem();
            if (tanqueFromTable == null)
                throw new Exception("Não foi selecionado nenhum registro na tabela.");

            txtNomeTanque.setText(tanqueFromTable.getNomeTanque());
            txtVolumeTanque.setText(String.valueOf(tanqueFromTable.getVolumeTanque()));
            cmbPeixes.setValue(tanqueFromTable.getPeixeTanque());
            txtIdTanque.setText(String.valueOf(tanqueFromTable.getTanqueId()));

        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
        }
    }

    public void AtualizarTanque(ActionEvent event) throws Exception {
        try {
            if (txtIdTanque.getText().isBlank())
                throw new Exception("Nada selecionado. Selecione um item na tabela e aperte Editar.");

            validarCampos();

            Tanque old = tanqueApp.getById(Integer.parseInt(txtIdTanque.getText()));
            old.setNomeTanque(txtNomeTanque.getText());
            old.setVolume(Double.parseDouble(txtVolumeTanque.getText()));
            old.setPeixe(peixeApp.getById(mapNameTanqueToIdTanque.get(cmbPeixes.getValue())));
            tanqueApp.hasDuplicate(old);

            tanqueApp.update(old);
            ex.RaiseOK("Atualizado com sucesso!");

            atualizaPagina();

        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
        }
    }

    public void validarCampos() throws Exception {
        Boolean hasInvalidField = false;
        String erros = "";
        if (txtNomeTanque.getText().isBlank()) {
            erros += "Campo nome não pode estar em branco.\n";
            hasInvalidField = true;
        }

        if (txtVolumeTanque.getText().isBlank()) {
            erros += "Campo volume não pode estar em branco.\n";
            hasInvalidField = true;
        } else if (!Utils.isNumeric(txtVolumeTanque.getText())) {
            erros += "Campo volume deve ser numérico.\n";
            hasInvalidField = true;
        }

        if (cmbPeixes.getValue() == null) {
            erros += "Caixa de seleção de peixe não pode estar em branco.\n";
            hasInvalidField = true;
        }

        if (hasInvalidField) {
            throw new Exception(erros);
        }
    }

}
