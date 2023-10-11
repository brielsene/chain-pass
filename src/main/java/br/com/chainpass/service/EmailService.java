package br.com.chainpass.service;

import br.com.chainpass.model.dto.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public void sendMail(String emailRecipient, String messageBody){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(sender);
        EmailDetails emailDetails = setUpEmail(emailRecipient, messageBody);
        simpleMailMessage.setTo(emailDetails.getRecipient());
        simpleMailMessage.setText(emailDetails.getMessageBody());
        simpleMailMessage.setSubject(emailDetails.getSubject());

        javaMailSender.send(simpleMailMessage);

    }

    private EmailDetails setUpEmail(String emailRecipient, String messageBody){
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient(emailRecipient);
        emailDetails.setSubject("New Password has ben sucefully");
        emailDetails.setMessageBody(messageBody);
        return emailDetails;

    }


}
