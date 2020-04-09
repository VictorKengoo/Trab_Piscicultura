package main.program.Models;
import javax.persistence.Entity;

import main.program.Interface.EstouraException;

@Entity
public class Peixe extends Entidade {
    //Declarações
    private String Especie;
    private double MaxTemp;
    private double MinTemp;
    private double MaxpH;
    private double MinpH;

    //getters
    public String getEspecie(){ return Especie; }
    public double getMaxTemp(){ return MaxTemp; }
    public double getMinTemp(){ return MinTemp; }
    public double getMaxpH(){ return MaxpH; }
    public double getMinpH(){ return MinpH; }

    //setters
    public void setEspecie(String Especie) { this.Especie = Especie; }
    public void setMaxTemp(double maxTemp) { this.MaxTemp = maxTemp; }
    public void setMinTemp(double minTemp) { this.MinTemp = minTemp; }
    public void setMinpH(double minpH) { this.MinpH = minpH; }
    public void setMaxpH(double maxpH) { this.MaxpH = maxpH; }

    //Validações
    @Override
    public void validar() throws Exception {
        EstouraException EE = new EstouraException();

        if(Especie.isBlank()){ EE.RaiseException("Espécie em branco."); }
        if(MinpH < 0 || MaxpH > 14 ) { EE.RaiseException("Valor de pH inválido."); }
    }
}
