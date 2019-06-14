package it.uniroma3.siw.demospring.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.demospring.model.Fotografia;
import it.uniroma3.siw.demospring.repository.FotografiaRepository;

@Component
public class FotografiaDB implements ApplicationRunner{

	@Autowired
	private FotografiaRepository fotografiaRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.deleteAll();
		this.addAll();
	}
	
	private void deleteAll() {
		System.out.print("Cancello tutto");
		fotografiaRepository.deleteAll();
	}
	
	private void addAll() {
		System.out.print("Aggiungo fotografie");
		Fotografia f1 = new Fotografia();
		Fotografia f2 = new Fotografia();
		Fotografia f3 = new Fotografia();
		Fotografia f4 = new Fotografia();		
		Fotografia f5 = new Fotografia();
		Fotografia f6 = new Fotografia();
		Fotografia f7 = new Fotografia();
		Fotografia f8 = new Fotografia();
		Fotografia f9 = new Fotografia();
		Fotografia f10 = new Fotografia();
		fotografiaRepository.save(f1);
		fotografiaRepository.save(f2);
		fotografiaRepository.save(f3);
		fotografiaRepository.save(f4);		
		fotografiaRepository.save(f5);
		fotografiaRepository.save(f6);
		fotografiaRepository.save(f7);
		fotografiaRepository.save(f8);
		fotografiaRepository.save(f9);
		fotografiaRepository.save(f10);
	}

	
	
}