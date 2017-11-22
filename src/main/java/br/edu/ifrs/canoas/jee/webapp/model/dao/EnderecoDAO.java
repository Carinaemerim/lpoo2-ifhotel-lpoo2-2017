package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.List;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Endereco;

public class EnderecoDAO extends BaseDAO<Endereco, Long> {
	public List<Endereco> buscaPorCep(String cep){
		List<Endereco> query = em.createQuery(
				"SELECT endereco FROM Endereco endereco WHERE endereco.cep = :cep", Endereco.class
				).setParameter("cep", cep)
				.getResultList();
		em.close();
		return query;
	}
}