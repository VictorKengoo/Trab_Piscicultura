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
    private double PrecoUnitario;

    //getters
    public String getEspecie(){ return Especie; }
    public double getMaxTemp(){ return MaxTemp; }
    public double getMinTemp(){ return MinTemp; }
    public double getMaxpH(){ return MaxpH; }
    public double getMinpH(){ return MinpH; }
    public double getPrecoUnitario(){ return PrecoUnitario; }

    //setters
    public void setEspecie(String Especie) { this.Especie = Especie; }
    public void setMaxTemp(double maxTemp) { MaxTemp = maxTemp; }
    public void setMinTemp(double minTemp) { MinTemp = minTemp; }
    public void setMinpH(double minpH) { MinpH = minpH; }
    public void setMaxpH(double maxpH) { MaxpH = maxpH; }
    public void setPrecoUnitario(double precoUnitario) { PrecoUnitario = precoUnitario; }

    public void validar() throws Exception {
        EstouraException EE = new EstouraException();

        if(Especie.isBlank()){ EE.RaiseException("Espécie em branco"); }
        if(MinpH < 0 || MaxpH > 14 ) { EE.RaiseException("Valor de pH inválido"); }
    }
}
