package ru.skblab.testtask.messagingapi.services.impl;

import ru.skblab.testtask.messagingapi.entities.Message;
import ru.skblab.testtask.messagingapi.services.MessagingService;

import java.util.Random;
import java.util.concurrent.TimeoutException;


/**
 * Simple realisation because test task
 * */
public class MessagingServiceImpl implements MessagingService {

    @Override
    public int send(Message msg) {
        return (new Random()).nextInt();
    }

    @Override
    public Message receive(int messageId) throws TimeoutException {
        return null;
    }

    @Override
    public Message doRequest(Message request) throws TimeoutException {
        return null;
    }
}
