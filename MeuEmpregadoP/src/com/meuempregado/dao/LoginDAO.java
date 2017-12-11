package com.meuempregado.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.meuempregado.model.Empregado;
import com.meuempregado.model.Empregador;
import com.meuempregado.util.ConnectDao;

public class LoginDAO {
	EntityManagerFactory emf = ConnectDao.getInstance();
	
	public List<Empregado> loginEmpregado(String email, String senha){
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query q = em.createQuery("select e from Empregado e where e.email = ? and e.senha = ?");
		q.setParameter(0, email);
		q.setParameter(1, senha);
		
		List<Empregado> listaEmpregado = q.getResultList();
		
		em.getTransaction().commit();
		return listaEmpregado;
	}
	
	public List<Empregador> loginEmpregador(String email, String senha){
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query q = em.createQuery("select e from Empregador e where e.email = ? and e.senha = ?");
		q.setParameter(0, email);
		q.setParameter(1, senha);
		
		List<Empregador> listaEmpregador = q.getResultList();
		
		em.getTransaction().commit();
		return listaEmpregador;
	}
	
}
