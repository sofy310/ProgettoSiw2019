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

import it.uniroma3.siw.demospring.model.Album;
import it.uniroma3.siw.demospring.model.Fotografia;
import it.uniroma3.siw.demospring.model.FotografiaCarrello;
import it.uniroma3.siw.demospring.services.AlbumService;
import it.uniroma3.siw.demospring.services.CarrelloService;
import it.uniroma3.siw.demospring.services.FotografiaService;
import it.uniroma3.siw.demospring.validator.FotografiaValidator;

@Controller
public class FotografiaController {

	@Autowired
	FotografiaService fotografiaService;
	
	@Autowired
	AlbumService albumService;
	
	@Autowired
	CarrelloService carrelloService;
	
	@Autowired
	FotografiaValidator fotografiaValidator;
	
	
	@RequestMapping(value = "/addFotografiaNelCarrello/{id}")
	public String addFotografiaNelCarrello(@PathVariable("id") Long id, Model model) {
		if(id!=null) {
			Fotografia f = this.fotografiaService.fotografiaPerId(id);
			FotografiaCarrello fc = new FotografiaCarrello(f.getNome(), f.getDescrizione(), f.getPrezzo(), f.getUrl());
			this.carrelloService.inserisciNelCarrello(fc);
			model.addAttribute("fotografie", this.fotografiaService.tutte());
			return "galleriaFoto";
		}
		else {
			model.addAttribute("fotografie", this.fotografiaService.tutte());
			return "galleriaFoto";
		}

	}
	
	@RequestMapping(value = "/paginaFotografia/{id}")
	public String paginaFotografia(@PathVariable("id") Long id, Model model) {
		if(id!=null) {
			Fotografia f = this.fotografiaService.fotografiaPerId(id);
			model.addAttribute("fotografia", f);
			return "fotografia";
		}
		else {
			model.addAttribute("fotografie", this.fotografiaService.tutte());
			return "galleriaFoto";
		}

	}
	
	@RequestMapping(value = "/ingrandimento/{id}")
	public String ingrandimentoFotografia(@PathVariable("id") Long id, Model model) {
		if(id!=null) {
			Fotografia f = this.fotografiaService.fotografiaPerId(id);
			model.addAttribute("fotografia", f);
			return "ingrandimentoFotografia";
		}
		else {
			model.addAttribute("fotografie", this.fotografiaService.tutte());
			return "listaAlbum";
		}

	}
	
	
	
	@RequestMapping(value = "/vaiAlCarrello", method = RequestMethod.GET)
	public String carrello(Model model) {
		if(this.carrelloService.tutte().isEmpty()) {
			//model.addAttribute("mex", "Il carrello è vuoto");
			return "carrelloVuoto";
		}
		else {
			model.addAttribute("fotografieCarrello", this.carrelloService.tutte());
			return "carrello";
		}

	}
	
	@RequestMapping("/cercaFotografia")
	public String cercaAlbum(Model model) {
		model.addAttribute("fotografia", new Fotografia());
		return "cercaFotografia";
		
	}
	
	@RequestMapping(value = "/fotografiaPerNome", method = RequestMethod.POST)
	public String fotografiaPerNome(@Valid @ModelAttribute Fotografia fotografia, 
			Model model, BindingResult bindingResult) {
		List<Fotografia> fotografie = new ArrayList<>();

			for (Fotografia f : this.fotografiaService.tutte()) {
				if(fotografia.getNome().equals(f.getNome())) {
					fotografie.add(f);
				}
			}
			
			if (fotografie.isEmpty()) {
				model.addAttribute("messaggio", "Non sono presenti Fotografie con "
						+ "questo nome.");
				return "cercaFotografia";
			}
			else {
				model.addAttribute("fotografie", fotografie);
				return "galleriaFoto";				
			}

		}

	@RequestMapping("/selezionaAlbum")
	public String selezionaFotografo(Model model) {
		model.addAttribute("listaAlbum", this.albumService.tutti());
		return "selezionaAlbum";
	}
	
	@RequestMapping(value = "/addFotografia")
	public String addFotografia(Model model, Album albumSelezionato) {
		Fotografia fotografia = new Fotografia();
		model.addAttribute("fotografia", fotografia);
		return "fotografiaForm";
	}
	
	@RequestMapping(value = "/fotografia", method = RequestMethod.POST)
	public String newFotografia(@Valid@ModelAttribute Fotografia fotografia,
			Model model, BindingResult bindingResult) {
		this.fotografiaValidator.validate(fotografia, bindingResult);
		if(!bindingResult.hasErrors()) {


			this.fotografiaService.inserisci(fotografia);
			model.addAttribute("fotografie", this.fotografiaService.tutte());
			return "fotografiaAggiunta";
		}
		else {
			return "fotografiaForm";
		}
	}

	@RequestMapping(value = "/albumSelezionato/{id}", method = RequestMethod.GET)
	public String selezionaAlbum(@PathVariable("id") Long id, Model model, 
			Fotografia fotografia) {
		if(id!=null) {
			Album albumSelezionato =  this.albumService.albumPerId(id);
			albumSelezionato.setId(this.albumService.albumPerId(id).getId());
			
			fotografia.setAlbum(albumSelezionato);
			fotografia.setFotografo(albumSelezionato.getFotografo());
			
			model.addAttribute("albumSelezionato", albumSelezionato);
			return "albumSelezionato";
		}
		else {
			model.addAttribute("listaAlbum", this.albumService.tutti());
			return "selezionaAlbum";
		}

	}
}
