package it.uniroma3.siw.demospring.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.demospring.model.FotografiaCarrello;
import it.uniroma3.siw.demospring.repository.CarrelloRepository;

@Component
public class CarrelloDB implements ApplicationRunner{
	
	@Autowired
	private CarrelloRepository carrelloRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.deleteAll();
		this.addAll();
	}
	
	private void deleteAll() {
		System.out.print("Cancello tutto");
		carrelloRepository.deleteAll();
	}
	
	private void addAll() {
		System.out.print("Aggiungo fotografie");

		String u1 = "/images/galleria/foto1.jpg";
		String u2 = "/images/galleria/foto2.jpg";
		String u3 = "/images/galleria/foto3.jpg";

		
		FotografiaCarrello f1 = new FotografiaCarrello("Lapponia", "tramonto", u1);
		FotografiaCarrello f2 = new FotografiaCarrello("Lapponia", "Santa Claus Village", u2);
		FotografiaCarrello f3 = new FotografiaCarrello("Edimburgo", "Arthur's Seat", u3);

		
		this.carrelloRepository.save(f1);
		this.carrelloRepository.save(f2);
		this.carrelloRepository.save(f3);

		
	}

	
	
}