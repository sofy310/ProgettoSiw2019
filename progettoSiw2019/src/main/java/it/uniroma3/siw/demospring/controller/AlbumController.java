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
import it.uniroma3.siw.demospring.model.Fotografo;
import it.uniroma3.siw.demospring.services.AlbumService;
import it.uniroma3.siw.demospring.services.FotografoService;
import it.uniroma3.siw.demospring.validator.AlbumValidator;

@Controller
public class AlbumController {

	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private AlbumValidator albumValidator;
	
	@Autowired
	private FotografoService fotografoService;
	
	@RequestMapping("/selezionaFotografo")
	public String selezionaFotografo(Model model) {
		model.addAttribute("fotografi", this.fotografoService.tutti());
		return "selezionaFotografo";
	}
	
	@RequestMapping("/addAlbum")
	public String addAlbum(Model model) {
		model.addAttribute("album", new Album());
		return "albumForm";
	}
	
	@RequestMapping(value = "/album", method = RequestMethod.POST)
	public String newAlbum(@Valid@ModelAttribute Album album,
			Model model, BindingResult bindingResult) {
		this.albumValidator.validate(album, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.albumService.inserisci(album);
			model.addAttribute("listaAlbum", this.albumService.tutti());
			return "listaAlbum";
		}
		else {
			model.addAttribute("fotografi", this.fotografoService.tutti());
			return "albumForm";
		}
	}
	
	@RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
	public String getAlbum(@PathVariable("id") Long id, Model model) {
		if(id!=null) {
			model.addAttribute("album", this.albumService.albumPerId(id));
			return "album";
		}
		else {
			model.addAttribute("listaAlbum", this.albumService.tutti());
			return "listaAlbum";
		}
	}
	
	@RequestMapping(value = "/fotografoSelezionato/{id}", method = RequestMethod.GET)
	public String selezionaFotografo(@PathVariable("id") Long id, Model model) {
		if(id!=null) {
			Fotografo fotografoSelezionato =  this.fotografoService.fotografoPerId(id);
			fotografoSelezionato.setId(this.fotografoService.fotografoPerId(id).getId());
			model.addAttribute("fotografoSelezionato", fotografoSelezionato);
			return "fotografoSelezionato";
		}
		else {
			model.addAttribute("fotografi", this.fotografoService.tutti());
			return "selezionaFotografo";
		}

	}
	
	@RequestMapping("/cercaAlbum")
	public String cercaAlbum(Model model) {
		model.addAttribute("album", new Album());
		return "cercaAlbum";
		
	}
	
	@RequestMapping(value = "/albumPerNome", method = RequestMethod.POST)
	public String albumPerNome(@Valid @ModelAttribute Album album, 
			Model model, BindingResult bindingResult) {
		List<Album> listaAlbum = new ArrayList<>();

			for (Album a : this.albumService.tutti()) {
				if(album.getNome().equals(a.getNome())) {
					listaAlbum.add(a);
				}
			}
			
			if (listaAlbum.isEmpty()) {
				model.addAttribute("messaggio", "Non sono presenti Album con "
						+ "questo nome.");
				return "cercaAlbum";
			}
			else {
				model.addAttribute("listaAlbum", listaAlbum);
				return "listaAlbum";				
			}

		}

	

}
