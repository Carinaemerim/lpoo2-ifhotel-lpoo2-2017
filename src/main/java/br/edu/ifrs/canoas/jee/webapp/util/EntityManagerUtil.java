package br.edu.ifrs.canoas.jee.webapp.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	private static EntityManagerFactory emf;

	public static EntityManager getEM() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("00-trabalhofinal-lpoo2_teamcap");
		}
		return emf.createEntityManager();
	}

	public static void fechaEmf() {
		emf.close();
	}

}