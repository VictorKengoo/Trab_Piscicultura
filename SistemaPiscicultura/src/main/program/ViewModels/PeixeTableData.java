package ViewModels;

import Models.Peixe;
import javafx.beans.property.SimpleStringProperty;

public class PeixeTableData {
    public SimpleStringProperty peixeId;
    public SimpleStringProperty especie;
    public SimpleStringProperty tempMax;
    public SimpleStringProperty tempMin;
    public SimpleStringProperty pHMax;
    public SimpleStringProperty pHMin;

    public PeixeTableData(Peixe peixe) {
        this.peixeId = new SimpleStringProperty(String.valueOf(peixe.id));
        this.especie = new SimpleStringProperty(String.valueOf(peixe.getEspecie()));
        this.tempMax = new SimpleStringProperty(String.valueOf(peixe.getMaxTemp()));
        this.tempMin = new SimpleStringProperty(String.valueOf(peixe.getMinTemp()));
        this.pHMax   = new SimpleStringProperty(String.valueOf(peixe.getMaxpH()));
        this.pHMin   = new SimpleStringProperty(String.valueOf(peixe.getMinpH()));
    }

    public String getPeixeId() {
        return peixeId.get();
    }

    public void setPeixeId(String peixeId) {
        this.peixeId.set(peixeId);
    }

    public String getEspecie() {
        return especie.get();
    }

    public void setEspecie(String especie) {
        this.especie.set(especie);
    }

    public String getTempMax() {
        return tempMax.get();
    }

    public void setTempMax(String tempMax) {
        this.tempMax.set(tempMax);
    }

    public String getTempMin() {
        return tempMin.get();
    }

    public void setTempMin(String tempMin) {
        this.tempMin.set(tempMin);
    }

    public String getPHMax() {
        return pHMax.get();
    }

    public void setPHMax(String phMax) {
        this.pHMax.set(phMax);
    }

    public String getPHMin() {
        return pHMin.get();
    }

    public void setPHMin(String phMin) {
        this.pHMin.set(phMin);
    }
}
