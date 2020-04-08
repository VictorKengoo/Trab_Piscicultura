package Application;

import Models.Produto;
import Repository.ProdutoRepository;

public class ProdutoApp extends BaseApp<Produto> {

    private ProdutoRepository _produtoRepository;

    public ProdutoApp() {
        _produtoRepository = new ProdutoRepository();
    }
}
