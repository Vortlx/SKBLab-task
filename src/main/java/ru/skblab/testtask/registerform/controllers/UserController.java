package ru.skblab.testtask.registerform.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import ru.skblab.testtask.messagingapi.entities.Message;
import ru.skblab.testtask.messagingapi.entities.Operation;
import ru.skblab.testtask.registerform.dto.UserFormDTO;
import ru.skblab.testtask.registerform.entities.User;
import ru.skblab.testtask.registerform.entities.UserRegisterStatus;
import ru.skblab.testtask.registerform.services.UserService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    @Value("${outersystemuri}")
    private String OUTER_SYSTEM_URI;

    @Value("${connectionTimeout}")
    private int CONNECTION_TIMEOUT;

    @Value("${readTimeout}")
    private int READ_TIMEOUT;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/register")
    public String getUserRegisterForm(Model model){
        model.addAttribute("user", new UserFormDTO());
        return "registerForm";
    }

    @PostMapping(value = "/register")
    public String saveUser(@Valid @ModelAttribute("user") UserFormDTO userFormDTO, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "registerForm";
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode userJson = mapper.convertValue(userFormDTO.getUser(), JsonNode.class);

        Message message = new Message(userJson, Operation.CHECKING);
        User user = userFormDTO.getUser();

        RestTemplate restTemplate = getRestTemplate(CONNECTION_TIMEOUT, READ_TIMEOUT);
        try{
            ResponseEntity response = restTemplate.postForEntity(OUTER_SYSTEM_URI, message, String.class);
            if(response.hasBody()){
                boolean userAccepted = Boolean.parseBoolean((String)response.getBody());
                if(userAccepted){
                    user.setUserRegisterStatus(UserRegisterStatus.ACCEPTED);
                } else {
                    user.setUserRegisterStatus(UserRegisterStatus.DENIED);
                }
            }
        } catch (RestClientException e){
            e.printStackTrace();
        } finally {
            userService.save(user);
            return "index";
        }
    }

    @GetMapping(value = "/user")
    @ResponseBody
    public Iterable<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping(value = "/user/{id}")
    @ResponseBody
    public Optional<User> getAllUsers(@PathVariable("id") int userId){
        return userService.findById(userId);
    }

    // ToDo Write via spring bean
    private RestTemplate getRestTemplate(int connectionTimeout, int readTimeout){
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(connectionTimeout);
        requestFactory.setReadTimeout(readTimeout);

        return new RestTemplate(requestFactory);
    }
}
