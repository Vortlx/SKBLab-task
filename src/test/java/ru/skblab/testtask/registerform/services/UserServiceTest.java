package ru.skblab.testtask.registerform.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.skblab.testtask.registerform.dao.UserDAO;
import ru.skblab.testtask.registerform.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTest{

    @Autowired
    private UserService userService;

    @MockBean
    private UserDAO userDAO;

    private List<User> expUsers;

    @Before
    public void initUsers(){
        User user1 = new User();
        user1.setId(1);
        user1.setLogin("First");
        user1.setPassword("111");
        user1.setEmail("First@.test.com");
        user1.setFio("First");

        User user2 = new User();
        user2.setId(2);
        user2.setLogin("Second");
        user2.setPassword("222");
        user2.setEmail("Second@.test.com");
        user2.setFio("Second");

        User user3 = new User();
        user3.setId(3);
        user3.setLogin("Third");
        user3.setPassword("333");
        user3.setEmail("Third@.test.com");
        user3.setFio("Third");

        expUsers = new ArrayList<>();
        expUsers.add(user1);
        expUsers.add(user2);
        expUsers.add(user3);
    }

    @Test
    public void findAll() {
        when(userDAO.findAll()).thenReturn(expUsers);
        Iterable<User> users = userService.findAll();

        assertThat(users).containsOnly((User[]) expUsers.toArray(new User[expUsers.size()]));
    }

    @Test
    public void findById() {
        when(userDAO.findById(1)).thenReturn(Optional.of(expUsers.get(0)));
        when(userDAO.findById(2)).thenReturn(Optional.of(expUsers.get(1)));
        when(userDAO.findById(3)).thenReturn(Optional.of(expUsers.get(2)));
        when(userDAO.findById(4)).thenReturn(Optional.of(null));

        Optional<User> user = userService.findById(1);
        assertThat(user).isEqualTo(Optional.of(expUsers.get(0)));

        user = userService.findById(2);
        assertThat(user).isEqualTo(Optional.of(expUsers.get(1)));

        user = userService.findById(3);
        assertThat(user).isEqualTo(Optional.of(expUsers.get(2)));

        user = userService.findById(4);
        assertThat(user).isEqualTo(null);
    }

    @Test
    public void save() {
        User newUser = new User();
        newUser.setId(99);
        newUser.setLogin("NinetyNine");
        newUser.setPassword("99");
        newUser.setEmail("NinetyNine@.test.com");
        newUser.setFio("NinetyNine");

        when(userDAO.save(newUser));
        when(userDAO.findById(99)).thenReturn(Optional.of(newUser));
    }

    @Test
    public void delete() {
    }

    @Test
    public void delete1() {
    }

    @Test
    public void existsById() {
    }

}
