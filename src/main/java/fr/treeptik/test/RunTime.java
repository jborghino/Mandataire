package fr.treeptik.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.treeptik.model.Client;
import fr.treeptik.model.Vehicule;
import fr.treeptik.service.ClientService;
import fr.treeptik.utils.PDFUtil;

@Component
public class RunTime {

	@Autowired
	private static ClientService clientService;


	public static void main(String[] args) {
		PDFUtil pdfUtil = new PDFUtil();
		Vehicule vehicule = new Vehicule();
		Client client = new Client();
		vehicule.setMarque("TEST");
		vehicule.setModele("model");
		pdfUtil.createPDF(vehicule, client);
		
	}

}
