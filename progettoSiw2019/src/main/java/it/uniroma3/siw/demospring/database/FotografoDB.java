package it.uniroma3.siw.demospring.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.demospring.model.Fotografo;
import it.uniroma3.siw.demospring.repository.FotografoRepository;

@Component
public class FotografoDB implements ApplicationRunner{

	@Autowired
	private FotografoRepository fotografoRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.deleteAll();
		this.addAll();
	}
	
	private void deleteAll() {
		System.out.print("Cancello tutto");
		fotografoRepository.deleteAll();
	}
	
	private void addAll() {
		System.out.print("Aggiungo fotografo");
		Fotografo p1 = new Fotografo("Mario", "Rossi", 1990);
		Fotografo p2 = new Fotografo("Giovanni", "Bianchi", 1996);
		Fotografo p3 = new Fotografo("Livia", "Verdi", 1982);
		fotografoRepository.save(p1);
		fotografoRepository.save(p2);
		fotografoRepository.save(p3);

	}

	
	
}