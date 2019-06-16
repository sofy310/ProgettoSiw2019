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

		
		Fotografia f1 = new Fotografia("Santa Claus village, Lapland, Napapijri", 
				"Questa fotografia è stata scattata al Circolo Polare Artico, "
				+ "nel villaggio di Santa Claus.",
				"12€", u1);
		Fotografia f2 = new Fotografia("Lapland, Napapijri",
				"Questa fotografia è stata scattata al Circolo Polare Artico, "
				+ "vicino al villaggio di Santa Claus.",
				"12€", u2);
		Fotografia f3 = new Fotografia("Arthur's Seat, Edimburgo", 
				"Questa fotografia è stata scattata sulla punta massima del gruppo"
				+ " di colline che fanno parte del Holyrood Park, "
				+ "un pezzo di paesaggio selvaggio al centro della città di Edimburgo.", 
				"13€", u3);
		Fotografia f4 = new Fotografia("Valle del Treja, Campagnano Romano", 
				"Questa fotografia è stata scattata nel parco regionale della"
				+ "Valle del treja, un'area protetta del lazio, "
				+ "dove le cascate rappresentate sono parte di un affluente di destra"
				+ "del fiume Tevere.", 
				"22€", u4);		
		Fotografia f5 = new Fotografia("Fotografia Barcellona", "piazza bla bla bla", "5€", u5);
		Fotografia f6 = new Fotografia("Fotografia Zaanse Schans", "mulini", "15€", u6);
		Fotografia f7 = new Fotografia("Fotografia Amsterdam", "castello bla bla", "30€", u7);
		
		
		
		this.fotografiaRepository.save(f1);
		this.fotografiaRepository.save(f2);
		this.fotografiaRepository.save(f3);
		this.fotografiaRepository.save(f4);
		this.fotografiaRepository.save(f5);
		this.fotografiaRepository.save(f6);
		this.fotografiaRepository.save(f7);


		
	}

	
	
}