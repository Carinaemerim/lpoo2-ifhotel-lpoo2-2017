package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
public class DiariaAvulsa extends Diaria {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="pessoa_id")
	private Pessoa cliente;

	public DiariaAvulsa() {
		
	}
	
	public DiariaAvulsa(Date data){
		super(data);
	}
	
	public Pessoa getCliente(){
		return cliente;
	}
	
	public void setCliente(Pessoa cliente){
		this.cliente = cliente;
	}
}
