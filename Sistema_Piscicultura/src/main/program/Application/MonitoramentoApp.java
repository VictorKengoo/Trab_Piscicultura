package main.program.Application;

import main.program.Models.Monitoramento;
import main.program.Repository.MonitoramentoRepository;


public class MonitoramentoApp extends BaseApp<Monitoramento> {

    private MonitoramentoRepository _monitoramentoRepository;

    public MonitoramentoApp() {
        _monitoramentoRepository = new MonitoramentoRepository();
    }
}
