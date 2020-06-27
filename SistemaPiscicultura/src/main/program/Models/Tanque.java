package Models;

import Interface.EstouraException;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Tanque extends Entidade {
    //Declarações
    @ManyToOne(targetEntity = Peixe.class, fetch = FetchType.EAGER)
    private Peixe Peixe;
    private String NomePeixe;
    private String Status;
    private Double Volume;

    //getters
    public Peixe getPeixe() {
        return Peixe;
    }

    public String getStatus() {
        return Status;
    }

    public Double getVolume() {
        return Volume;
    }

    //setters
    public void setPeixe(Peixe Peixe) {
        this.Peixe = Peixe;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setVolume(Double volume) {
        this.Volume = volume;
    }

    public Tanque() {
        this.Peixe = null;
        this.Status = "";
        this.Volume = 0.0;
    }

    public Tanque(Peixe peixe, String status, Double volume) {
        this.Peixe = peixe;
        this.Status = status;
        this.Volume = volume;
    }

    public Tanque(String nomePeixe, String status, Double volume) {
        this.NomePeixe = nomePeixe;
        this.Status = status;
        this.Volume = volume;
    }

    //Validações
    @Override
    public void validar() throws Exception {
        EstouraException EE = new EstouraException();

        //if(Peixe.id.isBlank()){ EE.RaiseException("Escreva quais peixes estarão neste tanque."); }
        if (Volume < 0) {
            EE.RaiseException("Valor de volume inválido.");
        }
    }
}
