package main.program.Models;

import java.util.Date;


public class Monitoramento extends Entidade{

    private int tanqueId;
    private double  temperatura;
    private double ph;
    private Date logData;

    @Override
    public void validar() throws Exception {

    }
}
