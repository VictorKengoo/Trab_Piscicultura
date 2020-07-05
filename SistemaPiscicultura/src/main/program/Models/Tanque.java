package Models;

import Application.PeixeApp;
import Application.TanqueApp;
import Interface.EstouraException;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;

@Entity
public class Tanque extends Entidade{
    //Declarações
    @ManyToOne(targetEntity = Peixe.class,fetch = FetchType.EAGER)
    private Peixe Peixe;
    private String NomeTanque;
    private String NomePeixe;
    private String StatusPh;
    private String StatusTemp;
    private String StatusGeral;
    private Double Volume;

    //getters
    public Peixe getPeixe() { return Peixe; }
    public String getNomeTanque() { return NomeTanque; }
    public String getNomePeixe() { return NomePeixe; }
    public String getStatusPh() { return StatusPh; }
    public String getStatusTemp() { return StatusTemp; }
    public String getStatusGeral() { return StatusGeral; }
    public Double getVolume() { return Volume; }

    //setters
    public void setPeixe(Peixe Peixe) { this.Peixe = Peixe; }
    public void setNomeTanque(String NomeTanque) { this.NomeTanque = NomeTanque; }
    public void setNomePeixe(String NomePeixe) { this.NomePeixe = NomePeixe; }
    public void setStatusPh(String StatusPh) { this.StatusPh = StatusPh; }
    public void setStatusTemp(String StatusTemp) { this.StatusTemp = StatusTemp; }
    public void setStatusGeral(String StatusGeral) { this.StatusTemp = StatusGeral; }
    public void setVolume(Double volume) { this.Volume = volume; }

    public Tanque () {
        this.Peixe = null;
        this.NomeTanque = "";
        this.NomePeixe = "";
        this.StatusPh = "";
        this.StatusTemp = "";
        this.StatusGeral = "";
        this.Volume = 0.0;
    };

    public Tanque (Peixe peixe, String nomeTanque, String statusPh, String statusTemp, String statusGeral, Double volume) throws Exception {
        this.Peixe = peixe;
        this.NomeTanque = nomeTanque;
        this.NomePeixe = peixe != null ? peixe.getEspecie() : null;
        this.StatusPh = statusPh;
        this.StatusTemp = statusTemp;
        this.StatusGeral = statusGeral;
        this.Volume = volume;
        validar();
    }

    //Validações
    @Override
    public void validar() throws Exception {
        if (Volume <= 0) { throw new Exception("Temperatura mínima deve ser menor que temperatura máximo.\n"); }
    }

}
