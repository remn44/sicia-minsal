package com.minsal.sicia.resolver;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SiciaResolver {

	private static SiciaResolver instance = null;
		   
	protected SiciaResolver() {
		      // Exists only to defeat instantiation.
	}
		   
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sicia-minsal");
		   
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public static SiciaResolver getInstance() {
		if(instance == null) {
				instance = new SiciaResolver();
		}
		   return instance;
	}
		   
		   
	
}
