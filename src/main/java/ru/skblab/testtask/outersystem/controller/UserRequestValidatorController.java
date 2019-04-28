package ru.skblab.testtask.outersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.skblab.testtask.messagingapi.entities.Message;
import ru.skblab.testtask.outersystem.service.UserRequestValidator;

import java.util.Random;

@RestController
public class UserRequestValidatorController {

    private final UserRequestValidator userRequestValidatorService;

    @Autowired
    public UserRequestValidatorController(UserRequestValidator userRequestValidatorService) {
        this.userRequestValidatorService = userRequestValidatorService;
    }

    @PostMapping(name="/check/user")
    public Boolean checkNewUserRequest(@RequestBody Message input){
        // Some user validation logic

        if(shouldSleep()){
            try{
                Thread.sleep(10000);
            } catch (Exception e){}
        }

        return userRequestValidatorService.validateUserRequest();
    }

    private boolean shouldSleep(){
        return new Random().nextInt(10) <= 3;
    }
}
