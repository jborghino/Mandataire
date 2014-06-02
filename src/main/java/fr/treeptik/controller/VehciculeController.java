package fr.treeptik.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Client;
import fr.treeptik.model.Pub;
import fr.treeptik.model.Vehicule;
import fr.treeptik.service.ClientService;
import fr.treeptik.service.PubService;
import fr.treeptik.service.VehiculeService;
import fr.treeptik.service.impl.MailServiceImpl;
import fr.treeptik.utils.PDFUtil;


@Controller
@RequestMapping(value = "/vehicule")
public class VehciculeController {

	
	@Autowired
	private VehiculeService vehiculeService;
	@Autowired
	private PubService pubService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private MailServiceImpl mailService;
	
	@RequestMapping(value = "/init.do", method = RequestMethod.GET)
	public ModelAndView initVehicule() throws ServiceException {
		List<Vehicule> findAllVehicule = vehiculeService.findAll();
		List<Pub> findAllPub = pubService.findAll();
		ModelAndView modelAndView = new ModelAndView("vehicule/vehicule", "vehicules", findAllVehicule);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	public ModelAndView detailVehicule(Vehicule vehicule) throws ServiceException {
		ModelAndView modelAndView = new ModelAndView("vehicule/vehicule-detailed");
		
		Boolean isUpdate = false;

		if (vehicule.getId() == null) {
			vehicule = new Vehicule();
		} else {
			vehicule = vehiculeService.findById(vehicule.getId());
			isUpdate = true;
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("v", vehicule);
		map.put("isUpdate", isUpdate);

		modelAndView.addAllObjects(map);
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/order.do", method = RequestMethod.GET)
	public ModelAndView orderVehicule(Vehicule vehicule, Client client) throws ServiceException {
		ModelAndView modelAndView = new ModelAndView("vehicule/vehicule-ordered");
		
		Boolean isUpdate = false;

		if (vehicule.getId() == null) {
			vehicule = new Vehicule();
		} else {
			vehicule = vehiculeService.findById(vehicule.getId());
			isUpdate = true;
		}
		client = clientService.findById(client.getId());
		
		Map<String, Object> map = new HashMap<>();
		map.put("v", vehicule);
		map.put("cl", client);
		map.put("isUpdate", isUpdate);

		modelAndView.addAllObjects(map);
		
		PDFUtil pdfWriter = new PDFUtil();
		String attachmentPath = pdfWriter.createPDF(vehicule, client);
		String message = "Toute l'équipe de Mandataire Auto vous remerci pour votre confiance.\n" +
				"Veuillez trouver ci-joint un recapitulatif de votre commande.\n\n" +
				"En esperant avoir repondu à vos attentes.\n\n" +
				"Cordialement,\n" +
				"L'équipe Mandataire Auto";

		mailService.sendMail("User", message, attachmentPath);
		
		System.out.println(client);
		
		return modelAndView;
	}
	
}
