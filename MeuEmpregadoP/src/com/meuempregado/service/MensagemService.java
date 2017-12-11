package com.meuempregado.service;

import java.util.ArrayList;
import java.util.List;

import com.meuempregado.dao.FactoryDao;
import com.meuempregado.model.Mensagem;


public class MensagemService {
	
	LoginService servicelogin = new LoginService();
	
	public void cadastrar(Mensagem m){
		m.setIdEmpregador(servicelogin.getIdEmpregadorlogin());
		FactoryDao.createGenericDao(Mensagem.class).inserir(m);
	}
	public List<Mensagem> listall(){
		return FactoryDao.createGenericDao(Mensagem.class).listarMensagens();
	}
	public List<Mensagem> listar(){
		
		List<Mensagem> list = FactoryDao.createGenericDao(Mensagem.class).listarMensagens();//dao.listAll();
		List<Mensagem> listamensagem = new ArrayList<Mensagem>();
		
		for(Mensagem item: list) {
			if(item.getIdEmpregado() == servicelogin.getIdEmpregadologin()) {
				//System.out.println(item.getIdEmpregado() +"MENSAGEM SERVICE"+servicelogin.getIdEmpregadologin());//servicelogin.getIdEmpregadologin()
				//if(item.getResposta().getDescription().equals("SIM")) {//NÃO
					listamensagem.add(item);
				//}
			}
		}
		
		return listamensagem;//return FactoryDao.createGenericDao(Mensagem.class).listarTodos();
	}
	
	public List<Mensagem> listarEmpregador(){
		
		List<Mensagem> list = FactoryDao.createGenericDao(Mensagem.class).listarMensagens();//dao.listAll();
		List<Mensagem> listamensagem = new ArrayList<Mensagem>();
		
		for(Mensagem item: list) {
			if(item.getIdEmpregador() == servicelogin.getIdEmpregadorlogin()) {
				//System.out.println(item.getIdEmpregado() +"MENSAGEM SERVICE"+servicelogin.getIdEmpregadologin());//servicelogin.getIdEmpregadologin()
				//if(item.getResposta().getDescription().equals("SIM")) {//NÃO
					listamensagem.add(item);
				//}
			}
		}
		
		return listamensagem;//return FactoryDao.createGenericDao(Mensagem.class).listarTodos();
	}
	
	public void excluir(Mensagem m){
		FactoryDao.createGenericDao(Mensagem.class).excluir(m.getIdMensagem());
	}
	public void atulizar(Mensagem m){
		FactoryDao.createGenericDao(Mensagem.class).alterar(m);
	}

}
