package it.uniroma3.siw.demospring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.demospring.model.Fotografia;
import it.uniroma3.siw.demospring.repository.CarrelloRepository;

@Service
public class CarrelloService {

	@Autowired
	CarrelloRepository carrelloRepository;
	
	@Transactional
	public Fotografia inserisciNelCarrello(Fotografia fotografia) {
		return this.carrelloRepository.save(fotografia);
	}
	
	@Transactional
	public List<Fotografia> tutte() {
		return(List<Fotografia>)this.carrelloRepository.findAll();
	}
}
