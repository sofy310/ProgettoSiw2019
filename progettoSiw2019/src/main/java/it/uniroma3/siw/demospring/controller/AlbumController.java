package it.uniroma3.siw.demospring.controller;

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
import it.uniroma3.siw.demospring.services.AlbumService;
import it.uniroma3.siw.demospring.validator.AlbumValidator;

@Controller
public class AlbumController {

	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private AlbumValidator albumValidator;
	
	@RequestMapping("/addAlbum")
	public String addAlbum(Model model) {
		model.addAttribute("album", new Album());
		return "albumForm.html";
	}
	
	@RequestMapping(value = "/album", method = RequestMethod.POST)
	public String newAlbum(@Valid@ModelAttribute Album album,
			Model model, BindingResult bindingResult) {
		this.albumValidator.validate(album, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.albumService.inserisci(album);
			model.addAttribute("listaAlbum", this.albumService.tutti());
			return "listaAlbum.html";
		}
		else {
			return "albumForm.html";
		}
	}
	
	@RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
	public String getAlbum(@PathVariable("id") Long id, Model model) {
		if(id!=null) {
			model.addAttribute("album", this.albumService.albumPerId(id));
			return "album.html";
		}
		else {
			model.addAttribute("listaAlbum", this.albumService.tutti());
			return "listaAlbum.html";
		}
	}
}
