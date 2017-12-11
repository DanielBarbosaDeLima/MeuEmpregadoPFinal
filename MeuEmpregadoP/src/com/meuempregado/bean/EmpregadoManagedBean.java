package com.meuempregado.bean;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.meuempregado.model.Empregado;
import com.meuempregado.model.Mensagem;
import com.meuempregado.service.EmpregadoService;
import com.meuempregado.service.LoginService;

@ManagedBean(name="empregadoManagedBean")
@SessionScoped


public class EmpregadoManagedBean {
	
	//Teste
	
	private Empregado empregado;
	private Mensagem mensagem;
	private List<Empregado> listEmpregado;
	private EmpregadoService serviceempregado;
	private LoginService login = new LoginService();
	
	public EmpregadoManagedBean() throws ClassNotFoundException, SQLException, IOException{
		
		mensagem = new Mensagem();
		serviceempregado = new EmpregadoService();
		empregado = new Empregado();
		
		listEmpregado = serviceempregado.listar();
		
	}
	
	public String searchByCidadeAction() throws SQLException, ClassNotFoundException, IOException{
		System.out.println("Searching...");
		this.listEmpregado = serviceempregado.findEmpregadoByCidade(empregado.getCidade());
		
		return "indexEMPREGADOR";
	}
	
	public void searchByIdAction() throws SQLException, ClassNotFoundException, IOException{
		System.out.println("Searching...");
		this.empregado= serviceempregado.buscarId(mensagem.getIdEmpregado());
	}
	
	public String ListarTudo() throws SQLException, ClassNotFoundException, IOException{
		
		this.listEmpregado = serviceempregado.listar();
		
		return "indexEMPREGADOR";
	}
	
	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado Empregado) {
		this.empregado = Empregado;
	}

	public List<Empregado> getListEmpregado() {
		return listEmpregado;
	}

	public void setListEmpregado(List<Empregado> listEmpregado) {
		this.listEmpregado = listEmpregado;
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	public EmpregadoService getServiceempregado() {
		return serviceempregado;
	}

	public void setServiceempregado(EmpregadoService serviceempregado) {
		this.serviceempregado = serviceempregado;
	}

	public LoginService getLogin() {
		return login;
	}

	public void setLogin(LoginService login) {
		this.login = login;
	}
}
