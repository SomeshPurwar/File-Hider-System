package service;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class SendOTPService {
	public static void sendOTP(String email, String genOTP) {
		String to=email;
		String from="purwarsomesh@gmail.com";
		String host="smtp.gmail.com";
		Properties properties=System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", 465);
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "jdpsrfytdlwwcdwt");
            }
        });
		
		session.setDebug(true);
		
		try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Your OTP Code");

            // Now set the actual message
            message.setText("Your OTP is: " + genOTP);
            System.out.println("sending...");
            

            // Send message
            Transport.send(message);
            System.out.println("OTP sent successfully to " + email);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
		
		
	}
	

}
