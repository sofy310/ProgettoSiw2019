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

	}

	
	
}