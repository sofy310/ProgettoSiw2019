package it.uniroma3.siw.demospring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.demospring.model.Fotografia;
import it.uniroma3.siw.demospring.repository.FotografiaRepository;

@Service
public class FotografiaService {
	
	@Autowired
	private FotografiaRepository fotografiaRepository;
	
	@Transactional
	public Fotografia inserisci(Fotografia fotografia) {
		return this.fotografiaRepository.save(fotografia);
	}
	
	@Transactional
	public List<Fotografia> tutte(){
		return (List<Fotografia>)this.fotografiaRepository.findAll();
	}
	
	@Transactional
	public Fotografia fotografiaPerId(Long id) {
		return this.fotografiaRepository.findById(id).get();
	}
}