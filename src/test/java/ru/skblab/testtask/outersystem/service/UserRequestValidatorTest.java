package ru.skblab.testtask.outersystem.service;

import org.springframework.stereotype.Service;
import ru.skblab.testtask.outersystem.service.UserRequestValidator;

import java.util.Random;

@Service
public class UserRequestValidatorTest implements UserRequestValidator {

    @Override
    public boolean validateUserRequest() {
        return (new Random()).nextBoolean();
    }
}
