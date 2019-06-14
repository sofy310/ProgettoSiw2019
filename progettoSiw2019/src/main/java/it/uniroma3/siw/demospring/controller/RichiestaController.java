package it.uniroma3.siw.demospring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.demospring.model.Richiesta;
import it.uniroma3.siw.demospring.services.RichiestaService;
import it.uniroma3.siw.demospring.validator.RichiestaValidator;

@Controller
public class RichiestaController {

	@Autowired
	RichiestaService richiestaService;
	
	@Autowired
	RichiestaValidator richiestaValidator;
	
	@RequestMapping("/addRichiesta")
	public String addRichiesta(Model model) {
		model.addAttribute("richiesta", new Richiesta());
		return "richiestaForm";
		
	}
	
	@RequestMapping(value = "/richiesta", method = RequestMethod.POST)
	public String newRichiesta(@Valid @ModelAttribute Richiesta richiesta, 
			Model model, BindingResult bindingResult) {
		this.richiestaValidator.validate(richiesta, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.richiestaService.inserisci(richiesta);
			model.addAttribute("richiesta", richiesta);
			return "richiesta";
		}
		else {
			return "richiestaForm";
		}
	}
}