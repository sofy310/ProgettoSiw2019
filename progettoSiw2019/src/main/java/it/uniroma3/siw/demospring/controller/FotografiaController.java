package it.uniroma3.siw.demospring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.demospring.model.Fotografia;
import it.uniroma3.siw.demospring.services.FotografiaService;
import it.uniroma3.siw.demospring.validator.FotografiaValidator;

@Controller
public class FotografiaController {

	@Autowired
	FotografiaService fotografiaService;
	
	@Autowired
	FotografiaValidator fotografiaValidator;
	
	@RequestMapping("/addFotografia")
	public String addFotografia(Model model) {
		model.addAttribute("fotografia", new Fotografia());
		return "fotografiaForm";
	}
	
	@RequestMapping(value = "/fotografia", method = RequestMethod.POST)
	public String newFotografia(@Valid @ModelAttribute Fotografia fotografia, 
			Model model, BindingResult bindingResult) {
		this.fotografiaValidator.validate(fotografia, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.fotografiaService.inserisci(fotografia);
			model.addAttribute("fotografie", this.fotografiaService.tutte());
			return "fotografie";
		}
		else {
			return "fotografiaForm";
		}
	}
	
	@RequestMapping(value = "/fotografie", method = RequestMethod.GET)
	public String listaDiFotografie(Model model) {
		return "fotografie";
	}
}
