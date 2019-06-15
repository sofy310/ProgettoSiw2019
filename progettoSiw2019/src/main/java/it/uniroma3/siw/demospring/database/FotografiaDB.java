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

		String u1 = "/images/galleria/foto1.jpg";
		String u2 = "/images/galleria/foto2.jpg";
		String u3 = "/images/galleria/foto3.jpg";
		String u4 = "/images/galleria/foto4.jpg";
		String u5 = "/images/galleria/foto5.jpg";
		String u6 = "/images/galleria/foto6.jpg";
		String u7 = "/images/galleria/foto7.jpg";

		
		Fotografia f1 = new Fotografia("Lapponia", "tramonto", u1);
		Fotografia f2 = new Fotografia("Lapponia", "Santa Claus Village", u2);
		Fotografia f3 = new Fotografia("Edimburgo", "Arthur's Seat", u3);
		Fotografia f4 = new Fotografia("Viterbo", "Valle del treja", u4);		
		Fotografia f5 = new Fotografia("Barcellona", "piazza bla bla bla", u5);
		Fotografia f6 = new Fotografia("Zaanse Schans", "mulini", u6);
		Fotografia f7 = new Fotografia("Amsterdam", "castello bla bla", u7);
		
		
		
		this.fotografiaRepository.save(f1);
		this.fotografiaRepository.save(f2);
		this.fotografiaRepository.save(f3);
		this.fotografiaRepository.save(f4);
		this.fotografiaRepository.save(f5);
		this.fotografiaRepository.save(f6);
		this.fotografiaRepository.save(f7);


		
	}

	
	
}