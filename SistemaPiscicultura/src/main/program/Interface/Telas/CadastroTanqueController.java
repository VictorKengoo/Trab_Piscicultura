package Interface.Telas;

import Application.PeixeApp;
import Application.TanqueApp;
import Interface.EstouraException;
import Interface.Utils;
import Models.*;
import ViewModels.TanqueTableData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javafx.scene.control.TableColumn;

import java.util.HashMap;
import java.util.List;
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

    ObservableList<TanqueTableData> obsListTanqueTableData = FXCollections.observableArrayList();

    Map<String, Integer> mapNameTanqueToIdTanque = new HashMap<String, Integer>();

    Stage stage = new Stage();
    Utils utils = new Utils();

    public void initialize() {
        if (LoginController.currentUser.equals("USUARIO")) {
            btnDeletarTanque.setDisable(true);
            btnAdicionarTanque.setDisable(true);
            btnAtualizarTanque.setDisable(true);
            btnEditar.setDisable(true);
            txtNomeTanque.setDisable(true);
            txtIdTanque.setDisable(true);
            txtVolumeTanque.setDisable(true);
            cmbPeixes.setDisable(true);
        }

        PeixeApp peixeApp = new PeixeApp();

        for (Peixe peixe : peixeApp.getAll(Peixe.class)) {
            peixesList.add(peixe.getEspecie());
            mapNameTanqueToIdTanque.put(peixe.getEspecie(), peixe.id);
        }

        cmbPeixes.setItems(peixesList);

        TanqueApp tanqueApp = new TanqueApp();

        for (Tanque tanque : tanqueApp.getAll(Tanque.class)) {
            obsListTanqueTableData.add(new TanqueTableData(tanque));
        }

        columnIdTanque.setCellValueFactory(new PropertyValueFactory<TanqueTableData, String>("tanqueId"));
        columnNomeTanque.setCellValueFactory(new PropertyValueFactory<TanqueTableData, String>("nomeTanque"));
        columnVolumeTanque.setCellValueFactory(new PropertyValueFactory<TanqueTableData, String>("volumeTanque"));
        columnPeixeTanque.setCellValueFactory(new PropertyValueFactory<TanqueTableData, String>("peixeTanque"));

        tblTanque.setItems(obsListTanqueTableData);
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

    public void CadastrarTanque(ActionEvent event) throws Exception {
        EstouraException ex = new EstouraException();
        TanqueApp tanqueApp = new TanqueApp();
        Tanque tanque;
        PeixeApp peixeApp = new PeixeApp();
        Peixe peixe = new Peixe();
        Boolean hasDuplicate;
        Boolean hasInvalidField;

        hasInvalidField = ValidarCamposTanque();
        int cod;
        if (!hasInvalidField) {
            cod = mapNameTanqueToIdTanque.get(cmbPeixes.getValue());
            for (Peixe p : peixeApp.getAll(Peixe.class)) {
                if (cmbPeixes.getValue() != null) {
                    if (p.id == cod) {
                        peixe = p;
                    }
                }
            }
            try {
                tanque = new Tanque(peixe, txtNomeTanque.getText(), "OK", "OK", "OK", Double.parseDouble(txtVolumeTanque.getText()));
                hasDuplicate = tanqueApp.hasDuplicate(txtNomeTanque.getText());
                if (!hasDuplicate) {
                    tanqueApp.Adicionar(tanque);
                    ex.RaiseOK("Tanque cadastrado com sucesso!");
                    stage = (Stage) btnAdicionarTanque.getScene().getWindow();
                    stage.close();
                    Parent root = FXMLLoader.load(getClass().getResource("CadastroTanque.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                }
            } catch (Exception e) {
                ex.RaiseException(e.getMessage());
            }
        }
    }

    public void DeletarTanque(ActionEvent event) throws Exception {
        EstouraException ex = new EstouraException();
        Boolean hasError = false;
        Boolean confirmed = false;
        TanqueApp tanqueApp = new TanqueApp();
        Tanque tanque = new Tanque();
        TanqueTableData tanqueFromTable;
        if (tblTanque.getSelectionModel().getSelectedItem() != null) {
            tanqueFromTable = tblTanque.getSelectionModel().getSelectedItem();
            List<Tanque> listTanque = tanqueApp.getAll(Tanque.class);
            for (Tanque tank : listTanque) {
                if (tank.id == Integer.parseInt(tanqueFromTable.getTanqueId())) {
                    tanque = tank;
                }
            }
            confirmed = ex.RaiseConfirmation("Tem certeza que deseja excluir o registro?");
        } else {
            ex.RaiseException("Não foi selecionado nenhum registro na tabela.");
            hasError = true;
        }

        if (!hasError && confirmed) {
            try {
                tanqueApp.delete(tanque);
                ex.RaiseOK("Tanque deletado com sucesso!");
                stage = (Stage) btnDeletarTanque.getScene().getWindow();
                stage.close();
                Parent root = FXMLLoader.load(getClass().getResource("CadastroTanque.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                ex.RaiseException(e.getMessage());
            }
        }
    }

    String currentTanque = "";

    public void EditarTanque(ActionEvent event) throws Exception {
        EstouraException ex = new EstouraException();
        Boolean hasError = false;
        TanqueApp tanqueApp = new TanqueApp();
        Tanque tanque = new Tanque();
        TanqueTableData tanqueFromTable;
        if (tblTanque.getSelectionModel().getSelectedItem() != null) {
            tanqueFromTable = tblTanque.getSelectionModel().getSelectedItem();
            List<Tanque> listTanque = tanqueApp.getAll(Tanque.class);
            for (Tanque tank : listTanque) {
                if (tank.id == Integer.parseInt(tanqueFromTable.getTanqueId())) {
                    tanque = tank;
                }
            }
        } else {
            ex.RaiseException("Não foi selecionado nenhum registro na tabela.");
            hasError = true;
        }

        if (!hasError) {
            try {
                currentTanque = tanque.getNomeTanque();
                txtNomeTanque.setText(tanque.getNomeTanque());
                txtVolumeTanque.setText(String.valueOf(tanque.getVolume()));
                cmbPeixes.setValue(tanque.getPeixe().getEspecie());
                txtIdTanque.setText(String.valueOf(tanque.id));
            } catch (Exception e) {
                ex.RaiseException(e.getMessage());
            }
        }
    }

    public void AtualizarTanque(ActionEvent event) throws Exception {
        EstouraException ex = new EstouraException();
        Boolean hasError = false;
        Boolean hasDuplicate = false;
        TanqueApp tanqueApp = new TanqueApp();
        Tanque tanque = new Tanque();
        PeixeApp peixeApp = new PeixeApp();
        Peixe peixe = new Peixe();

        if (txtIdTanque.getText().isBlank() || txtIdTanque.getText().isEmpty()) {
            ex.RaiseException("Nenhum tanque selecionado para ser atualizado.");
            hasError = true;
        } else {
            ValidarCamposTanque();
            int codPeixe = mapNameTanqueToIdTanque.get(cmbPeixes.getValue());
            for (Peixe p : peixeApp.getAll(Peixe.class)) {
                if (p.id == codPeixe) {
                    peixe = p;
                }
            }
            int cod = Integer.parseInt(txtIdTanque.getText());
            List<Tanque> listTanque = tanqueApp.getAll(Tanque.class);
            for (Tanque tank : listTanque) {
                if (tank.id == cod) {
                    tanque = tank;
                }
            }
            tanque.setNomeTanque(txtNomeTanque.getText());
            tanque.setPeixe(peixe);
            tanque.setVolume(Double.parseDouble(txtVolumeTanque.getText()));
            if (!txtNomeTanque.getText().equals(currentTanque)) {
                hasDuplicate = tanqueApp.hasDuplicate(txtNomeTanque.getText());
            }
        }

        if (!hasError && !hasDuplicate) {
            try {
                tanqueApp.update(tanque);
                ex.RaiseOK("Tanque atualizado com sucesso!");
                stage = (Stage) btnAtualizarTanque.getScene().getWindow();
                stage.close();
                Parent root = FXMLLoader.load(getClass().getResource("CadastroTanque.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                ex.RaiseException(e.getMessage());
            }
        }
<<<<<<< HEAD
    }

    public Boolean ValidarCamposTanque() {
        EstouraException ex = new EstouraException();
        Boolean hasInvalidField = false;
        String erros = "";
        if (txtNomeTanque.getText().isBlank()) {
            erros += "Campo nome não pode estar em branco.\n";
            hasInvalidField = true;
        }

        if (txtVolumeTanque.getText().isBlank()) {
            erros += "Campo volume não pode estar em branco.\n";
            hasInvalidField = true;
        } else if (!utils.isNumeric(txtVolumeTanque.getText())) {
            erros += "Campo volume deve ser numérico.\n";
            hasInvalidField = true;
        }

        if (cmbPeixes.getValue() == null) {
            erros += "Caixa de seleção de peixe não pode estar em branco.\n";
            hasInvalidField = true;
        }

        if(hasInvalidField) {
            ex.RaiseException(erros);
=======
        Tanque tanque = new Tanque(peixe, "OK", Double.parseDouble(txtVolumeTanque.getText()));

        try {
            tanqueApp.Adicionar(tanque);
            ex.RaiseOK("Tanque cadastrado com sucesso!");
            stage = (Stage) btnAdicionarTanque.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("CadastroTanque.fxml"));
            Scene scene = new Scene(root, 450, 300);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
>>>>>>> f9c76c88962873aaeb646bef4cfdd1676d5bfbb4
        }

        return hasInvalidField;
    }

}
