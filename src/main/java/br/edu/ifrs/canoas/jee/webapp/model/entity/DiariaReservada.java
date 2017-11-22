package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
public class DiariaReservada extends Diaria {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="reserva_id")
	private Reserva reserva;

	public DiariaReservada() {

	}
	
	public DiariaReservada(Date data){
		super(data);
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
}
