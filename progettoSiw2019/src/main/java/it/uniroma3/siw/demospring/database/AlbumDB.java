package it.uniroma3.siw.demospring.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.demospring.model.Album;
import it.uniroma3.siw.demospring.model.Fotografo;
import it.uniroma3.siw.demospring.repository.AlbumRepository;
import it.uniroma3.siw.demospring.repository.FotografoRepository;

@Component
public class AlbumDB implements ApplicationRunner{

	@Autowired
	private FotografoRepository fotografoRepository;
	
	@Autowired
	private AlbumRepository albumRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.addAll();
	}
	
	
	private void addAll() {
		Fotografo p= new Fotografo("Francesco", "Bianchi", 1980);
		this.fotografoRepository.save(p);
		Fotografo q= new Fotografo("Maria", "Verdi", 1980);
		this.fotografoRepository.save(q);
		Fotografo r= new Fotografo("Daniele", "Rossi", 1980);
		this.fotografoRepository.save(r);
		
		Album a1 = new Album("Lapponia", p);
		Album a2 = new Album("Scozia", q);
		Album a3 = new Album("Italia", r);
		Album a4 = new Album("Spagna", r);
		Album a5 = new Album("Olanda", p);
		

		this.albumRepository.save(a1);
		this.albumRepository.save(a2);
		this.albumRepository.save(a3);
		this.albumRepository.save(a4);
		this.albumRepository.save(a5);



	}

	
	
}