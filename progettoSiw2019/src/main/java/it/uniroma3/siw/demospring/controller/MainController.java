package it.uniroma3.siw.demospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.demospring.services.FotografiaService;

@Controller
public class MainController {
	
	@Autowired
	private FotografiaService fotografiaService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getIndex() {
		return "index.html"; 
	}
	
	@RequestMapping(value="/getGalleria")
	public String getGalleria(Model model) {
		model.addAttribute("fotografie", this.fotografiaService.tutte());
		return "galleriaFoto";
	}

}
