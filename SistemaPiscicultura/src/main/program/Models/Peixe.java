package Models;

import Application.PeixeApp;
import Interface.EstouraException;
import Interface.Telas.CadastroPeixeController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.Entity;
import java.util.ArrayList;

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
<<<<<<< HEAD
    public void setEspecie(String Especie) {this.Especie = Especie; }
    public void setMaxTemp(Double maxTemp) { this.MaxTemp = maxTemp; }
    public void setMinTemp(Double minTemp) { this.MinTemp = minTemp; }
    public void setMinpH(Double minpH) { this.MinpH = minpH; }
    public void setMaxpH(Double minpH) { this.MaxpH = minpH; }
=======
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
>>>>>>> f9c76c88962873aaeb646bef4cfdd1676d5bfbb4

    public Peixe() {
        this.Especie = "";
        this.MaxTemp = 0.0;
        this.MinTemp = 0.0;
        this.MaxpH = 0.0;
        this.MinpH = 0.0;
    }

<<<<<<< HEAD
    public Peixe (String especie, Double maxTemp, Double minTemp, Double maxPh, Double minPh) throws Exception {
=======
    public Peixe(String especie, Double maxTemp, Double minTemp, Double maxPh, Double minPh) {
>>>>>>> f9c76c88962873aaeb646bef4cfdd1676d5bfbb4
        this.Especie = especie;
        this.MaxTemp = maxTemp;
        this.MinTemp = minTemp;
        this.MaxpH = maxPh;
        this.MinpH = minPh;
        validar();
    }

    //Validações
    @Override
    public void validar() throws Exception {
        String erros = "";
        boolean hasError = false;

<<<<<<< HEAD
        if((MinpH < 0 || MinpH > 14) || (MaxpH < 0 || MaxpH > 14)) {
            throw new Exception("pH deve estar entre 0 e 14.\n");
        }

        if(MinpH >= MaxpH ) {erros += "pH mínimo deve ser menor que pH máximo.\n"; hasError=true;}

        if(MinTemp >= MaxTemp) {erros += "Temperatura mínima deve ser menor que temperatura máximo.\n"; hasError=true;}

        if(hasError) {
            throw new Exception(erros);
=======
        if (Especie.isBlank()) {
            EE.RaiseException("Espécie em branco.");
        }
        if (MinpH < 0 || MaxpH > 14) {
            EE.RaiseException("Valor de pH inválido.");
>>>>>>> f9c76c88962873aaeb646bef4cfdd1676d5bfbb4
        }
    }

}
