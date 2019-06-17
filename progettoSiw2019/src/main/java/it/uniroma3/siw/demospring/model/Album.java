package it.uniroma3.siw.demospring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Album {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	@OneToMany(mappedBy = "album")
	private List<Fotografia> fotografie;
	
	@ManyToOne
	private Fotografo fotografo;

	public Album(String nome, Fotografo fotografo) {
		this.nome = nome;
		this.fotografo = fotografo;
	}
	
	public Album() {
		
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

	public List<Fotografia> getFotografie() {
		return fotografie;
	}

	public void setFotografie(List<Fotografia> fotografie) {
		this.fotografie = fotografie;
	}

	public Fotografo getFotografo() {
		return fotografo;
	}

	public void setFotografo(Fotografo fotografo) {
		this.fotografo = fotografo;

	}
	
}
