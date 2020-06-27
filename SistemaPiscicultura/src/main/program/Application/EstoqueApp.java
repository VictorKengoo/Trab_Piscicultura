package Application;

import Models.Estoque;
import Repository.EstoqueRepository;


public class EstoqueApp extends BaseApp<Estoque> {

    private final EstoqueRepository _estoqueRepository;

    public EstoqueApp() {
        _estoqueRepository = new EstoqueRepository();
    }
}
