package it.uniroma3.siw.demospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.siw.demospring.model.FotografiaCarrello;
import it.uniroma3.siw.demospring.services.CarrelloService;
import it.uniroma3.siw.demospring.services.FotografiaService;
import it.uniroma3.siw.demospring.validator.FotografiaValidator;

@Controller
public class FotografiaController {

	@Autowired
	FotografiaService fotografiaService;
	
	@Autowired
	CarrelloService carrelloService;
	
	@Autowired
	FotografiaValidator fotografiaValidator;
	
	@RequestMapping(value="/getGalleria")
	public String getGalleria(Model model) {
		model.addAttribute("fotografie", this.fotografiaService.tutte());
		model.addAttribute("carrello", new FotografiaCarrello());
		return "galleriaFoto";
	}
	
	@RequestMapping(value = "/addFotografiaNelCarrello")
	public String addFotografiaNelCarrello(@ModelAttribute Model model, FotografiaCarrello fotografiaCarrello) {
		this.carrelloService.inserisciNelCarrello(fotografiaCarrello);
		model.addAttribute("fotografiaCarrello", fotografiaCarrello);
		model.addAttribute("fotografie", this.fotografiaService.tutte());
		return "galleriaFoto";
	}
	
	@RequestMapping(value = "/carrello")
	public String carrello() {
			return "carrello";
	}
}
