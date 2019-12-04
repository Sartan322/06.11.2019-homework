package ru.kpfu.itis.db.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {
    void save(T model);
    void update(String login, String password, String name, String secondName, String information);
    void delete(String login, String password);
    Optional<T> find(String login, String password);
    Optional<T> find(ID id);
    boolean checkValidation(String login, String password);
/*
    String findCity(String id);
    String findUrl(String name);
*/

    List<T> findAll();
}