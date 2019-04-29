package ru.skblab.testtask.registerform.schedulers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.skblab.testtask.registerform.entities.User;
import ru.skblab.testtask.registerform.services.UserService;

@Component
public class UserActivateSchedule {

    @Value("${outersystemuri}")
    private String OUTER_SYSTEM_URI;

    @Value("${connectionTimeout}")
    private int CONNECTION_TIMEOUT;

    @Value("${readTimeout}")
    private int READ_TIMEOUT;

    private final UserService userService;

    public UserActivateSchedule(UserService userService) {
        this.userService = userService;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 10000)
    public void reportCurrentTime() {
        User user = userService.findOneInUnknownState();
        if(user != null){
            userService.activateUser(user, CONNECTION_TIMEOUT, READ_TIMEOUT, OUTER_SYSTEM_URI);
            userService.save(user);
        }
    }
}
