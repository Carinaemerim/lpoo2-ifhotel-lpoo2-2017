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

import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaAvulsa;

@RunWith(Arquillian.class)
public class DiariaAvulsaDAOTest {

	@Inject
	DiariaAvulsaDAO daDAO;
	
	@Deployment
    public static Archive<?> createTestArchive() {
	    return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(DiariaAvulsaDAO.class)
                .addPackages(true, "br.edu.ifrs.canoas.jee.webapp")
                .addPackages(true, "org.apache.commons")
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }
	

	@Test
	public void lista_diaria_avulsa() {
		
		DiariaAvulsa da = new DiariaAvulsa();
		DiariaAvulsa da1 = new DiariaAvulsa();
		daDAO.insere(da);
		daDAO.insere(da1);
		
		assertNotNull(daDAO.listaDiariasAvulsas());
	}

}
