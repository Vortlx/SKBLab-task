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
import ru.skblab.testtask.registerform.Utils;
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

        User user = userFormDTO.getUser();
        userService.activateUser(user, CONNECTION_TIMEOUT, READ_TIMEOUT, OUTER_SYSTEM_URI);
        userService.save(user);
        return "index";
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
}
