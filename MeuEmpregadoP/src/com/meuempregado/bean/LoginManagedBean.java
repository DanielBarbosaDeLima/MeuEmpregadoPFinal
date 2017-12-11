package com.meuempregado.bean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.meuempregado.model.Empregado;
import com.meuempregado.model.Empregador;
import com.meuempregado.service.EmpregadoService;
import com.meuempregado.service.EmpregadorService;
import com.meuempregado.service.LoginService;

@ManagedBean(name = "loginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable {
	private static final long serialVersionUID = 4024239853460771489L;
	
	private Empregado empregado;
	private Empregador empregador;
	private LoginService service;
	private String email;
	private String senha;
	private String tipoUsuario;
	
	String retorna = "";
	
	public LoginManagedBean() {
		empregador = new Empregador();
		empregado = new Empregado();
		service = new LoginService();
	}
	public void addEmpregado() throws ClassNotFoundException, SQLException, IOException{
		EmpregadorService s = new EmpregadorService();
		EmpregadoService w = new EmpregadoService();
		
		if(service.getIdEmpregadologin()!=null){
			empregado = w.buscarId(service.getIdEmpregadologin());
		}
		if(service.getIdEmpregadorlogin()!=null){
			List<Empregador> l = s.buscarId(service.getIdEmpregadorlogin());
			empregador = l.get(0);
		}
	}
	public String logar() throws ClassNotFoundException, SQLException, IOException {
		retorna = service.login(email, senha, tipoUsuario);//, empregado, empregador
		return retorna;
	}
	
	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

	public Empregador getEmpregador() {
		return empregador;
	}

	public void setEmpregador(Empregador empregador) {
		this.empregador = empregador;
	}

	public LoginService getService() {
		return service;
	}

	public void setService(LoginService service) {
		this.service = service;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public void limpar(){
		empregador = new Empregador();
		empregado = new Empregado();
	}
}
