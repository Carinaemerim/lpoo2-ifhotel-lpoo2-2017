package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.Date;
import java.util.List;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Reserva;
import br.edu.ifrs.canoas.jee.webapp.util.EntityManagerUtil;

public class ReservaDAO extends BaseDAO<Reserva, Long>{
	public List<Reserva> buscaPorData(Date data){
		em = EntityManagerUtil.getEM();
		List<Reserva> query = em.createQuery(
				"SELECT reserva FROM Reserva reserva WHERE reserva.data = :data", Reserva.class
				).setParameter("data", data)
				.getResultList();
		em.close();
		return query;
	}
}
