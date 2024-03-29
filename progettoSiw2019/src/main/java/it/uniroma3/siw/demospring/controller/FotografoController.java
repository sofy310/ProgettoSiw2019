package it.uniroma3.siw.demospring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.demospring.model.Fotografo;
import it.uniroma3.siw.demospring.services.FotografoService;
import it.uniroma3.siw.demospring.validator.FotografoValidator;

@Controller
public class FotografoController {

	@Autowired
	FotografoService fotografoService;
	
	@Autowired
	FotografoValidator fotografoValidator;
	
	@RequestMapping("/addFotografo")
	public String addFotografo(Model model) {
		model.addAttribute("fotografo", new Fotografo());
		return "fotografoForm";
		
	}
	
	@RequestMapping(value = "/fotografo", method = RequestMethod.POST)
	public String newFotografo(@Valid @ModelAttribute Fotografo fotografo, 
			Model model, BindingResult bindingResult) {
		this.fotografoValidator.validate(fotografo, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.fotografoService.inserisci(fotografo);
			model.addAttribute("fotografi", this.fotografoService.tutti());
			return "fotografi";
		}
		else {
			return "fotografoForm";
		}
	}
	

	
	@RequestMapping(value = "/fotografo/{id}", method = RequestMethod.GET)
	public String getFotografo(@PathVariable("id") Long id, Model model) {
		if(id!=null) {
			model.addAttribute("fotografo", this.fotografoService.fotografoPerId(id));
			return "fotografo.html";
		}
		else {
			model.addAttribute("fotografi", this.fotografoService.tutti());
			return "fotografi.html";
		}
	}
	
	@RequestMapping("/cercaFotografo")
	public String cercaFotografo(Model model) {
		model.addAttribute("fotografo", new Fotografo());
		return "cercaFotografoPerNome";
		
	}
	
	@RequestMapping(value = "/fotografoPerNome", method = RequestMethod.POST)
	public String fotografoPerNome(@Valid @ModelAttribute Fotografo fotografo, 
			Model model, BindingResult bindingResult) {
		this.fotografoValidator.validate(fotografo, bindingResult);
		List<Fotografo> fotografi = new ArrayList<>();

			for (Fotografo f : this.fotografoService.tutti()) {
				if(fotografo.getNome().equals(f.getNome())) {
					fotografi.add(f);
				}
			}
			
			if (fotografi.isEmpty()) {
				model.addAttribute("messaggio", "Non sono presenti Fotografi con "
						+ "questo nome.");
				return "cercaFotografoPerNome";
			}
			else {
				model.addAttribute("fotografi", fotografi);
				return "fotografi";				
			}

		}

	
	
}
