package it.uniroma3.siw.demospring.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.demospring.model.Fotografia;

public interface CarrelloRepository extends CrudRepository<Fotografia, Long>{

	
}
