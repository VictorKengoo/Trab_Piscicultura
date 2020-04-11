package Application;

import Models.Peixe;
import Repository.PeixeRepository;

public class PeixeApp extends BaseApp<Peixe> {

    private PeixeRepository _peixeRepository;

    public PeixeApp() { _peixeRepository = new PeixeRepository();}
}
