package it.uniroma3.siw.demospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getIndex() {
		return "index.html"; 
	}
	
	@RequestMapping(value="/getGalleria")
	public String getGalleria() {
		return "galleriaFoto";
	}

}
