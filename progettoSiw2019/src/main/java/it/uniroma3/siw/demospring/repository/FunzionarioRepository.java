package it.uniroma3.siw.demospring.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.demospring.model.Funzionario;

public interface FunzionarioRepository extends CrudRepository<Funzionario, Long>{
	
	public Funzionario findByUserName(String userName);
}
