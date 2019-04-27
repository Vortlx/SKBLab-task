package ru.skblab.testtask.mailsystem.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.skblab.testtask.mailsystem.entities.Email;

@Repository
public interface EmailDAO extends CrudRepository<Email, Integer> {
}
