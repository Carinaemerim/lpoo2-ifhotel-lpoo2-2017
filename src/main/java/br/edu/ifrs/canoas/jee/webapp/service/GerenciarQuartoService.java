package br.edu.ifrs.canoas.jee.webapp.service;

import java.util.List;
import java.util.logging.Logger;

import org.jboss.arquillian.core.api.annotation.Inject;

import br.edu.ifrs.canoas.jee.webapp.model.TipoDeQuarto;
import br.edu.ifrs.canoas.jee.webapp.model.dao.QuartoDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Quarto;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Usuario;

public class GerenciarQuartoService {

	@Inject
	private QuartoDAO quartoDAO;
	
	@Inject
	private Logger log;
	
	public List<Quarto> buscaNumero(String numero) {
		if (numero != null && numero.length() > 0) 
			return quartoDAO.buscaPorNumero(numero);
		else
			return quartoDAO.lista();
	}
	
	public List<Quarto> buscaTipo(TipoDeQuarto tipo) {
		if (tipo != null) 
			return quartoDAO.buscaPorTipo(tipo);
		else
			return quartoDAO.lista();
	}
}
