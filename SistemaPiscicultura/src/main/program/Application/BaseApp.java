package Application;


import Models.Entidade;
import Repository.Base.BaseRepository;

import java.util.List;

public class BaseApp<T extends Entidade> {

    private BaseRepository<T> _baseRepository;

    public BaseApp() {
        _baseRepository = new BaseRepository<>();
    }

    public T Adicionar(T entity) throws Exception {
        if (entity == null) {
            throw new Exception("Entidade nula");
        }
        _baseRepository.add(entity);
        return entity;
    }

    public T getById(String tabela, int id) throws Exception {
        return _baseRepository.getById(tabela,id);
    }

    public void delete(T entity) throws Exception {
        _baseRepository.delete(entity);
    }

    public void update(T entity) throws Exception {
        entity.validar();
        _baseRepository.update(entity);
    }

    public List<T> getAll(Class<T> entity) {
        return _baseRepository.list(entity);
    }

    public List<T> getMonitoramentData(Class<T> entity, Integer id) { return _baseRepository.listData(entity, id); }
}
