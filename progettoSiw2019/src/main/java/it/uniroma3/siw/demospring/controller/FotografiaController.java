package it.uniroma3.siw.demospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.demospring.model.Fotografia;
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
	
	@RequestMapping(value = "/addFotografiaNelCarrello/{id}")
	public String addFotografiaNelCarrello(@PathVariable("id") Long id, Model model) {
		if(id!=null) {
			Fotografia f = this.fotografiaService.fotografiaPerId(id);
			FotografiaCarrello fc = new FotografiaCarrello(f.getNome(), f.getDescrizione(), f.getUrl());
			this.carrelloService.inserisciNelCarrello(fc);
		}
		model.addAttribute("fotografie", this.fotografiaService.tutte());
		return "galleriaFoto";
	}
	
	@RequestMapping(value = "/vaiAlCarrello")
	public String carrello(Model model) {
			model.addAttribute("fotografieCarrello", this.carrelloService.tutte());
			return "carrello";
	}
}
