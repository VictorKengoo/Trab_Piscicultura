package ViewModels;

import Models.Tanque;
import javafx.beans.property.SimpleStringProperty;

public class TanqueTableData {

    public SimpleStringProperty tanqueId;
    public SimpleStringProperty nomeTanque;
    public SimpleStringProperty volumeTanque;
    public SimpleStringProperty peixeTanque;

    public TanqueTableData(Tanque tanque) {
        this.tanqueId     = new SimpleStringProperty(String.valueOf(tanque.id));
        this.nomeTanque   = new SimpleStringProperty(String.valueOf(tanque.getNomeTanque()));
        this.volumeTanque = new SimpleStringProperty(String.valueOf(tanque.getVolume()));
        this.peixeTanque  = new SimpleStringProperty(String.valueOf(tanque.getPeixe().getEspecie()));
    }

    public String getTanqueId() {
        return tanqueId.get();
    }

    public void setTanqueId(String tanqueId) {
        this.tanqueId.set(tanqueId);
    }

    public String getNomeTanque() { return nomeTanque.get(); }

    public void setNomeTanque(String nomeTanque) {
        this.nomeTanque.set(nomeTanque);
    }

    public String getVolumeTanque() {
        return volumeTanque.get();
    }

    public void setVolumeTanque(String volumeTanque) {
        this.volumeTanque.set(volumeTanque);
    }

    public String getPeixeTanque() {
        return peixeTanque.get();
    }

    public void setPeixeTanque(String peixeTanque) {
        this.peixeTanque.set(peixeTanque);
    }
}
