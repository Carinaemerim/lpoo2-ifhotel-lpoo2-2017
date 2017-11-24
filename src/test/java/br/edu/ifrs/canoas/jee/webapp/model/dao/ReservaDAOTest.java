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

import br.edu.ifrs.canoas.jee.webapp.model.entity.Reserva;

@RunWith(Arquillian.class)
public class ReservaDAOTest{

		@Inject
		ReservaDAO rDAO;
		
		@Deployment
	    public static Archive<?> createTestArchive() {
			 return ShrinkWrap.create(WebArchive.class, "test.war")
		                .addClasses(ReservaDAO.class)
		                .addPackages(true, "br.edu.ifrs.canoas.jee.webapp")
		                .addPackages(true, "org.apache.commons")
		                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
		                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	    }
		
		@Test
		public void testa_a_persistencia_da_reserva_em_branco () {	
			Reserva reserva = new Reserva();
			reserva.setValor(198.90);
			rDAO.insere(reserva);
			assertNotNull(reserva.getId());
		
		}
		
		@Test
		public void busca_por_data() throws ParseException{
			
			Reserva r1 = new Reserva();
			SimpleDateFormat dt = new SimpleDateFormat( "dd/MM/yyyy" );
			r1.setData(dt.parse("20/12/2017"));
			rDAO.insere(r1);
			
			assertNotNull(rDAO.buscaPorData(dt.parse("20/12/2017")));
			
		}
		
		@Test
		public void busca_por_data_vazia(){
			
			assertTrue(rDAO.buscaPorData(null).isEmpty());
		}
		
}
