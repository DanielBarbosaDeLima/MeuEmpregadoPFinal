package com.meuempregado.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import com.meuempregado.service.LoginService;
import com.meuempregado.util.ConnectDao;

public class GenericDao<E> implements InterfaceGenericDao<E> { 

	private EntityManager em;

	private final Class<E> entityClass;

	LoginService service = new LoginService();
	
	public GenericDao(Class<E> entityClass) {
	 	this.entityClass = entityClass;
	}

	@Override
	public void inserir(E entity) {

		em = ConnectDao.getInstance().createEntityManager();

		try {

			em.getTransaction().begin();

			em.persist(entity);

			em.getTransaction().commit();

		} catch (Exception e) {

			em.getTransaction().rollback();

		} finally {
			em.close();
		}

	}

	@Override
	public void alterar(E entity) {

		em = ConnectDao.getInstance().createEntityManager();

		try {

			em.getTransaction().begin();

			em.merge(entity);

			em.getTransaction().commit();

		} catch (Exception e) {

			em.getTransaction().rollback();

		} finally {
			em.close();
		}

	}

	@Override
	public void excluir(Integer id) {

		em = ConnectDao.getInstance().createEntityManager();

		try {

			em.getTransaction().begin();

			em.remove(em.getReference(entityClass, id));

			em.getTransaction().commit();

		} catch (Exception e) {

			em.getTransaction().rollback();

		} finally {
			em.close();
		}

	}

	@Override
	public List<E> listarTodos() {
		
		em = ConnectDao.getInstance().createEntityManager();

		em.getTransaction().begin();
		
		CriteriaQuery<E> query = em.getCriteriaBuilder().createQuery(entityClass);
		query.select(query.from(entityClass));

		List<E> lista = em.createQuery(query).getResultList();

		em.getTransaction().commit();//*
		em.close();
		
		return lista;

	}

	@Override
	public List<E> listarMensagens(){
		em = ConnectDao.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		
		Query q = em.createQuery("SELECT m FROM Mensagem m JOIN m.resposta r ON m.resposta.idResposta = r.idResposta");//SELECT m FROM Mensagem m JOIN m.resposta r where m.idResposta = r.id // SELECT m FROM Mensagem m JOIN m.resposta r
		
		em.getTransaction().commit();
		
		return q.getResultList();
	}
	
	@Override
	public E buscarPorId(Integer id) {

		em = ConnectDao.getInstance().createEntityManager();

		E entity = em.find(entityClass, id);

		em.close();

		return entity;
	}

	@Override
	public Integer contarTodos() {
		
		em = ConnectDao.getInstance().createEntityManager();
		
		Integer resultado =  Integer.valueOf(
				em.createQuery("select count(*) from "+entityClass.getCanonicalName()).getSingleResult().toString());
		
		em.close();
		
		return resultado;
	}
}
