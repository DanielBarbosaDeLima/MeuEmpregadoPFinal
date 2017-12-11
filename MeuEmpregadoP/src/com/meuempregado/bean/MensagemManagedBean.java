package com.meuempregado.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.meuempregado.model.Empregado;
import com.meuempregado.model.Mensagem;
import com.meuempregado.model.Resposta;
import com.meuempregado.service.MensagemService;

@ManagedBean(name="mensagemManagedBean")
@SessionScoped

public class MensagemManagedBean implements Serializable {
	private static final long serialVersionUID = 7997258218435606996L;
	
	private Mensagem Mensagem;
	private List<Mensagem> listMensagem;
	private List<Mensagem> listMensagemEmpregador;
	private MensagemService service;
	private Empregado empregado;
	private Resposta resposta;
	
	public MensagemManagedBean() {
		service = new MensagemService();
		resposta = new Resposta(0, "");
		Mensagem = new Mensagem(0, "", "", "", resposta, "", "", "", "", 0f, "", 0, 0, true, null, false);
		empregado = new Empregado();
		//Mensagem.setResposta(resposta);
		listMensagemEmpregador = service.listarEmpregador();
		listMensagem = service.listar();
	}
	
	///////////////////////////insert
	public String insertMensagemAction(){
			System.out.println("Saving...");
			Mensagem.setIdEmpregado(empregado.getId());
			service.cadastrar(Mensagem);
			Mensagem = new Mensagem();
			this.listMensagem = service.listar();
			
			return "indexEMPREGADOR";
	}
	
	//////////////////////////delete
	public String deleteMensagemAction(){
		System.out.println("Deleting...");
		service.excluir(Mensagem);
		listMensagem = service.listar();
		
		return "listamensagemEMPREGADOR";
	}
	
	///////update
	public String updateMensagemAction(){
		System.out.println("Updating...");
		if(Mensagem.getResposta().getDescription().equals("SIM")){//if(Mensagem.getResposta().equals("Sim")){
			Mensagem.setAtivo(true);
		}else{
			Mensagem.setAtivo(false);
		}
		
		System.out.println(Mensagem.getAtivo()+"Ativo?");
		
		service.atulizar(Mensagem);
		this.listMensagem = service.listar();
		
		return "listamensagemEMPREGADO";
	}

	////////////////////////////////////////limpar campos
	public String limpar(){
		System.out.println("limpando campos...");
		Mensagem = new Mensagem();
		return "novaMensagemEMPREGADO";
	}
	
	public Mensagem getMensagem() {
		return Mensagem;
	}

	public void setMensagem(Mensagem Mensagem) {
		this.Mensagem = Mensagem;
	}

	public List<Mensagem> getListMensagem() {
		return listMensagem;
	}

	public void setListMensagem(List<Mensagem> listMensagem) {
		this.listMensagem = listMensagem;
	}
	
	public MensagemService getService() {
		return service;
	}

	public void setService(MensagemService service) {
		this.service = service;
	}

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

	public Resposta getResposta() {
		return resposta;
	}

	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}
	public List<Mensagem> getListMensagemEmpregador() {
		return listMensagemEmpregador;
	}

	public void setListMensagemEmpregador(List<Mensagem> listMensagemEmpregador) {
		this.listMensagemEmpregador = listMensagemEmpregador;
	}

	///////////////////////////////////////////
	public void atualizar() {
		service = new MensagemService();	
		Mensagem = new Mensagem();
		listMensagemEmpregador = service.listarEmpregador();
		listMensagem = service.listar();
	}
}
