package it.uniroma3.siw.demospring.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.demospring.repository.FotografoRepository;

@Component
public class FotografoDB implements ApplicationRunner{

	@Autowired
	private FotografoRepository fotografoRepository;
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.addAll();
	}
	
	
	private void addAll() {
		System.out.print("Aggiungo fotografo");
		

	}

	
	
}