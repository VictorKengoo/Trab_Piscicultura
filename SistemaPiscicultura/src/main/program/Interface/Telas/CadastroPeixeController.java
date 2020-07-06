package Interface.Telas;

import Application.PeixeApp;
import Interface.EstouraException;
import Interface.Utils;
import Models.Peixe;
import ViewModels.PeixeTableData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CadastroPeixeController {
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnAdicionar;
    @FXML
    private Button btnDeletar;
    @FXML
    private Button btnAtualizar;
    @FXML
    private Button btnEditar;
    @FXML
    private TextField txtEspecie;
    @FXML
    private TextField txtTempMax;
    @FXML
    private TextField txtTempMin;
    @FXML
    private TextField txtPhMax;
    @FXML
    private TextField txtPhMin;
    @FXML
    private TextField txtIdPeixe;
    @FXML
    private TableView<PeixeTableData> tblPeixe;
    @FXML
    private TableColumn<PeixeTableData, String> peixeIdColumn;
    @FXML
    private TableColumn<PeixeTableData, String> especieColumn;
    @FXML
    private TableColumn<PeixeTableData, String> tempMaxColumn;
    @FXML
    private TableColumn<PeixeTableData, String> tempMinColumn;
    @FXML
    private TableColumn<PeixeTableData, String> pHMaxColumn;
    @FXML
    private TableColumn<PeixeTableData, String> pHMinColumn;

    ObservableList<PeixeTableData> obsListTableData = FXCollections.observableArrayList();

    Stage stage = new Stage();
    Utils utils = new Utils();

    PeixeApp peixeApp = new PeixeApp();

    public void initialize() {
        bloqueiaCampos();
        populaTabela();
    }


    private void populaTabela() {
        for (Peixe peixe : peixeApp.getAll(Peixe.class)) {
            obsListTableData.add(new PeixeTableData(peixe));
        }
        peixeIdColumn.setCellValueFactory(new PropertyValueFactory<PeixeTableData, String>("peixeId"));
        especieColumn.setCellValueFactory(new PropertyValueFactory<PeixeTableData, String>("especie"));
        tempMaxColumn.setCellValueFactory(new PropertyValueFactory<PeixeTableData, String>("tempMax"));
        tempMinColumn.setCellValueFactory(new PropertyValueFactory<PeixeTableData, String>("tempMin"));
        pHMaxColumn.setCellValueFactory(new PropertyValueFactory<PeixeTableData, String>("pHMax"));
        pHMinColumn.setCellValueFactory(new PropertyValueFactory<PeixeTableData, String>("pHMin"));
        tblPeixe.setItems(obsListTableData);
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
        txtEspecie.clear();
        txtPhMin.clear();
        txtPhMax.clear();
        txtTempMin.clear();
        txtTempMax.clear();
    }

    private void bloqueiaCampos() {
        if (!peixeApp.hasPermition()) {
            btnAdicionar.setDisable(true);
            btnEditar.setDisable(true);
            btnDeletar.setDisable(true);
            btnAtualizar.setDisable(true);
            txtEspecie.setDisable(true);
            txtPhMin.setDisable(true);
            txtPhMax.setDisable(true);
            txtTempMin.setDisable(true);
            txtTempMax.setDisable(true);
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

    public void Cadastrar(ActionEvent event) {
        EstouraException ex = new EstouraException();
        try {
            validarCampos();
            Peixe peixe = new Peixe(txtEspecie.getText(), Double.parseDouble(txtTempMax.getText()), Double.parseDouble(txtTempMin.getText()), Double.parseDouble(txtPhMax.getText()), Double.parseDouble(txtPhMin.getText()));
            peixeApp.hasDuplicate(peixe);
            peixeApp.Adicionar(peixe);
            ex.RaiseOK("Tanque cadastrado com sucesso!");
            atualizaPagina();
        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
        }
    }

    public void Deletar(ActionEvent event) throws Exception {
        EstouraException ex = new EstouraException();
        try {

            PeixeTableData peixeFromTable = tblPeixe.getSelectionModel().getSelectedItem();

            if (peixeFromTable == null)
                throw new Exception("Não foi selecionado nenhum registro na tabela.");
            Peixe peixe = peixeApp.getById(Integer.parseInt(peixeFromTable.getPeixeId()));
            peixeApp.delete(peixe);
            ex.RaiseOK("Item deletado com sucesso!");
            stage = (Stage) btnDeletar.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("CadastroPeixe.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
        }

    }

    //String currentEspecie = "";

    public void Editar(ActionEvent event) {
        EstouraException ex = new EstouraException();
        try {

            PeixeTableData peixeFromTable = tblPeixe.getSelectionModel().getSelectedItem();

            if (peixeFromTable == null)
                throw new Exception("Não foi selecionado nenhum registro na tabela.");


            //currentEspecie = peixeFromTable.getEspecie();
            txtEspecie.setText(peixeFromTable.getEspecie());
            txtTempMax.setText(String.valueOf(peixeFromTable.getTempMax()));
            txtTempMin.setText(String.valueOf(peixeFromTable.getTempMin()));
            txtPhMax.setText(String.valueOf(peixeFromTable.getPHMax()));
            txtPhMin.setText(String.valueOf(peixeFromTable.getPHMin()));
            txtIdPeixe.setText(String.valueOf(peixeFromTable.getPeixeId()));
        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
        }
    }


    public void Atualizar(ActionEvent event) throws Exception {

            EstouraException ex = new EstouraException();
            try {
                if (txtIdPeixe.getText().isBlank())
                    throw new Exception("Nada selecionado. Selecione um item na tabela e aperte Editar.");

                Peixe oldEntity = peixeApp.getById(Integer.parseInt(txtIdPeixe.getText()));
                validarCampos();

                oldEntity.setEspecie(txtEspecie.getText());
                oldEntity.setMaxTemp(Double.parseDouble(txtTempMax.getText()));
                oldEntity.setMinTemp(Double.parseDouble(txtTempMin.getText()));
                oldEntity.setMaxpH(Double.parseDouble(txtPhMax.getText()));
                oldEntity.setMinpH(Double.parseDouble(txtPhMin.getText()));
                peixeApp.hasDuplicate(oldEntity);

                peixeApp.update(oldEntity);
                ex.RaiseOK("Peixe atualizado com sucesso!");

                atualizaPagina();


        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
        }

    }

    public void validarCampos() throws Exception {
        EstouraException ex = new EstouraException();
        Boolean hasInvalidField = false;
        String erros = "";
        if (txtEspecie.getText().isBlank()) {
            erros += "Campo espécie não pode estar em branco.\n";
            hasInvalidField = true;
        }

        if (txtTempMax.getText().isBlank()) {
            erros += "Campo temperatura máxima não pode estar em branco.\n";
            hasInvalidField = true;
        } else if (!utils.isNumeric(txtTempMax.getText())) {
            erros += "Campo temperatura máxima deve ser numérico.\n";
            hasInvalidField = true;
        }

        if (txtTempMin.getText().isBlank()) {
            erros += "Campo temperatura mínima não pode estar em branco.\n";
            hasInvalidField = true;
        } else if (!utils.isNumeric(txtTempMin.getText())) {
            erros += "Campo temperatura mínima deve ser numérico.\n";
            hasInvalidField = true;
        }

        if (txtPhMax.getText().isBlank()) {
            erros += "Campo pH máximo não pode estar em branco.\n";
            hasInvalidField = true;
        } else if (!utils.isNumeric(txtPhMax.getText())) {
            erros += "Campo pH máximo deve ser numérico.\n";
            hasInvalidField = true;
        }

        if (txtPhMin.getText().isBlank()) {
            erros += "Campo pH mínimo não pode estar em branco.\n";
            hasInvalidField = true;
        } else if (!utils.isNumeric(txtPhMin.getText())) {
            erros += "Campo pH mínimo deve ser numérico.\n";
            hasInvalidField = true;
        }
        if (hasInvalidField) {
            throw new Exception(erros);
        }
    }
}
