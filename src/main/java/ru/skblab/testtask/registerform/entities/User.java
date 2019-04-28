package ru.skblab.testtask.registerform.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="login", nullable = false, unique = true)
    private String login;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    // Only one field because test project
    @Column(name="fio", nullable = false)
    private String fio;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_Register_Status", nullable = false, columnDefinition = "varchar(255) default 'UNKNOWN'")
    private UserRegisterStatus userRegisterStatus = UserRegisterStatus.UNKNOWN;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public UserRegisterStatus getUserRegisterStatus() {
        return userRegisterStatus;
    }

    public void setUserRegisterStatus(UserRegisterStatus userRegisterStatus) {
        this.userRegisterStatus = userRegisterStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(fio, user.fio) &&
                userRegisterStatus == user.userRegisterStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email, fio, userRegisterStatus);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fio='" + fio + '\'' +
                ", userRegisterStatus=" + userRegisterStatus +
                '}';
    }
}
