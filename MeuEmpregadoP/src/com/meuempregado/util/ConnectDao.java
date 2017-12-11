package com.meuempregado.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectDao {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MeuEmpregadoP");
	
	public static EntityManagerFactory getInstance() {
		return emf;
	}

}
