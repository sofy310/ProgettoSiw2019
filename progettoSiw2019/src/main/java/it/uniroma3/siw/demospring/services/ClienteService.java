package it.uniroma3.siw.demospring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.demospring.model.Cliente;
import it.uniroma3.siw.demospring.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente inserisci(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	@Transactional
	public List<Cliente> tutti(){
		return (List<Cliente>)this.clienteRepository.findAll();
	}
	
	@Transactional
	public Cliente clientePerId(Long id) {
		return this.clienteRepository.findById(id).get();
	}
}
