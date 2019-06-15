package it.uniroma3.siw.demospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.siw.demospring.model.Fotografia;
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
	
	
	@RequestMapping("/addFotografiaNelCarrello")
	public String addFotografiaNelCarrello(Model model, Fotografia fotografia) {
		model.addAttribute("fotografia", this.carrelloService.inserisciNelCarrello(fotografia));
		return "galleriaFoto";
	}
	
	@RequestMapping(value = "/carrello")
	public String carrello(@ModelAttribute Fotografia fotografia, Model model) {
		model.addAttribute("carrello", this.carrelloService.tutte());
		return "richiesta";
	}
}
