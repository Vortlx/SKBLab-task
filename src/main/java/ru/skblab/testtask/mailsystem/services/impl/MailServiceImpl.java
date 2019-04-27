package ru.skblab.testtask.mailsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.skblab.testtask.mailsystem.dao.EmailDAO;
import ru.skblab.testtask.mailsystem.entities.Email;
import ru.skblab.testtask.mailsystem.services.EmailService;

import java.util.Optional;
import java.util.concurrent.TimeoutException;

@Service
public class MailServiceImpl implements EmailService {

    private final EmailDAO emailDAO;

    private final JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String username;

    @Autowired
    public MailServiceImpl(JavaMailSender emailSender, EmailDAO emailDAO) {
        this.emailSender = emailSender;
        this.emailDAO = emailDAO;
    }

    @Override
    public void send(Email email) throws TimeoutException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getText());

        emailSender.send(message);
    }

    @Override
    public Iterable<Email> findAll() {
        return emailDAO.findAll();
    }

    @Override
    public Optional<Email> findById(Integer id) {
        return emailDAO.findById(id);
    }

    @Override
    public Email save(Email email) {
        return emailDAO.save(email);
    }

    @Override
    public void delete(Email email) {
        emailDAO.delete(email);
    }

    @Override
    public void delete(Integer id) {
        emailDAO.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return emailDAO.existsById(id);
    }
}
