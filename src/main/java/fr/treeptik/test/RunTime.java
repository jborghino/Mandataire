package fr.treeptik.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Client;
import fr.treeptik.model.Concessionnaire;
import fr.treeptik.model.Vehicule;
import fr.treeptik.service.ClientService;
import fr.treeptik.watcher.Watcher;

@Component
public class RunTime {

	@Autowired
	private static ClientService clientService;
	
	public static void main(String[] args) {
//		Watcher watcher = new Watcher();
//		
//		watcher.start();
		
		
//		System.out.println("test  :  " + FileSystem.getPath());
		
		Concessionnaire concessionnaire = new Concessionnaire();
		Vehicule vehicule = new Vehicule();
		Client client = new Client();
		client.setAdresse("adadadada");
		client.setMail("memmemememem");
		client.setNom("nononononm");
		client.setPrenom("prprprprpr");
		
		try {
			clientService.save(client);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}


	
}
