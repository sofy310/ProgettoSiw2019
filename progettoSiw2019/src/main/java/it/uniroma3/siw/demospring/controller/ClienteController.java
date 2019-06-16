package it.uniroma3.siw.demospring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.demospring.model.Cliente;
import it.uniroma3.siw.demospring.services.ClienteService;
import it.uniroma3.siw.demospring.validator.ClienteValidator;

@Controller
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ClienteValidator clienteValidator;
	
	@RequestMapping("/addRichiesta")
	public String addCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "richiestaForm";
		
	}
	
	@RequestMapping(value = "/richiesta", method = RequestMethod.POST)
	public String newCliente(@Valid @ModelAttribute Cliente cliente, 
			Model model, BindingResult bindingResult) {
		this.clienteValidator.validate(cliente, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.clienteService.inserisci(cliente);
			model.addAttribute("cliente", cliente);
			return "richiesta";
		}
		else {
			return "richiestaForm";
		}
	}
	
	
}
