
package it.uniroma3.siw.demospring.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.demospring.model.Album;
import it.uniroma3.siw.demospring.model.Fotografia;
import it.uniroma3.siw.demospring.model.Fotografo;
import it.uniroma3.siw.demospring.repository.AlbumRepository;
import it.uniroma3.siw.demospring.repository.FotografiaRepository;
import it.uniroma3.siw.demospring.repository.FotografoRepository;

@Component
public class FotografiaDB implements ApplicationRunner{
	
	@Autowired
	private FotografiaRepository fotografiaRepository;

	@Autowired
	private AlbumRepository albumRepository;
	

	@Autowired
	private FotografoRepository fotografoRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.addAll();
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
		String u8 = "/images/galleria/foto8.jpg";
		String u9 = "/images/galleria/foto9.jpg";
		String u10 = "/images/galleria/foto10.jpg";
		String u11= "/images/galleria/foto11.jpg";

		Fotografo p= new Fotografo("Francesco", "Bianchi", 1980);
		this.fotografoRepository.save(p);
		Fotografo q= new Fotografo("Maria", "Verdi", 1980);
		this.fotografoRepository.save(q);
		Fotografo r= new Fotografo("Daniele", "Rossi", 1980);
		this.fotografoRepository.save(r);
		
		Album a1 = new Album("Finlandia");
		Album a2 = new Album("Scozia");
		Album a3 = new Album("Italia");
		Album a4 = new Album("Spagna");
		Album a5 = new Album("Olanda");
		
		a1.setFotografo(p);
		a2.setFotografo(p);
		a3.setFotografo(q);
		a4.setFotografo(r);
		a5.setFotografo(r);
		
		this.albumRepository.save(a1);
		this.albumRepository.save(a2);
		this.albumRepository.save(a3);
		this.albumRepository.save(a4);
		this.albumRepository.save(a5);

		
		
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
		Fotografia f8 = new Fotografia("Fotografia Barcellona", "piazza bla bla", "30€", u8);
		Fotografia f9 = new Fotografia("Fotografia Helsinki", "piazza bla bla", "30€", u9);
		Fotografia f10 = new Fotografia("Fotografia Suomelinna", "piazza bla bla", "30€", u10);
		Fotografia f11 = new Fotografia("Fotografia Napapijri", "piazza bla bla", "30€", u11);

		f1.setAlbum(a1);
		f2.setAlbum(a1);
		f3.setAlbum(a2);
		f4.setAlbum(a3);
		f5.setAlbum(a4);
		f6.setAlbum(a5);
		f7.setAlbum(a5);
		f8.setAlbum(a5);
		f9.setAlbum(a1);
		f10.setAlbum(a1);
		f11.setAlbum(a1);

		
		f1.setFotografo(f1.getAlbum().getFotografo());
		f2.setFotografo(f2.getAlbum().getFotografo());
		f3.setFotografo(f3.getAlbum().getFotografo());
		f4.setFotografo(f4.getAlbum().getFotografo());
		f5.setFotografo(f5.getAlbum().getFotografo());
		f6.setFotografo(f6.getAlbum().getFotografo());
		f7.setFotografo(f7.getAlbum().getFotografo());
		f8.setFotografo(f8.getAlbum().getFotografo());
		f9.setFotografo(f9.getAlbum().getFotografo());
		f10.setFotografo(f10.getAlbum().getFotografo());
		f11.setFotografo(f11.getAlbum().getFotografo());



		this.fotografiaRepository.save(f1);
		this.fotografiaRepository.save(f2);
		this.fotografiaRepository.save(f3);
		this.fotografiaRepository.save(f4);
		this.fotografiaRepository.save(f5);
		this.fotografiaRepository.save(f6);
		this.fotografiaRepository.save(f7);
		this.fotografiaRepository.save(f8);
		this.fotografiaRepository.save(f9);
		this.fotografiaRepository.save(f10);
		this.fotografiaRepository.save(f11);
		
	}	
	
}