package com.meuempregado.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.meuempregado.model.PacoteSeguro;
import com.meuempregado.service.PacoteSeguroService;


@ManagedBean(name = "pacoteSeguroManagedBean")
@SessionScoped
public class PacoteSeguroManagedBean implements Serializable{
	private static final long serialVersionUID = 4941282069006820685L;

	private PacoteSeguro pacote;
	
	private PacoteSeguro primeiropacote;
	private PacoteSeguro segundopacote;
	private PacoteSeguro terceiropacote;
	
	private List<PacoteSeguro> pacotes;
	
	private PacoteSeguroService service;
	
	public PacoteSeguroManagedBean(){
		atualizar();
	}
	
	
	public String inserirPacoteSeguroAction(){
		service.cadastrar(pacote);;
		atualizar();
		return "listaPacoteSeguro";
	}
	
	public String atualizarPacoteSeguroAction(){
		service.atulizar(pacote);
		atualizar();
		return "listaPacoteSeguro";
	}
	public void excluirPacoteSeguroAction(){
		service.excluir(pacote);
		atualizar();
	}
	public PacoteSeguro getPacote() {
		return pacote;
	}
	public void setPacote(PacoteSeguro pacote) {
		this.pacote = pacote;
	}
	public List<PacoteSeguro> getPacotes() {
		return pacotes;
	}
	public void setPacotes(List<PacoteSeguro> pacotes) {
		this.pacotes = pacotes;
	}
	public PacoteSeguroService getService() {
		return service;
	}
	public void setService(PacoteSeguroService service) {
		this.service = service;
	}
	public PacoteSeguro getPrimeiropacote() {
		return primeiropacote;
	}
	public void setPrimeiropacote(PacoteSeguro primeiropacote) {
		this.primeiropacote = primeiropacote;
	}
	public PacoteSeguro getSegundopacote() {
		return segundopacote;
	}
	public void setSegundopacote(PacoteSeguro segundopacote) {
		this.segundopacote = segundopacote;
	}
	public PacoteSeguro getTerceiropacote() {
		return terceiropacote;
	}
	public void setTerceiropacote(PacoteSeguro terceiropacote) {
		this.terceiropacote = terceiropacote;
	}
	public void atualizar(){
		service = new PacoteSeguroService();
		pacotes = service.listar();
		pacote = new PacoteSeguro();
		primeiropacote = pacotes.get(0);
		segundopacote = pacotes.get(1);
		terceiropacote = pacotes.get(2);
	}
}
