package ru.skblab.testtask.registerform.services.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import ru.skblab.testtask.messagingapi.entities.Message;
import ru.skblab.testtask.messagingapi.entities.Operation;
import ru.skblab.testtask.registerform.Utils;
import ru.skblab.testtask.registerform.dao.UserDAO;
import ru.skblab.testtask.registerform.entities.User;
import ru.skblab.testtask.registerform.entities.UserRegisterStatus;
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
    public User findOneInUnknownState() {
        return userDAO.findInUnknownState();
    }

    @Override
    public void activateUser(User user, int connectionTimeout, int readTimeout, String outerSystemURI) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode userJson = mapper.convertValue(user, JsonNode.class);
        Message message = new Message(userJson, Operation.CHECKING);

        RestTemplate restTemplate = Utils.getRestTemplate(connectionTimeout, readTimeout);
        try{
            ResponseEntity response = restTemplate.postForEntity(outerSystemURI, message, String.class);
            if(response.hasBody()){
                boolean userAccepted = Boolean.parseBoolean((String)response.getBody());
                if(userAccepted){
                    user.setUserRegisterStatus(UserRegisterStatus.ACCEPTED);
                } else {
                    user.setUserRegisterStatus(UserRegisterStatus.DENIED);
                }
            }
        } catch (RestClientException e){}
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
