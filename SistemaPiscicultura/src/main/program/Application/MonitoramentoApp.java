package Application;

import Models.Monitoramento;
import Repository.MonitoramentoRepository;


public class MonitoramentoApp extends BaseApp<Monitoramento> {

    private MonitoramentoRepository _monitoramentoRepository;

    public MonitoramentoApp() {
        _monitoramentoRepository = new MonitoramentoRepository();
    }
}
