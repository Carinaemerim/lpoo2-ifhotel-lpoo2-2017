package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Reserva extends BaseEntity<Long> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Date data;
	private double valor;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="pessoa_id")
	private Pessoa cliente;
	@OneToMany(mappedBy="reserva")
	private Collection<DiariaReservada> diariasReservadas;
	
	public Reserva(){
		
	}
	
	public Reserva(Date data, double valor){
		this.data = data;
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public Collection<DiariaReservada> getDiariasReservadas() {
		return diariasReservadas;
	}

	public void setDiariasReservadas(Collection<DiariaReservada> diariasReservadas) {
		this.diariasReservadas = diariasReservadas;
	}
}
