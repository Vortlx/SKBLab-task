package ru.skblab.testtask.registerform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.skblab.testtask.registerform.entities.User;
import ru.skblab.testtask.registerform.services.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/registerUser", method = {RequestMethod.GET})
    public String getUserRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "registerForm";
    }
}
