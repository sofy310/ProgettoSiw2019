package it.uniroma3.siw.demospring.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.demospring.model.Album;
import it.uniroma3.siw.demospring.repository.AlbumRepository;

@Component
public class AlbumDB implements ApplicationRunner{

	@Autowired
	private AlbumRepository albumRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.deleteAll();
		this.addAll();
	}
	
	private void deleteAll() {
		System.out.print("Cancello tutto");
		albumRepository.deleteAll();
	}
	
	private void addAll() {
		System.out.print("Aggiungo album");
		Album a1 = new Album();
		Album a2 = new Album();
		Album a3 = new Album();
		albumRepository.save(a1);
		albumRepository.save(a2);
		albumRepository.save(a3);

	}

	
	
}