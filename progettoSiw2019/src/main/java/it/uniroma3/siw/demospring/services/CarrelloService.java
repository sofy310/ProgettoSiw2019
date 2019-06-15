package it.uniroma3.siw.demospring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.demospring.model.FotografiaCarrello;
import it.uniroma3.siw.demospring.repository.CarrelloRepository;

@Service
public class CarrelloService {

	@Autowired
	CarrelloRepository carrelloRepository;
	
	@Transactional
	public FotografiaCarrello inserisciNelCarrello(FotografiaCarrello fotografia) {
		return this.carrelloRepository.save(fotografia);
	}
	
	@Transactional
	public List<FotografiaCarrello> tutte() {
		return(List<FotografiaCarrello>)this.carrelloRepository.findAll();
	}
}
