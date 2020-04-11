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

        entity.validar();
        _baseRepository.add(entity);
        return entity;
    }

    public T getById(int id) throws Exception {
        return _baseRepository.getById(id);
    }

    public void delete(Class<T> entity,int id) throws Exception {
        _baseRepository.delete(entity,id);
    }

    public void update(T entity) {
        _baseRepository.update(entity);
    }

    public List<T> getAll(Class<T> entity) {
        return _baseRepository.list(entity);
    }
}
