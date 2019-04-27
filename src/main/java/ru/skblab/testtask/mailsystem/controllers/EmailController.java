package ru.skblab.testtask.mailsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.skblab.testtask.mailsystem.entities.Email;
import ru.skblab.testtask.mailsystem.services.EmailService;
import ru.skblab.testtask.registerform.services.UserService;

import java.util.Map;
import java.util.concurrent.TimeoutException;

@RestController
public class EmailController {

    private final UserService userService;

    private final EmailService emailService;

    @Autowired
    public EmailController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @PostMapping(value = "/sendEmail/user")
    public ResponseEntity<Integer> sendToUser(@RequestBody Map<String, String> emailInfo){
        Email email = new Email();

        // ToDo Use emilInfo for email subject and text
        email.setTo(emailInfo.get("to"));
        email.setSubject("Test");
        email.setText("Test");

        emailService.save(email);
        try{
            emailService.send(email);
            return new ResponseEntity<Integer>(email.getId(), HttpStatus.OK);
        } catch (TimeoutException e){
            return new ResponseEntity<Integer>(email.getId(), HttpStatus.REQUEST_TIMEOUT);
        }
    }
}
