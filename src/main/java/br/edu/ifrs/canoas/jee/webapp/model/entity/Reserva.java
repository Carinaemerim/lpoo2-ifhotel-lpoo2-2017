package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Reserva extends BaseEntity<Long> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Date data;
	private double valor;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="pessoa_id")
	private PessoaFisica cliente;
	
	@OneToOne
	private DiariaReservada diariaReservada;
	
	public DiariaReservada getDiariaReservada() {
		return diariaReservada;
	}


	public void setDiariaReservada(DiariaReservada diariaReservada) {
		this.diariaReservada = diariaReservada;
	}


	@Transient
	public String getNumeroQuarto(){
		
		if(diariaReservada == null){
			return null;
		}
		
		
		
		if(diariaReservada.getQuarto() == null){
			return null;
		}
		
		return diariaReservada.getQuarto().getNumero();
	}
	

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

	public PessoaFisica getCliente() {
		return cliente;
	}

	public void setCliente(PessoaFisica cliente) {
		this.cliente = cliente;
	}

}
