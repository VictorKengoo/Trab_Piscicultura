package Application;

import Models.Cliente;
import Repository.ClienteRepository;

public class ClienteApp extends BaseApp<Cliente> {

    private ClienteRepository _clienteRepository;

    public ClienteApp() {
        _clienteRepository = new ClienteRepository();
    }
}
