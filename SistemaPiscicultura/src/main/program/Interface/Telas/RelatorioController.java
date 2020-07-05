package Interface.Telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RelatorioController {
    @FXML
    private Button btnVoltar;

    Stage stage = new Stage();

    public void GraficoTanque(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HistoryData.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Dados Históricos (Gráficos)");
        stage.setScene(scene);
        stage.show();
    }
    public void TabelaMonitoramento(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HistoryDataTable.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Dados Históricos (Tabela)");
        stage.setScene(scene);
        stage.show();
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
}
