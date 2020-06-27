package Application;

import Repository.EstoqueRepository;
import Models.Estoque;


public class EstoqueApp extends BaseApp<Estoque> {

    private EstoqueRepository _estoqueRepository;

    public EstoqueApp() {
        _estoqueRepository = new EstoqueRepository();
    }
}
