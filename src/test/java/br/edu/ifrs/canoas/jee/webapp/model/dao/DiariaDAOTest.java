package br.edu.ifrs.canoas.jee.webapp.model.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Diaria;
import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaAvulsa;

@RunWith(Arquillian.class)
public class DiariaDAOTest {

	@Inject
	DiariaDAO dDAO;

	@Deployment
    public static Archive<?> createTestArchive() {
	    return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(DiariaDAO.class)
                .addPackages(true, "br.edu.ifrs.canoas.jee.webapp")
                .addPackages(true, "org.apache.commons")
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

	@Test
	public void busca_diaria_por_data() throws ParseException {
		DiariaAvulsa d1 = new DiariaAvulsa();
		SimpleDateFormat dt = new SimpleDateFormat( "dd/MM/yyyy" );
		d1.setData(dt.parse("24/12/2017"));
		
		dDAO.insere(d1);
		
		assertNotNull(dDAO.buscaPorData(dt.parse("24/12/2017")));
		
	}
	
	@Test
	public void testa_busca_por_data_vazio(){
			
			assertTrue(dDAO.buscaPorData(null).isEmpty());							
	}

}
