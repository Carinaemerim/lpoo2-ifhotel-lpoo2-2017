package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import br.edu.ifrs.canoas.jee.webapp.model.TipoDeQuarto;

@Entity
public class Quarto extends BaseEntity<Long> implements Serializable{	
	private static final long serialVersionUID = 1L;

	private String numero;
	@Enumerated(EnumType.STRING)
	private TipoDeQuarto tipo;
	
	public Quarto(){
		
	}
	
	public Quarto(String numero, TipoDeQuarto tipo) {
		this.numero = numero;
		this.tipo = tipo;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public TipoDeQuarto getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoDeQuarto tipo){
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quarto other = (Quarto) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
}
