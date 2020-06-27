package Interface.Telas;

import Interface.Utils;
import Models.Estoque;
import Models.Tanque;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MenuController {

    TableView<Estoque> tabelaEstoque;
    TableView<Tanque> tabelaMonitoramento;

    @FXML
    private Button btnGerenciamento;
    @FXML
    private Button btnCadastro;
    @FXML
    private Button btnLogout;

    Stage stage = new Stage();
    Utils utils = new Utils();

    public void Estoque(ActionEvent event) {
        // coluna Marca
        TableColumn<Estoque, String> colunaMarca = new TableColumn("Marca");
        colunaMarca.setMinWidth(200);
        colunaMarca.setCellValueFactory(new PropertyValueFactory<>("Marca"));

        // coluna Quantidade
        TableColumn<Estoque, Integer> colunaQtd = new TableColumn("Quantidade");
        colunaQtd.setMinWidth(200);
        colunaQtd.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));

        tabelaEstoque = new TableView<>();
        tabelaEstoque.setItems(utils.getEstoque());
        tabelaEstoque.getColumns().addAll(colunaMarca, colunaQtd);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(tabelaEstoque);

        Scene scene = new Scene(vBox);
        stage.setTitle("Estoque");
        stage.setScene(scene);
        stage.show();
    }

    public void Monitoramento(ActionEvent event) {
        // coluna Peixe
        TableColumn<Tanque, String> colunaPeixe = new TableColumn("Peixe");
        colunaPeixe.setMinWidth(200);
        colunaPeixe.setCellValueFactory(new PropertyValueFactory<>("NomePeixe"));

        // coluna Status
        TableColumn<Tanque, String> colunaStatus = new TableColumn("Status");
        colunaStatus.setMinWidth(100);
        colunaStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));

        // coluna Volume
        TableColumn<Tanque, Double> colunaVolume = new TableColumn("Volume");
        colunaVolume.setMinWidth(100);
        colunaVolume.setCellValueFactory(new PropertyValueFactory<>("Volume"));

        tabelaMonitoramento = new TableView<>();
        tabelaMonitoramento.setItems(utils.getTanque());
        tabelaMonitoramento.getColumns().addAll(colunaPeixe, colunaVolume, colunaStatus);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(tabelaMonitoramento);

        Scene scene = new Scene(vBox);
        stage.setTitle("Monitoramento");
        stage.setScene(scene);
        stage.show();
    }

    public void HistoryData(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HistoryData.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("History Data");
        stage.setScene(scene);
        stage.show();
    }

    public void Gerenciamento(ActionEvent event) throws Exception {
        stage = (Stage) btnGerenciamento.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Gerenciador.fxml"));
        Scene scene = new Scene(root, 350, 500);
        stage.setTitle("Gerenciamento");
        stage.setScene(scene);
        stage.show();
    }

    public void Cadastro(ActionEvent event) throws Exception {
        stage = (Stage) btnCadastro.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Cadastro.fxml"));
        Scene scene = new Scene(root, 200, 300);
        stage.setTitle(null);
        stage.setScene(scene);
        stage.show();
    }

    public void Logout(ActionEvent event) throws Exception {
        stage = (Stage) btnLogout.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root, 350, 300);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

}
