package main.program.Models;

import main.program.Interface.EstouraException;

public class Tanque extends Entidade{
    //Declarações
    private String Peixes;
    private double TempAtual;
    private double PHAtual;
    private double Volume;

    //getters
    public String getPeixesContidos() { return Peixes; }
    public double getTempAtual() { return TempAtual; }
    public double getPHAtual() { return PHAtual; }
    public double getVolume() { return Volume; }

    //setters
    public void setPeixesContidos(String peixesContidos) { this.Peixes = peixesContidos; }
    public void setTempAtual(double tempAtual) { this.TempAtual = tempAtual; }
    public void setPHAtual(double pHAtual) { this.PHAtual = pHAtual; }
    public void setVolume(double volume) { this.Volume = volume; }

    //Validações
    @Override
    public void validar() throws Exception {
        EstouraException EE = new EstouraException();

        if(Peixes.isBlank()){ EE.RaiseException("Escreva quais peixes estarão neste tanque."); }
        if(PHAtual < 0 || PHAtual > 14 ) { EE.RaiseException("Valor de pH inválido."); }
        if(Volume < 0){ EE.RaiseException("Valor de volume inválido."); }
    }
}
