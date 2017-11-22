package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Diaria;
import br.edu.ifrs.canoas.jee.webapp.util.EntityManagerUtil;

public class DiariaDAO extends BaseDAO<Diaria, Long>{
	public List<Diaria> buscaPorData(Date data){
		em = EntityManagerUtil.getEM();
		List<Diaria> query = em.createQuery(
				"SELECT diaria FROM Diaria diaria WHERE diaria.data = :data", Diaria.class
				).setParameter("data", data)
				.getResultList();
		em.close();
		return query;
	}
}
