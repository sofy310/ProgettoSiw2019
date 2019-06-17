package it.uniroma3.siw.demospring.database;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class FotografoDB implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.addAll();
	}
	
	
	private void addAll() {
		

	}

	
	
}