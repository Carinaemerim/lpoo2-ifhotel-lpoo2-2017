package br.edu.ifrs.canoas.jee.webapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.jee.webapp.model.dao.DiariaReservadaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.dao.PessoaFisicaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.dao.PessoaJuridicaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.dao.QuartoDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaReservada;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaJuridica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Quarto;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Reserva;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarQuartoService;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarReservaService;

@Named
@RequestScoped
public class GerenciarReservaMB {

	@Inject
    private GerenciarReservaService gerenciarReservaService;
	
	@Inject
	private PessoaFisicaDAO pfDAO;
	
	@Inject
	private PessoaJuridicaDAO pjDAO;
	
	@Inject
	private DiariaReservadaDAO drDAO;
	
	@Inject
	private QuartoDAO qDAO;
	
	@Inject
	private Reserva reserva;
	
	@Inject
	private DiariaReservada diariaReservada;
	
	private List<Reserva> reservas = new ArrayList<Reserva>();
	
	private List<Quarto> quartos = new ArrayList<Quarto>();
	
	private List<PessoaFisica> pf = new ArrayList<PessoaFisica>();
	private List<PessoaJuridica> pj = new ArrayList<PessoaJuridica>();
	
	private String tipo;
	private boolean rendered = true;
	
	private Long pessoaFId;
	private Long pessoaJId;
	private Long quartoId;
	
	

	public String salva() {
		
		if(reserva.getId() != null){
			Long id = reserva.getDiariaReservada().getId();
			reserva.setDiariaReservada(null);
			drDAO.exclui(id);	
		}
		
		diariaReservada.setQuarto(qDAO.busca(quartoId));
		diariaReservada.setData(reserva.getData());
		drDAO.insere(diariaReservada);
		
		reserva.setDiariaReservada(diariaReservada);
		
		reserva.setCliente(pfDAO.busca(pessoaFId));
		
		if(pessoaJId != null){
			PessoaJuridica pessoaJ = pjDAO.busca(pessoaJId);
			reserva.setEmpresa(pessoaJ);
		}
		
		gerenciarReservaService.salvaReserva(reserva);
		
		diariaReservada.setReserva(reserva);
		drDAO.atualiza(diariaReservada);
		
		this.init();
		return limpa();
	}
		
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init() {
		reservas = gerenciarReservaService.busca();	
		quartos = qDAO.lista();
		pf = pfDAO.lista();
		pj = pjDAO.lista();
		
    }

	public void exclui() {
		gerenciarReservaService.exclui(reserva);
		this.init();
	}
	
	public void edita(Reserva reserva) {
		this.reserva = reserva;
		this.diariaReservada = reserva.getDiariaReservada();
		pessoaFId = reserva.getCliente().getId();
		quartoId = reserva.getDiariaReservada().getQuarto().getId();
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	public List<Reserva> getReservas() {
		return reservas;
	}
	
	public List<Quarto> getQuartos(){
		return quartos;
	}

	public void setReservas (List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	public void setQuartos (List<Quarto> quartos){
		this.quartos = quartos;
	}
	
	public void selectListener(){
		setRendered(getTipo().contains("PJ"));
	}
	
	public String limpa() {
		reserva = new Reserva();
		return "/public/reserva.jsf?facesRedirect=true";
	}

	public String getTipo(){
		return tipo;
	}
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}

	public boolean isRendered() {
		return rendered;
	}

	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}

	public List<PessoaFisica> getPf() {
		return pf;
	}

	public void setPf(List<PessoaFisica> pf) {
		this.pf = pf;
	}

	public List<PessoaJuridica> getPj() {
		return pj;
	}

	public void setPj(List<PessoaJuridica> pj) {
		this.pj = pj;
	}
	
	public Long getPessoaFId() {
		return pessoaFId;
	}

	public void setPessoaFId(Long pessoaFId) {
		this.pessoaFId = pessoaFId;
	}

	public Long getPessoaJId() {
		return pessoaJId;
	}

	public void setPessoaJId(Long pessoaJId) {
		this.pessoaJId = pessoaJId;
	}

	public Long getQuartoId() {
		return quartoId;
	}

	public void setQuartoId(Long quartoId) {
		this.quartoId = quartoId;
	}

	public DiariaReservada getDiariaReservada() {
		return diariaReservada;
	}

	public void setDiariaReservada(DiariaReservada diariaReservada) {
		this.diariaReservada = diariaReservada;
	}

	
}

	

