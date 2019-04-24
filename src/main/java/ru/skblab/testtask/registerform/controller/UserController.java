package ru.skblab.testtask.registerform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.skblab.testtask.registerform.entities.User;
import ru.skblab.testtask.registerform.services.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = {RequestMethod.GET})
    public String getUserRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public String saveUser(@Valid @ModelAttribute("user")User user, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "registerForm";
        }
        userService.save(user);
        return "index";
    }

    @RequestMapping(value = "/user", method = {RequestMethod.GET})
    @ResponseBody
    public String getAllUsers(){
        return userService.findAll().toString();
    }

    @RequestMapping(value = "/user/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public String getAllUsers(@PathVariable("id") int userId){
        return userService.findById(userId).toString();
    }
}
