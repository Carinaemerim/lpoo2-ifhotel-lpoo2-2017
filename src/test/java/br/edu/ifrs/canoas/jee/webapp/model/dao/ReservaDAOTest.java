package br.edu.ifrs.canoas.jee.webapp.model.dao;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Reserva;

@RunWith(Arquillian.class)
public class ReservaDAOTest extends BaseDAOTest{

		@Inject
		ReservaDAO reservaDAO;
		
		@Deployment
	    public static Archive<?> createTestArchive() {
		    return createTestArchive().
	                .addClasses(ReservaDAO.class);
	    }
		
		@Test
		public void testa_a_persistencia_da_reserva_em_branco () {	
			Reserva reserva = new Reserva();
			reserva.setValor(198.90);
			reservaDAO.insere(reserva);
			assertNotNull(reserva.getId());
		
		}
		
		

	}
