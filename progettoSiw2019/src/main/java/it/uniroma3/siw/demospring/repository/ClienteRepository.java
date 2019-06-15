package it.uniroma3.siw.demospring.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.demospring.model.Cliente;

public interface ClienteRepository  extends CrudRepository<Cliente, Long>{

}
