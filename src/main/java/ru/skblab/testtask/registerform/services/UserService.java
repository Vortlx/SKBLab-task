package ru.skblab.testtask.registerform.services;

import ru.skblab.testtask.registerform.entities.User;

import java.util.Optional;

public interface UserService {

    Iterable<User> findAll();

    User findOneInUnknownState();

    void activateUser(User user, int connectionTimeout, int readTimeout, String outerSystemURI);

    Optional<User> findById(Integer id);

    User save(User user);

    void delete(User user);

    void delete(Integer id);

    boolean existsById(Integer id);
}
