package br.edu.ifpb.padroes.repository;

import java.util.List;

public interface DAO<T, I> {
    public void add(T object);
    public void update(T object);
    public void delete(T object);
    public List<T> list();
    public T get(I id);
}
