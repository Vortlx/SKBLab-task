package ru.skblab.testtask.registerform.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.skblab.testtask.registerform.dao.UserDAO;
import ru.skblab.testtask.registerform.entities.User;
import ru.skblab.testtask.registerform.services.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public Iterable<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userDAO.findById(id);
    }

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    public void delete(Integer id) {
        userDAO.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return userDAO.existsById(id);
    }
}
