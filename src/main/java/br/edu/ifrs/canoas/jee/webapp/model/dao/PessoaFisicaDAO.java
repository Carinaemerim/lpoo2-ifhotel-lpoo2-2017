package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.List;

import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;

public class PessoaFisicaDAO extends BaseDAO<PessoaFisica, Long> {
	public PessoaFisica buscaPorDocumento(String documento){
		List<PessoaFisica> pfs;
		
		if(documento.length() == 11){
			pfs = em.createQuery(
					"SELECT pf FROM PessoaFisica pf WHERE pf.cpf = :cpf", PessoaFisica.class
					).setParameter("cpf", documento)
					.getResultList();
		}else{
			pfs = em.createQuery(
					"SELECT pf FROM PessoaFisica pf WHERE pf.rg = :rg", PessoaFisica.class
					).setParameter("rg", documento)
					.getResultList();
		}
		
		em.close();
		
		return (pfs.size() == 0) ? null : pfs.get(0);
	}
}
