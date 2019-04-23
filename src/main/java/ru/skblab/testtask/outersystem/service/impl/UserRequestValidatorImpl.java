package ru.skblab.testtask.outersystem.service.impl;

import org.springframework.stereotype.Service;
import ru.skblab.testtask.outersystem.service.UserRequestValidator;

import java.util.Random;

@Service
public class UserRequestValidatorImpl implements UserRequestValidator {

    @Override
    public boolean validateUserRequest() {
        return (new Random()).nextBoolean();
    }
}
