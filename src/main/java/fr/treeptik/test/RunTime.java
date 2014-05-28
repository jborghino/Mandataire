package fr.treeptik.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.treeptik.service.ClientService;
import fr.treeptik.service.impl.MailSenderServiceImpl;
import fr.treeptik.utils.FileSystem;

@Component
public class RunTime {

	@Autowired
	private static ClientService clientService;

	@Autowired
	private MailSenderServiceImpl senderServiceImpl;

	public static void main(String[] args) {
		
		FileSystem fileSystem = new FileSystem();
		fileSystem.sendMail();
		
	}

}
