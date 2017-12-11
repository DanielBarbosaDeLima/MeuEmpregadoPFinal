package com.meuempregado.dao;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.meuempregado.model.Empregado;
import com.meuempregado.util.ConnectDao;

public class EmpregadoDAO {
	EntityManagerFactory emf = ConnectDao.getInstance();

	public List<Empregado> listAll() {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query q = em.createQuery("FROM Empregado");
		
		em.getTransaction().commit();
		//em.close();
		
		return q.getResultList();
	}
	
	public List<Empregado> findEmpregadoByCidade(String cidade) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query q = em.createQuery("FROM Empregado where cidade like ?");
		q.setParameter(0, cidade);
		
		em.getTransaction().commit();
		//em.close();
		
		return q.getResultList();
	}
	
	public List<Empregado> findEmpregadoById(Integer id) throws ClassNotFoundException, SQLException, IOException{
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query q = em.createQuery("FROM Empregado where id like ?");
		q.setParameter(0, id);
		
		em.getTransaction().commit();
		//em.close();
		
		return q.getResultList();
	}
	
	public List<Empregado> findEmpregadoByEstadoCidade(String estado, String cidade) throws ClassNotFoundException, SQLException, IOException{
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query q = em.createQuery("FROM Empregado where estado like ? and cidade like ?");
		q.setParameter(0, estado);
		q.setParameter(1, cidade);
		
		em.getTransaction().commit();
		//em.close();
		
		return q.getResultList();
	}
	
	public void updateEmpregado(Empregado empregado) throws SQLException {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(empregado);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public void insertEmpregado(Empregado empregado) throws SQLException, ClassNotFoundException, IOException {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(empregado);
		
		em.getTransaction().commit();
		em.close();
	}

}

