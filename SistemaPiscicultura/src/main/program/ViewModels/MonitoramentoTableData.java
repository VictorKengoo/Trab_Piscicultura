package ViewModels;

import Models.Monitoramento;
import javafx.beans.property.SimpleStringProperty;

public class MonitoramentoTableData {

    public SimpleStringProperty logData;
    public SimpleStringProperty currentPh;
    public SimpleStringProperty currentTemp;

    public MonitoramentoTableData(Monitoramento monitoramento) {
        this.logData     = new SimpleStringProperty(String.valueOf(monitoramento.getLogData()));
        this.currentPh   = new SimpleStringProperty(String.valueOf(monitoramento.getPh()));
        this.currentTemp = new SimpleStringProperty(String.valueOf(monitoramento.getTemperatura()));
    }

    public String getLogData() {
        return logData.get();
    }

    public void setLogData(String logData) {
        this.logData.set(logData);
    }

    public String getCurrentPh() {
        return currentPh.get();
    }

    public void setCurrentPh(String currentPh) {
        this.currentPh.set(currentPh);
    }

    public String getCurrentTemp() {
        return currentTemp.get();
    }

    public void setCurrentTemp(String currentTemp) {
        this.currentTemp.set(currentTemp);
    }
}
