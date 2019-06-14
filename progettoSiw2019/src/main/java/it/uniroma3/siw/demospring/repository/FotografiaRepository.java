package it.uniroma3.siw.demospring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.demospring.model.Fotografia;

public interface FotografiaRepository extends CrudRepository<Fotografia, Long>{

	public List<Fotografia> findByNome(String nome);
}
