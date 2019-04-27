package ru.skblab.testtask.mailsystem.services;

import ru.skblab.testtask.mailsystem.entities.Email;

import java.util.Optional;
import java.util.concurrent.TimeoutException;

public interface EmailService {
    void send(Email email) throws TimeoutException;

    Iterable<Email> findAll();

    Optional<Email> findById(Integer id);

    Email save(Email email);

    void delete(Email email);

    void delete(Integer id);

    boolean existsById(Integer id);
}
