package main.program.Models.Enums;

import main.program.Interface.Telas.*;

import main.program.Models.EstadoStage;

public enum EnumEstadoStage {

    BEM_VINDO(new TelaBemVindo()),

    SOBRE(new TelaSobre()),

    LOGIN(new TelaLogin()),

    MENU(new TelaMenu()),

    GRAFICOS(new TelaGraficos());


    private final EstadoStage estadoMaquina;

    EnumEstadoStage(EstadoStage estadoMaquina) {
        this.estadoMaquina = estadoMaquina;
    }

    public EstadoStage getEstadoMaquina() {
        return estadoMaquina;
    }

}
