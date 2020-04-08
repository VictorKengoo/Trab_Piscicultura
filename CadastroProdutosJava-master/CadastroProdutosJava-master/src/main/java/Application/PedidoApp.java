package Application;

import Models.Pedido;
import Repository.PedidoRepository;

public class PedidoApp extends BaseApp<Pedido> {
    private PedidoRepository _pedidoRepository;

    public PedidoApp() {
        _pedidoRepository = new PedidoRepository();
    }

    public String imprimirPedido(int id) throws Exception {

        Pedido pedido = _pedidoRepository.getById(id);
        if (pedido != null) {
            return pedido.toString();
        }

        throw new Exception("Não existe o pedido");
    }
}
