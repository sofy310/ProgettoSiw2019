package it.uniroma3.siw.demospring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.demospring.model.Fotografo;
import it.uniroma3.siw.demospring.repository.FotografoRepository;

@Service
public class FotografoService {
	
	@Autowired
	private FotografoRepository fotografoRepository;
	
	@Transactional
	public Fotografo inserisci(Fotografo fotografo) {
		return this.fotografoRepository.save(fotografo);
	}
	
	@Transactional
	public List<Fotografo> tutti(){
		return (List<Fotografo>)this.fotografoRepository.findAll();
	}
	
	@Transactional
	public Fotografo fotografoPerId(Long id) {
		return this.fotografoRepository.findById(id).get();
	}
	
	@Transactional
	public List<Fotografo> fotografoPerNome(String nome){
		return this.fotografoRepository.findByNome(nome);
	}
}
