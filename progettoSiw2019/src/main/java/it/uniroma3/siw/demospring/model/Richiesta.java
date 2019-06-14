package it.uniroma3.siw.demospring.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Richiesta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private LocalDate data;
	
	private int numeroDiFoto;


	@OneToOne
	private Cliente cliente;

	@ManyToMany
	private List<Fotografia> fotografie;

	
	public Richiesta(Cliente cliente, List<Fotografia> fotografie) {
		this.data=LocalDate.now();
		this.cliente = cliente;
		this.fotografie = fotografie;
		this.numeroDiFoto = fotografie.size();
	}
	
	public Richiesta() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getNumeroDiFoto() {
		return numeroDiFoto;
	}

	public void setNumeroDiFoto(int numeroDiFoto) {
		this.numeroDiFoto = numeroDiFoto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Fotografia> getFotografie() {
		return fotografie;
	}

	public void setFotografie(List<Fotografia> fotografie) {
		this.fotografie = fotografie;
	}
	
	
}

	