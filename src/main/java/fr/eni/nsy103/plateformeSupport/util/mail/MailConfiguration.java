package fr.eni.nsy103.plateformeSupport.util.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configurable
@PropertySource("classpath:mail.properties")
public class MailConfiguration {
	@Value("${mail.host}")
	private String host;
	@Value("${mail.port}")
	private int port;
	@Value("${mail.protocol}")
	private String protocol;
	@Value("${mail.username}")
	private String username;
	@Value("${mail.password}")
	private String password;
	@Value("${mail.smtp.auth}")
	private boolean authentification;
	@Value("${mail.smtp.starttls.enable")
	private String tlsEnable;
	@Value("${mail.smtp.quitwait}")
	private boolean quitWait;

    @Bean
    public JavaMailSender javaMailSender() {
    	System.out.println(System.getSecurityManager());
    	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    	System.out.println(System.getProperties().toString());
    	System.out.println(Session.getDefaultInstance(System.getProperties()));
    	mailSender.setSession(Session.getDefaultInstance(System.getProperties()));
    	System.out.println(mailSender.getSession().toString());
		mailSender.setHost("smtp.free.fr");
		mailSender.setPort(465);
		mailSender.setProtocol("smtp");
		//Set gmail email id
		mailSender.setUsername("baptiste.rivalin@free.fr");
		//Set gmail email password
		mailSender.setPassword("23/10/1996");
		Properties prop = mailSender.getJavaMailProperties();
		prop.put("mail.transport.protocol", "smtp");
    	prop.put("mail.smtp.port","465");
		prop.put("mail.smtp.auth", "true");
//		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.ssl.enable","true");
		prop.put("mail.debug", "true");
    	
//    	final String username = "baptiste.rivalin@gmail.com";
//        final String password = "85ea704b427";
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props,
//          new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//          });
//
//        try {
//
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("from@gmail.com"));
//            message.setRecipients(Message.RecipientType.TO,
//                InternetAddress.parse("to@gmail.com"));
//            message.setSubject("Testing Subject");
//            message.setText("Dear Mail Crawler,"
//                + "\n\n No spam to my email, please!");
//
//            Transport.send(message);
//
//            System.out.println("Done");
//
//        } 
//        catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
		return mailSender;
    }
}