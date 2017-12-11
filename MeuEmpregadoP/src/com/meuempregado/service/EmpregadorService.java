package com.meuempregado.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.meuempregado.dao.EmpregadorDAO;
import com.meuempregado.dao.FactoryDao;
import com.meuempregado.model.Empregador;

public class EmpregadorService {

	public void cadastrar(Empregador e){
		FactoryDao.createGenericDao(Empregador.class).inserir(e);
	}
	public List<Empregador>listar(){
		return FactoryDao.createGenericDao(Empregador.class).listarTodos();
	}
	public void excluir(Empregador e){
		FactoryDao.createGenericDao(Empregador.class).excluir(e.getId());
	}
	public void atulizar(Empregador e){
		FactoryDao.createGenericDao(Empregador.class).alterar(e);
	}
	public List<Empregador> buscarId(Integer id) throws ClassNotFoundException, SQLException, IOException{
		EmpregadorDAO dao = new EmpregadorDAO();
		return dao.findEmpregadoById(id);
	}
}
