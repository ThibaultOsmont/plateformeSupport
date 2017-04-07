package fr.eni.nsy103.plateformeSupport.util.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.security.auth.login.AppConfigurationEntry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MailSubmissionController {

//    @RequestMapping("/mail")
//    @ResponseStatus(HttpStatus.CREATED)
    public String send() throws MessagingException{   
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    	ctx.register(MailConfiguration.class);
    	ctx.refresh();    	
    	JavaMailSenderImpl mailSender =  ctx.getBean(JavaMailSenderImpl.class);
    	MimeMessage mime = mailSender.createMimeMessage();
    	MimeMessageHelper mailMsg = new MimeMessageHelper(mime);
		mailMsg.setFrom("baptiste.rivalin@free.fr");
		mailMsg.setTo("baptiste.rivalin2016@campus-eni.fr");
		mailMsg.setSubject("TEST PlateformeSupport");
		mailMsg.setText("Hello World !");
		System.out.println("Mail sending ...");
		mailSender.send(mime);
		System.out.println("Mail send !");
		
    	ctx.close();
    	
    	MailConfiguration mc = new MailConfiguration();
    	mc.javaMailSender();
    	
        /*SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("vincent.louison2016@campus-eni.fr");
        mailMessage.setReplyTo("vincent.louison2016@campus-eni.fr");
        mailMessage.setFrom("baptiste.rivalin@gmail.com");
        mailMessage.setSubject("Test Envoi plateformeSupport");
        mailMessage.setText("Putain de merde ça marche !");
        javaMailSender.send(mailMessage);*/
        return "/adm";
    }
}