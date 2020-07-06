package Interface.Telas;

import Application.EstoqueApp;
import Interface.EstouraException;
import Interface.Utils;
import Models.Estoque;
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
import jdk.jshell.spi.ExecutionControl;

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

    ObservableList<EstoqueTableData> obsListTableData = FXCollections.observableArrayList();

    EstoqueApp estoqueApp = new EstoqueApp();
    Stage stage = new Stage();
    Utils utils = new Utils();
    EstouraException ex = new EstouraException();

    public void initialize() {
        populaTabela();
    }

    private void populaTabela() {
        for (Estoque estoque : estoqueApp.getAll(Estoque.class)) {
            obsListTableData.add(new EstoqueTableData(estoque));
        }
        columnIdEstoque.setCellValueFactory(new PropertyValueFactory<EstoqueTableData, String>("estoqueId"));
        columnProduto.setCellValueFactory(new PropertyValueFactory<EstoqueTableData, String>("produto"));
        columnQuantidade.setCellValueFactory(new PropertyValueFactory<EstoqueTableData, String>("quantidade"));
        tblEstoque.setItems(obsListTableData);
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
        txtIdEstoque.clear();
        txtProduto.clear();
        txtQuantidade.clear();
    }

    private void bloqueiaCampos() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Falta implementar Estoque - bloqueiaCampos");
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

            Estoque estoque = new Estoque(txtProduto.getText(), Integer.parseInt(txtQuantidade.getText()));
            estoqueApp.hasDuplicate(estoque);

            estoqueApp.Adicionar(estoque);
            ex.RaiseOK("Estoque cadastrado com sucesso!");

            atualizaPagina();

        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
        }
    }

    public void Deletar(ActionEvent event) throws Exception {
        try {
            EstoqueTableData estoqueFromTable = tblEstoque.getSelectionModel().getSelectedItem();
            if (estoqueFromTable == null)
                ex.RaiseException("Não foi selecionado nenhum registro na tabela.");

            Estoque estoque = estoqueApp.getById(Integer.parseInt(estoqueFromTable.getEstoqueId()));
            if (ex.RaiseConfirmation("Tem certeza que deseja excluir registro?")) {
                estoqueApp.delete(estoque);
                ex.RaiseOK("Estoque deletado com sucesso!");

                atualizaPagina();
            }
        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
        }

    }


    public void Editar(ActionEvent event) throws Exception {
        try {
            EstoqueTableData estoqueFromTable = tblEstoque.getSelectionModel().getSelectedItem();
            if (estoqueFromTable == null)
                throw new Exception("Não foi selecionado nenhum registro na tabela.");

            txtProduto.setText(estoqueFromTable.getProduto());
            txtQuantidade.setText(String.valueOf(estoqueFromTable.getQuantidade()));
            txtIdEstoque.setText(String.valueOf(estoqueFromTable.getEstoqueId()));

        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
        }
    }


    public void Atualizar(ActionEvent event) throws Exception {
        try {
            if (txtIdEstoque.getText().isBlank())
                throw new Exception("Nenhum item selecionado para edição.");

            validarCampos();

            Estoque estoque = estoqueApp.getById(Integer.parseInt(txtIdEstoque.getText()));
            estoque.setMarca(txtProduto.getText());
            estoque.setQntEstoque(Integer.parseInt(txtQuantidade.getText()));
            estoqueApp.hasDuplicate(estoque);

            estoqueApp.update(estoque);
            ex.RaiseOK("Estoque atualizado com sucesso!");

            atualizaPagina();

        } catch (Exception e) {
            ex.RaiseException(e.getMessage());
        }
    }

    public void validarCampos() throws Exception {
        Boolean hasInvalidField = false;
        String erros = "";
        if (txtProduto.getText().isBlank()) {
            erros += "Campo produto não pode estar em branco.\n";
            hasInvalidField = true;
        }
        if (txtQuantidade.getText().isBlank()) {
            erros += "Campo quantidade não pode estar em branco.\n";
            hasInvalidField = true;
        } else if (!Utils.isNumeric(txtQuantidade.getText())) {
            erros += "Campo quantidade deve ser numérico.\n";
            hasInvalidField = true;
        }
        if (hasInvalidField) {
            throw new Exception(erros);
        }
    }
}
