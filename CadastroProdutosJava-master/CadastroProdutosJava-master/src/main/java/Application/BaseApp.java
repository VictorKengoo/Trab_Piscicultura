package Application;

import Models.Entidade;
import Models.LogSecurity;
import Repository.Base.BaseRepository;
import Repository.LogSecurityRepository;

import java.util.Date;
import java.util.List;

public abstract class BaseApp<T extends Entidade> {

    private BaseRepository<T> _baseRepository;
    private LogSecurityRepository _logSecuriryRepository;

    public BaseApp() {
        _baseRepository = new BaseRepository<T>();

        _logSecuriryRepository = new LogSecurityRepository();
    }

    public T Adicionar(T entity) throws Exception {
        if (entity == null) {
            throw new Exception("Entidade nula");
        }

        entity.validar();
        _baseRepository.add(entity);
        registerLog("Adicionou", entity);
        return entity;
    }

    public T getById(int id) throws Exception {
        T entity = _baseRepository.getById(id);
        registerLog("Buscou(" + id + ")", entity);
        return entity;
    }

    public List<T> getAll(Class<T> entity) {
        return _baseRepository.list(entity);
    }

    private void registerLog(String acao, T entity) {
        LogSecurity logSecurity = new LogSecurity();
        logSecurity.setAcao(acao + " " + entity.getClass().getSimpleName());
        logSecurity.setFuncionario(Session.getInstance().getFuncionarioLogado());
        logSecurity.setData(new Date());
        _logSecuriryRepository.add(logSecurity);
    }
}
