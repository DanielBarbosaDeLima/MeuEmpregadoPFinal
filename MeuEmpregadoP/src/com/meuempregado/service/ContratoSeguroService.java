package com.meuempregado.service;

import java.util.ArrayList;
import java.util.List;

import com.meuempregado.dao.FactoryDao;
import com.meuempregado.model.ContratoSeguro;

public class ContratoSeguroService {
	
	public void cadastrar(ContratoSeguro cs){
		FactoryDao.createGenericDao(ContratoSeguro.class).inserir(cs);
	}
	
	public List<ContratoSeguro>listar(){
		List<ContratoSeguro> lista = new ArrayList<ContratoSeguro>();
		List<ContratoSeguro> restricao = FactoryDao.createGenericDao(ContratoSeguro.class).listarTodos();
		
		for(ContratoSeguro c:restricao){
			if(c.getAtivo()){
				lista.add(c);
			}
		}
		return lista;
	}
	
	public void excluir(ContratoSeguro cs){
		FactoryDao.createGenericDao(ContratoSeguro.class).excluir(cs.getId());;
	}
	public void atulizar(ContratoSeguro cs){
		FactoryDao.createGenericDao(ContratoSeguro.class).alterar(cs);
	}
	public ContratoSeguro buscaId(Integer id){
		return FactoryDao.createGenericDao(ContratoSeguro.class).buscarPorId(id);
	}
}
