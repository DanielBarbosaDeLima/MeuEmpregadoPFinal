package com.meuempregado.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.meuempregado.model.Empregado;
import com.meuempregado.service.LoginService;
import com.meuempregado.util.ConnectDao;

public class ListarEmpregadosDAO {
	EntityManagerFactory emf = ConnectDao.getInstance();
	
	LoginService service = new LoginService();
	
	public List<Empregado> listarEmpregados(){
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query q = em.createQuery("SELECT e FROM Mensagem m, Empregado e WHERE e.id = m.idEmpregado and m.idEmpregador = ? and idresposta= 1");//select tb_empregado.*, tb_empregador.idEmpregador from tb_empregado inner join tb_mensagem on tb_empregado.id=tb_mensagem.idEmpregado inner join tb_empregador on tb_mensagem.idEmpregador=tb_empregador.idEmpregador where tb_empregador.idEmpregador = 2;
		q.setParameter(0, service.getIdEmpregadorlogin());
		
		em.getTransaction().commit();
		//em.close();
		
		return q.getResultList();
	}
}
