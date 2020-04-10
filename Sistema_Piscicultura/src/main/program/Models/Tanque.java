package main.program.Models;

import main.program.Interface.EstouraException;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tanque extends Entidade{
    //Declarações
    @ManyToOne
    @JoinColumn(name="id_Peixe")
    private Peixe Peixe;
    private String Status;
    private double Volume;

    //getters
    public Peixe getPeixe() { return Peixe; }
    public String getStatus() { return Status; }
    public double getVolume() { return Volume; }

    //setters
    public void setPeixe(Peixe Peixe) { this.Peixe = Peixe; }
    public void setStatus(String Status) { this.Status = Status; }
    public void setVolume(double volume) { this.Volume = volume; }

    public Tanque (Peixe peixe, String status, double volume) {
        this.Peixe = peixe;
        this.Status = status;
        this.Volume = volume;
    }

    //Validações
    @Override
    public void validar() throws Exception {
        EstouraException EE = new EstouraException();

        //if(Peixe.id.isBlank()){ EE.RaiseException("Escreva quais peixes estarão neste tanque."); }
        if(Volume < 0){ EE.RaiseException("Valor de volume inválido."); }
    }
}
