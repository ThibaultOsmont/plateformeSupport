package fr.eni.nsy103.plateformeSupport.util.mail;

import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class GmailSender {	  
	@RequestMapping("/mail")
    @ResponseStatus(HttpStatus.CREATED)
    public String send() throws AddressException, MessagingException {   		
		System.setProperty("http.proxyHost","proxy-sh.ad.campus-eni.fr");
		System.setProperty("http.proxyPort","8080");
		
		System.out.println(System.getProperty("http.proxyHost"));
		System.out.println(System.getProperty("http.proxyPort"));
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.ssl.enable","true");
		props.put("mail.debug", "true");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("baptiste.rivalin@gmail.com","85ea704b427");
				}
			});
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("baptiste.rivalin@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("baptiste.rivalin2016@campus-eni.fr"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler," +
					"\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			//throw new RuntimeException(e);
			e.printStackTrace();
		}
       
       return "/adm";
    }
 }
