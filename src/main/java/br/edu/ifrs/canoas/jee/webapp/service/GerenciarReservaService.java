package br.edu.ifrs.canoas.jee.webapp.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.edu.ifrs.canoas.jee.webapp.model.dao.DiariaAvulsaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.dao.DiariaReservadaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.dao.PessoaFisicaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.dao.PessoaJuridicaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.dao.QuartoDAO;
import br.edu.ifrs.canoas.jee.webapp.model.dao.ReservaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaAvulsa;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Reserva;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Usuario;
import br.edu.ifrs.canoas.jee.webapp.util.Mensagens;

@Stateless
public class GerenciarReservaService {

	@Inject
	PessoaFisicaDAO pfDAO;
	
	@Inject
	PessoaJuridicaDAO pjDAO;
	
	@Inject 
	DiariaAvulsaDAO diariaAvulsaDAO;

	@Inject
	DiariaReservadaDAO diariaReservadaDAO;
	
	@Inject
	QuartoDAO quartoDAO;
	
	@Inject
	ReservaDAO reservaDAO;
	
	@Inject
	private Logger log;
	
	public boolean salvaReserva(Reserva reserva){
		log.info("Salvando reserva em "+reserva.getData());
	
		if(reserva.getId() != null){
			Mensagens.define(FacesMessage.SEVERITY_INFO, "Reserva.atualizada", reserva.getData());
			reservaDAO.atualiza(reserva);
			return true;
		}
		
		reservaDAO.insere(reserva);
		Mensagens.define(FacesMessage.SEVERITY_INFO, "Reserva.cadastrada", reserva.getData());
		log.info("Salva diária em " + reserva.getData() + " com id " + reserva.getId());
		return true;
	}
	
	public void exclui(Reserva reserva) {
		
		reservaDAO.exclui(reserva.getId());
		Mensagens.define(FacesMessage.SEVERITY_INFO, "Reserva.excluida",reserva.getData());
		log.info("Excluída reserva do dia "+reserva.getData()+" com id "+reserva.getId());
		
	}

	public Reserva get(Long id) {
		
		return reservaDAO.busca(id);
	}
	
	public List<Reserva> busca(){
		return reservaDAO.lista();
	}
	
	
	
}

