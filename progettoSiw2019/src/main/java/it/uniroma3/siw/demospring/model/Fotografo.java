package it.uniroma3.siw.demospring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fotografo {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String cognome;
	
	private int annoDiNascita;
	
	@OneToMany(mappedBy = "fotografo", cascade = CascadeType.ALL)
	private List<Fotografia> fotografie;
	
	@OneToMany(mappedBy = "fotografo", cascade = CascadeType.ALL)
	private List<Album> album;

	public Fotografo(String nome, String cognome, int annoDiNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.annoDiNascita = annoDiNascita;
	}
	
	public Fotografo() {
		
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

	public int getAnnoDiNascita() {
		return annoDiNascita;
	}

	public void setAnnoDiNascita(int annoDiNascita) {
		this.annoDiNascita = annoDiNascita;
	}

	public List<Fotografia> getFotografie() {
		return fotografie;
	}

	public void setFotografie(List<Fotografia> fotografie) {
		this.fotografie = fotografie;
        this.fotografie.forEach(x -> x.setFotografo(this));

	}

	public List<Album> getAlbum() {
		return album;
	}

	public void setAlbum(List<Album> album) {
		this.album = album;
        this.album.forEach(x -> x.setFotografo(this));

	}

}
