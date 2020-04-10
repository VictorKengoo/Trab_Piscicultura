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


public class MenuController {

    TableView<Estoque> tabelaEstoque;

    Stage stage = new Stage();

    public void Estoque(ActionEvent event) {
        Utils utils = new Utils();

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
        stage.setScene(scene);
        stage.show();
    }

    public void Monitoramento(ActionEvent event) {

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
