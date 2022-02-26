package uz.master.demotest.utils;

// Java program to send email

import org.springframework.stereotype.Service;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;


@Service
public class SendEmail {
    public void sendEmail(String... args) {
        String recipient = args[0];
        Properties properties=System.getProperties();
        String host = "smtp.gmail.com";
        String sender = "ibook2025com@gmail.com";
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("ibook2025com@gmail.com","sokcrrlqangdxcmh");
                    }
                });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(recipient));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(sender));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setContent("<a href='localhost:8080/auth/reset/" +args[1]+ "'>"+args[1]+"</a>","text/html; charset=utf-8");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
