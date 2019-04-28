package ru.skblab.testtask.mailsystem.entities;

import javax.persistence.*;
import java.util.Objects;


// ToDo Create jar library
@Entity
@Table(name = "emails")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "to", nullable = false)
    private String to;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "text")
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email eMail = (Email) o;
        return id == eMail.id &&
                Objects.equals(to, eMail.to) &&
                Objects.equals(subject, eMail.subject) &&
                Objects.equals(text, eMail.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, to, subject, text);
    }

    @Override
    public String toString() {
        return "EMail{" +
                "id=" + id +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
