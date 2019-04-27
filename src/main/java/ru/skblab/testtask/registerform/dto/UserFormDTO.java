package ru.skblab.testtask.registerform.dto;


import ru.skblab.testtask.registerform.entities.User;
import ru.skblab.testtask.registerform.validators.annotations.FieldMatch;

import javax.validation.GroupSequence;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@GroupSequence({First.class, Second.class, Third.class, UserFormDTO.class})
@FieldMatch.List({
        @FieldMatch(first = "confirmPassword", second = "password", message = "пароли не совпадают"),
})
public class UserFormDTO {

    @NotEmpty(groups = First.class)
    @Size(min=6, max = 255, groups = Second.class)
    private String login;

    @NotEmpty(groups = First.class)
    @Size(min=6, max = 255, groups = Second.class)
    private String password;

    private String confirmPassword;

    @NotEmpty(groups = First.class)
    @Email(groups = Third.class)
    private String email;

    @NotEmpty(groups = First.class)
    private String fio;

    public User getUser(){
        User user = new User();
        user.setId(null);
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setFio(fio);

        return user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
}

interface First {
}

interface Second {
}

interface Third {
}
