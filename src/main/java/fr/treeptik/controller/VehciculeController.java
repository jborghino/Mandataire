package fr.treeptik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Vehicule;
import fr.treeptik.service.VehiculeService;


@Controller
@RequestMapping(value = "/vehicule")
public class VehciculeController {

	
	@Autowired
	private VehiculeService vehiculeService;
	
	@RequestMapping(value = "/init.do", method = RequestMethod.GET)
	public ModelAndView initVehicule() throws ServiceException {
		List<Vehicule> findAll = vehiculeService.findAll();
		ModelAndView modelAndView = new ModelAndView("vehicule/vehicule", "vehicules", findAll);
		return modelAndView;
	}
	
}
