package main.program.Application;

import main.program.Models.Peixe;
import main.program.Repository.PeixeRepository;

public class PeixeApp extends BaseApp<Peixe> {

    private PeixeRepository _peixeRepository;

    public PeixeApp() { _peixeRepository = new PeixeRepository();}
}
