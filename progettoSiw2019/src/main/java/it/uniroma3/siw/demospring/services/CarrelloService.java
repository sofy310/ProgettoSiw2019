package it.uniroma3.siw.demospring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.demospring.model.Fotografia;
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
	
	@Transactional
	public void rimuoviFotografia(FotografiaCarrello fotografia) {
		List <FotografiaCarrello> fotografie = this.tutte();
		if (fotografie.contains(fotografia)) {
			fotografie.remove(fotografia);
		}else {
			System.out.println("Fotografia non trovata");	
		}
	}
	
	@Transactional
	public FotografiaCarrello findById(Long id) {
		return this.carrelloRepository.findById(id).get();
	}
	
}
