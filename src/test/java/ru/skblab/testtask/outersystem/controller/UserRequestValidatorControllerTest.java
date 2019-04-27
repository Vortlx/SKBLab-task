package ru.skblab.testtask.outersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.skblab.testtask.outersystem.service.UserRequestValidator;

@RestController
public class UserRequestValidatorControllerTest {

    private final UserRequestValidator userRequestValidatorService;

    @Autowired
    public UserRequestValidatorControllerTest(UserRequestValidator userRequestValidatorService) {
        this.userRequestValidatorService = userRequestValidatorService;
    }

    @RequestMapping(name="/check", method = {RequestMethod.GET})
    public Boolean checkNewUserRequest(){
        return userRequestValidatorService.validateUserRequest();
    }
}
