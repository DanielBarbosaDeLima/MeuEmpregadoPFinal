package com.meuempregado.dao;

import java.util.List;

public interface InterfaceGenericDao<E>{
	
	void inserir(E entity);
	void alterar(E entity);
	void excluir(Integer id);
	List<E> listarTodos();
	E buscarPorId(Integer id);
	Integer contarTodos();
	List<E> listarMensagens();
}
