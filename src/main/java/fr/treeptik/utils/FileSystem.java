package fr.treeptik.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.treeptik.service.impl.MailSenderServiceImpl;

@Component
public class FileSystem {

	@Autowired
	private MailSenderServiceImpl senderServiceImpl;
	
	public static String getPath(){
		return System.getProperty("user.dir");
	}
	
	public void sendMail() {
		System.out.println("envoi du mail...");
		senderServiceImpl.sendMail("a.alfonso25@laposte.net",
				"johan.borghino@gmail.com", "Vehicule vendu",
				"Votre vehicule a bien ete vendu");
	}
	
}
