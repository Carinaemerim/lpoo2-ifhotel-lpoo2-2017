package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.List;

import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaAvulsa;

public class DiariaAvulsaDAO extends BaseDAO<DiariaAvulsa, Long> {
	public List<DiariaAvulsa> listaDiariasAvulsas(){
		List<DiariaAvulsa> query = em.createQuery(
				"SELECT diaria FROM DiariaAvulsa diaria",
				DiariaAvulsa.class)
				.getResultList();
		em.close();
		
		return query;
	}
}
