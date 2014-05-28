package fr.treeptik.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailSenderServiceImpl {

	@Autowired
    private MailSender mailSender;
     
    @Autowired
    private SimpleMailMessage preConfiguredMessage;
 
    /**
     * This method will send compose and send the message
     * */
    public void sendMail(String from, String to, String subject, String msg)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
        mailSender.send(message);
    }
 
    /**
     * This method will send a pre-configured message
     * */
    public void sendPreConfiguredMail(String message)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
	
}
