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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;

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

    ObservableList<PeixeTableData> obsListPeixeData = FXCollections.observableArrayList();

    Stage stage = new Stage();
    Utils utils = new Utils();

    public void initialize() {
        if (LoginController.currentUser.equals("USUARIO")) {
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

        PeixeApp peixeApp = new PeixeApp();

        for (Peixe peixe : peixeApp.getAll(Peixe.class)) {
            obsListPeixeData.add(new PeixeTableData(peixe));
        }

        peixeIdColumn.setCellValueFactory(new PropertyValueFactory<PeixeTableData, String>("peixeId"));
        especieColumn.setCellValueFactory(new PropertyValueFactory<PeixeTableData, String>("especie"));
        tempMaxColumn.setCellValueFactory(new PropertyValueFactory<PeixeTableData, String>("tempMax"));
        tempMinColumn.setCellValueFactory(new PropertyValueFactory<PeixeTableData, String>("tempMin"));
        pHMaxColumn.setCellValueFactory(new PropertyValueFactory<PeixeTableData, String>("pHMax"));
        pHMinColumn.setCellValueFactory(new PropertyValueFactory<PeixeTableData, String>("pHMin"));

        tblPeixe.setItems(obsListPeixeData);
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

    public void CadastrarPeixe(ActionEvent event) {
        EstouraException ex = new EstouraException();
        PeixeApp peixeApp = new PeixeApp();
        Peixe peixe;
        Boolean hasDuplicate;
        Boolean hasInvalidField;

        hasInvalidField = ValidarCamposPeixe();

        if (!hasInvalidField) {
            try {
                peixe = new Peixe(txtEspecie.getText(), Double.parseDouble(txtTempMax.getText()), Double.parseDouble(txtTempMin.getText()), Double.parseDouble(txtPhMax.getText()), Double.parseDouble(txtPhMin.getText()));
                hasDuplicate = peixeApp.hasDuplicate(txtEspecie.getText());
                if (!hasDuplicate) {
                    peixeApp.Adicionar(peixe);
                    ex.RaiseOK("Peixe cadastrado com sucesso!");
                    stage = (Stage) btnAdicionar.getScene().getWindow();
                    stage.close();
                    Parent root = FXMLLoader.load(getClass().getResource("CadastroPeixe.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            } catch (Exception e) {
                ex.RaiseException(e.getMessage());
            }
        }
    }

    public void DeletarPeixe(ActionEvent event) {
        EstouraException ex = new EstouraException();
        Boolean hasError = false;
        Boolean confirmed = false;
        PeixeApp peixeApp = new PeixeApp();
        Peixe peixe = new Peixe();
        PeixeTableData peixeFromTable;
        if (tblPeixe.getSelectionModel().getSelectedItem() != null) {
            peixeFromTable = tblPeixe.getSelectionModel().getSelectedItem();
            List<Peixe> listPeixe = peixeApp.getAll(Peixe.class);
            for (Peixe p : listPeixe) {
                if (p.id == Integer.parseInt(peixeFromTable.getPeixeId())) {
                    peixe = p;
                }
            }
            confirmed = ex.RaiseConfirmation("Tem certeza que deseja excluir o registro?");
        } else {
            ex.RaiseException("Não foi selecionado nenhum registro na tabela.");
            hasError = true;
        }

        if (!hasError && confirmed) {
            try {
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
    }

    String currentEspecie = "";

    public void EditarPeixe(ActionEvent event) {
        EstouraException ex = new EstouraException();
        Boolean hasError = false;
        PeixeApp peixeApp = new PeixeApp();
        Peixe peixe = new Peixe();
        PeixeTableData peixeFromTable;
        if (tblPeixe.getSelectionModel().getSelectedItem() != null) {
            peixeFromTable = tblPeixe.getSelectionModel().getSelectedItem();
            List<Peixe> listPeixe = peixeApp.getAll(Peixe.class);
            for (Peixe p : listPeixe) {
                if (p.id == Integer.parseInt(peixeFromTable.getPeixeId())) {
                    peixe = p;
                }
            }
        } else {
            ex.RaiseException("Não foi selecionado nenhum registro na tabela.");
            hasError = true;
        }

        if (!hasError) {
            try {
                currentEspecie = peixe.getEspecie();
                txtEspecie.setText(peixe.getEspecie());
                txtTempMax.setText(String.valueOf(peixe.getMaxTemp()));
                txtTempMin.setText(String.valueOf(peixe.getMinTemp()));
                txtPhMax.setText(String.valueOf(peixe.getMaxpH()));
                txtPhMin.setText(String.valueOf(peixe.getMinpH()));
                txtIdPeixe.setText(String.valueOf(peixe.id));
            } catch (Exception e) {
                ex.RaiseException(e.getMessage());
            }
        }
    }

    public void AtualizarPeixe(ActionEvent event) {
        EstouraException ex = new EstouraException();
        Boolean hasError = false;
        Boolean hasDuplicate = false;
        Boolean hasInvalidField = false;
        PeixeApp peixeApp = new PeixeApp();
        Peixe peixe = new Peixe();

        if (txtIdPeixe.getText().isBlank() || txtIdPeixe.getText().isEmpty()) {
            ex.RaiseException("Nenhum item selecionado para edição.");
            hasError = true;
        } else {
            hasInvalidField = ValidarCamposPeixe();
            for (Peixe p : peixeApp.getAll(Peixe.class)) {
                if (p.id == Integer.parseInt(txtIdPeixe.getText())) {
                    peixe = p;
                }
            }
            if (!hasInvalidField) {
                peixe.setEspecie(txtEspecie.getText());
                peixe.setMaxTemp(Double.parseDouble(txtTempMax.getText()));
                peixe.setMinTemp(Double.parseDouble(txtTempMin.getText()));
                peixe.setMaxpH(Double.parseDouble(txtPhMax.getText()));
                peixe.setMinpH(Double.parseDouble(txtPhMin.getText()));
                if (!txtEspecie.getText().equals(currentEspecie)) {
                    hasDuplicate = peixeApp.hasDuplicate(txtEspecie.getText());
                }
            }
        }

        if (!hasError && !hasDuplicate && !hasInvalidField) {
            try {
                peixeApp.update(peixe);
                ex.RaiseOK("Item atualizado com sucesso!");
                stage = (Stage) btnAtualizar.getScene().getWindow();
                stage.close();
                Parent root = FXMLLoader.load(getClass().getResource("CadastroPeixe.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                ex.RaiseException(e.getMessage());
            }
        }
    }

    public Boolean ValidarCamposPeixe() {
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
        if(hasInvalidField) {
            ex.RaiseException(erros);
        }
        return hasInvalidField;
    }
}
