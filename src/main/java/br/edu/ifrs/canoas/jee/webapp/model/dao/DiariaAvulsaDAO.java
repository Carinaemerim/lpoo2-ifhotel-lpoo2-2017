package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaAvulsa;

@Stateless
public class DiariaAvulsaDAO extends BaseDAO<DiariaAvulsa, Long> {
	
	private static final long serialVersionUID = 1L;

	public List<DiariaAvulsa> listaDiariasAvulsas(){
		List<DiariaAvulsa> query = em.createQuery(
				"SELECT diaria FROM DiariaAvulsa diaria",
				DiariaAvulsa.class)
				.getResultList();
		
		return query;
	}
}
