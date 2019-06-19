package it.uniroma3.siw.demospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.siw.demospring.services.CarrelloService;

@Controller
public class CarrelloController {

	@Autowired
	private CarrelloService carrelloService;

	@RequestMapping("/rimuoviFotografia/{id}")
	public String rimuoviFotografiaDalCarrello(@PathVariable("id") Long id, Model model) {
		if (this.carrelloService.tutte().contains(this.carrelloService.findById(id))) {
			this.carrelloService.rimuoviFotografia(this.carrelloService.findById(id));
			if(this.carrelloService.tutte().isEmpty()) {
				return "carelloVuoto";
			}
			else {
				model.addAttribute("fotorgafieCarrello", this.carrelloService.tutte());
				return "carrello";
			}
		}
		else {
			model.addAttribute("fotorgafieCarrello", this.carrelloService.tutte());
			return "carrello";
		}
	}
}