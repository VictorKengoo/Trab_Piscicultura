package Models;

import Interface.EstouraException;

import javax.persistence.Entity;

@Entity
public class Peixe extends Entidade {
    //Declarações
    private String Especie;
    private Double MaxTemp;
    private Double MinTemp;
    private Double MaxpH;
    private Double MinpH;

    //getters
    public String getEspecie() {
        return Especie;
    }

    public Double getMaxTemp() {
        return MaxTemp;
    }

    public Double getMinTemp() {
        return MinTemp;
    }

    public Double getMaxpH() {
        return MaxpH;
    }

    public Double getMinpH() {
        return MinpH;
    }

    //setters
    public void setEspecie(String Especie) {
        this.Especie = Especie;
    }

    public void setMaxTemp(Double maxTemp) {
        this.MaxTemp = maxTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.MinTemp = minTemp;
    }

    public void setMinpH(Double minpH) {
        this.MinpH = minpH;
    }

    public void setMaxpH(Double maxpH) {
        this.MaxpH = maxpH;
    }

    public Peixe() {
        this.Especie = "";
        this.MaxTemp = 0.0;
        this.MinTemp = 0.0;
        this.MaxpH = 0.0;
        this.MinpH = 0.0;
    }

    public Peixe(String especie, Double maxTemp, Double minTemp, Double maxPh, Double minPh) {
        this.Especie = especie;
        this.MaxTemp = maxTemp;
        this.MinTemp = minTemp;
        this.MaxpH = maxPh;
        this.MinpH = minPh;
    }

    //Validações
    @Override
    public void validar() throws Exception {
        EstouraException EE = new EstouraException();

        if (Especie.isBlank()) {
            EE.RaiseException("Espécie em branco.");
        }
        if (MinpH < 0 || MaxpH > 14) {
            EE.RaiseException("Valor de pH inválido.");
        }
    }
}
