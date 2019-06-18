package it.uniroma3.siw.demospring.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.demospring.model.Funzionario;
import it.uniroma3.siw.demospring.services.FunzionarioService;

@Component
public class FunzionarioDB implements ApplicationRunner {
	
	@Autowired
	private FunzionarioService funzionarioService;
	
	private void addAll() {
		
		Funzionario funzionario1;
		Funzionario funzionario2;
		
		funzionario1 = addFunzionario("Tiziano", "Taroni", "tizianok10","88888");
		funzionario2 = addFunzionario("Sofia", "Perticarà", "sofy380","99999");
		
		this.funzionarioService.inserisci(funzionario1);
		this.funzionarioService.inserisci(funzionario2);
	
	}
	
	private Funzionario addFunzionario(String nome, String cognome, String userName, String password) {
		Funzionario f = new Funzionario();
		f.setNome(nome);
		f.setCognome(cognome);
		f.setUserName(userName);
		f.setPassword(password);
		return f;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.addAll();	
	}
	
}