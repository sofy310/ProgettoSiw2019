package it.uniroma3.siw.demospring.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FotografiaCarrello {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String descrizione;
	
	private LocalDate data;
	
    private String url;
	
	@ManyToOne
	private Album album;
	
	@ManyToOne
	private Fotografo fotografo;

	public FotografiaCarrello(String nome, String descrizione, String url) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.url = url;
	}
	
	public FotografiaCarrello() {
		
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Fotografo getFotografo() {
		return fotografo;
	}

	public void setFotografo(Fotografo fotografo) {
		this.fotografo = fotografo;
	}

}
