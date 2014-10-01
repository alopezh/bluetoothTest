package es.indra.movilidad.repository;

import java.util.List;

import de.greenrobot.dao.AbstractDao;

public class BaseRepository<T> {

    protected AbstractDao<T, Long> dao;

    public BaseRepository(AbstractDao<T, Long> dao) {
        this.dao = dao;
    }

    public List<T> findAll() {
        return dao.loadAll();
    }

    public T findById(long id) {
        return dao.load(id);
    }

    public void save(T value) {
        dao.insertOrReplace(value);
    }

    public void remove(T object) {
        dao.delete(object);
    }

    public void removeById(long id) {
        dao.deleteByKey(id);
    }

    public void removeAll() {
        dao.deleteAll();
    }

    public long count() {
        return dao.count();
    }
}
