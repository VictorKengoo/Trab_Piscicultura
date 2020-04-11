package Application;

import Models.Tanque;
import Repository.TanqueRepository;

public class TanqueApp extends BaseApp<Tanque> {

    private TanqueRepository _tanqueRepository;

    public TanqueApp() { _tanqueRepository = new TanqueRepository(); }
}