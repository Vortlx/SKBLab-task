package ru.skblab.testtask.registerform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import ru.skblab.testtask.registerform.services.UserService;

@SpringBootApplication
@ComponentScan("ru.skblab.testtask.registerform")
public class Main {

    @Autowired
    private UserService userService;

//    @EventListener
//    public void appReady(ApplicationReadyEvent event) {
//        User user = new User();
//
//        user.setLogin("123123");
//        user.setPassword("123123");
//        user.setEmail("SKBLab-Lebedev@yandex.ru");
//        user.setFio("Test");
//
//        userService.save(user);
//    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
