package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;

@Stateless
public class PessoaFisicaDAO extends BaseDAO<PessoaFisica, Long> {
	
	private static final long serialVersionUID = -1691949096247206266L;

	public PessoaFisica buscaPorDocumento(String documento){
		List<PessoaFisica> pfs;
		
		if(documento == null){
			return null;
		}
		
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
			
		return (pfs.size() == 0) ? null : pfs.get(0);
	}
}
