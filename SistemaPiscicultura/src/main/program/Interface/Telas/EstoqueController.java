package Interface.Telas;

import Application.EstoqueApp;
import Interface.EstouraException;
import Interface.Utils;
import Models.*;
import ViewModels.EstoqueTableData;
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

import java.util.List;

public class EstoqueController {
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
    private TextField txtProduto;
    @FXML
    private TextField txtQuantidade;
    @FXML
    private TextField txtIdEstoque;
    @FXML
    private TableView<EstoqueTableData> tblEstoque;
    @FXML
    private TableColumn<EstoqueTableData, String> columnIdEstoque;
    @FXML
    private TableColumn<EstoqueTableData, String> columnProduto;
    @FXML
    private TableColumn<EstoqueTableData, String> columnQuantidade;

    ObservableList<EstoqueTableData> obsListEstoqueData = FXCollections.observableArrayList();

    Stage stage = new Stage();
    Utils utils = new Utils();

    public void initialize() {
        EstoqueApp estoqueApp = new EstoqueApp();

        for (Estoque estoque : estoqueApp.getAll(Estoque.class)) {
            obsListEstoqueData.add(new EstoqueTableData(estoque));
        }

        columnIdEstoque.setCellValueFactory(new PropertyValueFactory<EstoqueTableData, String>("estoqueId"));
        columnProduto.setCellValueFactory(new PropertyValueFactory<EstoqueTableData, String>("produto"));
        columnQuantidade.setCellValueFactory(new PropertyValueFactory<EstoqueTableData, String>("quantidade"));

        tblEstoque.setItems(obsListEstoqueData);
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

    public void CadastrarEstoque(ActionEvent event) throws Exception {
        EstouraException ex = new EstouraException();
        EstoqueApp estoqueApp = new EstoqueApp();
        Estoque estoque;
        Boolean hasDuplicate;
        Boolean hasInvalidField;

        hasInvalidField = ValidarCamposEstoque();

        if (!hasInvalidField) {
            estoque = new Estoque(txtProduto.getText(), Integer.parseInt(txtQuantidade.getText()));
            hasDuplicate = estoqueApp.hasDuplicate(txtProduto.getText());
            if (!hasDuplicate) {
                try {
                    estoqueApp.Adicionar(estoque);
                    ex.RaiseOK("Estoque cadastrado com sucesso!");
                    stage = (Stage) btnAdicionar.getScene().getWindow();
                    stage.close();
                    Parent root = FXMLLoader.load(getClass().getResource("Estoque.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    ex.RaiseException(e.getMessage());
                }
            }
        }
    }

    public void DeletarEstoque(ActionEvent event) throws Exception {
        EstouraException ex = new EstouraException();
        Boolean hasError = false;
        Boolean confirmed = false;
        EstoqueApp estoqueApp = new EstoqueApp();
        Estoque estoque = new Estoque();
        EstoqueTableData estoqueFromTable;
        if (tblEstoque.getSelectionModel().getSelectedItem() != null) {
            estoqueFromTable = tblEstoque.getSelectionModel().getSelectedItem();
            List<Estoque> listEstoque = estoqueApp.getAll(Estoque.class);
            for (Estoque e : listEstoque) {
                if (e.id == Integer.parseInt(estoqueFromTable.getEstoqueId())) {
                    estoque = e;
                }
            }
            confirmed = ex.RaiseConfirmation("Tem certeza que deseja excluir registro?");
        } else {
            ex.RaiseException("Não foi selecionado nenhum registro na tabela.");
            hasError = true;
        }

        if (!hasError && confirmed) {
            try {
                estoqueApp.delete(estoque);
                ex.RaiseOK("Estoque deletado com sucesso!");
                stage = (Stage) btnDeletar.getScene().getWindow();
                stage.close();
                Parent root = FXMLLoader.load(getClass().getResource("Estoque.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                ex.RaiseException(e.getMessage());
            }
        }
    }

    String currentProduto = "";

    public void EditarEstoque(ActionEvent event) throws Exception {
        EstouraException ex = new EstouraException();
        Boolean hasError = false;
        EstoqueApp estoqueApp = new EstoqueApp();
        Estoque estoque = new Estoque();
        EstoqueTableData estoqueFromTable;
        if (tblEstoque.getSelectionModel().getSelectedItem() != null) {
            estoqueFromTable = tblEstoque.getSelectionModel().getSelectedItem();
            List<Estoque> listEstoque = estoqueApp.getAll(Estoque.class);
            for (Estoque e : listEstoque) {
                if (e.id == Integer.parseInt(estoqueFromTable.getEstoqueId())) {
                    estoque = e;
                }
            }
        } else {
            ex.RaiseException("Não foi selecionado nenhum registro na tabela.");
            hasError = true;
        }

        if (!hasError) {
            try {
                currentProduto = estoque.getMarca();
                txtProduto.setText(estoque.getMarca());
                txtQuantidade.setText(String.valueOf(estoque.getQuantidade()));
                txtIdEstoque.setText(String.valueOf(estoque.id));
            } catch (Exception e) {
                ex.RaiseException(e.getMessage());
            }
        }
    }

    public void AtualizarEstoque(ActionEvent event) throws Exception {
        EstouraException ex = new EstouraException();
        Boolean hasError = false;
        Boolean hasDuplicate = false;
        Boolean hasInvalidField = false;
        EstoqueApp estoqueApp = new EstoqueApp();
        Estoque estoque = new Estoque();
        if (txtIdEstoque.getText().isBlank() || txtIdEstoque.getText().isEmpty()) {
            ex.RaiseException("Nenhum item selecionado para edição.");
            hasError = true;
        } else {
            hasInvalidField = ValidarCamposEstoque();
            int cod = Integer.parseInt(txtIdEstoque.getText());
            List<Estoque> listEstoque = estoqueApp.getAll(Estoque.class);
            for (Estoque e : listEstoque) {
                if (e.id == cod) {
                    estoque = e;
                }
            }
            if (!hasInvalidField) {
                estoque.setMarca(txtProduto.getText());
                estoque.setQntEstoque(Integer.parseInt(txtQuantidade.getText()));
                if (!txtProduto.getText().equals(currentProduto)) {
                    hasDuplicate = estoqueApp.hasDuplicate(txtProduto.getText());
                }
            }
        }

        if (!hasError && !hasDuplicate && !hasInvalidField) {
            try {
                estoqueApp.update(estoque);
                ex.RaiseOK("Estoque atualizado com sucesso!");
                stage = (Stage) btnAtualizar.getScene().getWindow();
                stage.close();
                Parent root = FXMLLoader.load(getClass().getResource("Estoque.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                ex.RaiseException(e.getMessage());
            }
        }
    }

    public Boolean ValidarCamposEstoque() {
        EstouraException ex = new EstouraException();
        Boolean hasInvalidField = false;
        String erros = "";
        if (txtProduto.getText().isBlank()) {
            erros += "Campo produto não pode estar em branco.\n";
            hasInvalidField = true;
        }

        if (txtQuantidade.getText().isBlank()) {
            erros += "Campo quantidade não pode estar em branco.\n";
            hasInvalidField = true;
        } else if (!utils.isNumeric(txtQuantidade.getText())) {
            erros += "Campo quantidade deve ser numérico.\n";
            hasInvalidField = true;
        }

        if(hasInvalidField) {
            ex.RaiseException(erros);
        }

        return hasInvalidField;
    }



}
