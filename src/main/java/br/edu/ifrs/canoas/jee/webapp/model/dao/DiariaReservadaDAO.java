package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.List;

import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaReservada;

public class DiariaReservadaDAO extends BaseDAO<DiariaReservada, Long> {
	public List<DiariaReservada> listaDiariasReservadas(){
		List<DiariaReservada> query = em.createQuery(
				"SELECT diaria FROM DiariaReservada diaria",
				DiariaReservada.class)
				.getResultList();
		em.close();
		
		return query;
	}
}
