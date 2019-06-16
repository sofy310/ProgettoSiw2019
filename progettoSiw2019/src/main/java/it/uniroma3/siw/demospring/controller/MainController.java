package it.uniroma3.siw.demospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.demospring.model.FotografiaCarrello;
import it.uniroma3.siw.demospring.services.FotografiaService;
import it.uniroma3.siw.demospring.services.FotografoService;

@Controller
public class MainController {
	
	@Autowired
	FotografiaService fotografiaService;

	@Autowired
	FotografoService fotografoService;
		
	
		
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getIndex(Model model) {
		return "index.html"; 
	}
	
	@RequestMapping(value="/getGalleria")
	public String getGalleria(Model model) {
		model.addAttribute("fotografie", this.fotografiaService.tutte());
		model.addAttribute("carrello", new FotografiaCarrello());
		return "galleriaFoto";
	}
	
	@RequestMapping(value="/getFotografi")
	public String getFotografi(Model model) {
		model.addAttribute("fotografi", this.fotografoService.tutti());
		return "fotografi";
	}


}
