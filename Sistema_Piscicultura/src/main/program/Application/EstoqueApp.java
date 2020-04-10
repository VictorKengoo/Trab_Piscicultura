package main.program.Application;

import main.program.Models.Estoque;
import main.program.Repository.EstoqueRepository;


public class EstoqueApp extends BaseApp<Estoque> {

    private EstoqueRepository _estoqueRepository;

    public EstoqueApp() {
        _estoqueRepository = new EstoqueRepository();
    }
}
