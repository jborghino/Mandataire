package fr.treeptik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.exception.ServiceException;


@Controller
@RequestMapping(value = "/home")
public class HomeController {

	
	@RequestMapping(value = "/init.do", method = RequestMethod.GET)
	public ModelAndView initHome() throws ServiceException {
		ModelAndView modelAndView = new ModelAndView("home/home");
		
		
		
		return modelAndView;
	}
	
}
