package it.uniroma3.siw.demospring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.demospring.model.Richiesta;
import it.uniroma3.siw.demospring.repository.RichiestaRepository;

@Service
public class RichiestaService {
	
	@Autowired
	private RichiestaRepository richiestaRepository;

	@Transactional
	public Richiesta inserisci(Richiesta richiesta) {
		return this.richiestaRepository.save(richiesta);
	}
	
	@Transactional
	public List<Richiesta> tutte(){
		return (List<Richiesta>)this.richiestaRepository.findAll();
	}

}