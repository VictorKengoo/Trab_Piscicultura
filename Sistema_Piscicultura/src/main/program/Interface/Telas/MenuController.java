package main.program.Interface.Telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.program.Models.Estoque;
import main.program.Interface.Utils;
import main.program.Models.Tanque;


public class MenuController {

    TableView<Estoque> tabelaEstoque;

    TableView<Tanque> tabelaMonitoramento;

    Stage stage = new Stage();
    Utils utils = new Utils();

    public void Estoque(ActionEvent event) {
        // coluna Marca
        TableColumn<Estoque, String> colunaMarca = new TableColumn("Marca");
        colunaMarca.setMinWidth(150);
        colunaMarca.setCellValueFactory(new PropertyValueFactory<>("Marca"));

        // coluna Quantidade
        TableColumn<Estoque, Integer> colunaQtd = new TableColumn("Quantidade");
        colunaQtd.setMinWidth(150);
        colunaQtd.setCellValueFactory(new PropertyValueFactory<>("QntEstoque"));

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
        colunaPeixe.setCellValueFactory(new PropertyValueFactory<>("Peixe"));

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
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root, 200, 400);
        stage.setScene(scene);
        stage.show();
    }

    public void Gerenciamento(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root, 200, 400);
        stage.setScene(scene);
        stage.show();
    }

    public void Cadastro(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root, 200, 400);
        stage.setScene(scene);
        stage.show();
    }

}
