package it.uniroma3.siw.demospring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.demospring.model.Funzionario;
import it.uniroma3.siw.demospring.services.FunzionarioService;
import it.uniroma3.siw.demospring.validator.FunzionarioValidator;

@Controller
public class LoginController {
	
	@Autowired
	private FunzionarioService funzionarioService;
	@Autowired
	private FunzionarioValidator funzionarioValidator;

	@RequestMapping(value = "/loginController", method = RequestMethod.POST)
	public String controllaCredenziali(
			@Valid @ModelAttribute("funzionario") Funzionario funzionario, 
			Model model, BindingResult bindingResult) {
		this.funzionarioValidator.validate(funzionario, bindingResult);
		if(!bindingResult.hasErrors()) {
			
			Funzionario funzionarioNelDB = this.funzionarioService.funzionarioByUsername(funzionario.getUserName());
			if((funzionarioNelDB!=null)&&(funzionario.checkPassword(funzionarioNelDB))) {
				return "funzionarioHome";
			}
		}
		model.addAttribute("funzionario", funzionario);
		model.addAttribute("datiErrati","I dati inseriti non sono corretti");
		return "funzionarioLogin";	
		
	}
}