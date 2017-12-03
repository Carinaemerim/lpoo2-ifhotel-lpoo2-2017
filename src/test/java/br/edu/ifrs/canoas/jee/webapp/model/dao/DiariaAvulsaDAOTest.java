package br.edu.ifrs.canoas.jee.webapp.model.dao;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.edu.ifrs.canoas.jee.webapp.model.TipoDeQuarto;
import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaAvulsa;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Quarto;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarDiariaAvulsaService;


@RunWith(Arquillian.class)
public class DiariaAvulsaDAOTest {

	@Inject
	DiariaAvulsaDAO daDAO;
	
	@Inject
	QuartoDAO qDAO;
	
	@Deployment
    public static Archive<?> createTestArchive() {
	    return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(DiariaAvulsaDAO.class, QuartoDAO.class)
                .addPackages(true, "br.edu.ifrs.canoas.jee.webapp")
                .addPackages(true, "org.apache.commons")
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }
	

	@Test
	public void lista_diaria_avulsa() {

		DiariaAvulsa da = new DiariaAvulsa();
		da.setQntdDias(4);
		Quarto q1 = new Quarto();
		q1.setDescricao("sdadas");
		q1.setNumero("555");
		q1.setSituacao("Disponível");
		q1.setTipo(TipoDeQuarto.PRESIDENCIAL);
		
		qDAO.insere(q1);
		
		da.setQuarto(q1);
		
		daDAO.insere(da);
		
	}

}
