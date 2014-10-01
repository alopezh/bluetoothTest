package es.indra.movilidad.repository;

import java.util.List;

public interface Repository<T> {

    public void save(T object);

    public void remove(T object);

    public void removeById(long id);

    public void removeAll();

    public List<T> findAll();

    public T findById(long id);

    public long count();

}
