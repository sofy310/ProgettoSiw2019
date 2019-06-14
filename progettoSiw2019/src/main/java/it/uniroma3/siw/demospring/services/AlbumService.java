package it.uniroma3.siw.demospring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.demospring.model.Album;
import it.uniroma3.siw.demospring.repository.AlbumRepository;

@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository albumRepository;
	
	@Transactional
	public Album inserisci(Album fotografo) {
		return this.albumRepository.save(fotografo);
	}
	
	@Transactional
	public List<Album> tutti(){
		return (List<Album>)this.albumRepository.findAll();
	}
	
	@Transactional
	public Album albumPerId(Long id) {
		return this.albumRepository.findById(id).get();
	}
}