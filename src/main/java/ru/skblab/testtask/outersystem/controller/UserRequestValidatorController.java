package ru.skblab.testtask.outersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.skblab.testtask.messagingapi.entities.Message;
import ru.skblab.testtask.outersystem.service.UserRequestValidator;

@RestController
public class UserRequestValidatorController {

    private final UserRequestValidator userRequestValidatorService;

    @Autowired
    public UserRequestValidatorController(UserRequestValidator userRequestValidatorService) {
        this.userRequestValidatorService = userRequestValidatorService;
    }

    @RequestMapping(name="/check/user", method = {RequestMethod.GET})
    public Boolean checkNewUserRequest(@RequestBody Message input){

        return userRequestValidatorService.validateUserRequest();
    }
}
