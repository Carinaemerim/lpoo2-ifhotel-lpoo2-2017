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
}

