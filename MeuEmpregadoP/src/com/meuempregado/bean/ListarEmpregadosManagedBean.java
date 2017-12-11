package com.meuempregado.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.meuempregado.model.Empregado;
import com.meuempregado.model.Empregador;
import com.meuempregado.service.ListarEmpregadosService;

@ManagedBean(name= "listarempregadosManagedBean")
@SessionScoped
public class ListarEmpregadosManagedBean implements Serializable {
	private static final long serialVersionUID = -9030489314518973471L;
	
	private Empregado empregado;
	private Empregador empregador;
	private ListarEmpregadosService service;
	private List<Empregado> listaEmpregados;
	
	public ListarEmpregadosManagedBean() {
		atualizar();
	}
	
	public String listarEmpregados() {
		service.listarEmpregados();
		atualizar();
		return "index";
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

	public ListarEmpregadosService getService() {
		return service;
	}

	public void setService(ListarEmpregadosService service) {
		this.service = service;
	}

	public List<Empregado> getListaEmpregados() {
		return listaEmpregados;
	}

	public void setListaEmpregados(List<Empregado> listaEmpregados) {
		this.listaEmpregados = listaEmpregados;
	}
	public void atualizar() {
		empregado = new Empregado();
		empregador = new Empregador();
		service = new ListarEmpregadosService();
		listaEmpregados = service.listarEmpregados();
	}
	public void limpar(){
		empregado = new Empregado();
		empregador = new Empregador();
		service = new ListarEmpregadosService();
		listaEmpregados = new ArrayList<Empregado>();
	}
}
