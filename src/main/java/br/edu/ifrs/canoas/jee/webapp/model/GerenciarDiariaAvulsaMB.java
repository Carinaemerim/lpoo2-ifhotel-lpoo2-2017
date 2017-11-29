package br.edu.ifrs.canoas.jee.webapp.model;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.jee.webapp.model.dao.PessoaFisicaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaAvulsa;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaJuridica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Quarto;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarDiariaAvulsaService;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarPessoaJuridicaService;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarQuartoService;

@Named
@RequestScoped
public class GerenciarDiariaAvulsaMB {	
	@Inject
    private GerenciarDiariaAvulsaService gerenciarDiariaAvulsaService;	
	@Inject
	private GerenciarQuartoService gerenciarQuartoService;	
	@Inject
	private GerenciarPessoaJuridicaService gerenciarPJService;	
	@Inject
	private DiariaAvulsa diariaAvulsa;
	@Inject
	private PessoaFisicaDAO pfDAO;
	
	private List<DiariaAvulsa> diariasAvulsas;
	private List<Quarto> quartos;
	private List<PessoaJuridica> pessoasJuridicas;
	private List<PessoaFisica> pessoasFisicas;
	
	private String tipo;
	private boolean rendered = false;
	
	public String salva() {
		gerenciarDiariaAvulsaService.salvaDiaria(diariaAvulsa);
		this.init();
		return limpa();
	}
	
	@PostConstruct
    public void init() {
		diariasAvulsas = gerenciarDiariaAvulsaService.busca();	
		quartos = gerenciarQuartoService.buscaNumero(null);
		pessoasJuridicas = gerenciarPJService.lista();
    }
	
	
	public void exclui() {
		gerenciarDiariaAvulsaService.exclui(diariaAvulsa);
		this.init();
	}
	
	public void edita(DiariaAvulsa d) {
		this.diariaAvulsa = d;
	}

	public DiariaAvulsa getDiariaAvulsa() {
		return diariaAvulsa;
	}

	public void setDiariaAvulsa(DiariaAvulsa diariaAvulsa) {
		this.diariaAvulsa = diariaAvulsa;
	}
	
	public List<DiariaAvulsa> getDiariasAvulsas() {
		return diariasAvulsas;
	}
	
	public List<Quarto> getQuartos(){
		return quartos;
	}

	public void setDiariasAvulsas (List<DiariaAvulsa> diariasAvulsas) {
		this.diariasAvulsas = diariasAvulsas;
	}
	
	public void setQuartos (List<Quarto> quartos){
		this.quartos = quartos;
	}
	
	public List<PessoaJuridica> getPessoasJuridicas() {
		return pessoasJuridicas;
	}

	public void setPessoasJuridicas(List<PessoaJuridica> pessoasJuridicas) {
		this.pessoasJuridicas = pessoasJuridicas;
	}

	public void selectListener(){
		setRendered(getTipo().contains("PJ"));
		System.out.println("Tipo: "+tipo+", rendered: "+rendered);
	}
	
	public String limpa() {
		diariaAvulsa = new DiariaAvulsa();
		return "/public/diaria-avulsa.jsf?facesRedirect=true";
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
	
	//MOCK
	public List<PessoaFisica> getPessoasFisicas(){
		return pfDAO.lista();
	}
	
	public void setPessoasFisicas(List<PessoaFisica> pessoasFisicas){
		this.pessoasFisicas = pessoasFisicas;
	}
}
