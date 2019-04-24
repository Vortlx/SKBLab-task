package ru.skblab.testtask.registerform.entities;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Size(min=6, max = 255)
    @Column(name="login", nullable = false, unique = true)
    private String login;

    @NotEmpty
    @Size(min=6, max = 255)
    @Column(name="password", nullable = false)
    private String password;

    @NotEmpty
    @Email
    @Column(name="email", nullable = false, unique = true)
    private String email;

    @NotEmpty
    @Size(min=6, max = 255)
    // Only one field because test project
    @Column(name="fio", nullable = false)
    private String fio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(fio, user.fio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email, fio);
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", login:'" + login + '\'' +
                ", password:'" + password + '\'' +
                ", email:'" + email + '\'' +
                ", fio:'" + fio + '\'' +
                '}';
    }
}
