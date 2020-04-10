package main.program.Application;

import main.program.Models.Tanque;
import main.program.Repository.TanqueRepository;

public class TanqueApp extends BaseApp<Tanque> {

    private TanqueRepository _tanqueRepository;

    public TanqueApp() { _tanqueRepository = new TanqueRepository(); }
}
