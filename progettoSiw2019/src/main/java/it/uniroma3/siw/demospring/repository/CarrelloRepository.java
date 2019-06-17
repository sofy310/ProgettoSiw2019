package it.uniroma3.siw.demospring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.demospring.model.Fotografia;
import it.uniroma3.siw.demospring.model.FotografiaCarrello;

public interface CarrelloRepository extends CrudRepository<FotografiaCarrello, Long>{

	public List <FotografiaCarrello> delete (Fotografia Fotografia);
}
