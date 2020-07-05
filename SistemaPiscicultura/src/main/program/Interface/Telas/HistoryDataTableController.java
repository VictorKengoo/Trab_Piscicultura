package Interface.Telas;

import Application.MonitoramentoApp;
import Application.TanqueApp;
import ViewModels.MonitoramentoTableData;
import Models.Tanque;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.HashMap;
import java.util.Map;

public class HistoryDataTableController {

    @FXML
    private ComboBox<String> cmbTanques;
    @FXML
    private TableView<MonitoramentoTableData> tblMonitoramento;
    @FXML
    private TableColumn<MonitoramentoTableData, String> columnLogData;
    @FXML
    private TableColumn<MonitoramentoTableData, String> columnTemp;
    @FXML
    private TableColumn<MonitoramentoTableData, String> columnPh;

    ObservableList<String> tanquesList = FXCollections.observableArrayList();

    Map<String, Integer> mapNameTanqueToIdTanque = new HashMap<String, Integer>();

    public void initialize() {
        TanqueApp tanqueApp = new TanqueApp();

        for (Tanque tanque : tanqueApp.getAll(Tanque.class)) {
            tanquesList.add(tanque.getNomeTanque());
            mapNameTanqueToIdTanque.put(tanque.getNomeTanque(), tanque.id);
        }
        cmbTanques.setItems(tanquesList);
    }

    public void callGetCurrentHistoryData(ActionEvent event) throws Exception {
        if (tblMonitoramento.getItems() != null) {
            tblMonitoramento.getItems().clear();
        }

        MonitoramentoApp monitoramentoApp = new MonitoramentoApp();

        ObservableList<MonitoramentoTableData> listCurrentMonitoramentoData;

        listCurrentMonitoramentoData = monitoramentoApp.getCurrentHistoryDataTable(mapNameTanqueToIdTanque, cmbTanques.getValue(), monitoramentoApp);

        columnLogData.setCellValueFactory(new PropertyValueFactory<MonitoramentoTableData, String>("logData"));
        columnTemp.setCellValueFactory(new PropertyValueFactory<MonitoramentoTableData, String>("currentTemp"));
        columnPh.setCellValueFactory(new PropertyValueFactory<MonitoramentoTableData, String>("currentPh"));

        tblMonitoramento.setItems(listCurrentMonitoramentoData);
        tblMonitoramento.scrollTo(0);
    }

}
