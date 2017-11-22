package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.List;

import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaJuridica;
import br.edu.ifrs.canoas.jee.webapp.util.EntityManagerUtil;

public class PessoaJuridicaDAO extends BaseDAO<PessoaJuridica, Long> {
	public PessoaJuridica buscaPorCnpj(String cnpj){
		em = EntityManagerUtil.getEM();
		List<PessoaJuridica> pjs = em.createQuery(
				"SELECT pj FROM PessoaJuridica pj WHERE pj.cnpj = :cnpj", PessoaJuridica.class
				).setParameter("cnpj", cnpj)
				.getResultList();
		em.close();
		
		return (pjs.size() == 0) ? null : pjs.get(0);
	}
}
