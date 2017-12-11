package com.meuempregado.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.meuempregado.model.Mensagem;
import com.meuempregado.util.ConnectDao;

public class MensagemDAO {
	EntityManagerFactory emf = ConnectDao.getInstance();
	
	public void salvar(Mensagem c) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(c);
		em.flush();
		
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Mensagem> listAll() {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query q = em.createQuery("SELECT m FROM Mensagem m JOIN m.resposta r ON m.resposta.idResposta = r.idResposta");//SELECT m FROM Mensagem m JOIN m.resposta r where m.idResposta = r.id // SELECT m FROM Mensagem m JOIN m.resposta r
		
		em.getTransaction().commit();
		//em.close();
		
		return q.getResultList();
	}
	
	public void delete(Mensagem c) throws SQLException, ClassNotFoundException, IOException {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(c);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Mensagem c) throws SQLException, ClassNotFoundException, IOException{
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(c);
		
		em.getTransaction().commit();
		em.close();
	}
	
}
