package ru.skblab.testtask.registerform.dao;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.skblab.testtask.registerform.entities.User;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {

    @Query("select u from User u where u.userRegisterStatus = 'UNKNOWN'")
    User findInUnknownState();
}
