package Interface.Telas;

import Application.TanqueApp;
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
import Models.Estoque;
import Interface.Utils;
import Models.Tanque;

import java.io.IOException;


public class MenuController {

    TableView<Estoque> tabelaEstoque;
    TableView<Tanque> tabelaMonitoramento;

    @FXML
    private Button btnGerenciamento;
    @FXML
    private Button btnRelatorio;
    @FXML
    private Button btnLogout;
    @FXML
    private Button btnHistoryData;
    @FXML
    private Button btnEstoque;
    @FXML
    private Button btnTanque;
    @FXML
    private Button btnUsuario;
    @FXML
    private Button btnPeixe;

    Stage stage = new Stage();
    Utils utils = new Utils();

    public void initialize() {
        if (LoginController.currentUser.equals("USUARIO")) {
            btnUsuario.setDisable(true);
        } else {
            btnUsuario.setDisable(false);
        }
    }

    public void Estoque(ActionEvent event) throws IOException {
        stage = (Stage) btnEstoque.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Estoque.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Estoques");
        stage.setScene(scene);
        stage.show();
    }

    public void Monitoramento(ActionEvent event) throws Exception {
        // coluna Tanque
        TableColumn<Tanque, String> colunaTanque = new TableColumn("Tanque");
        colunaTanque.setMinWidth(150);
        colunaTanque.setCellValueFactory(new PropertyValueFactory<>("NomeTanque"));

        // coluna Peixe
        TableColumn<Tanque, String> colunaPeixe = new TableColumn("Peixe");
        colunaPeixe.setMinWidth(150);
        colunaPeixe.setCellValueFactory(new PropertyValueFactory<>("NomePeixe"));

        // coluna Status Ph
        TableColumn<Tanque, String> colunaStatusPh = new TableColumn("Status pH");
        colunaStatusPh.setMinWidth(100);
        colunaStatusPh.setCellValueFactory(new PropertyValueFactory<>("StatusPh"));

        // coluna Status Temp
        TableColumn<Tanque, String> colunaStatusTemp = new TableColumn("Status Temp");
        colunaStatusTemp.setMinWidth(100);
        colunaStatusTemp.setCellValueFactory(new PropertyValueFactory<>("StatusTemp"));

        // coluna Status Geral
        TableColumn<Tanque, String> colunaStatusGeral = new TableColumn("Status Geral");
        colunaStatusGeral.setMinWidth(100);
        colunaStatusGeral.setCellValueFactory(new PropertyValueFactory<>("StatusGeral"));

        // coluna Volume
        TableColumn<Tanque, Double> colunaVolume = new TableColumn("Volume");
        colunaVolume.setMinWidth(100);
        colunaVolume.setCellValueFactory(new PropertyValueFactory<>("Volume"));
        TanqueApp tanqueApp = new TanqueApp();
        tabelaMonitoramento = new TableView<>();
        tabelaMonitoramento.setItems(tanqueApp.getTanque());
        tabelaMonitoramento.getColumns().addAll(colunaTanque, colunaPeixe, colunaVolume, colunaStatusPh, colunaStatusTemp, colunaStatusGeral);

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
        stage.setTitle("Dados Históricos");
        stage.setScene(scene);
        stage.show();
    }

    public void Gerenciamento(ActionEvent event) throws Exception {
        stage = (Stage) btnGerenciamento.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Gerenciador.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Gerenciamento");
        stage.setScene(scene);
        stage.show();
    }

    public void Relatorio(ActionEvent event) throws Exception {
        stage = (Stage) btnRelatorio.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Relatorio.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Relatorios");
        stage.setScene(scene);
        stage.show();
    }

    public void CadastroPeixe(ActionEvent event) throws Exception {
        stage = (Stage) btnPeixe.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("CadastroPeixe.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Peixes");
        stage.setScene(scene);
        stage.show();
    }

    public void CadastroTanque(ActionEvent event) throws Exception {
        stage = (Stage) btnTanque.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("CadastroTanque.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Tanques");
        stage.setScene(scene);
        stage.show();
    }

    public void Usuario(ActionEvent event) throws Exception {
        stage = (Stage) btnUsuario.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Usuario.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Usuarios");
        stage.setScene(scene);
        stage.show();
    }

    public void Logout(ActionEvent event) throws Exception {
        stage = (Stage) btnLogout.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

}
