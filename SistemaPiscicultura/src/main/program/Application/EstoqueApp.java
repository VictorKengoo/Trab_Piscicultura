package Application;

import Models.Estoque;
import Repository.EstoqueRepository;


public class EstoqueApp extends BaseApp<Estoque> {

    private EstoqueRepository _estoqueRepository;

    public EstoqueApp() {
        _estoqueRepository = new EstoqueRepository();
    }

    public void hasDuplicate(Estoque novo) throws Exception {
        Estoque existente = _estoqueRepository.getByName(novo);
        if (existente != null) {
            if ((novo.id != existente.id) && (novo.getMarca().toLowerCase().trim().equals(existente.getMarca().toLowerCase().trim()))) {
                throw new Exception("Já existe um registro com este nome.");
            }
        }
    }

    public Estoque getById(int id) throws Exception {
        return super.getById("Estoque", id);
    }

}
