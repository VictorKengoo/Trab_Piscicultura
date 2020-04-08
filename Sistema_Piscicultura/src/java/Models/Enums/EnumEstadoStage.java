package java.Models.Enums;

import java.Interface.Telas.*;
import java.Models.EstadoStage;

public enum EnumEstadoStage {

    BEM_VINDO(new TelaBemVindo()),

    DEVS(new TelaSobre()),

    LOGIN(new TelaLogin()),

    MENU(new TelaMenu());


    private final EstadoStage estadoMaquina;

    EnumEstadoStage(EstadoStage estadoMaquina) {
        this.estadoMaquina = estadoMaquina;
    }

    public EstadoStage getEstadoMaquina() {
        return estadoMaquina;
    }

}
