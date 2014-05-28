package fr.treeptik.controller;

import java.util.HashMap;
import java.util.Map;

import javax.management.relation.Role;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Client;
import fr.treeptik.service.ClientService;

@Controller
@RequestMapping(value = "/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	
	@RequestMapping(value = "/init.do", method = RequestMethod.GET)
	public ModelAndView initFormulaire(Client client) throws ServiceException {
		ModelAndView modelAndView = new ModelAndView("client/client");
		return modelAndView;
	}

	
	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public ModelAndView save(
			@ModelAttribute(value = "cl") @Valid Client client,
			BindingResult result) throws ServiceException {


		if (result.hasErrors()) {
			return new ModelAndView("client/client", "cl", client);
		}

		ModelAndView modelAndView = new ModelAndView("client/client-created");
		
		if(client.getId()==null){
			//récupere le role ROLE_USER avec l'id 1
			client = clientService.save(client);
		} else {
			client = clientService.update(client);

		}
		
		modelAndView.addObject("client", client);
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView list() throws ServiceException {
		ModelAndView modelAndView = new ModelAndView("client/list-client", "clients",
				clientService.findAll());
		return modelAndView;
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public ModelAndView delete(Client client) throws ServiceException {
		ModelAndView modelAndView = new ModelAndView("redirect:list.do");
		clientService.remove(client);
		return modelAndView;
	}
	
}
