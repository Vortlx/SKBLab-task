package ru.skblab.testtask.registerform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.skblab.testtask.registerform.dto.UserFormDTO;
import ru.skblab.testtask.registerform.entities.User;
import ru.skblab.testtask.registerform.services.UserService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

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
        userService.save(userFormDTO.getUser());
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
