package Models;



import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Monitoramento extends Entidade {

    private int tanqueId;
    private double temperatura;
    private double ph;
    private Date logData;

    public int getTanqueId() {
        return tanqueId;
    }

    public void setTanqueId(int tanqueId) {
        this.tanqueId = tanqueId;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public Date getLogData() {
        return logData;
    }

    public void setLogData(Date logData) {
        this.logData = logData;
    }

    @Override
    public void validar() throws Exception {

    }
}
