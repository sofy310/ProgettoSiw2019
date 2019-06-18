package it.uniroma3.siw.demospring.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.demospring.model.Funzionario;
import it.uniroma3.siw.demospring.repository.FunzionarioRepository;

@Service
public class FunzionarioService {
	
	@Autowired
	private FunzionarioRepository funzionarioRepository;
	
	@Transactional
	public Funzionario funzionarioByUsername(String userName) {
		return this.funzionarioRepository.findByUserName(userName);
	}

	public Funzionario inserisci(Funzionario funzionario) {
		return this.funzionarioRepository.save(funzionario);
	}

}