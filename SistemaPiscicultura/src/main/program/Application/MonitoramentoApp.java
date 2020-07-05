package Application;

import Models.Monitoramento;
import ViewModels.MonitoramentoTableData;
import Repository.MonitoramentoRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Map;


public class MonitoramentoApp extends BaseApp<Monitoramento> {

    private final MonitoramentoRepository _monitoramentoRepository;

    public MonitoramentoApp() {
        _monitoramentoRepository = new MonitoramentoRepository();
    }


    public ObservableList<Monitoramento> getCurrentHistoryData(Map<String, Integer> mapNameTanqueToIdTanque, String nomeTanque, MonitoramentoApp monitoramentoApp) throws Exception {
        ObservableList<Monitoramento> listCurrentMonitoramentoData = FXCollections.observableArrayList();
        for (Monitoramento monitoramentoData : monitoramentoApp.getAll(Monitoramento.class)) {
            if (monitoramentoData.getTanqueId() == mapNameTanqueToIdTanque.get(nomeTanque)) {
                listCurrentMonitoramentoData.add(monitoramentoData);
            }
        }

        return listCurrentMonitoramentoData;
    }

    public ObservableList<MonitoramentoTableData> getCurrentHistoryDataTable (Map<String, Integer> mapNameTanqueToIdTanque, String nomeTanque, MonitoramentoApp monitoramentoApp) {
        ObservableList<MonitoramentoTableData> listCurrentMonitoramentoData = FXCollections.observableArrayList();
        for (Monitoramento monitoramentoData : monitoramentoApp.getAll(Monitoramento.class)) {
            if (monitoramentoData.getTanqueId() == mapNameTanqueToIdTanque.get(nomeTanque)) {
                listCurrentMonitoramentoData.add(new MonitoramentoTableData(monitoramentoData));
            }
        }

        return listCurrentMonitoramentoData;
    }
}
