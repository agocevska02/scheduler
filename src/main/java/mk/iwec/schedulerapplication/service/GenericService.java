package mk.iwec.schedulerapplication.service;

import mk.iwec.schedulerapplication.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GenericService<T> {
    List<T> getAll();
    Optional<T> getById(UUID id);
    T save(T entity);
    Optional<T> update(UUID id,T entity);
    boolean delete(UUID id);
}
