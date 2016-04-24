package br.univel.generics;

import java.util.List;

/**
 * Created by felipefrizzo on 4/24/16.
 */
public interface Dao<T, K> {
    public void save(T t);
    public T search(K k);
    public void update(T t);
    public void delete(K k);
    public List<T> listAll();
}
