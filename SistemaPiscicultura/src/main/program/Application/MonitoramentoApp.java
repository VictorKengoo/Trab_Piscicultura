package Application;

import Models.Monitoramento;
import Repository.MonitoramentoRepository;


public class MonitoramentoApp extends BaseApp<Monitoramento> {

    private final MonitoramentoRepository _monitoramentoRepository;

    public MonitoramentoApp() {
        _monitoramentoRepository = new MonitoramentoRepository();
    }
}
