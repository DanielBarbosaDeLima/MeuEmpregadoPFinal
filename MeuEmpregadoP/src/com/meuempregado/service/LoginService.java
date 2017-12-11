package com.meuempregado.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.meuempregado.dao.EmpregadoDAO;
import com.meuempregado.dao.EmpregadorDAO;
import com.meuempregado.dao.LoginDAO;
import com.meuempregado.model.Empregado;
import com.meuempregado.model.Empregador;

public class LoginService {
	LoginDAO dao = new LoginDAO();
	EmpregadoDAO daoEmpregado = new EmpregadoDAO();
	EmpregadorDAO daoEmpregador = new EmpregadorDAO();
	
	private static Integer idEmpregadologin;
	private static Integer idEmpregadorlogin;
	
	String retorno = "";
	
	public String login(String email, String senha, String tipoUsuario) throws ClassNotFoundException, SQLException, IOException {
		List<Empregado> listaEmpregado = daoEmpregado.listAll();
		List<Empregador> listaEmpregador = daoEmpregador.listAll();
		
		if(tipoUsuario.equals("EMPREGADO")) {
			for(int i=0;i<listaEmpregado.size();i++) {
				if(email.equals(listaEmpregado.get(i).getEmail())) {
					if(senha.equals(listaEmpregado.get(i).getSenha())) {
						setIdEmpregadologin(listaEmpregado.get(i).getId());//this.idEmpregadologin = listaEmpregado.get(i).getId();
						dao.loginEmpregado(email, senha);//empregado //getIdEmpregadologin()
						
						retorno = "listamensagemEMPREGADO.xhtml";//"index.xhtml";
					}
				}
			}
		}
		
		if(tipoUsuario.equals("EMPREGADOR")) {
			for(int i=0;i<listaEmpregador.size();i++) {
				if(email.equals(listaEmpregador.get(i).getEmail())) {
					if(senha.equals(listaEmpregador.get(i).getSenha())) {
						setIdEmpregadorlogin(listaEmpregador.get(i).getId());
						dao.loginEmpregador(email, senha);//getIdEmpregadorlogin()
						retorno = "indexEMPREGADOR.xhtml";
					}
				}
			}
		}
		
		return retorno;
	}

	public Integer getIdEmpregadologin() {//int
		return idEmpregadologin;
	}

	public void setIdEmpregadologin(Integer idEmpregadologin) {//int
		LoginService.idEmpregadologin = idEmpregadologin;//this.idEmpregadologin = idEmpregadologin;
	}

	public Integer getIdEmpregadorlogin() {//int
		return idEmpregadorlogin;
	}

	public void setIdEmpregadorlogin(Integer idEmpregadorlogin) {//int
		LoginService.idEmpregadorlogin = idEmpregadorlogin;//this.idEmpregadorlogin = idEmpregadorlogin;
	}
	
}
