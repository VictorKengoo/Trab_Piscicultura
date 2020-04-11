package Application;

import Models.Estoque;
import Repository.EstoqueRepository;


public class EstoqueApp extends BaseApp<Estoque> {

    private EstoqueRepository _estoqueRepository;

    public EstoqueApp() {
        _estoqueRepository = new EstoqueRepository();
    }
}
