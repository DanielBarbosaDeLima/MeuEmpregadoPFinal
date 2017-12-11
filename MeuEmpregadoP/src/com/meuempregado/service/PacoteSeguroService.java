package com.meuempregado.service;

import java.util.List;

import com.meuempregado.dao.FactoryDao;
import com.meuempregado.model.PacoteSeguro;

public class PacoteSeguroService {
	
	public void cadastrar(PacoteSeguro p){
		FactoryDao.createGenericDao(PacoteSeguro.class).inserir(p);
	}
	
	public List<PacoteSeguro>listar(){
		return FactoryDao.createGenericDao(PacoteSeguro.class).listarTodos();
	}
	
	public void excluir(PacoteSeguro p){
		FactoryDao.createGenericDao(PacoteSeguro.class).excluir(p.getId());
	}
	public void atulizar(PacoteSeguro p){
		FactoryDao.createGenericDao(PacoteSeguro.class).alterar(p);
	}
	public PacoteSeguro buscarId(Integer id){
		return FactoryDao.createGenericDao(PacoteSeguro.class).buscarPorId(id);
	}
}
