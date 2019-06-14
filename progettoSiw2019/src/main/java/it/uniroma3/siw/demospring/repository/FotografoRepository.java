package it.uniroma3.siw.demospring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.demospring.model.Fotografo;

public interface FotografoRepository extends CrudRepository<Fotografo, Long>{

	public List<Fotografo> findByNome(String nome);
	
	public List<Fotografo> findByNomeAndCognome(String nome, String cognome);
}
