package it.uniroma3.siw.demospring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Funzionario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String cognome;
	
	private String userName;
	
	private String password;
	
	@OneToMany
	@JoinColumn(name = "funzionario")
	private List<Cliente> richiesteClienti;

	public Funzionario(String nome, String cognome, String userName, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.userName = userName;
		this.password = password;
	}
	
	public Funzionario () {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Cliente> getRichiesteClienti() {
		return richiesteClienti;
	}

	public void setRichiesteClienti(List<Cliente> richiesteClienti) {
		this.richiesteClienti = richiesteClienti;
	}

	
}
