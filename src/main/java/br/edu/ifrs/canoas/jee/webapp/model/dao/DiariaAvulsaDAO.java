package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.List;

import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaAvulsa;
import br.edu.ifrs.canoas.jee.webapp.util.EntityManagerUtil;

public class DiariaAvulsaDAO extends BaseDAO<DiariaAvulsa, Long> {
	public List<DiariaAvulsa> listaDiariasAvulsas(){
		em = EntityManagerUtil.getEM();
		List<DiariaAvulsa> query = em.createQuery(
				"SELECT diaria FROM DiariaAvulsa diaria",
				DiariaAvulsa.class)
				.getResultList();
		em.close();
		
		return query;
	}
}
