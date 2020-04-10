package main.program.Models;

import main.program.Interface.EstouraException;

public class Tanque extends Entidade{
    //Declarações
    private String Peixe;
    private String Status;
    private double Volume;

    //getters
    public String getPeixes() { return Peixe; }
    public String getStatus() { return Status; }
    public double getVolume() { return Volume; }

    //setters
    public void setPeixesContidos(String Peixe) { this.Peixe = Peixe; }
    public void setStatus(String Status) { this.Status = Status; }
    public void setVolume(double volume) { this.Volume = volume; }

    //Validações
    @Override
    public void validar() throws Exception {
        EstouraException EE = new EstouraException();

        if(Peixe.isBlank()){ EE.RaiseException("Escreva quais peixes estarão neste tanque."); }
        if(Volume < 0){ EE.RaiseException("Valor de volume inválido."); }
    }
}
