package it.uniroma3.siw.demospring.database;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.demospring.model.Fotografia;
import it.uniroma3.siw.demospring.repository.FotografiaRepository;
import it.uniroma3.siw.demospring.services.AlbumService;
import it.uniroma3.siw.demospring.services.FotografoService;

@Component
public class FotografiaDB implements ApplicationRunner{

	@Autowired
	private FotografoService fotografoService;
	
	@Autowired
	private AlbumService albumService;
	
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

		Fotografia f1 = new Fotografia("Lapponia", "tramonto");
		Fotografia f2 = new Fotografia("Lapponia", "Santa Claus Village");
		Fotografia f3 = new Fotografia("Edimburgo", "Arthur's Seat");
		Fotografia f4 = new Fotografia("Viterbo", "Valle del treja");		
		Fotografia f5 = new Fotografia("Barcellona", "piazza bla bla bla");
		Fotografia f6 = new Fotografia("Zaanse Schans", "mulini");
		Fotografia f7 = new Fotografia("Amsterdam", "castello bla bla");
		
		this.fotografiaRepository.save(f1);
		this.fotografiaRepository.save(f2);
		this.fotografiaRepository.save(f3);
		this.fotografiaRepository.save(f4);
		this.fotografiaRepository.save(f5);
		this.fotografiaRepository.save(f6);
		this.fotografiaRepository.save(f7);


		
	}

	
	
}