package it.uniroma3.siw.demospring.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.demospring.model.Fotografia;
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

		
		FotografiaCarrello f1 = new FotografiaCarrello("Santa Claus village, Lapland, Napapijri", 
				"Questa fotografia è stata scattata al Circolo Polare Artico, "
				+ "nel villaggio di Santa Claus.",
				"12€", u1);
		FotografiaCarrello f2 = new FotografiaCarrello("Lapland, Napapijri",
				"Questa fotografia è stata scattata al Circolo Polare Artico, "
				+ "vicino al villaggio di Santa Claus.",
				"12€", u2);
		FotografiaCarrello f3 = new FotografiaCarrello("Arthur's Seat, Edimburgo", 
				"Questa fotografia è stata scattata sulla punta massima del gruppo"
				+ " di colline che fanno parte del Holyrood Park, "
				+ "un pezzo di paesaggio selvaggio al centro della città di Edimburgo.", 
				"13€", u3);
		
		this.carrelloRepository.save(f1);
		this.carrelloRepository.save(f2);
		this.carrelloRepository.save(f3);

		
	}

	
	
}